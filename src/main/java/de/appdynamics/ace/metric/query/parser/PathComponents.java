package de.appdynamics.ace.metric.query.parser;

/**
 * Created by stefan.marx on 18.07.14.
 */
public enum PathComponents {
    APPLICATION (1,"Application:");
    private final String _name;
    private final int _index;

    public String getName() {
        return _name;
    }

    public int getIndex() {
        return _index;
    }

    PathComponents(int index, String name) {
        this._index = index;
        this._name = name;
    }

    @Override
    public String toString() {
        return this.getName()+"("+getIndex()+")";
    }
}
