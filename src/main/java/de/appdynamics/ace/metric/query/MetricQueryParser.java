// Generated from /vlab/development/github/RestMetricQueries/src/main/antlr/MetricQuery.g4 by ANTLR 4.5.3
package de.appdynamics.ace.metric.query;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MetricQueryParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, NUMBER_NO_LEADING_ZEROS=11, TIME_UNIT=12, ANSIDATE=13, ANSITIME=14, 
		TIMEZONE=15, EXPORT=16, METRIC=17, AGGREGATED=18, FROM=19, ON=20, WS=21, 
		COMMA=22, STAR=23, PLAINSTRING=24, APPLICATION=25, ID=26;
	public static final int
		RULE_query = 0, RULE_exportStatement = 1, RULE_timeStatement = 2, RULE_timeShiftingStatement = 3, 
		RULE_fieldList = 4, RULE_anyField = 5, RULE_metriclist = 6, RULE_metric = 7, 
		RULE_metricname = 8, RULE_pathSelection = 9, RULE_pathElements = 10, RULE_pathElement = 11, 
		RULE_elementName = 12, RULE_pathElementName = 13, RULE_anyElement = 14, 
		RULE_componentSelection = 15, RULE_componentIdentifier = 16, RULE_ansiDate = 17;
	public static final String[] ruleNames = {
		"query", "exportStatement", "timeStatement", "timeShiftingStatement", 
		"fieldList", "anyField", "metriclist", "metric", "metricname", "pathSelection", 
		"pathElements", "pathElement", "elementName", "pathElementName", "anyElement", 
		"componentSelection", "componentIdentifier", "ansiDate"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'for'", "'starting'", "'ending'", "'at'", "'ago'", "'\"'", "'as'", 
		"'''", "'\\'", "'.'", null, null, null, null, null, null, null, "'aggregated'", 
		"'from'", "'on'", null, "','", "'*'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "NUMBER_NO_LEADING_ZEROS", 
		"TIME_UNIT", "ANSIDATE", "ANSITIME", "TIMEZONE", "EXPORT", "METRIC", "AGGREGATED", 
		"FROM", "ON", "WS", "COMMA", "STAR", "PLAINSTRING", "APPLICATION", "ID"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MetricQuery.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MetricQueryParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class QueryContext extends ParserRuleContext {
		public TerminalNode EXPORT() { return getToken(MetricQueryParser.EXPORT, 0); }
		public ExportStatementContext exportStatement() {
			return getRuleContext(ExportStatementContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MetricQueryParser.EOF, 0); }
		public TerminalNode METRIC() { return getToken(MetricQueryParser.METRIC, 0); }
		public TerminalNode AGGREGATED() { return getToken(MetricQueryParser.AGGREGATED, 0); }
		public TimeStatementContext timeStatement() {
			return getRuleContext(TimeStatementContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetricQueryVisitor ) return ((MetricQueryVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(EXPORT);
			setState(38);
			_la = _input.LA(1);
			if (_la==METRIC) {
				{
				setState(37);
				match(METRIC);
				}
			}

			setState(41);
			_la = _input.LA(1);
			if (_la==AGGREGATED) {
				{
				setState(40);
				match(AGGREGATED);
				}
			}

			setState(43);
			exportStatement();
			setState(45);
			_la = _input.LA(1);
			if (_la==T__0 || _la==T__1) {
				{
				setState(44);
				timeStatement();
				}
			}

			setState(47);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExportStatementContext extends ParserRuleContext {
		public FieldListContext fieldList() {
			return getRuleContext(FieldListContext.class,0);
		}
		public TerminalNode FROM() { return getToken(MetricQueryParser.FROM, 0); }
		public PathSelectionContext pathSelection() {
			return getRuleContext(PathSelectionContext.class,0);
		}
		public TerminalNode ON() { return getToken(MetricQueryParser.ON, 0); }
		public ComponentSelectionContext componentSelection() {
			return getRuleContext(ComponentSelectionContext.class,0);
		}
		public ExportStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exportStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).enterExportStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).exitExportStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetricQueryVisitor ) return ((MetricQueryVisitor<? extends T>)visitor).visitExportStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExportStatementContext exportStatement() throws RecognitionException {
		ExportStatementContext _localctx = new ExportStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_exportStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			fieldList();
			setState(50);
			match(FROM);
			setState(51);
			pathSelection();
			setState(52);
			match(ON);
			setState(53);
			componentSelection();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimeStatementContext extends ParserRuleContext {
		public TimeStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeStatement; }
	 
		public TimeStatementContext() { }
		public void copyFrom(TimeStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RelativeTimerangeContext extends TimeStatementContext {
		public TerminalNode NUMBER_NO_LEADING_ZEROS() { return getToken(MetricQueryParser.NUMBER_NO_LEADING_ZEROS, 0); }
		public TerminalNode TIME_UNIT() { return getToken(MetricQueryParser.TIME_UNIT, 0); }
		public TimeShiftingStatementContext timeShiftingStatement() {
			return getRuleContext(TimeShiftingStatementContext.class,0);
		}
		public RelativeTimerangeContext(TimeStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).enterRelativeTimerange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).exitRelativeTimerange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetricQueryVisitor ) return ((MetricQueryVisitor<? extends T>)visitor).visitRelativeTimerange(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AbsoluteTimerangeContext extends TimeStatementContext {
		public List<AnsiDateContext> ansiDate() {
			return getRuleContexts(AnsiDateContext.class);
		}
		public AnsiDateContext ansiDate(int i) {
			return getRuleContext(AnsiDateContext.class,i);
		}
		public AbsoluteTimerangeContext(TimeStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).enterAbsoluteTimerange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).exitAbsoluteTimerange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetricQueryVisitor ) return ((MetricQueryVisitor<? extends T>)visitor).visitAbsoluteTimerange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeStatementContext timeStatement() throws RecognitionException {
		TimeStatementContext _localctx = new TimeStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_timeStatement);
		int _la;
		try {
			setState(66);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new RelativeTimerangeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				match(T__0);
				setState(56);
				match(NUMBER_NO_LEADING_ZEROS);
				setState(57);
				match(TIME_UNIT);
				setState(59);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << NUMBER_NO_LEADING_ZEROS))) != 0)) {
					{
					setState(58);
					timeShiftingStatement();
					}
				}

				}
				break;
			case T__1:
				_localctx = new AbsoluteTimerangeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				match(T__1);
				setState(62);
				ansiDate();
				setState(63);
				match(T__2);
				setState(64);
				ansiDate();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimeShiftingStatementContext extends ParserRuleContext {
		public int value;
		public TimeShiftingStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeShiftingStatement; }
	 
		public TimeShiftingStatementContext() { }
		public void copyFrom(TimeShiftingStatementContext ctx) {
			super.copyFrom(ctx);
			this.value = ctx.value;
		}
	}
	public static class AbsoluteTimerangeOffsetContext extends TimeShiftingStatementContext {
		public AnsiDateContext ansiDate() {
			return getRuleContext(AnsiDateContext.class,0);
		}
		public AbsoluteTimerangeOffsetContext(TimeShiftingStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).enterAbsoluteTimerangeOffset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).exitAbsoluteTimerangeOffset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetricQueryVisitor ) return ((MetricQueryVisitor<? extends T>)visitor).visitAbsoluteTimerangeOffset(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelativeTimerangeOffsetContext extends TimeShiftingStatementContext {
		public TerminalNode NUMBER_NO_LEADING_ZEROS() { return getToken(MetricQueryParser.NUMBER_NO_LEADING_ZEROS, 0); }
		public TerminalNode TIME_UNIT() { return getToken(MetricQueryParser.TIME_UNIT, 0); }
		public RelativeTimerangeOffsetContext(TimeShiftingStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).enterRelativeTimerangeOffset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).exitRelativeTimerangeOffset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetricQueryVisitor ) return ((MetricQueryVisitor<? extends T>)visitor).visitRelativeTimerangeOffset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeShiftingStatementContext timeShiftingStatement() throws RecognitionException {
		TimeShiftingStatementContext _localctx = new TimeShiftingStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_timeShiftingStatement);
		int _la;
		try {
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new AbsoluteTimerangeOffsetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(T__1);
				setState(69);
				match(T__3);
				setState(70);
				ansiDate();
				}
				break;
			case 2:
				_localctx = new AbsoluteTimerangeOffsetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				match(T__2);
				setState(72);
				match(T__3);
				setState(73);
				ansiDate();
				}
				break;
			case 3:
				_localctx = new RelativeTimerangeOffsetContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				match(T__1);
				setState(75);
				match(NUMBER_NO_LEADING_ZEROS);
				setState(76);
				match(TIME_UNIT);
				setState(77);
				match(T__4);
				}
				break;
			case 4:
				_localctx = new RelativeTimerangeOffsetContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(78);
					match(T__2);
					}
				}

				setState(81);
				match(NUMBER_NO_LEADING_ZEROS);
				setState(82);
				match(TIME_UNIT);
				setState(83);
				match(T__4);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldListContext extends ParserRuleContext {
		public AnyFieldContext anyField() {
			return getRuleContext(AnyFieldContext.class,0);
		}
		public MetriclistContext metriclist() {
			return getRuleContext(MetriclistContext.class,0);
		}
		public FieldListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).enterFieldList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).exitFieldList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetricQueryVisitor ) return ((MetricQueryVisitor<? extends T>)visitor).visitFieldList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldListContext fieldList() throws RecognitionException {
		FieldListContext _localctx = new FieldListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fieldList);
		try {
			setState(88);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				anyField();
				}
				break;
			case T__5:
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				metriclist();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnyFieldContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(MetricQueryParser.STAR, 0); }
		public AnyFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).enterAnyField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).exitAnyField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetricQueryVisitor ) return ((MetricQueryVisitor<? extends T>)visitor).visitAnyField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnyFieldContext anyField() throws RecognitionException {
		AnyFieldContext _localctx = new AnyFieldContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_anyField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(STAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MetriclistContext extends ParserRuleContext {
		public List<MetricContext> metric() {
			return getRuleContexts(MetricContext.class);
		}
		public MetricContext metric(int i) {
			return getRuleContext(MetricContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MetricQueryParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MetricQueryParser.COMMA, i);
		}
		public MetriclistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metriclist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).enterMetriclist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).exitMetriclist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetricQueryVisitor ) return ((MetricQueryVisitor<? extends T>)visitor).visitMetriclist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MetriclistContext metriclist() throws RecognitionException {
		MetriclistContext _localctx = new MetriclistContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_metriclist);
		int _la;
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				metric();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				metric();
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(94);
					match(COMMA);
					setState(95);
					metric();
					}
					}
					setState(98); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MetricContext extends ParserRuleContext {
		public String metricName;
		public MetricnameContext metricname;
		public MetricnameContext metricname() {
			return getRuleContext(MetricnameContext.class,0);
		}
		public PathElementNameContext pathElementName() {
			return getRuleContext(PathElementNameContext.class,0);
		}
		public MetricContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metric; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).enterMetric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).exitMetric(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetricQueryVisitor ) return ((MetricQueryVisitor<? extends T>)visitor).visitMetric(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MetricContext metric() throws RecognitionException {
		MetricContext _localctx = new MetricContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_metric);
		int _la;
		try {
			setState(120);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				match(T__5);
				setState(103);
				((MetricContext)_localctx).metricname = metricname();
				setState(104);
				match(T__5);
				setState(107);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(105);
					match(T__6);
					setState(106);
					pathElementName();
					}
				}

				((MetricContext)_localctx).metricName =  (((MetricContext)_localctx).metricname!=null?_input.getText(((MetricContext)_localctx).metricname.start,((MetricContext)_localctx).metricname.stop):null);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(T__7);
				setState(112);
				((MetricContext)_localctx).metricname = metricname();
				setState(113);
				match(T__7);
				setState(116);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(114);
					match(T__6);
					setState(115);
					pathElementName();
					}
				}

				((MetricContext)_localctx).metricName =  (((MetricContext)_localctx).metricname!=null?_input.getText(((MetricContext)_localctx).metricname.start,((MetricContext)_localctx).metricname.stop):null);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MetricnameContext extends ParserRuleContext {
		public MetricnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metricname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).enterMetricname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).exitMetricname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetricQueryVisitor ) return ((MetricQueryVisitor<? extends T>)visitor).visitMetricname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MetricnameContext metricname() throws RecognitionException {
		MetricnameContext _localctx = new MetricnameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_metricname);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(122);
				_la = _input.LA(1);
				if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__7) | (1L << T__8))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(125); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__6) | (1L << T__9) | (1L << NUMBER_NO_LEADING_ZEROS) | (1L << TIME_UNIT) | (1L << ANSIDATE) | (1L << ANSITIME) | (1L << TIMEZONE) | (1L << EXPORT) | (1L << METRIC) | (1L << AGGREGATED) | (1L << FROM) | (1L << ON) | (1L << WS) | (1L << COMMA) | (1L << STAR) | (1L << PLAINSTRING) | (1L << APPLICATION) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathSelectionContext extends ParserRuleContext {
		public PathElementsContext pathElements() {
			return getRuleContext(PathElementsContext.class,0);
		}
		public PathSelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathSelection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).enterPathSelection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).exitPathSelection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetricQueryVisitor ) return ((MetricQueryVisitor<? extends T>)visitor).visitPathSelection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathSelectionContext pathSelection() throws RecognitionException {
		PathSelectionContext _localctx = new PathSelectionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_pathSelection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			pathElements();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathElementsContext extends ParserRuleContext {
		public PathElementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathElements; }
	 
		public PathElementsContext() { }
		public void copyFrom(PathElementsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DottedPathElementsContext extends PathElementsContext {
		public List<PathElementContext> pathElement() {
			return getRuleContexts(PathElementContext.class);
		}
		public PathElementContext pathElement(int i) {
			return getRuleContext(PathElementContext.class,i);
		}
		public DottedPathElementsContext(PathElementsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).enterDottedPathElements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).exitDottedPathElements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetricQueryVisitor ) return ((MetricQueryVisitor<? extends T>)visitor).visitDottedPathElements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathElementsContext pathElements() throws RecognitionException {
		PathElementsContext _localctx = new PathElementsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_pathElements);
		int _la;
		try {
			_localctx = new DottedPathElementsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			pathElement();
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(130);
				match(T__9);
				setState(131);
				pathElement();
				}
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathElementContext extends ParserRuleContext {
		public String elementText;
		public ElementNameContext elementName;
		public AnyElementContext anyElement() {
			return getRuleContext(AnyElementContext.class,0);
		}
		public PathElementNameContext pathElementName() {
			return getRuleContext(PathElementNameContext.class,0);
		}
		public ElementNameContext elementName() {
			return getRuleContext(ElementNameContext.class,0);
		}
		public PathElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).enterPathElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).exitPathElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetricQueryVisitor ) return ((MetricQueryVisitor<? extends T>)visitor).visitPathElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathElementContext pathElement() throws RecognitionException {
		PathElementContext _localctx = new PathElementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pathElement);
		int _la;
		try {
			setState(160);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				anyElement();
				setState(140);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(138);
					match(T__6);
					setState(139);
					pathElementName();
					}
				}

				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				match(T__5);
				setState(143);
				((PathElementContext)_localctx).elementName = elementName();
				setState(144);
				match(T__5);
				setState(147);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(145);
					match(T__6);
					setState(146);
					pathElementName();
					}
				}

				 ((PathElementContext)_localctx).elementText =  (((PathElementContext)_localctx).elementName!=null?_input.getText(((PathElementContext)_localctx).elementName.start,((PathElementContext)_localctx).elementName.stop):null);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(151);
				match(T__7);
				setState(152);
				((PathElementContext)_localctx).elementName = elementName();
				setState(153);
				match(T__7);
				setState(156);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(154);
					match(T__6);
					setState(155);
					pathElementName();
					}
				}

				 ((PathElementContext)_localctx).elementText =  (((PathElementContext)_localctx).elementName!=null?_input.getText(((PathElementContext)_localctx).elementName.start,((PathElementContext)_localctx).elementName.stop):null);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementNameContext extends ParserRuleContext {
		public ElementNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).enterElementName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).exitElementName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetricQueryVisitor ) return ((MetricQueryVisitor<? extends T>)visitor).visitElementName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementNameContext elementName() throws RecognitionException {
		ElementNameContext _localctx = new ElementNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_elementName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(162);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==T__5 || _la==T__7) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(165); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << NUMBER_NO_LEADING_ZEROS) | (1L << TIME_UNIT) | (1L << ANSIDATE) | (1L << ANSITIME) | (1L << TIMEZONE) | (1L << EXPORT) | (1L << METRIC) | (1L << AGGREGATED) | (1L << FROM) | (1L << ON) | (1L << WS) | (1L << COMMA) | (1L << STAR) | (1L << PLAINSTRING) | (1L << APPLICATION) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathElementNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MetricQueryParser.ID, 0); }
		public PathElementNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathElementName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).enterPathElementName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).exitPathElementName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetricQueryVisitor ) return ((MetricQueryVisitor<? extends T>)visitor).visitPathElementName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathElementNameContext pathElementName() throws RecognitionException {
		PathElementNameContext _localctx = new PathElementNameContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pathElementName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnyElementContext extends ParserRuleContext {
		public AnyElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).enterAnyElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).exitAnyElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetricQueryVisitor ) return ((MetricQueryVisitor<? extends T>)visitor).visitAnyElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnyElementContext anyElement() throws RecognitionException {
		AnyElementContext _localctx = new AnyElementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_anyElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(STAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComponentSelectionContext extends ParserRuleContext {
		public ComponentSelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_componentSelection; }
	 
		public ComponentSelectionContext() { }
		public void copyFrom(ComponentSelectionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ApplicationComponentSelectionContext extends ComponentSelectionContext {
		public TerminalNode APPLICATION() { return getToken(MetricQueryParser.APPLICATION, 0); }
		public ComponentIdentifierContext componentIdentifier() {
			return getRuleContext(ComponentIdentifierContext.class,0);
		}
		public ApplicationComponentSelectionContext(ComponentSelectionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).enterApplicationComponentSelection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).exitApplicationComponentSelection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetricQueryVisitor ) return ((MetricQueryVisitor<? extends T>)visitor).visitApplicationComponentSelection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComponentSelectionContext componentSelection() throws RecognitionException {
		ComponentSelectionContext _localctx = new ComponentSelectionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_componentSelection);
		try {
			_localctx = new ApplicationComponentSelectionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(APPLICATION);
			setState(172);
			componentIdentifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComponentIdentifierContext extends ParserRuleContext {
		public String compName;
		public ElementNameContext elementName;
		public ElementNameContext elementName() {
			return getRuleContext(ElementNameContext.class,0);
		}
		public ComponentIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_componentIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).enterComponentIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).exitComponentIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetricQueryVisitor ) return ((MetricQueryVisitor<? extends T>)visitor).visitComponentIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComponentIdentifierContext componentIdentifier() throws RecognitionException {
		ComponentIdentifierContext _localctx = new ComponentIdentifierContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_componentIdentifier);
		try {
			setState(184);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				match(T__5);
				setState(175);
				((ComponentIdentifierContext)_localctx).elementName = elementName();
				setState(176);
				match(T__5);
				((ComponentIdentifierContext)_localctx).compName =  (((ComponentIdentifierContext)_localctx).elementName!=null?_input.getText(((ComponentIdentifierContext)_localctx).elementName.start,((ComponentIdentifierContext)_localctx).elementName.stop):null);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				match(T__7);
				setState(180);
				((ComponentIdentifierContext)_localctx).elementName = elementName();
				setState(181);
				match(T__7);
				((ComponentIdentifierContext)_localctx).compName =  (((ComponentIdentifierContext)_localctx).elementName!=null?_input.getText(((ComponentIdentifierContext)_localctx).elementName.start,((ComponentIdentifierContext)_localctx).elementName.stop):null);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnsiDateContext extends ParserRuleContext {
		public TerminalNode ANSIDATE() { return getToken(MetricQueryParser.ANSIDATE, 0); }
		public TerminalNode ANSITIME() { return getToken(MetricQueryParser.ANSITIME, 0); }
		public TerminalNode TIMEZONE() { return getToken(MetricQueryParser.TIMEZONE, 0); }
		public AnsiDateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ansiDate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).enterAnsiDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetricQueryListener ) ((MetricQueryListener)listener).exitAnsiDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetricQueryVisitor ) return ((MetricQueryVisitor<? extends T>)visitor).visitAnsiDate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnsiDateContext ansiDate() throws RecognitionException {
		AnsiDateContext _localctx = new AnsiDateContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_ansiDate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(ANSIDATE);
			setState(187);
			match(ANSITIME);
			setState(189);
			_la = _input.LA(1);
			if (_la==TIMEZONE) {
				{
				setState(188);
				match(TIMEZONE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\34\u00c2\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\5\2)\n\2\3\2\5\2,\n\2\3\2\3\2\5\2\60\n\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4>\n\4\3\4\3\4\3\4\3\4\3\4\5"+
		"\4E\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5R\n\5\3\5\3\5\3"+
		"\5\5\5W\n\5\3\6\3\6\5\6[\n\6\3\7\3\7\3\b\3\b\3\b\3\b\6\bc\n\b\r\b\16\b"+
		"d\5\bg\n\b\3\t\3\t\3\t\3\t\3\t\5\tn\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5"+
		"\tw\n\t\3\t\3\t\5\t{\n\t\3\n\6\n~\n\n\r\n\16\n\177\3\13\3\13\3\f\3\f\3"+
		"\f\7\f\u0087\n\f\f\f\16\f\u008a\13\f\3\r\3\r\3\r\5\r\u008f\n\r\3\r\3\r"+
		"\3\r\3\r\3\r\5\r\u0096\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u009f\n\r\3"+
		"\r\3\r\5\r\u00a3\n\r\3\16\6\16\u00a6\n\16\r\16\16\16\u00a7\3\17\3\17\3"+
		"\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\5\22\u00bb\n\22\3\23\3\23\3\23\5\23\u00c0\n\23\3\23\2\2\24\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$\2\4\4\2\b\b\n\13\4\2\b\b\n\n\u00c8"+
		"\2&\3\2\2\2\4\63\3\2\2\2\6D\3\2\2\2\bV\3\2\2\2\nZ\3\2\2\2\f\\\3\2\2\2"+
		"\16f\3\2\2\2\20z\3\2\2\2\22}\3\2\2\2\24\u0081\3\2\2\2\26\u0083\3\2\2\2"+
		"\30\u00a2\3\2\2\2\32\u00a5\3\2\2\2\34\u00a9\3\2\2\2\36\u00ab\3\2\2\2 "+
		"\u00ad\3\2\2\2\"\u00ba\3\2\2\2$\u00bc\3\2\2\2&(\7\22\2\2\')\7\23\2\2("+
		"\'\3\2\2\2()\3\2\2\2)+\3\2\2\2*,\7\24\2\2+*\3\2\2\2+,\3\2\2\2,-\3\2\2"+
		"\2-/\5\4\3\2.\60\5\6\4\2/.\3\2\2\2/\60\3\2\2\2\60\61\3\2\2\2\61\62\7\2"+
		"\2\3\62\3\3\2\2\2\63\64\5\n\6\2\64\65\7\25\2\2\65\66\5\24\13\2\66\67\7"+
		"\26\2\2\678\5 \21\28\5\3\2\2\29:\7\3\2\2:;\7\r\2\2;=\7\16\2\2<>\5\b\5"+
		"\2=<\3\2\2\2=>\3\2\2\2>E\3\2\2\2?@\7\4\2\2@A\5$\23\2AB\7\5\2\2BC\5$\23"+
		"\2CE\3\2\2\2D9\3\2\2\2D?\3\2\2\2E\7\3\2\2\2FG\7\4\2\2GH\7\6\2\2HW\5$\23"+
		"\2IJ\7\5\2\2JK\7\6\2\2KW\5$\23\2LM\7\4\2\2MN\7\r\2\2NO\7\16\2\2OW\7\7"+
		"\2\2PR\7\5\2\2QP\3\2\2\2QR\3\2\2\2RS\3\2\2\2ST\7\r\2\2TU\7\16\2\2UW\7"+
		"\7\2\2VF\3\2\2\2VI\3\2\2\2VL\3\2\2\2VQ\3\2\2\2W\t\3\2\2\2X[\5\f\7\2Y["+
		"\5\16\b\2ZX\3\2\2\2ZY\3\2\2\2[\13\3\2\2\2\\]\7\31\2\2]\r\3\2\2\2^g\5\20"+
		"\t\2_b\5\20\t\2`a\7\30\2\2ac\5\20\t\2b`\3\2\2\2cd\3\2\2\2db\3\2\2\2de"+
		"\3\2\2\2eg\3\2\2\2f^\3\2\2\2f_\3\2\2\2g\17\3\2\2\2hi\7\b\2\2ij\5\22\n"+
		"\2jm\7\b\2\2kl\7\t\2\2ln\5\34\17\2mk\3\2\2\2mn\3\2\2\2no\3\2\2\2op\b\t"+
		"\1\2p{\3\2\2\2qr\7\n\2\2rs\5\22\n\2sv\7\n\2\2tu\7\t\2\2uw\5\34\17\2vt"+
		"\3\2\2\2vw\3\2\2\2wx\3\2\2\2xy\b\t\1\2y{\3\2\2\2zh\3\2\2\2zq\3\2\2\2{"+
		"\21\3\2\2\2|~\n\2\2\2}|\3\2\2\2~\177\3\2\2\2\177}\3\2\2\2\177\u0080\3"+
		"\2\2\2\u0080\23\3\2\2\2\u0081\u0082\5\26\f\2\u0082\25\3\2\2\2\u0083\u0088"+
		"\5\30\r\2\u0084\u0085\7\f\2\2\u0085\u0087\5\30\r\2\u0086\u0084\3\2\2\2"+
		"\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\27"+
		"\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008e\5\36\20\2\u008c\u008d\7\t\2\2"+
		"\u008d\u008f\5\34\17\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u00a3"+
		"\3\2\2\2\u0090\u0091\7\b\2\2\u0091\u0092\5\32\16\2\u0092\u0095\7\b\2\2"+
		"\u0093\u0094\7\t\2\2\u0094\u0096\5\34\17\2\u0095\u0093\3\2\2\2\u0095\u0096"+
		"\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\b\r\1\2\u0098\u00a3\3\2\2\2\u0099"+
		"\u009a\7\n\2\2\u009a\u009b\5\32\16\2\u009b\u009e\7\n\2\2\u009c\u009d\7"+
		"\t\2\2\u009d\u009f\5\34\17\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u00a1\b\r\1\2\u00a1\u00a3\3\2\2\2\u00a2\u008b\3\2"+
		"\2\2\u00a2\u0090\3\2\2\2\u00a2\u0099\3\2\2\2\u00a3\31\3\2\2\2\u00a4\u00a6"+
		"\n\3\2\2\u00a5\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\33\3\2\2\2\u00a9\u00aa\7\34\2\2\u00aa\35\3\2\2\2"+
		"\u00ab\u00ac\7\31\2\2\u00ac\37\3\2\2\2\u00ad\u00ae\7\33\2\2\u00ae\u00af"+
		"\5\"\22\2\u00af!\3\2\2\2\u00b0\u00b1\7\b\2\2\u00b1\u00b2\5\32\16\2\u00b2"+
		"\u00b3\7\b\2\2\u00b3\u00b4\b\22\1\2\u00b4\u00bb\3\2\2\2\u00b5\u00b6\7"+
		"\n\2\2\u00b6\u00b7\5\32\16\2\u00b7\u00b8\7\n\2\2\u00b8\u00b9\b\22\1\2"+
		"\u00b9\u00bb\3\2\2\2\u00ba\u00b0\3\2\2\2\u00ba\u00b5\3\2\2\2\u00bb#\3"+
		"\2\2\2\u00bc\u00bd\7\17\2\2\u00bd\u00bf\7\20\2\2\u00be\u00c0\7\21\2\2"+
		"\u00bf\u00be\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0%\3\2\2\2\30(+/=DQVZdfm"+
		"vz\177\u0088\u008e\u0095\u009e\u00a2\u00a7\u00ba\u00bf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}