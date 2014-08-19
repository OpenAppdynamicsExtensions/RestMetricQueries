package de.appdynamics.ace.metric.query.data;

/**
 * Created by stefan.marx on 22.07.14.
 */
public class TextDataObject extends DataObject {
    private String _stringValue;

    @Override
    public void setTextValue(String value) {
        _stringValue = value;
    }

    @Override
    public String getTextValue() {
        return _stringValue;
    }
}
