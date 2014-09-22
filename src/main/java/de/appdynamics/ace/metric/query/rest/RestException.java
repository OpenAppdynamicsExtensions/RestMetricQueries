package de.appdynamics.ace.metric.query.rest;

/**
 * Created by stefan.marx on 28.08.14.
 */
public class RestException extends Exception {
    public RestException(String msg ) {
        super(msg);
    }

    public RestException(String msg, Throwable t) {
        super(msg,t);
    }
}
