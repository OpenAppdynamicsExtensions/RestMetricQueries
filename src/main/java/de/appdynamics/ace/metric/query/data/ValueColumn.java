package de.appdynamics.ace.metric.query.data;

/**
 * Created by stefan.marx on 21.07.14.
 */
public class ValueColumn extends Column{
    public ValueColumn(String name) {
        super(name);
    }

    @Override
    public DataObject constructDataObject() {
        return new ValueDataObject();
    }
}
