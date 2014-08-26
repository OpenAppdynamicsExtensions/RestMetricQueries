package de.appdynamics.ace;

import de.appdynamics.ace.metric.query.data.DataMap;
import de.appdynamics.ace.metric.query.parser.CompiledRestMetricQuery;
import de.appdynamics.ace.metric.query.parser.MetricParserException;
import de.appdynamics.ace.metric.query.parser.MetricQuery;
import de.appdynamics.ace.metric.query.parser.QueryException;
import de.appdynamics.ace.reporting.printer.*;
import org.appdynamics.appdrestapi.RESTAccess;
import org.junit.Test;

import java.io.*;

/**
 * Created by stefan.marx on 21.07.14.
 */
public class PrintMetricTest {


    String q = "export  'Calls per Minute', 'Average Response Time (ms)' from " +
            "'Business Transaction Performance'." +
            "'Business Transactions'." +
            "'Commerce'.*" +
            "on Application 'Bundy Online Shoes' for 5 minutes";


    @Test
    public void testAggregatedWildcardQuery() throws MetricParserException, QueryException {
        executeQuery(q,new PrettyDataPrinter(),"Pretty");

    }
    @Test
    public void testAggregatedWildcardQueryCSV() throws MetricParserException, QueryException {

        executeQuery(q,new CSVDataPrinter("","\""),"CSV");

    }
    @Test
    public void testAggregatedWildcardQueryTable() throws MetricParserException, QueryException {

        executeQuery(q,new TableDataPrinter(),"TABLE");

    }
    @Test
    public void testAggregatedWildcardQueryCMLSimple() throws MetricParserException, QueryException {
        executeQuery(q,new XMLDataPrinter(false),"XML simple");
    }
    @Test
    public void testAggregatedWildcardQueryXMLComplex() throws MetricParserException, QueryException {
        executeQuery(q,new XMLDataPrinter(true),"XML condensed");
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

        RESTAccess a = new RESTAccess("controller3.demo.appdynamics.com","80",false,"demouser","apm13ad3r","customer1");


        DataMap data = erg.execute(a,printer.isRequireSimplified());
        System.out.println(name+" :\n-----------\n");

        printer.printData(query, a, data,output );
        System.out.println(":"+output);
        return data;
    }
}
