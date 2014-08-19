package de.appdynamics.ace;

import de.appdynamics.ace.metric.query.parser.CompiledRestMetricQuery;
import de.appdynamics.ace.metric.query.parser.MetricParserException;
import de.appdynamics.ace.metric.query.parser.MetricQuery;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by stefan.marx on 18.07.14.
 */
public class RestQueryBuilderTest extends TestCase {

    @Test
      public void testSimpleQuery () throws MetricParserException {
        String q = "export 'Calls per Minute' from " +
                "'Business Transaction Performance'." +
                "'Business Transactions'." +
                "'E-Commerce'.'Checkout'" +
                "on Application 'Acme Online Book Store'";
        ArrayList<String> result = executeQuery(q);

        ArrayList<String> resultCompare = new ArrayList<String>();
        resultCompare.add("Business Transaction Performance|Business Transactions|E-Commerce|Checkout|Calls per Minute");

        checkResults(resultCompare,result);

    }

    public void testSimpleTimedQuery () throws MetricParserException {
        String q = "export 'Calls per Minute' from " +
                "'Business Transaction Performance'." +
                "'Business Transactions'." +
                "'E-Commerce'.'Checkout'" +
                "on Application 'Acme Online Book Store' for 1 day";
        ArrayList<String> result = executeQuery(q);

        ArrayList<String> resultCompare = new ArrayList<String>();
        resultCompare.add("Business Transaction Performance|Business Transactions|E-Commerce|Checkout|Calls per Minute");

        checkResults(resultCompare,result);

    }

    @Test
    public void testSimpleQueryPipe () throws MetricParserException {
        String q = "export 'Calls per Minute' from " +
                "'Business Transaction Performance|Business Transactions|E-Commerce|Checkout'" +
                "on Application 'Acme Online Book Store'";
        ArrayList<String> result = executeQuery(q);

        ArrayList<String> resultCompare = new ArrayList<String>();
        resultCompare.add("Business Transaction Performance|Business Transactions|E-Commerce|Checkout|Calls per Minute");

        checkResults(resultCompare,result);

    }

    private void checkResults(ArrayList<String> resultCompare, ArrayList<String> result) {
        String msg = "";
        for (String r : result) {
            if (!resultCompare.contains(r)) msg += "Result wasn't expected :\n"+r+"\n";
        }

        for (String r: resultCompare) {
            if (!result.contains(r)) msg += "Result wasn't found :\n"+r+"\n";
        }

        if (!msg.equals("")) fail (msg);

    }

    private ArrayList<String> executeQuery(String q) throws MetricParserException {
        MetricQuery mq = new MetricQuery();

        CompiledRestMetricQuery erg = mq.parse( q);
        return erg.getQueryStrings();
    }

}
