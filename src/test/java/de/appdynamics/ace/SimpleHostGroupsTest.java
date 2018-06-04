package de.appdynamics.ace;

import de.appdynamics.ace.metric.query.data.DataMap;
import de.appdynamics.ace.metric.query.parser.CompiledRestMetricQuery;
import de.appdynamics.ace.metric.query.parser.MetricParserException;
import de.appdynamics.ace.metric.query.parser.MetricQuery;
import de.appdynamics.ace.metric.query.parser.QueryException;
import de.appdynamics.ace.metric.query.rest.ControllerRestAccess;
import de.appdynamics.ace.reporting.printer.TableDataPrinter;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;

/**
 * Created by stefan.marx on 18.07.14.
 */

public class SimpleHostGroupsTest extends TestCase {
    @Test
    public void testSimpleStatements() throws MetricParserException {
//        Application Infrastructure Performance|Root|Master|Cluster|Individual Nodes|NSKDHJ|Hardware Resources|CPU|System
//        execute("export * from 'Application Infrastructure Performance|Root\\|Master\\|Cluster|Individual Nodes|NSKDHJ|Hardware Resources|Memory' on Application 'Server & Infrastructure Monitoring'");
//        execute("export aggregated * from 'Application Infrastructure Performance|Root\\|Master\\|Cluster|Individual Nodes|NSKDHJ|Hardware Resources|Memory' on Application 'Server & Infrastructure Monitoring'");
        execute("export aggregated * from 'Application Infrastructure Performance'. * as cluster .'Individual Nodes|NSKDHJ|Hardware Resources|Memory' on Application 'Server & Infrastructure Monitoring'");
//        execute("export aggregated 'nope (count/ms)','My pony #ÄÖÜ' from 'Overall Application Performance' on Application 'Name'");
//        execute("export 'A' from 'Overall Application Performance' on Application 'Name'");
//        execute("export * from 'Overall Application Performance' on Application 'Name'");

    }

    @Test
    public void testBuggyStatements()  {

//        try {
//            execute("export * from \"Overall Application Performance' on Application 'Name'");
//            execute("export * from Overall Application Performance on Application 'Name'");
//            execute("export *,'max' from 'Overall Application Performance' on Application 'Name'");
//            fail("No Exceptions on wrong Queries");
//        } catch (MetricParserException e) {
//
//        }

    }
    private void execute(String query) throws MetricParserException {
        MetricQuery mq = new MetricQuery();

        CompiledRestMetricQuery erg = mq.parse(query);
        System.out.println("Result :"+erg);


        try {
            getData(query, erg);
        } catch (QueryException e) {
            e.printStackTrace();
        }
        return;

    }

    private DataMap getData(String query, CompiledRestMetricQuery erg) throws QueryException {
        StringWriter writer = new StringWriter();
        TableDataPrinter printer = new TableDataPrinter();

        OutputStream output = new OutputStream()
        {
            private StringBuilder string = new StringBuilder();

            @Override
            public void write(int b) throws IOException {
                this.string.append((char) b );
            }

            public String toString(){
                return this.string.toString();
            }
        };


        ControllerRestAccess a = new ControllerRestAccess("smarxdocker2.ddns.net", "8090", false, "admin", "admin", "customer1");


        DataMap data = erg.execute(a,printer.isRequireSimplified());

        printer.printData(query, a, data,output );
        System.out.println(":"+output);
        return data;
    }
}
