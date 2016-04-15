package de.appdynamics.ace;

import de.appdynamics.ace.metric.query.data.Column;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stefan.marx on 21.07.14.
 */
public class CloneMetricTest {




    String q3 = "export aggregated * from 'Business Transaction Performance|Business Transactions'.* as Tier. * as BT " +
            "on Application 'ECommerce' "+
            "for 1 day" ;



    @Test
    public void testPrettyTable() throws MetricParserException, QueryException, CloneNotSupportedException {


        DataPrinter printer = new TableDataPrinter();
        ControllerRestAccess a = new ControllerRestAccess(TestConsts.DEMO_APPDYNAMICS_COM, "80", false, "demouser", "Ghed7ped0geN", "customer1");




        DataMap data2 = executeQuery(q3, printer, "TABLE");
        Column pathCol = data2.getHeaderColumn(DataMap.PATH);
        List<DataMap> maps = data2.splitBy(pathCol);
        printListOfMaps(printer, a, maps);
    }

    @Test
    public void testPrettyTableMultipleSplit() throws MetricParserException, QueryException, CloneNotSupportedException {


        DataPrinter printer = new TableDataPrinter();
        ControllerRestAccess a = new ControllerRestAccess(TestConsts.DEMO_APPDYNAMICS_COM, "80", false, "demouser", "Ghed7ped0geN", "customer1");




        DataMap data2 = executeQuery(q3, printer, "TABLE");


        Column col1 = data2.getHeaderColumn("Tier");
        Column col2 = data2.getHeaderColumn("BT");

        Column [] cols = {col1,col2};


        List<DataMap> maps = data2.splitBy(new Column[]{col1, col2});
        printListOfMaps(printer, a, maps);
    }

    private void printListOfMaps(DataPrinter printer, ControllerRestAccess a, List<DataMap> maps) {
        for (DataMap data:maps) {

            System.out.println(" :\n-----------\n");

            OutputStream output = new OutputStream() {
                private StringBuilder string = new StringBuilder();

                @Override
                public void write(int b) throws IOException {
                    this.string.append((char) b);
                }

                public String toString() {
                    return this.string.toString();
                }
            };

            printer.printData(q3, a, data, output);
            System.out.println(":" + output);
        }
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

        return data;
    }



}
