package de.appdynamics.ace.metric.query.parser;

/**
 * Created by stefan.marx on 18.07.14.
 */
public class MetricParserException extends Exception {

    public MetricParserException(String msg) {
        super(msg);
    }

    public MetricParserException( String msg, Throwable t) {
        super(msg,t);
    }
}
