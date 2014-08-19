package de.appdynamics.ace.metric.query.data;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by stefan.marx on 22.07.14.
 */
public class TimestampDataObject extends DataObject {
    private Date _timestampValue;

    public void setTimestampValue(Date timestampValue) {
        _timestampValue = timestampValue;
    }

    public Date getTimestampValue() {
        return _timestampValue;
    }

    @Override
    public void setTextValue(String value) {
        try {
            setTimestampValue(DateFormat.getDateTimeInstance().parse(value));
        } catch (ParseException e) {
            e.printStackTrace();
            setTimestampValue(null);
        }
    }

    @Override
    public String getTextValue() {
        if (getTimestampValue() != null) return getTimestampValue().toString();
        return "";
    }
}
