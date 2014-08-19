package de.appdynamics.ace.metric.query.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stefan.marx on 21.07.14.
 */
public class DataRows {
    Map<String,DataRow> _rowData = new HashMap<String,DataRow>();


    public DataRow getDataRow(String rowKey) {

        if (_rowData.containsKey(rowKey)) return _rowData.get(rowKey);

        DataRow r = new DataRow(rowKey,getNewRowId());
        _rowData.put(rowKey,r);
        return r;
    }



    private int _lastRowIndex = 1;

    private synchronized int getNewRowId() {
        return _lastRowIndex++;
    }

    public java.util.Collection<DataRow> getRows() {
        return _rowData.values();
    }
}
