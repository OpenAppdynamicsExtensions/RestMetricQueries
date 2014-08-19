package de.appdynamics.ace.metric.query.data;

/**
 * Created by stefan.marx on 22.07.14.
 */
public class ValueDataObject extends DataObject {
    private long _intValue = 0;
    private double _doubleValue = 0;
    private boolean _bfDouble = false;
    private boolean _bfInt = false;

    public void setValue(long intValue) {
        _intValue = intValue;
        _bfInt = true;
    }
    public void setValue(double value) {
        _doubleValue = value;
        _bfDouble=true;
    }

    public double getValue() {
        if (_bfInt) return _intValue;
        else return _doubleValue;
    }


    @Override
    public void setTextValue(String value) {
        setValue(Double.parseDouble(value));
    }

    @Override
    public String getTextValue() {
        return ""+getValue();
    }
}
