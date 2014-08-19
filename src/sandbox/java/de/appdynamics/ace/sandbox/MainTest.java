package de.appdynamics.ace.sandbox;

import de.appdynamics.ace.metric.query.MetricQueryLexer;
import de.appdynamics.ace.metric.query.MetricQueryParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Created by stefan.marx on 16.07.14.
 */
public class MainTest {

    public static void main(String[] args) {



        execute("export \"A\",\"nope (count/ms)\",\"Master\",\"Xjf ölsdaf\"");
        execute("export \"A\"");

        execute("export *");


    }

    private static void execute(String test) {
        CharStream input = new ANTLRInputStream(test);

        MetricQueryLexer lexer = new MetricQueryLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MetricQueryParser parser = new MetricQueryParser(tokens);
        ParseTree pt = parser.query();


        System.out.println("PT :"+pt);
        System.out.println(pt.toStringTree(parser));
    }
}
