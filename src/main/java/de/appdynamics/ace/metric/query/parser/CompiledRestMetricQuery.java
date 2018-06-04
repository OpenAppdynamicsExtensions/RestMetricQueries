package de.appdynamics.ace.metric.query.parser;

import de.appdynamics.ace.metric.query.data.DataMap;
import de.appdynamics.ace.metric.query.rest.ControllerRestAccess;
import de.appdynamics.ace.metric.query.rest.MetricResults;
import de.appdynamics.ace.metric.query.rest.RestException;


import java.util.*;

/**
 * Created by stefan.marx on 18.07.14.
 */
public class CompiledRestMetricQuery {

    private final String _src;
    private Fields _fields;
    private Path _path;
    private QueryTimeRange _timerange = new QueryTimeRange();
    private boolean _includeEmptyRecords;

    public CompiledRestMetricQuery(String src) {
        _src = src;

    }

    public boolean isAggregated() {
        return _Aggregated;
    }

    public void setAggregated(boolean bfAggregated) {
        _Aggregated = bfAggregated;
    }

    private boolean _Aggregated = false;


    @Override
    public String toString() {
        return "QueryDefinition : \n" +
                "SRC: " + _src + "\n" +
                ((isAggregated()) ? "   (aggregated Results)\n" : "") + "" +
                "Fields :" + getFields() + "\n" +
                "Paths :" + getPath() + "\n" +
                "Timerange :" +getTimerange() +"\n";
    }

    public void setFields(Fields fields) {
        _fields = fields;
    }

    public Fields getFields() {
        return _fields;
    }

    public void setPath(Path path) {
        _path = path;
    }

    public Path getPath() {
        return _path;
    }

    public ArrayList<String> getQueryStrings() {

        // Simple Use Cases for now

        ArrayList<MetricName> fn = _fields._fieldNames;
        if (_fields.isAll()) {
            fn = new ArrayList<MetricName>();
            fn.add(new MetricName("*"));
        }

        ArrayList<String> pn = getPath().getFullPathComponents();


        ArrayList<String> result = new ArrayList<String>();


        for (String base : pn) {
            for (MetricName field : fn) {

                result.add(base + "|" + field.getName());
            }
        }

        return result;
    }

    public DataMap execute(ControllerRestAccess backend) throws QueryException {
        return execute(backend, false);

    }

    public QueryTimeRange getTimerange() {
        return _timerange;
    }



    public DataMap execute(ControllerRestAccess backend, boolean simplify) throws QueryException {
        DataMap map = new DataMap();


        for (String qs : getQueryStrings()) {
            try {
                MetricResults tempData = backend.queryMetrics(getPath().getComponent(PathComponents.APPLICATION), qs
                        , getTimerange().getStartMilis(), getTimerange().getStopMillis(), isAggregated());
                map.registerData(tempData,simplify,isIncludeEmptyRecords(),this);
            } catch (RestException e) {
                throw new QueryException("Error while Data retrieval :"+e,e);
            }



        }

        return map;
    }

    public Map<String, String> getQueryMap() {
        Map<String, String> map = new HashMap<String, String>();
        // Simple Use Cases for now

        ArrayList<MetricName> fn = _fields._fieldNames;

        if (_fields.isAll()) { return map;}

        for (MetricName field : fn) {
            if (field.isAliased()) map.put(field.getName(),field.getAlias());
        }

        return map;
    }

    public void setIncludeEmptyRecords(boolean includeEmptyRecords) {
        _includeEmptyRecords = includeEmptyRecords;
    }

    public boolean isIncludeEmptyRecords() {
        return _includeEmptyRecords;
    }


    public static class Fields {
        private ArrayList<MetricName> _fieldNames = new ArrayList<MetricName>();
        private boolean _all;

        @Override
        public String toString() {

            if (isAll()) return "STAR";
            if (isEmpty()) return "EMPTY";


            return "FieldList :" + _fieldNames;
        }

        private boolean isEmpty() {
            return _fieldNames.isEmpty();
        }

        public boolean isAll() {
            return _all;
        }

        public void setAll(boolean all) {
            _all = all;
        }

        public void setFieldList(ArrayList<MetricName> list) {
            _fieldNames.clear();
            _fieldNames.addAll(list);
        }
    }

    public static class Path {
        private ArrayList<String> _pathList = new ArrayList<String>();
        private HashMap<PathComponents, String> _components = new HashMap<PathComponents, String>();
        private HashMap<String,Integer> _componentNames = new HashMap<String, Integer>();

        public void setPathList(ArrayList<String> pathList) {
            _pathList.clear();
            _componentNames.clear();
            for (String p : pathList) {
                addPathElement(p);

            }
        }

        public String toString() {

            StringBuffer p = new StringBuffer("Path List: ");

            boolean first = true;
            for (String s : _pathList) {
                if (!first) p.append("      -> ");
                else {
                    first = false;

                }
                p.append(s).append("\n");
            }

            for (String compName : _componentNames.keySet()) {
                p.append(compName).append(" (").append(_componentNames.get(compName))
                        .append(") ").append("\n");
            }

            p.append("Start Component : \n");

            Set<Map.Entry<PathComponents, String>> es = _components.entrySet();

            for (Map.Entry<PathComponents, String> s : es) {
                p.append(s.getKey().toString()).append("   : ").append(s.getValue());

            }

            return p.toString();

        }


        public void setComponent(PathComponents component, String value) {
            _components.put(component, value);
        }


        public ArrayList<String> getFullPathComponents() {
            StringBuffer b = new StringBuffer("");
            boolean bffirst = true;

            for (String pc : _pathList) {
                if (bffirst) {
                    bffirst = false;
                } else b.append("|");
                b.append(pc);
            }

            ArrayList<String> result = new ArrayList<String>();

            result.add(b.toString());
            return result;
        }

        public String getComponent(PathComponents key) {
            if (_components.containsKey(key)) return _components.get(key);
            return null;
        }

        public void addPathElement(String elementText) {
            if (!elementText.contains("|")) {
                _pathList.add(elementText);
            } else {
                elementText = elementText.replaceAll("\\\\\\|","####");
                for (String k : elementText.split("\\|")) {
                    _pathList.add(k.replaceAll("####","\\\\\\|"));
                }
            }
        }

        public void nameCurrentPathElement(String name) {
            int index = _pathList.size();
            _componentNames.put(name,new Integer(index-1));

        }

        public String getPathElementName(int i) {
            for (Map.Entry<String,Integer> value:_componentNames.entrySet()) {
                if (value.getValue().intValue() == i) {
                    return value.getKey();
                }

            }
            return null;
        }

        public ArrayList<String> getFullQueryPathList() {
            return _pathList;
        }
    }

    public static class QueryTimeRange {
        private Date _startDate = new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 1));
        private Date _endDate = new Date();


        public long getStartMilis() {
            return _startDate.getTime();
        }

        public long getStopMillis() {
            return _endDate.getTime();

        }

        public void setStartDate(Date date) {
            _startDate = date;

        }

        public void setEndDate(Date date) {
            _endDate = date;

        }

        @Override
        public String toString() {
            return _startDate.toString() + "  --> " + _endDate.toString();
        }
    }
}
