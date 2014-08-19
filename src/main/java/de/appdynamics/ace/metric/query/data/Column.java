package de.appdynamics.ace.metric.query.data;

/**
 * Created by stefan.marx on 21.07.14.
 */
public abstract class Column implements Comparable<Column>{
    private String _name;
    private int _ID;

    public Column(String name) {
         _name = name;


    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public void setID(int ID) {
        _ID = ID;
    }

    public int getID() {
        return _ID;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Column) {
            Column c = (Column) obj;
            return getID()==c.getID();
        }
        return super.equals(obj);
    }


    @Override
    public int compareTo(Column target) {
        return getID()-target.getID();
    }

    public abstract DataObject constructDataObject() ;
}
