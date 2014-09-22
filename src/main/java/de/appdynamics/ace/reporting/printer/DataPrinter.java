package de.appdynamics.ace.reporting.printer;

import de.appdynamics.ace.metric.query.data.DataMap;
import de.appdynamics.ace.metric.query.rest.ControllerRestAccess;


import java.io.OutputStream;

/**
 * Created by stefan.marx on 21.08.14.
 */
public interface DataPrinter {

    void printData(String query, ControllerRestAccess client, DataMap result, OutputStream os);

    boolean isRequireSimplified();
}
