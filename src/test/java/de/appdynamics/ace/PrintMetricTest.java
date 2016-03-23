package de.appdynamics.ace;

import de.appdynamics.ace.metric.query.data.DataMap;
import de.appdynamics.ace.metric.query.parser.CompiledRestMetricQuery;
import de.appdynamics.ace.metric.query.parser.MetricParserException;
import de.appdynamics.ace.metric.query.parser.MetricQuery;
import de.appdynamics.ace.metric.query.parser.QueryException;
import de.appdynamics.ace.metric.query.rest.ControllerRestAccess;
import de.appdynamics.ace.reporting.printer.*;

import org.junit.Test;

import java.io.*;

/**
 * Created by stefan.marx on 21.07.14.
 */
public class PrintMetricTest {


    String q = "export aggregated  'Calls per Minute', 'Average Response Time (ms)' from " +
            "'Business Transaction Performance'." +
            "'Business Transactions'." +
            "* as tier . * as transaction " +
            "on Application 'Fulfillment' for 1 day";

    String q3 = "export aggregated * from 'Business Transaction Performance|Business Transactions|*|*' " +
            "on Application 'Bundy Online Shoes' "+
            "for 1 day" ;


    @Test
    public void testAggregatedWildcardQuery() throws MetricParserException, QueryException {
        executeQuery(q,new PrettyDataPrinter(),"Pretty");

        ControllerRestAccess a = new ControllerRestAccess(TestConsts.DEMO_APPDYNAMICS_COM, "80", false, "demouser", "Ghed7ped0geN", "customer1");

        MetricQuery mq = new MetricQuery();
        String query = "export aggregated * " +
                "from \"Business Transaction Performance|Business Transactions|*|*\" " +
                " on Application 'Bundy Online Shoes'\n" +
                " for 2 days";

        CompiledRestMetricQuery erg = mq.parse( query);
        DataMap result = erg.execute(a);   // Work wih Data
        CSVDataPrinter printer = new CSVDataPrinter(",", "\"");
        printer.printData(query,a,result,System.out);      // Export as CSV

    }
    @Test
    public void testAggregatedWildcardQueryCSV() throws MetricParserException, QueryException {

        executeQuery(q,new CSVDataPrinter("","\""),"CSV");

    }
    @Test
    public void testAggregatedWildcardQueryTable() throws MetricParserException, QueryException {

        executeQuery(q3,new TableDataPrinter(),"TABLE");

    }
    @Test
    public void testAggregatedWildcardQueryCMLSimple() throws MetricParserException, QueryException {
        executeQuery(q,new XMLDataPrinter(false),"XML simple");
    }


    private DataMap executeQuery(String query,  DataPrinter printer, String name) throws MetricParserException, QueryException {
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


        ControllerRestAccess a = new ControllerRestAccess(TestConsts.DEMO_APPDYNAMICS_COM, "80", false, "demouser", "Ghed7ped0geN", "customer1");


        DataMap data = erg.execute(a,printer.isRequireSimplified());
        System.out.println(name+" :\n-----------\n");

        printer.printData(query, a, data,output );
        System.out.println(":"+output);
        return data;
    }
    @Test
    public void testAggregatedWildcardQueryXMLComplex() throws MetricParserException, QueryException {
        executeQuery(q,new XMLDataPrinter(true),"XML condensed");
    }


}
