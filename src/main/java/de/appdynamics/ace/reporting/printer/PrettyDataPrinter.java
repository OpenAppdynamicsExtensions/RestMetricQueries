package de.appdynamics.ace.reporting.printer;

import de.appdynamics.ace.metric.query.data.Column;
import de.appdynamics.ace.metric.query.data.DataMap;
import de.appdynamics.ace.metric.query.data.DataRow;
import org.appdynamics.appdrestapi.RESTAccess;

import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Created by stefan.marx on 21.08.14.
 */
public class PrettyDataPrinter extends IterativeDataPrinter{

    private int maxColumnLableLength = 0;

    @Override
    public void printData(String query, RESTAccess client, DataMap result, OutputStream os) {
        maxColumnLableLength = 0;
        for (Column c : result.getHeader()) {
            int s = c.getName().length();
            if (s > maxColumnLableLength) maxColumnLableLength = s;
        }
        super.printData(query, client, result, os);
    }

    @Override
    protected void printDataRowStart(PrintWriter pw, int i) {

    }

    @Override
    protected void printDataRowEnd(PrintWriter pw) {

        pw.print("--\n");
    }

    @Override
    protected void printHeaderEnd(PrintWriter pw) {

    }

    @Override
    protected void printDataEnd(PrintWriter pw) {

    }

    @Override
    protected void printFooter(PrintWriter pw) {

    }

    @Override
    protected void printHeader(PrintWriter pw, String query) {
          pw.print("Results for Query :"+query+"\n");
    }

    @Override
    protected void printDataCell(PrintWriter pw, boolean first, DataRow r, Column c) {
          pw.print(c.getName());
        pw.print(" : ");
        fillLine(pw,c.getName().length());
        pw.print(r.findData(c).getTextValue());
        pw.print("\n");
    }

    private void fillLine(PrintWriter pw, int length) {
        for (int i = length ; i <= maxColumnLableLength; i++) {
            pw.print(" ");
        }

    }

    @Override
    protected void printHeaderCell(PrintWriter pw, boolean first, Column c) {

    }

    @Override
    public boolean isRequireSimplified() {
        return true;
    }
}
