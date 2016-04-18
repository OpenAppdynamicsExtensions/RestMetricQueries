package de.appdynamics.ace;

import de.appdynamics.ace.metric.query.data.DataMap;
import de.appdynamics.ace.metric.query.parser.CompiledRestMetricQuery;
import de.appdynamics.ace.metric.query.parser.MetricParserException;
import de.appdynamics.ace.metric.query.parser.MetricQuery;
import de.appdynamics.ace.metric.query.parser.QueryException;
import de.appdynamics.ace.metric.query.rest.ControllerRestAccess;
import de.appdynamics.ace.reporting.printer.*;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;

/**
 * Created by stefan.marx on 21.07.14.
 */
public class MetricAliasTest {




    String q3 = "export aggregated 'Stall Count' as stalls, 'Number of Slow Calls' as slows,'Average Response Time (ms)' as resp from 'Business Transaction Performance|Business Transactions|*|*' " +
            "on Application 'ECommerce' "+
            "for 1 day" ;



    @Test
    public void testAliasTable() throws MetricParserException, QueryException {

        executeQuery(q3,new PrettyDataPrinter(),"TABLE");

    }

    @Test
    public void testAliasFull() throws MetricParserException, QueryException {

        executeQuery(q3,new TableDataPrinter(),"TABLE");

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


}
