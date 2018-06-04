package de.appdynamics.ace;

import de.appdynamics.ace.metric.query.data.DataMap;
import de.appdynamics.ace.metric.query.parser.CompiledRestMetricQuery;
import de.appdynamics.ace.metric.query.parser.MetricParserException;
import de.appdynamics.ace.metric.query.parser.MetricQuery;
import de.appdynamics.ace.metric.query.parser.QueryException;
import de.appdynamics.ace.metric.query.rest.ControllerRestAccess;
import de.appdynamics.ace.reporting.printer.DataPrinter;
import de.appdynamics.ace.reporting.printer.TableDataPrinter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;

/**
 * Created by stefan.marx on 05.06.15.
 */
public class MainTest {
    static String q = "export aggregated  'Calls per Minute', 'Average Response Time (ms)' from " +
            "'Business Transaction Performance'." +
            "'Business Transactions'." +
            "* as tier . * as transaction " +
            "on Application 'Fulfillment' for 1 day";

    static String q3 = "export aggregated * from 'Business Transaction Performance|Business Transactions|*|*' " +
            "on Application 'Fulfillment' "+
            "for 1 day" ;

    public static void main(String[] args) {
        try {
            testAggregatedWildcardQueryTable();
        } catch (MetricParserException e) {
            e.printStackTrace();
        } catch (QueryException e) {
            e.printStackTrace();
        }
    }

    public static void testAggregatedWildcardQueryTable() throws MetricParserException, QueryException {

        String q = "export aggregated 'Average Response Time (ms)' from " +
                "'Business Transaction Performance'." +
                "'Business Transactions'." +
                "* as tier . * as transaction " +
                "on Application 'Fulfillment' for 1 day";
        executeQuery(q,new TableDataPrinter(),"TABLE");

    }
    private static  DataMap executeQuery(String query,  DataPrinter printer, String name) throws MetricParserException, QueryException {
        MetricQuery mq = new MetricQuery();

        CompiledRestMetricQuery erg = mq.parse( query);


        StringWriter writer = new StringWriter();

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


        ControllerRestAccess a = new ControllerRestAccess(TestConsts.DEMO_APPDYNAMICS_COM, "80", false, "demouser", System.getProperty("PASSWD"), "customer1");


        DataMap data = erg.execute(a,printer.isRequireSimplified());
        System.out.println(name+" :\n-----------\n");

        printer.printData(query, a, data,output );
        System.out.println(":"+output);
        return data;
    }
}
