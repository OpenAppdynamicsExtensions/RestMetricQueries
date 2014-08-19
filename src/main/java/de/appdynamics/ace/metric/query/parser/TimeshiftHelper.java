package de.appdynamics.ace.metric.query.parser;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by stefan.marx on 19.08.14.
 */
public class TimeshiftHelper {
    private final String _rangeUnit;
    private final long _rangeNum;

    private boolean startDateFixed = false;
    private boolean absolute = true;
    private String _fixUnit;
    private long _fixNum;
    private Date _fixDate = new Date();


    public TimeshiftHelper(long number, String unit) {
        _rangeNum = number;
        _rangeUnit = unit;

        setFixedEndDate(new Date());

    }

    public void setFixedEndDate(Date date) {
        startDateFixed = false;
        absolute = true;
        _fixDate = date;

    }

    public void setFixedStartDate(Date date) {
        startDateFixed = true;
        absolute = true;
        _fixDate = date;

    }

    public boolean isStartDateFixed() {
        return startDateFixed;
    }

    public boolean isAbsolute() {
        return absolute;
    }

    public void setRelativeStartDate(long num, String unit) {
        absolute = false;
        startDateFixed = true;
        _fixNum = num;
        _fixUnit = unit;
    }
    public void setRelativeEndDate(long num, String unit) {
        absolute = false;
        startDateFixed = false;
        _fixNum = num;
        _fixUnit = unit;
    }

    /** Calculates the start date based on range and Settings */
    public Date getStartDate() {

        if (isStartDateFixed()) {
            // start date fixed, let's calculate from _fix Fields
            if (isAbsolute()) {
                // easy, just return the fix date
                return _fixDate;
            } else {
                // need calulation, Subtract relatives from current Date
                Date now = new Date();

                now = calcDateOffset(now,_fixUnit,_fixNum*-1);
                return now;
            }

        } else {
            // if Start is not fixed we need to calculate backwards from the end date using the configured range
            Date end = getEndDate();
            return calcDateOffset(end,_rangeUnit,_rangeNum*-1);
        }

    }
    /** Calculates the end date based on range and Settings */
    public Date getEndDate() {
        if (!isStartDateFixed()) {
            // end date fixed, let's calculate from _fix Fields
            if (isAbsolute()) {
                // easy, just return the fix date
                return _fixDate;
            } else {
                // need calulation, Subtract relatives from current Date
                Date now = new Date();

                now = calcDateOffset(now,_fixUnit,_fixNum*-1);
                return now;
            }

        } else {
            // if End is not fixed we need to calculate backwards from the end date using the configured range
            Date start = getStartDate();
            return calcDateOffset(start,_rangeUnit,_rangeNum);
        }

    }
    private Date calcDateOffset(Date now, String unit, long num) {
        if (findCalFieldID(unit) != -1) {
            //time adjustment needed
            Calendar calc = new GregorianCalendar();

            calc.setTime(now);
            calc.add(findCalFieldID(unit),(int)(num*findCalFieldMultiplier(unit)));
            now = calc.getTime();
        }

        return applyTimeAdjustment(now,unit,num);
    }



    private int findCalFieldID(String fixUnit) {
        if (fixUnit.startsWith("minute")) {
           return -1; // no date Calc needed
        }
        if (fixUnit.startsWith("hour")) {
            return -1; // no date Calc needed
        }
        if (fixUnit.startsWith("day")) {
            return Calendar.DATE;
        }
        if (fixUnit.startsWith("week")) {
            return Calendar.DATE; // need to add week multiplier
        }
        if (fixUnit.startsWith("month")) {
            return Calendar.MONTH;
        }
        return -1;

    }

    private int findCalFieldMultiplier(String fixUnit) {
        if (fixUnit.startsWith("week")) {
          return 7;
        }
        return 1;
    }

    private Date applyTimeAdjustment(Date dat, String fixUnit, long num) {
        if (fixUnit.startsWith("minute")) {
          return new Date(dat.getTime()+(num*(1000*60)));
        }
        if (fixUnit.startsWith("hour")) {
            return new Date(dat.getTime()+(num*(1000*60*60)));
        }
        return dat;
    }


}
