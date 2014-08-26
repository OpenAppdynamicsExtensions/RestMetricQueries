package de.appdynamics.ace.tools.printer;

import de.appdynamics.ace.metric.query.data.Column;
import de.appdynamics.ace.metric.query.data.DataMap;
import de.appdynamics.ace.metric.query.data.DataRow;
import org.appdynamics.appdrestapi.RESTAccess;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by stefan.marx on 21.08.14.
 */
public abstract class IterativeDataPrinter implements DataPrinter{
    @Override
    public void printData(String query, RESTAccess client, DataMap result, OutputStream os) {
        ArrayList<Column> cl = result.getHeader();
        Collection<DataRow> rows = result.getOrderedRows();

        PrintWriter pw = new PrintWriter(os);

        printHeader(pw, query);

        boolean first = true;
        for (Column c : cl) {


            printHeaderCell(pw,first, c);

            if (first) first=false;
        }

        printHeaderEnd(pw);

        int rowCount = 0;
        for (DataRow r : rows) {
            first = true;
            printDataRowStart(pw, ++rowCount);
            for (Column c : cl) {
                printDataCell(pw, first, r, c);
                if (first) first=false;
            }
            printDataRowEnd(pw);
        }

        printDataEnd(pw);
        printFooter(pw);
        
        pw.close();
    }

    protected abstract void printDataRowStart(PrintWriter pw, int i);

    protected abstract void printDataRowEnd(PrintWriter pw);

    protected abstract void printHeaderEnd(PrintWriter pw);

    protected abstract void printDataEnd(PrintWriter pw);

    protected abstract void printFooter(PrintWriter pw);

    protected abstract void printHeader(PrintWriter pw, String query);

    protected abstract void printDataCell(PrintWriter pw, boolean first, DataRow r, Column c);

    protected abstract void printHeaderCell(PrintWriter pw, boolean first, Column c) ;

    @Override
    public boolean isRequireSimplified() {
        return false;
    }
}
