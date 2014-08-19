package de.appdynamics.ace;

import de.appdynamics.ace.metric.query.data.DataMap;
import de.appdynamics.ace.metric.query.parser.CompiledRestMetricQuery;
import de.appdynamics.ace.metric.query.parser.MetricParserException;
import de.appdynamics.ace.metric.query.parser.MetricQuery;
import de.appdynamics.ace.metric.query.parser.QueryException;
import junit.framework.TestCase;
import org.appdynamics.appdrestapi.RESTAccess;
import org.junit.Test;

/**
 * Created by stefan.marx on 21.07.14.
 */
public class RetrieveMetricTest  {


    @Test
    public void testSimpleQuery() throws MetricParserException, QueryException {
        String q = "export 'Calls per Minute' from " +
                "'Business Transaction Performance'." +
                "'Business Transactions'." +
                "'E-Commerce'.'Checkout'" +
                "on Application 'Acme Online Book Store' for 4 hours 1 day ago";

        DataMap m = executeQuery(q,true);
       
    }

    @Test
    public void testSimpleWildcardQuery() throws MetricParserException, QueryException {
        String q = "export * from " +
                "'Business Transaction Performance'." +
                "'Business Transactions'." +
                "'E-Commerce'.'Checkout'" +
                "on Application 'Acme Online Book Store'";

        DataMap m = executeQuery(q,false);

    }

    @Test
    public void testAggregatedWildcardQuery() throws MetricParserException, QueryException {
        String q = "export aggregated * from " +
                "'Business Transaction Performance'." +
                "'Business Transactions'." +
                "'E-Commerce'.'Checkout'" +
                "on Application 'Acme Online Book Store'";



        DataMap m = executeQuery(q,true);

    }

    private DataMap executeQuery(String query,boolean condensed) throws MetricParserException, QueryException {
        System.out.println("Query :" + query);
        MetricQuery mq = new MetricQuery();

        CompiledRestMetricQuery erg = mq.parse( query);

        RESTAccess a = new RESTAccess("controller3.demo.appdynamics.com","80",false,"demouser","apm13ad3r","customer1");


        DataMap data = erg.execute(a,condensed);
        System.out.println("DATA:" + data.dumpData());
        data.getHeader();
        data.getOrderedRows();

        return data;
    }
}
