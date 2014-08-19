package de.appdynamics.ace.metric.query.data;

/**
 * Created by stefan.marx on 21.07.14.
 */
public class TextColumn extends Column{
    public TextColumn(String name) {
        super(name);

    }

    @Override
    public DataObject constructDataObject() {
        return new TextDataObject();
    }
}
