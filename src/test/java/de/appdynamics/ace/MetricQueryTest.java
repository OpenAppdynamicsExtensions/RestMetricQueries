package de.appdynamics.ace;

import de.appdynamics.ace.metric.query.MetricQueryLexer;
import de.appdynamics.ace.metric.query.MetricQueryParser;
import junit.framework.TestCase;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Nullable;
import org.junit.Test;

import java.util.BitSet;

/**
 * Created by stefan.marx on 17.07.14.
 */
public class MetricQueryTest extends TestCase {

    @Test
    public void testSimpleStatements() {
        execute("export 'nope (count/ms)','My pony #ÄÖÜ' from 'Overall Application Performance' on Application 'Name'");
        execute("export aggregated 'nope (count/ms)','My pony #ÄÖÜ' from 'Overall Application Performance' on Application 'Name'");
        execute("export 'A' from 'Overall Application Performance' on Application 'Name'");
        execute("export * from 'Overall Application Performance' on Application 'Name'");

    }

    @Test
    public void testFullSimpleStatement() {
        execute("export * from \"Overall Application Performance\" on Application 'Name'");
    }

    @Test
    public void testMultiplePathElements () {
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name'");
    }

    @Test
    public void testMultiplePathElementsWithTimerange () {
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' for 29 minutes");
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' for 1 day");
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' for 1 day ending 2 days ago");
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' for 1 day 2 days ago");
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' for 1 day ending at 2014-12-31 20:00:21");
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' for 1 day starting at 2014-12-31 20:00:21");
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' for 1 day starting 2 days ago");
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' for 1 day starting 2 days ago");
        execute("export 'A' from 'Overall Application Performance'.'Master' on Application 'Name' starting  2014-12-31 20:00:21 ending 2014-12-31 20:00:21");
    }

    @Test
    public void testWildCardInPath() {
        execute ("export 'Calls per Minute' from 'Business Transaction Performance'.'Business Transactions'.*.* on Application 'Name'");
    }

    @Test
    public void testNamedPathElementsPath() {
        execute ("export 'Calls per Minute' from 'Business Transaction Performance'.'Business Transactions'.* as tierName . * as BT on Application 'Name'");
    }


    private static void execute(String test) {
        CharStream input = new ANTLRInputStream(test);

        MetricQueryLexer lexer = new MetricQueryLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MetricQueryParser parser = new MetricQueryParser(tokens);
        parser.addErrorListener(new ANTLRErrorListener() {
            @Override
            public void syntaxError(@NotNull Recognizer<?, ?> recognizer, @Nullable Object offendingSymbol, int line, int charPositionInLine, @NotNull String msg, @Nullable RecognitionException e) {
                  fail(msg);
            }

            @Override
            public void reportAmbiguity(@NotNull Parser recognizer, @NotNull DFA dfa, int startIndex, int stopIndex, boolean exact, @Nullable BitSet ambigAlts, @NotNull ATNConfigSet configs) {
                fail("No1");

            }

            @Override
            public void reportAttemptingFullContext(@NotNull Parser recognizer, @NotNull DFA dfa, int startIndex, int stopIndex, @Nullable BitSet conflictingAlts, @NotNull ATNConfigSet configs) {
                fail("no2");

            }

            @Override
            public void reportContextSensitivity(@NotNull Parser recognizer, @NotNull DFA dfa, int startIndex, int stopIndex, int prediction, @NotNull ATNConfigSet configs) {
                fail("no3");

            }
        });

        MetricQueryParser.QueryContext pt = parser.query();

        System.out.println("Q: "+test+" -->");
        System.out.println(pt.toStringTree(parser));
        //System.out.println(pt.queryDefinition);


    }
}
