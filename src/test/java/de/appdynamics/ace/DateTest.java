package de.appdynamics.ace;

import de.appdynamics.ace.metric.query.MetricQueryLexer;
import de.appdynamics.ace.metric.query.MetricQueryParser;
import de.appdynamics.ace.metric.query.parser.CompiledRestMetricQuery;
import de.appdynamics.ace.metric.query.parser.MetricParserException;
import de.appdynamics.ace.metric.query.parser.MetricQuery;
import de.appdynamics.ace.metric.query.parser.MetricQueryCompiler;
import junit.framework.TestCase;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Created by stefan.marx on 19.08.14.
 */
public class DateTest extends TestCase {
    public void  testDate () throws MetricParserException {
        MetricQueryParser.AnsiDateContext p = parseQuery("2014-12-31 20:00:21");

        System.out.println(p.getText());
    }
    public void  testDate2 () throws MetricParserException {
        MetricQueryParser.AnsiDateContext p = parseQuery("2014-12-31 20:00:21 (CET)");

        System.out.println(p.getText());
    }

    public void testDateCompiler() throws MetricParserException {
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' ");
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' for 1 day");
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' for 1 day ending 2 days ago");
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' for 1 day 2 days ago");
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' for 1 day ending at 2014-12-31 20:00:21");
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' for 1 day starting at 2014-12-31 20:00:21");
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' for 1 day starting 2 days ago");
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' for 1 day starting 2 days ago");
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' starting  2014-12-31 20:00:21 (EST) ending 2014-12-11 20:00:21 (EST)");
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' starting  2014-12-31 20:00:21 (GMT) ending 2014-12-11 20:00:21 (GMT)");
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' starting  2014-12-31 20:00:21  ending 2014-12-11 20:00:21 ");
    }

    public void testDateCompilerUnits() throws MetricParserException {
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' for 5 minutes");
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' for 5 hours");
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' for 5 days");
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' for 5 weeks");
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' for 5 months");


    }
    private CompiledRestMetricQuery execute(String q) throws MetricParserException {
        System.out.println("Compile :");
        System.out.println("  "+q);
        System.out.println( "---");
        MetricQuery mq = new MetricQuery();

        CompiledRestMetricQuery erg = mq.parse( q);

        System.out.println("ERG:"+erg);
        System.out.println("----");
        return erg;
    }

    private MetricQueryParser.AnsiDateContext parseQuery(final String query) throws MetricParserException {
        CharStream input = new ANTLRInputStream(query);

        MetricQueryLexer lexer = new MetricQueryLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MetricQueryParser parser = new MetricQueryParser(tokens);


        MetricQueryParser.AnsiDateContext pt = parser.ansiDate();

        return pt;
    }
}


