package de.appdynamics.ace;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by stefan.marx on 19.08.14.
 */
public class TestDateMath {
    public static void main(String[] args) {
        Date now = new Date();
        Calendar calc = new GregorianCalendar();
        calc.setTime(now);
        System.out.println("Starting with Date "+now);
        calc.add(Calendar.MONTH,-1);
        System.out.println("BEcomming "+calc.getTime());
    }
}
