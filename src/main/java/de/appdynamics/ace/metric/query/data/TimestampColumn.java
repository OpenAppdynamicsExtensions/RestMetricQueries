package de.appdynamics.ace.metric.query.data;

/**
 * Created by stefan.marx on 21.07.14.
 */
public class TimestampColumn extends Column{
    public TimestampColumn(String name) {
        super(name);

    }

    @Override
    public DataObject constructDataObject() {
        return new TimestampDataObject();
    }
}
