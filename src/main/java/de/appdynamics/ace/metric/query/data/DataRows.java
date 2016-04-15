package de.appdynamics.ace.metric.query.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stefan.marx on 21.07.14.
 */
public class DataRows implements Cloneable{
    Map<String,DataRow> _rowData = new HashMap<String,DataRow>();


    @Override
    protected Object clone() throws CloneNotSupportedException {
        DataRows r = new DataRows();
        r._rowData = new HashMap<String, DataRow>(_rowData);

        return r;
    }

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

    public DataRows cloneFiltered(Column splitCol,String value) throws CloneNotSupportedException {
        DataRows erg;
        erg = (DataRows) this.clone();
        for (Map.Entry<String,DataRow> row:_rowData.entrySet()) {
            DataObject data = row.getValue().findData(splitCol);
            if (data != null) {
                if (!data.getTextValue().equals(value)) {
                    // Remove Entry from cloned copy if filter criteria isn't met
                    erg._rowData.remove(row.getKey());
                }
            }

        }
        return erg;
    }
}
