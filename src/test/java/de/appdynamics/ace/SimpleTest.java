package de.appdynamics.ace;

import de.appdynamics.ace.metric.query.parser.CompiledRestMetricQuery;
import de.appdynamics.ace.metric.query.parser.MetricParserException;
import de.appdynamics.ace.metric.query.parser.MetricQuery;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by stefan.marx on 18.07.14.
 */

public class SimpleTest extends TestCase {
    @Test
    public void testSimpleStatements() throws MetricParserException {
        execute("export 'nope (count/ms)','My pony #ÄÖÜ' from 'Overall Application Performance' on Application 'Name'");
        execute("export aggregated 'nope (count/ms)','My pony #ÄÖÜ' from 'Overall Application Performance' on Application 'Name'");
        execute("export 'A' from 'Overall Application Performance' on Application 'Name'");
        execute("export * from 'Overall Application Performance' on Application 'Name'");

    }

    @Test
    public void testBuggyStatements()  {

        try {
            execute("export * from \"Overall Application Performance' on Application 'Name'");
            execute("export * from Overall Application Performance on Application 'Name'");
            execute("export *,'max' from 'Overall Application Performance' on Application 'Name'");
            fail("No Exceptions on wrong Queries");
        } catch (MetricParserException e) {

        }

    }
    private void execute(String query) throws MetricParserException {
        MetricQuery mq = new MetricQuery();

        CompiledRestMetricQuery erg = mq.parse(query);
        System.out.println("Result :"+erg);


    }
}
