package de.appdynamics.ace.metric.query.data;

import de.appdynamics.ace.metric.query.parser.CompiledRestMetricQuery;
import de.appdynamics.ace.metric.query.rest.MetricData;
import de.appdynamics.ace.metric.query.rest.MetricResults;
import de.appdynamics.ace.metric.query.rest.MetricValue;
import org.apache.commons.lang3.StringUtils ;


import javax.xml.soap.Text;
import java.util.*;

/**
 * Created by stefan.marx on 21.07.14.
 */
public class DataMap {

    public static final String METRIC_NAME = "metric Name";
    public static final String PATH = "path";
    public static final String VALUE = "value";
    public static final String MAX = "max";
    public static final String MIN = "min";
    public static final String SUM = "sum";
    public static final String STD_DEV = "stdDev";
    public static final String TIME = "time";
    private final DataColumns _columns;
    private final DataRows _rows;
    private Comparator<DataRow> _comp;

    public DataMap() {
        _columns = new DataColumns();
        _rows = new DataRows();

    }


    public void registerDataNormal(MetricResults tempData, boolean includeEmptyRecords, CompiledRestMetricQuery compiledRestMetricQuery) {
        List<MetricData> data = tempData.getMetricData();


        Column pathCol = findOrCreateTextColumn("path");
        Column timestampCol = findOrCreateTimestampColumn("time");




        for (MetricData d : data) {
           String path = d.getMetricPath();
            String[] elements = path.split("\\|");
            String metricName = elements[elements.length-1];
            path = path.substring(0,path.lastIndexOf("|"));

            Column value,max,min,sum,stdDev;
            value = findOrCreateValueColumn(metricName);
            max = findOrCreateValueColumn(metricName+" (max)");
            min =  findOrCreateValueColumn(metricName+ " (min)");
            sum = findOrCreateValueColumn(metricName+ " (sum)");
            stdDev = findOrCreateValueColumn(metricName + " (stdDev)");



                    for (MetricValue m :d.getMetricValues()) {
                        String rowKey =  path+"_"+m.getStartTimeInMillis();
                        DataRow dr = _rows.getDataRow(rowKey);
                        dr.setTextValue (pathCol,path);
                        fillPathComponents(d,dr,compiledRestMetricQuery);

                        dr.setTimestampValue(timestampCol, new Date(m.getStartTimeInMillis()));
                        dr.setValue(value, m.getValue());
                        dr.setValue(max, m.getMax());
                        dr.setValue(min, m.getMin());
                        dr.setValue(sum, m.getSum());
                        dr.setValue(stdDev, m.getStandardDeviation());
                    }

            if (includeEmptyRecords) {
                String rk =  path+"_<empty>";
                DataRow dr = _rows.getDataRow(rk);
                dr.setTextValue (pathCol,path);

            }

        }

        _comp = new LongFormatComparator(timestampCol,pathCol);



    }

    private void fillPathComponents(MetricData d, DataRow dr, CompiledRestMetricQuery compiledRestMetricQuery) {

        int i = 0;
        for (String e :  d.getMetricPath().split("\\|")) {
            String pName = compiledRestMetricQuery.getPath().getPathElementName(i);
            if (pName != null) {
                TextColumn pcol = findOrCreateTextColumn(pName);
                dr.setTextValue(pcol,e);
            }

            i++;
        }




    }

    private TextColumn findOrCreateTextColumn(String name) {
        TextColumn col = (TextColumn) _columns.getColumn(name);
        if (col == null) {
            col = new TextColumn(name);
            _columns.registerColumn(col);
        }
        return col;
    }

    private TimestampColumn findOrCreateTimestampColumn(String name) {
        TimestampColumn col = (TimestampColumn) _columns.getColumn(name);
        if (col == null) {
            col = new TimestampColumn(name);
            _columns.registerColumn(col);
        }
        return col;
    }

    private ValueColumn findOrCreateValueColumn(String name) {
        ValueColumn col = (ValueColumn) _columns.getColumn(name);
        if (col == null) {
            col = new ValueColumn(name);
            _columns.registerColumn(col);
        }
        return col;
    }

    public String dumpData() {
        StringBuffer sb = new StringBuffer("");

        ArrayList<Column> cl = _columns.getColumnsList();


        for(Column c : cl) {
            sb.append(StringUtils.center(c.getName(),12,' ')).append ("|");
        }

        sb.append("\n");
        Column pathCol = findOrCreateTextColumn("path");

        for (DataRow r : getOrderedRows())  {
            for(Column c : cl) {
                DataObject ob = r.findData(c);
                if (ob == null) sb.append(StringUtils.center("---",12,' ')).append ("|");
                else  {
                    if (c.equals(pathCol)) sb.append(StringUtils.center(ob.getTextValue().replace("|",":-:") ,12,' ')).append ("|");
                    else sb.append(StringUtils.center(ob.getTextValue() ,12,' ')).append("|");

                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public Collection<DataRow> getOrderedRows() {
        List<DataRow> erg = new ArrayList<DataRow>()  ;
        erg.addAll(_rows.getRows());

        Collections.sort(erg,_comp);

        return erg;
    }


    public void registerData(MetricResults tempData, boolean simplify, boolean includeEmptyRecords, CompiledRestMetricQuery compiledRestMetricQuery) {
        if (!simplify)  registerDataNormal(tempData, includeEmptyRecords,compiledRestMetricQuery);
        else registerDataAndSimplify(tempData,includeEmptyRecords,compiledRestMetricQuery);

    }

    public void registerDataAndSimplify(MetricResults tempData, boolean includeEmptyRecords, CompiledRestMetricQuery compiledRestMetricQuery) {
        List<MetricData> data = tempData.getMetricData();


        Column metricNameCol = findOrCreateTextColumn(METRIC_NAME);
        Column pathCol = findOrCreateTextColumn(PATH);
        Column timestampCol = findOrCreateTimestampColumn(TIME);


        Column value,max,min,sum,stdDev;
        value = findOrCreateValueColumn(VALUE);
        max = findOrCreateValueColumn(MAX);
        min =  findOrCreateValueColumn(MIN);
        sum = findOrCreateValueColumn(SUM);
        stdDev = findOrCreateValueColumn(STD_DEV);




        for (MetricData d : data) {
            String path = d.getMetricPath();
            String[] elements = path.split("\\|");
            String metricName = elements[elements.length-1];
            path = path.substring(0,path.lastIndexOf("|"));



            for (MetricValue m  : d.getMetricValues()) {
                    String rowKey =  path+"_"+metricName+"_"+m.getStartTimeInMillis();
                    DataRow dr = _rows.getDataRow(rowKey);
                    fillPathComponents(d,dr,compiledRestMetricQuery);

                    dr.setTextValue(metricNameCol,metricName);
                    dr.setTextValue (pathCol,path);
                    dr.setTimestampValue(timestampCol, new Date(m.getStartTimeInMillis()));

                    dr.setValue(value, m.getValue());
                    dr.setValue(max, m.getMax());
                    dr.setValue(min, m.getMin());
                    dr.setValue(sum, m.getSum());
                    dr.setValue(stdDev, m.getStandardDeviation());
            }
            if (includeEmptyRecords) {
                String rk =  path+"_"+metricName+"_<empty>";
                DataRow dr = _rows.getDataRow(rk);
                dr.setTextValue(metricNameCol,metricName);
                dr.setTextValue (pathCol,path);
                dr.setTimestampValue(timestampCol,new Date(compiledRestMetricQuery.getTimerange().getStopMillis()));
            }
        }

        _comp = new SimplifiedComparator(metricNameCol,timestampCol,pathCol);




    }

    public ArrayList<Column> getHeader() {
        return _columns.getColumnsList();
     }

    public void registerData(MetricResults tempData, boolean simplify,CompiledRestMetricQuery compiledRestMetricQuery) {
        registerData(tempData,simplify,false,compiledRestMetricQuery);
    }


    private class SimplifiedComparator implements Comparator<DataRow>{
        private final Column _pathCol;
        private final Column _metricNameCol;
        private final Column _timestampCol;

        public SimplifiedComparator(Column metricNameCol, Column timestampCol, Column pathCol) {
            _metricNameCol =  metricNameCol;
            _timestampCol = timestampCol;
            _pathCol = pathCol;
        }

        @Override
        public int compare(DataRow o1, DataRow o2) {
            int erg = 0;

            erg = o1.findData(_metricNameCol).getTextValue().compareTo(o2.findData(_metricNameCol).getTextValue());
            if (erg == 0) {
                erg = o1.findData(_pathCol).getTextValue().compareTo(o2.findData(_pathCol).getTextValue());
            }

            if (erg == 0) {
                erg = ((TimestampDataObject)o1.findData(_timestampCol)).getTimestampValue().compareTo(
                        ((TimestampDataObject)o2.findData(_timestampCol)).getTimestampValue());
            }


            return erg;
        }
    }

    private class LongFormatComparator implements Comparator<DataRow>{
        private final Column _pathCol;

        private final Column _timestampCol;

        public LongFormatComparator(Column timestampCol, Column pathCol) {
            _timestampCol = timestampCol;
            _pathCol = pathCol;
        }

        @Override
        public int compare(DataRow o1, DataRow o2) {
            int erg = 0;


            erg = o1.findData(_pathCol).getTextValue().compareTo(o2.findData(_pathCol).getTextValue());


            if (erg == 0) {
                erg = ((TimestampDataObject)o1.findData(_timestampCol)).getTimestampValue().compareTo(
                        ((TimestampDataObject)o2.findData(_timestampCol)).getTimestampValue());
            }
            return erg;
        }
    }
}
