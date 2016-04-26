package de.appdynamics.ace.metric.query.data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by stefan.marx on 22.07.14.
 */
public class DataRow {
    private final String _key;
    private final int _id;

    private Map<Column,DataObject> _cols = new HashMap<Column,DataObject>();
    public DataRow(String rowKey, int newRowId) {
        _key = rowKey;
        _id = newRowId;


    }

    public DataObject getData(Column pathCol) {
        try {
            if (_cols.containsKey(pathCol)) return _cols.get(pathCol);


            DataObject col = pathCol.constructDataObject();
            _cols.put(pathCol, col);
            return col;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public DataObject findData(Column pathCol) {
        if (_cols.containsKey(pathCol)) return _cols.get(pathCol);
        else  return null;
    }

    public DataObject setTextValue(Column col, String value) {
        DataObject erg = getData(col);

        erg.setTextValue(value);

        return erg;
    }

    public DataObject setTimestampValue(Column col, Date date) {

        try {
            TimestampDataObject erg = (TimestampDataObject) getData(col);
            erg.setTimestampValue(date);
            return erg;
        }  catch (ClassCastException ex) {
            return setTextValue(col,date.toString());
        }

    }

    public DataObject setValue(Column col, long value) {
        try {
            ValueDataObject erg = (ValueDataObject) getData(col);
            erg.setValue(value);
            return erg;
        }  catch (ClassCastException ex) {
            return setTextValue(col,""+value);
        }
    }

    public DataObject setValue(Column col, double value) {
        try {
            ValueDataObject erg = (ValueDataObject) getData(col);
            erg.setValue(value);
            return erg;
        }  catch (ClassCastException ex) {
            return setTextValue(col,""+value);
        }
    }
}
