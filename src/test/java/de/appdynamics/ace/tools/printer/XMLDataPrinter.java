package de.appdynamics.ace.tools.printer;

import de.appdynamics.ace.metric.query.data.Column;
import de.appdynamics.ace.metric.query.data.DataRow;

import java.io.PrintWriter;

/**
 * Created by stefan.marx on 21.08.14.
 */
public class XMLDataPrinter extends IterativeDataPrinter {
    private final boolean _useSimplified;

    public XMLDataPrinter(boolean b) {
        _useSimplified = b;

    }

    @Override
    public boolean isRequireSimplified() {
        return _useSimplified;
    }

    @Override
    protected void printDataRowStart(PrintWriter pw, int i) {
        pw.print("<Row index=\""+i+"\">\n");
    }

    @Override
    protected void printDataRowEnd(PrintWriter pw) {
      pw.print("</Row>\n");
    }

    @Override
    protected void printHeaderEnd(PrintWriter pw) {


    }

    @Override
    protected void printDataEnd(PrintWriter pw) {



    }

    @Override
    protected void printFooter(PrintWriter pw) {

        pw.print("</ExportedData>\n");
    }

    @Override
    protected void printHeader(PrintWriter pw, String query) {
        pw.print("<ExportedData>\n");
    }

    @Override
    protected void printDataCell(PrintWriter pw, boolean first, DataRow r, Column c) {
        pw.print("<DataField field=\""+c.getName()+"\" >");
        pw.print(r.findData(c).getTextValue());
        pw.print("</DataField>\n");

    }

    @Override
    protected void printHeaderCell(PrintWriter pw, boolean first, Column c) {

    }
}
