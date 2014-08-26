package de.appdynamics.ace.reporting.printer;

import de.appdynamics.ace.metric.query.data.DataMap;
import org.appdynamics.appdrestapi.RESTAccess;

import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Created by stefan.marx on 21.08.14.
 */
public class TableDataPrinter implements DataPrinter {

    @Override
    public void printData(String query, RESTAccess client, DataMap result, OutputStream os) {
        PrintWriter pw = new PrintWriter(os);
        String dataS = result.dumpData();
        pw.print("Query: "+query+"\n");
        pw.print(dataS);
        pw.print("\n");

    }

    @Override
    public boolean isRequireSimplified() {
        return false;
    }
}
