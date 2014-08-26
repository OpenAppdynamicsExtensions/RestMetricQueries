package de.appdynamics.ace.tools.printer;

import de.appdynamics.ace.metric.query.data.*;

import java.io.PrintWriter;

/**
 * Created by stefan.marx on 21.08.14.
 */
public class CSVDataPrinter extends IterativeDataPrinter {
    private final String _seperator;
    private final String _wrapper;

    public CSVDataPrinter(String separator, String stringWrapper) {
        _seperator = separator;
        _wrapper = stringWrapper;

    }


     protected void printHeaderCell(PrintWriter pw, boolean first, Column c) {
        if (!first) pw.print(_seperator);
        pw.print(_wrapper+c.getName()+_wrapper);
    }

    @Override
    protected void printDataRowStart(PrintWriter pw, int i) {

    }

    @Override
    protected void printDataRowEnd(PrintWriter pw) {
          pw.print("\n");
    }

    @Override
    protected void printHeaderEnd(PrintWriter pw) {
        pw.print("\n");
    }

    @Override
    protected void printDataEnd(PrintWriter pw) {

    }

    @Override
    protected void printFooter(PrintWriter pw) {

    }

    @Override
    protected void printHeader(PrintWriter pw, String query) {

    }

    protected void printDataCell(PrintWriter pw, boolean first, DataRow r, Column c) {
        if (!first) pw.print(_seperator);
        DataObject data = r.findData(c);
        if (data instanceof TextDataObject) {
            TextDataObject td = (TextDataObject) data;
            pw.print(_wrapper);
            String s = td.getTextValue();
            s.replace(_wrapper,_wrapper+_wrapper);
            pw.print(s);
            pw.print(_wrapper);
        } else if (data instanceof TimestampDataObject) {
            pw.print(_wrapper);
            pw.print(data.getTextValue());
            pw.print(_wrapper);
        } else if (data instanceof ValueDataObject) {
            pw.print(_wrapper);
            pw.print(data.getTextValue());
            pw.print(_wrapper);
        } else                 {
            pw.print(_wrapper);
            pw.print(data.getTextValue());
            pw.print(_wrapper);
        }
    }

}
