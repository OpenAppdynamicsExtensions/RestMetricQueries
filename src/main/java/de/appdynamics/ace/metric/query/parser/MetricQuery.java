package de.appdynamics.ace.metric.query.parser;


import de.appdynamics.ace.metric.query.MetricQueryLexer;
import de.appdynamics.ace.metric.query.MetricQueryParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.NotNull;


import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by stefan.marx on 18.07.14.
 */
public class MetricQuery {

    public MetricQuery() {}


    public CompiledRestMetricQuery parse(String query) throws MetricParserException{
        CompiledRestMetricQuery erg = null;

        MetricQueryParser.QueryContext ctx = parseQuery(query);

        MetricQueryCompiler compiler =  new MetricQueryCompiler(query,ctx);

        erg = compiler.compile();
        return erg ;
    }

    private MetricQueryParser.QueryContext parseQuery(final String query) throws MetricParserException {
        CharStream input = new ANTLRInputStream(query);

        MetricQueryLexer lexer = new MetricQueryLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MetricQueryParser parser = new MetricQueryParser(tokens);

        ErrorHandler errorHandler = new ErrorHandler();
        parser.addErrorListener(errorHandler);


        MetricQueryParser.QueryContext pt = parser.query();

        if (errorHandler.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder("Errors while parsing :");
            for (String e : errorHandler.getErrors()) {
                errorMessage.append(e).append("\n");
            }
            if (errorHandler.getLastException() != null) {
                throw new MetricParserException(errorMessage.toString(),errorHandler.getLastException());
            }   else {
                throw new MetricParserException(errorMessage.toString());
            }
        }

        return pt;
    }

    private class ErrorHandler implements ANTLRErrorListener {
        public List<String> getErrors() {
            return errors;
        }

        private List<String> errors = new LinkedList<String>();

        public RecognitionException getLastException() {
            return lastException;
        }

        public boolean hasErrors() {
            return !errors.isEmpty();
        }
        private RecognitionException lastException;

        @Override
        public void syntaxError(@NotNull Recognizer<?, ?> recognizer,  Object offendingSymbol, int line, int charPositionInLine, @NotNull String msg,  RecognitionException e) {
            this.errors.add(msg);
            this.lastException = e;
        }

        @Override
        public void reportAmbiguity(@NotNull Parser recognizer, @NotNull DFA dfa, int startIndex, int stopIndex, boolean exact,  BitSet ambigAlts, @NotNull ATNConfigSet configs) {

        }

        @Override
        public void reportAttemptingFullContext(@NotNull Parser recognizer, @NotNull DFA dfa, int startIndex, int stopIndex,  BitSet conflictingAlts, @NotNull ATNConfigSet configs) {

        }

        @Override
        public void reportContextSensitivity(@NotNull Parser recognizer, @NotNull DFA dfa, int startIndex, int stopIndex, int prediction, @NotNull ATNConfigSet configs) {

        }
    }
}
