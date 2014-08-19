package de.appdynamics.ace.metric.query.data;

import java.util.*;

/**
 * Created by stefan.marx on 21.07.14.
 */
public class DataColumns {
    private Map<String, Column> _columnMap = new HashMap<String,Column>();
    private int _nextId = 1;

    public Column getColumn(String name) {
        if (_columnMap.containsKey(name) ) return _columnMap.get(name);
        else return null;

    }

    public void registerColumn(Column col) {
        if (_columnMap.containsKey(col.getName())) return;

        col.setID(getNextID());
        _columnMap.put(col.getName(),col);

    }

    private synchronized int getNextID() {
        return _nextId++;
    }

    public ArrayList<Column> getColumnsList() {
        ArrayList<Column> erg = new ArrayList<Column>();
        erg.addAll(_columnMap.values());
        Collections.sort(erg, new Comparator<Column>() {

            @Override
            public int compare(Column o1, Column o2) {
                return o1.getID()-o2.getID();
            }
        });
        return erg;
    }

    public int count() {
        return _columnMap.entrySet().size();
    }
}
