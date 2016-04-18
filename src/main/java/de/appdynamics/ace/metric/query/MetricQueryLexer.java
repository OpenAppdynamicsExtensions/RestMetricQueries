// Generated from /vlab/development/github/RestMetricQueries/src/main/antlr/MetricQuery.g4 by ANTLR 4.3
package de.appdynamics.ace.metric.query;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MetricQueryLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__9=1, T__8=2, T__7=3, T__6=4, T__5=5, T__4=6, T__3=7, T__2=8, T__1=9, 
		T__0=10, NUMBER_NO_LEADING_ZEROS=11, TIME_UNIT=12, ANSIDATE=13, ANSITIME=14, 
		TIMEZONE=15, EXPORT=16, METRIC=17, AGGREGATED=18, FROM=19, ON=20, WS=21, 
		COMMA=22, STAR=23, PLAINSTRING=24, APPLICATION=25, ID=26;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'"
	};
	public static final String[] ruleNames = {
		"T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", 
		"T__0", "DIGIT", "DIGIT_NOT_ZERO", "NUMBER_NO_LEADING_ZEROS", "TIME_UNIT", 
		"ANSIDATE", "ANSITIME", "TIMEZONE", "EXPORT", "METRIC", "AGGREGATED", 
		"FROM", "ON", "WS", "COMMA", "STAR", "PLAINSTRING", "APPLICATION", "ID"
	};


	public MetricQueryLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MetricQuery.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\34\u00fa\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\3\16\6\16i\n\16\r\16\16\16j\5\16m\n\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17w\n\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\177\n\17\3\17\3\17\3\17\3\17\3\17\5\17\u0086\n\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\5\17\u008e\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0097"+
		"\n\17\5\17\u0099\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u00c4\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\6\30\u00da"+
		"\n\30\r\30\16\30\u00db\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\5\35\u00f3"+
		"\n\35\3\35\7\35\u00f6\n\35\f\35\16\35\u00f9\13\35\2\2\36\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\2\31\2\33\r\35\16\37\17!\20#\21%\22"+
		"\'\23)\24+\25-\26/\27\61\30\63\31\65\32\67\339\34\3\2\t\4\2GGgg\4\2OO"+
		"oo\5\2\13\f\17\17\"\"\4\2$$))\4\2CCcc\4\2C\\c|\5\2\62;C\\c|\u0105\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\3;\3\2\2\2\5?\3\2\2\2\7B\3\2\2\2\t"+
		"D\3\2\2\2\13F\3\2\2\2\rM\3\2\2\2\17P\3\2\2\2\21R\3\2\2\2\23V\3\2\2\2\25"+
		"_\3\2\2\2\27a\3\2\2\2\31c\3\2\2\2\33l\3\2\2\2\35\u0098\3\2\2\2\37\u009a"+
		"\3\2\2\2!\u00a5\3\2\2\2#\u00ae\3\2\2\2%\u00b4\3\2\2\2\'\u00bb\3\2\2\2"+
		")\u00c5\3\2\2\2+\u00d0\3\2\2\2-\u00d5\3\2\2\2/\u00d9\3\2\2\2\61\u00df"+
		"\3\2\2\2\63\u00e1\3\2\2\2\65\u00e3\3\2\2\2\67\u00e5\3\2\2\29\u00f2\3\2"+
		"\2\2;<\7c\2\2<=\7i\2\2=>\7q\2\2>\4\3\2\2\2?@\7c\2\2@A\7u\2\2A\6\3\2\2"+
		"\2BC\7)\2\2C\b\3\2\2\2DE\7^\2\2E\n\3\2\2\2FG\7g\2\2GH\7p\2\2HI\7f\2\2"+
		"IJ\7k\2\2JK\7p\2\2KL\7i\2\2L\f\3\2\2\2MN\7c\2\2NO\7v\2\2O\16\3\2\2\2P"+
		"Q\7\60\2\2Q\20\3\2\2\2RS\7h\2\2ST\7q\2\2TU\7t\2\2U\22\3\2\2\2VW\7u\2\2"+
		"WX\7v\2\2XY\7c\2\2YZ\7t\2\2Z[\7v\2\2[\\\7k\2\2\\]\7p\2\2]^\7i\2\2^\24"+
		"\3\2\2\2_`\7$\2\2`\26\3\2\2\2ab\4\62;\2b\30\3\2\2\2cd\4\63;\2d\32\3\2"+
		"\2\2em\5\27\f\2fh\5\31\r\2gi\5\27\f\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk"+
		"\3\2\2\2km\3\2\2\2le\3\2\2\2lf\3\2\2\2m\34\3\2\2\2no\7o\2\2op\7k\2\2p"+
		"q\7p\2\2qr\7w\2\2rs\7v\2\2st\7g\2\2tv\3\2\2\2uw\7u\2\2vu\3\2\2\2vw\3\2"+
		"\2\2w\u0099\3\2\2\2xy\7j\2\2yz\7q\2\2z{\7w\2\2{|\7t\2\2|~\3\2\2\2}\177"+
		"\7u\2\2~}\3\2\2\2~\177\3\2\2\2\177\u0099\3\2\2\2\u0080\u0081\7f\2\2\u0081"+
		"\u0082\7c\2\2\u0082\u0083\7{\2\2\u0083\u0085\3\2\2\2\u0084\u0086\7u\2"+
		"\2\u0085\u0084\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0099\3\2\2\2\u0087\u0088"+
		"\7y\2\2\u0088\u0089\7g\2\2\u0089\u008a\7g\2\2\u008a\u008b\7m\2\2\u008b"+
		"\u008d\3\2\2\2\u008c\u008e\7u\2\2\u008d\u008c\3\2\2\2\u008d\u008e\3\2"+
		"\2\2\u008e\u0099\3\2\2\2\u008f\u0090\7o\2\2\u0090\u0091\7q\2\2\u0091\u0092"+
		"\7p\2\2\u0092\u0093\7v\2\2\u0093\u0094\7j\2\2\u0094\u0096\3\2\2\2\u0095"+
		"\u0097\7u\2\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2"+
		"\2\2\u0098n\3\2\2\2\u0098x\3\2\2\2\u0098\u0080\3\2\2\2\u0098\u0087\3\2"+
		"\2\2\u0098\u008f\3\2\2\2\u0099\36\3\2\2\2\u009a\u009b\5\27\f\2\u009b\u009c"+
		"\5\27\f\2\u009c\u009d\5\27\f\2\u009d\u009e\5\27\f\2\u009e\u009f\7/\2\2"+
		"\u009f\u00a0\5\27\f\2\u00a0\u00a1\5\27\f\2\u00a1\u00a2\7/\2\2\u00a2\u00a3"+
		"\5\27\f\2\u00a3\u00a4\5\27\f\2\u00a4 \3\2\2\2\u00a5\u00a6\5\27\f\2\u00a6"+
		"\u00a7\5\27\f\2\u00a7\u00a8\7<\2\2\u00a8\u00a9\5\27\f\2\u00a9\u00aa\5"+
		"\27\f\2\u00aa\u00ab\7<\2\2\u00ab\u00ac\5\27\f\2\u00ac\u00ad\5\27\f\2\u00ad"+
		"\"\3\2\2\2\u00ae\u00af\7*\2\2\u00af\u00b0\4C\\\2\u00b0\u00b1\4C\\\2\u00b1"+
		"\u00b2\4C\\\2\u00b2\u00b3\7+\2\2\u00b3$\3\2\2\2\u00b4\u00b5\t\2\2\2\u00b5"+
		"\u00b6\7z\2\2\u00b6\u00b7\7r\2\2\u00b7\u00b8\7q\2\2\u00b8\u00b9\7t\2\2"+
		"\u00b9\u00ba\7v\2\2\u00ba&\3\2\2\2\u00bb\u00bc\t\3\2\2\u00bc\u00bd\7g"+
		"\2\2\u00bd\u00be\7v\2\2\u00be\u00bf\7t\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1"+
		"\7e\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00c4\7u\2\2\u00c3\u00c2\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4(\3\2\2\2\u00c5\u00c6\7c\2\2\u00c6\u00c7\7i\2\2\u00c7"+
		"\u00c8\7i\2\2\u00c8\u00c9\7t\2\2\u00c9\u00ca\7g\2\2\u00ca\u00cb\7i\2\2"+
		"\u00cb\u00cc\7c\2\2\u00cc\u00cd\7v\2\2\u00cd\u00ce\7g\2\2\u00ce\u00cf"+
		"\7f\2\2\u00cf*\3\2\2\2\u00d0\u00d1\7h\2\2\u00d1\u00d2\7t\2\2\u00d2\u00d3"+
		"\7q\2\2\u00d3\u00d4\7o\2\2\u00d4,\3\2\2\2\u00d5\u00d6\7q\2\2\u00d6\u00d7"+
		"\7p\2\2\u00d7.\3\2\2\2\u00d8\u00da\t\4\2\2\u00d9\u00d8\3\2\2\2\u00da\u00db"+
		"\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd"+
		"\u00de\b\30\2\2\u00de\60\3\2\2\2\u00df\u00e0\7.\2\2\u00e0\62\3\2\2\2\u00e1"+
		"\u00e2\7,\2\2\u00e2\64\3\2\2\2\u00e3\u00e4\n\5\2\2\u00e4\66\3\2\2\2\u00e5"+
		"\u00e6\t\6\2\2\u00e6\u00e7\7r\2\2\u00e7\u00e8\7r\2\2\u00e8\u00e9\7n\2"+
		"\2\u00e9\u00ea\7k\2\2\u00ea\u00eb\7e\2\2\u00eb\u00ec\7c\2\2\u00ec\u00ed"+
		"\7v\2\2\u00ed\u00ee\7k\2\2\u00ee\u00ef\7q\2\2\u00ef\u00f0\7p\2\2\u00f0"+
		"8\3\2\2\2\u00f1\u00f3\t\7\2\2\u00f2\u00f1\3\2\2\2\u00f3\u00f7\3\2\2\2"+
		"\u00f4\u00f6\t\b\2\2\u00f5\u00f4\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5"+
		"\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8:\3\2\2\2\u00f9\u00f7\3\2\2\2\20\2j"+
		"lv~\u0085\u008d\u0096\u0098\u00c3\u00db\u00f2\u00f5\u00f7\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}