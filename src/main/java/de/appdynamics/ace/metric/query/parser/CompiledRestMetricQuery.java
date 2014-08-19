package de.appdynamics.ace.metric.query.parser;

import de.appdynamics.ace.metric.query.data.DataMap;
import org.appdynamics.appdrestapi.RESTAccess;
import org.appdynamics.appdrestapi.data.Application;
import org.appdynamics.appdrestapi.data.Applications;
import org.appdynamics.appdrestapi.data.MetricDatas;
import org.appdynamics.appdrestapi.util.TimeRange;

import java.util.*;

/**
 * Created by stefan.marx on 18.07.14.
 */
public class CompiledRestMetricQuery {

    private final String _src;
    private Fields _fields;
    private Path _path;
    private QueryTimeRange _timerange = new QueryTimeRange();

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

        ArrayList<String> fn = _fields._fieldNames;
        if (_fields.isAll()) {
            fn = new ArrayList<String>();
            fn.add("*");
        }

        ArrayList<String> pn = getPath().getFullPathComponents();


        ArrayList<String> result = new ArrayList<String>();


        for (String base : pn) {
            for (String field : fn) {

                result.add(base + "|" + field);
            }
        }

        return result;
    }

    public DataMap execute(RESTAccess backend) throws QueryException {
        return execute(backend, false);

    }

    public QueryTimeRange getTimerange() {
        return _timerange;
    }

    private Application findApplication(RESTAccess backend) {
        Applications apps = backend.getApplications();

        for (Application a : apps.getApplications()) {
            if (a.getName().equals(getPath().getComponent(PathComponents.APPLICATION))) {
                return a;
            }
        }
        return null;
    }

    public DataMap execute(RESTAccess backend, boolean simplify) throws QueryException {
        DataMap map = new DataMap();


        Application a = findApplication(backend);
        if (a == null) throw new QueryException("Couldn't find Application for root Path :\n" + this);

        for (String qs : getQueryStrings()) {
            MetricDatas tempData = backend.getRESTGenericMetricQuery("" + a.getId(), qs
                    , getTimerange().getStartMilis(), getTimerange().getStopMillis(), isAggregated());

            map.registerData(tempData,simplify);

        }

        return map;
    }


    public static class Fields {
        private ArrayList<String> _fieldNames = new ArrayList<String>();
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

        public void setFieldList(ArrayList<String> list) {
            _fieldNames.clear();
            _fieldNames.addAll(list);
        }
    }

    public static class Path {
        private ArrayList<String> _pathList = new ArrayList<String>();
        private HashMap<PathComponents, String> _components = new HashMap<PathComponents, String>();

        public void setPathList(ArrayList<String> pathList) {
            _pathList.clear();
            for (String p : pathList) {
                if (!p.contains("|")) {
                    _pathList.add(p);
                } else {
                    for (String k : p.split("\\|")) {
                        _pathList.add(k);
                    }
                }

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
