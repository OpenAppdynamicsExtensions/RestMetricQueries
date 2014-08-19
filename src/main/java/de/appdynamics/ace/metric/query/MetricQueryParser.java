// Generated from /vlab/development/github/RestMetricQueries/src/main/antlr/MetricQuery.g4 by ANTLR 4.3
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
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		NUMBER_NO_LEADING_ZEROS=10, TIME_UNIT=11, ANSIDATE=12, ANSITIME=13, TIMEZONE=14, 
		EXPORT=15, AGGREGATED=16, FROM=17, ON=18, WS=19, COMMA=20, STAR=21, PLAINSTRING=22, 
		APPLICATION=23;
	public static final String[] tokenNames = {
		"<INVALID>", "'ago'", "'''", "'\\'", "'ending'", "'at'", "'.'", "'for'", 
		"'starting'", "'\"'", "NUMBER_NO_LEADING_ZEROS", "TIME_UNIT", "ANSIDATE", 
		"ANSITIME", "TIMEZONE", "EXPORT", "'aggregated'", "'from'", "'on'", "WS", 
		"','", "'*'", "PLAINSTRING", "APPLICATION"
	};
	public static final int
		RULE_query = 0, RULE_exportStatement = 1, RULE_timeStatement = 2, RULE_timeShiftingStatement = 3, 
		RULE_fieldList = 4, RULE_anyField = 5, RULE_metriclist = 6, RULE_metric = 7, 
		RULE_metricname = 8, RULE_pathSelection = 9, RULE_pathElements = 10, RULE_pathElement = 11, 
		RULE_elementName = 12, RULE_anyElement = 13, RULE_componentSelection = 14, 
		RULE_componentIdentifier = 15, RULE_ansiDate = 16;
	public static final String[] ruleNames = {
		"query", "exportStatement", "timeStatement", "timeShiftingStatement", 
		"fieldList", "anyField", "metriclist", "metric", "metricname", "pathSelection", 
		"pathElements", "pathElement", "elementName", "anyElement", "componentSelection", 
		"componentIdentifier", "ansiDate"
	};

	@Override
	public String getGrammarFileName() { return "MetricQuery.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

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
		public TerminalNode AGGREGATED() { return getToken(MetricQueryParser.AGGREGATED, 0); }
		public TerminalNode EOF() { return getToken(MetricQueryParser.EOF, 0); }
		public ExportStatementContext exportStatement() {
			return getRuleContext(ExportStatementContext.class,0);
		}
		public TerminalNode EXPORT() { return getToken(MetricQueryParser.EXPORT, 0); }
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
			setState(34); match(EXPORT);
			setState(36);
			_la = _input.LA(1);
			if (_la==AGGREGATED) {
				{
				setState(35); match(AGGREGATED);
				}
			}

			setState(38); exportStatement();
			setState(40);
			_la = _input.LA(1);
			if (_la==T__2 || _la==T__1) {
				{
				setState(39); timeStatement();
				}
			}

			setState(42); match(EOF);
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
		public TerminalNode ON() { return getToken(MetricQueryParser.ON, 0); }
		public PathSelectionContext pathSelection() {
			return getRuleContext(PathSelectionContext.class,0);
		}
		public ComponentSelectionContext componentSelection() {
			return getRuleContext(ComponentSelectionContext.class,0);
		}
		public FieldListContext fieldList() {
			return getRuleContext(FieldListContext.class,0);
		}
		public TerminalNode FROM() { return getToken(MetricQueryParser.FROM, 0); }
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
			setState(44); fieldList();
			setState(45); match(FROM);
			setState(46); pathSelection();
			setState(47); match(ON);
			setState(48); componentSelection();
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
		public TimeShiftingStatementContext timeShiftingStatement() {
			return getRuleContext(TimeShiftingStatementContext.class,0);
		}
		public TerminalNode NUMBER_NO_LEADING_ZEROS() { return getToken(MetricQueryParser.NUMBER_NO_LEADING_ZEROS, 0); }
		public TerminalNode TIME_UNIT() { return getToken(MetricQueryParser.TIME_UNIT, 0); }
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
			setState(61);
			switch (_input.LA(1)) {
			case T__2:
				_localctx = new RelativeTimerangeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(50); match(T__2);
				setState(51); match(NUMBER_NO_LEADING_ZEROS);
				setState(52); match(TIME_UNIT);
				setState(54);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__1) | (1L << NUMBER_NO_LEADING_ZEROS))) != 0)) {
					{
					setState(53); timeShiftingStatement();
					}
				}

				}
				break;
			case T__1:
				_localctx = new AbsoluteTimerangeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(56); match(T__1);
				setState(57); ansiDate();
				setState(58); match(T__5);
				setState(59); ansiDate();
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

	public final TimeShiftingStatementContext timeShiftingStatement() throws RecognitionException {
		TimeShiftingStatementContext _localctx = new TimeShiftingStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_timeShiftingStatement);
		int _la;
		try {
			setState(79);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new AbsoluteTimerangeOffsetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(63); match(T__1);
				setState(64); match(T__4);
				setState(65); ansiDate();
				}
				break;

			case 2:
				_localctx = new AbsoluteTimerangeOffsetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(66); match(T__5);
				setState(67); match(T__4);
				setState(68); ansiDate();
				}
				break;

			case 3:
				_localctx = new RelativeTimerangeOffsetContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(69); match(T__1);
				setState(70); match(NUMBER_NO_LEADING_ZEROS);
				setState(71); match(TIME_UNIT);
				setState(72); match(T__8);
				}
				break;

			case 4:
				_localctx = new RelativeTimerangeOffsetContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(73); match(T__5);
					}
				}

				setState(76); match(NUMBER_NO_LEADING_ZEROS);
				setState(77); match(TIME_UNIT);
				setState(78); match(T__8);
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
			setState(83);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(81); anyField();
				}
				break;
			case T__7:
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(82); metriclist();
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
			setState(85); match(STAR);
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
		public MetricContext metric(int i) {
			return getRuleContext(MetricContext.class,i);
		}
		public List<MetricContext> metric() {
			return getRuleContexts(MetricContext.class);
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
			setState(95);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(87); metric();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(88); metric();
				setState(91); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(89); match(COMMA);
					setState(90); metric();
					}
					}
					setState(93); 
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
		try {
			setState(107);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(97); match(T__0);
				setState(98); ((MetricContext)_localctx).metricname = metricname();
				setState(99); match(T__0);
				((MetricContext)_localctx).metricName =  (((MetricContext)_localctx).metricname!=null?_input.getText(((MetricContext)_localctx).metricname.start,((MetricContext)_localctx).metricname.stop):null);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(102); match(T__7);
				setState(103); ((MetricContext)_localctx).metricname = metricname();
				setState(104); match(T__7);
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
			setState(110); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(109);
				_la = _input.LA(1);
				if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__6) | (1L << T__0))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(112); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__5) | (1L << T__4) | (1L << T__3) | (1L << T__2) | (1L << T__1) | (1L << NUMBER_NO_LEADING_ZEROS) | (1L << TIME_UNIT) | (1L << ANSIDATE) | (1L << ANSITIME) | (1L << TIMEZONE) | (1L << EXPORT) | (1L << AGGREGATED) | (1L << FROM) | (1L << ON) | (1L << WS) | (1L << COMMA) | (1L << STAR) | (1L << PLAINSTRING) | (1L << APPLICATION))) != 0) );
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
			setState(114); pathElements();
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
		public PathElementContext pathElement(int i) {
			return getRuleContext(PathElementContext.class,i);
		}
		public List<PathElementContext> pathElement() {
			return getRuleContexts(PathElementContext.class);
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
			setState(116); pathElement();
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(117); match(T__3);
				setState(118); pathElement();
				}
				}
				setState(123);
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
		public ElementNameContext elementName() {
			return getRuleContext(ElementNameContext.class,0);
		}
		public AnyElementContext anyElement() {
			return getRuleContext(AnyElementContext.class,0);
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
		try {
			setState(135);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(124); anyElement();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(125); match(T__0);
				setState(126); ((PathElementContext)_localctx).elementName = elementName();
				setState(127); match(T__0);
				 ((PathElementContext)_localctx).elementText =  (((PathElementContext)_localctx).elementName!=null?_input.getText(((PathElementContext)_localctx).elementName.start,((PathElementContext)_localctx).elementName.stop):null);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(130); match(T__7);
				setState(131); ((PathElementContext)_localctx).elementName = elementName();
				setState(132); match(T__7);
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
			setState(138); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(137);
				_la = _input.LA(1);
				if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__6) | (1L << T__0))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(140); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__5) | (1L << T__4) | (1L << T__3) | (1L << T__2) | (1L << T__1) | (1L << NUMBER_NO_LEADING_ZEROS) | (1L << TIME_UNIT) | (1L << ANSIDATE) | (1L << ANSITIME) | (1L << TIMEZONE) | (1L << EXPORT) | (1L << AGGREGATED) | (1L << FROM) | (1L << ON) | (1L << WS) | (1L << COMMA) | (1L << STAR) | (1L << PLAINSTRING) | (1L << APPLICATION))) != 0) );
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
		enterRule(_localctx, 26, RULE_anyElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142); match(STAR);
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
		enterRule(_localctx, 28, RULE_componentSelection);
		try {
			_localctx = new ApplicationComponentSelectionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(144); match(APPLICATION);
			setState(145); componentIdentifier();
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
		enterRule(_localctx, 30, RULE_componentIdentifier);
		try {
			setState(157);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(147); match(T__0);
				setState(148); ((ComponentIdentifierContext)_localctx).elementName = elementName();
				setState(149); match(T__0);
				((ComponentIdentifierContext)_localctx).compName =  (((ComponentIdentifierContext)_localctx).elementName!=null?_input.getText(((ComponentIdentifierContext)_localctx).elementName.start,((ComponentIdentifierContext)_localctx).elementName.stop):null);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(152); match(T__7);
				setState(153); ((ComponentIdentifierContext)_localctx).elementName = elementName();
				setState(154); match(T__7);
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
		public TerminalNode ANSITIME() { return getToken(MetricQueryParser.ANSITIME, 0); }
		public TerminalNode ANSIDATE() { return getToken(MetricQueryParser.ANSIDATE, 0); }
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
		enterRule(_localctx, 32, RULE_ansiDate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159); match(ANSIDATE);
			setState(160); match(ANSITIME);
			setState(162);
			_la = _input.LA(1);
			if (_la==TIMEZONE) {
				{
				setState(161); match(TIMEZONE);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\31\u00a7\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\5\2\'\n\2\3\2\3\2\5\2+\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\5\49\n\4\3\4\3\4\3\4\3\4\3\4\5\4@\n\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5M\n\5\3\5\3\5\3\5\5\5R\n\5\3\6\3\6\5\6V"+
		"\n\6\3\7\3\7\3\b\3\b\3\b\3\b\6\b^\n\b\r\b\16\b_\5\bb\n\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tn\n\t\3\n\6\nq\n\n\r\n\16\nr\3\13\3\13\3"+
		"\f\3\f\3\f\7\fz\n\f\f\f\16\f}\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\5\r\u008a\n\r\3\16\6\16\u008d\n\16\r\16\16\16\u008e\3\17\3\17"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u00a0\n\21\3\22\3\22\3\22\5\22\u00a5\n\22\3\22\2\2\23\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"\2\3\4\2\4\5\13\13\u00a8\2$\3\2\2\2\4.\3\2"+
		"\2\2\6?\3\2\2\2\bQ\3\2\2\2\nU\3\2\2\2\fW\3\2\2\2\16a\3\2\2\2\20m\3\2\2"+
		"\2\22p\3\2\2\2\24t\3\2\2\2\26v\3\2\2\2\30\u0089\3\2\2\2\32\u008c\3\2\2"+
		"\2\34\u0090\3\2\2\2\36\u0092\3\2\2\2 \u009f\3\2\2\2\"\u00a1\3\2\2\2$&"+
		"\7\21\2\2%\'\7\22\2\2&%\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2(*\5\4\3\2)+\5\6"+
		"\4\2*)\3\2\2\2*+\3\2\2\2+,\3\2\2\2,-\7\2\2\3-\3\3\2\2\2./\5\n\6\2/\60"+
		"\7\23\2\2\60\61\5\24\13\2\61\62\7\24\2\2\62\63\5\36\20\2\63\5\3\2\2\2"+
		"\64\65\7\t\2\2\65\66\7\f\2\2\668\7\r\2\2\679\5\b\5\28\67\3\2\2\289\3\2"+
		"\2\29@\3\2\2\2:;\7\n\2\2;<\5\"\22\2<=\7\6\2\2=>\5\"\22\2>@\3\2\2\2?\64"+
		"\3\2\2\2?:\3\2\2\2@\7\3\2\2\2AB\7\n\2\2BC\7\7\2\2CR\5\"\22\2DE\7\6\2\2"+
		"EF\7\7\2\2FR\5\"\22\2GH\7\n\2\2HI\7\f\2\2IJ\7\r\2\2JR\7\3\2\2KM\7\6\2"+
		"\2LK\3\2\2\2LM\3\2\2\2MN\3\2\2\2NO\7\f\2\2OP\7\r\2\2PR\7\3\2\2QA\3\2\2"+
		"\2QD\3\2\2\2QG\3\2\2\2QL\3\2\2\2R\t\3\2\2\2SV\5\f\7\2TV\5\16\b\2US\3\2"+
		"\2\2UT\3\2\2\2V\13\3\2\2\2WX\7\27\2\2X\r\3\2\2\2Yb\5\20\t\2Z]\5\20\t\2"+
		"[\\\7\26\2\2\\^\5\20\t\2][\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3\2\2\2`b\3\2"+
		"\2\2aY\3\2\2\2aZ\3\2\2\2b\17\3\2\2\2cd\7\13\2\2de\5\22\n\2ef\7\13\2\2"+
		"fg\b\t\1\2gn\3\2\2\2hi\7\4\2\2ij\5\22\n\2jk\7\4\2\2kl\b\t\1\2ln\3\2\2"+
		"\2mc\3\2\2\2mh\3\2\2\2n\21\3\2\2\2oq\n\2\2\2po\3\2\2\2qr\3\2\2\2rp\3\2"+
		"\2\2rs\3\2\2\2s\23\3\2\2\2tu\5\26\f\2u\25\3\2\2\2v{\5\30\r\2wx\7\b\2\2"+
		"xz\5\30\r\2yw\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\27\3\2\2\2}{\3\2"+
		"\2\2~\u008a\5\34\17\2\177\u0080\7\13\2\2\u0080\u0081\5\32\16\2\u0081\u0082"+
		"\7\13\2\2\u0082\u0083\b\r\1\2\u0083\u008a\3\2\2\2\u0084\u0085\7\4\2\2"+
		"\u0085\u0086\5\32\16\2\u0086\u0087\7\4\2\2\u0087\u0088\b\r\1\2\u0088\u008a"+
		"\3\2\2\2\u0089~\3\2\2\2\u0089\177\3\2\2\2\u0089\u0084\3\2\2\2\u008a\31"+
		"\3\2\2\2\u008b\u008d\n\2\2\2\u008c\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\33\3\2\2\2\u0090\u0091\7\27\2"+
		"\2\u0091\35\3\2\2\2\u0092\u0093\7\31\2\2\u0093\u0094\5 \21\2\u0094\37"+
		"\3\2\2\2\u0095\u0096\7\13\2\2\u0096\u0097\5\32\16\2\u0097\u0098\7\13\2"+
		"\2\u0098\u0099\b\21\1\2\u0099\u00a0\3\2\2\2\u009a\u009b\7\4\2\2\u009b"+
		"\u009c\5\32\16\2\u009c\u009d\7\4\2\2\u009d\u009e\b\21\1\2\u009e\u00a0"+
		"\3\2\2\2\u009f\u0095\3\2\2\2\u009f\u009a\3\2\2\2\u00a0!\3\2\2\2\u00a1"+
		"\u00a2\7\16\2\2\u00a2\u00a4\7\17\2\2\u00a3\u00a5\7\20\2\2\u00a4\u00a3"+
		"\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5#\3\2\2\2\22&*8?LQU_amr{\u0089\u008e"+
		"\u009f\u00a4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}