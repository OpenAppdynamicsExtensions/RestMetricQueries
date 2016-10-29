package de.appdynamics.ace;

import de.appdynamics.ace.metric.query.data.DataMap;
import de.appdynamics.ace.metric.query.parser.CompiledRestMetricQuery;
import de.appdynamics.ace.metric.query.parser.MetricParserException;
import de.appdynamics.ace.metric.query.parser.MetricQuery;
import de.appdynamics.ace.metric.query.parser.QueryException;
import de.appdynamics.ace.metric.query.rest.ControllerRestAccess;
import org.junit.Test;

/**
 * Created by stefan.marx on 21.07.14.
 */
public class SimpleRetrieveTest {


    @Test
    public void testSimpleQuery() throws MetricParserException, QueryException {
        String q = "export 'Calls per Minute' from " +
                "'Business Transaction Performance'." +
                "'Business Transactions'." +
                "'MovieSearchSite'.'/'" +
                "on Application 'Movie Tickets Online' for 4 hours 1 day ago";

        DataMap m = executeQuery(q,true);
       
    }


    @Test

    public void testAggregatedWildcardQuery() throws MetricParserException, QueryException {
        String q = "export aggregated * from " +
                "'Business Transaction Performance'." +
                "'Business Transactions'." +
                "'MovieSearchSite'.'/'" +
                "on Application 'Movie Tickets Online'";



        DataMap m = executeQuery(q,true);

    }

    private DataMap executeQuery(String query,boolean condensed) throws MetricParserException, QueryException {
        System.out.println("Query :" + query);
        MetricQuery mq = new MetricQuery();

        CompiledRestMetricQuery erg = mq.parse( query);

        ControllerRestAccess a = new ControllerRestAccess(TestConsts.DEMO_APPDYNAMICS_COM, "80", false, "demouser", "Ghed7ped0geN", "customer1");


        DataMap data = erg.execute(a,condensed);
        System.out.println("DATA:" + data.dumpData());
        data.getHeader();
        data.getOrderedRows();

        return data;
    }
}
