package de.appdynamics.ace.metric.query.parser;

import de.appdynamics.ace.metric.query.rest.RestException;

/**
 * Created by stefan.marx on 21.07.14.
 */
public class QueryException extends Exception {
    public QueryException(String msg) {
        super(msg)                          ;
    }

    public QueryException(String s, RestException e) {
        super(s,e);

    }
}
