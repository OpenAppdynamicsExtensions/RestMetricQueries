// Generated from /vlab/development/github/RestMetricQueries/src/main/antlr/MetricQuery.g4 by ANTLR 4.5.3
package de.appdynamics.ace.metric.query;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MetricQueryParser}.
 */
public interface MetricQueryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(MetricQueryParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(MetricQueryParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#exportStatement}.
	 * @param ctx the parse tree
	 */
	void enterExportStatement(MetricQueryParser.ExportStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#exportStatement}.
	 * @param ctx the parse tree
	 */
	void exitExportStatement(MetricQueryParser.ExportStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relativeTimerange}
	 * labeled alternative in {@link MetricQueryParser#timeStatement}.
	 * @param ctx the parse tree
	 */
	void enterRelativeTimerange(MetricQueryParser.RelativeTimerangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relativeTimerange}
	 * labeled alternative in {@link MetricQueryParser#timeStatement}.
	 * @param ctx the parse tree
	 */
	void exitRelativeTimerange(MetricQueryParser.RelativeTimerangeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code absoluteTimerange}
	 * labeled alternative in {@link MetricQueryParser#timeStatement}.
	 * @param ctx the parse tree
	 */
	void enterAbsoluteTimerange(MetricQueryParser.AbsoluteTimerangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code absoluteTimerange}
	 * labeled alternative in {@link MetricQueryParser#timeStatement}.
	 * @param ctx the parse tree
	 */
	void exitAbsoluteTimerange(MetricQueryParser.AbsoluteTimerangeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code absoluteTimerangeOffset}
	 * labeled alternative in {@link MetricQueryParser#timeShiftingStatement}.
	 * @param ctx the parse tree
	 */
	void enterAbsoluteTimerangeOffset(MetricQueryParser.AbsoluteTimerangeOffsetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code absoluteTimerangeOffset}
	 * labeled alternative in {@link MetricQueryParser#timeShiftingStatement}.
	 * @param ctx the parse tree
	 */
	void exitAbsoluteTimerangeOffset(MetricQueryParser.AbsoluteTimerangeOffsetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relativeTimerangeOffset}
	 * labeled alternative in {@link MetricQueryParser#timeShiftingStatement}.
	 * @param ctx the parse tree
	 */
	void enterRelativeTimerangeOffset(MetricQueryParser.RelativeTimerangeOffsetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relativeTimerangeOffset}
	 * labeled alternative in {@link MetricQueryParser#timeShiftingStatement}.
	 * @param ctx the parse tree
	 */
	void exitRelativeTimerangeOffset(MetricQueryParser.RelativeTimerangeOffsetContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#fieldList}.
	 * @param ctx the parse tree
	 */
	void enterFieldList(MetricQueryParser.FieldListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#fieldList}.
	 * @param ctx the parse tree
	 */
	void exitFieldList(MetricQueryParser.FieldListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#anyField}.
	 * @param ctx the parse tree
	 */
	void enterAnyField(MetricQueryParser.AnyFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#anyField}.
	 * @param ctx the parse tree
	 */
	void exitAnyField(MetricQueryParser.AnyFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#metriclist}.
	 * @param ctx the parse tree
	 */
	void enterMetriclist(MetricQueryParser.MetriclistContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#metriclist}.
	 * @param ctx the parse tree
	 */
	void exitMetriclist(MetricQueryParser.MetriclistContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#metric}.
	 * @param ctx the parse tree
	 */
	void enterMetric(MetricQueryParser.MetricContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#metric}.
	 * @param ctx the parse tree
	 */
	void exitMetric(MetricQueryParser.MetricContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#metricname}.
	 * @param ctx the parse tree
	 */
	void enterMetricname(MetricQueryParser.MetricnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#metricname}.
	 * @param ctx the parse tree
	 */
	void exitMetricname(MetricQueryParser.MetricnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#pathSelection}.
	 * @param ctx the parse tree
	 */
	void enterPathSelection(MetricQueryParser.PathSelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#pathSelection}.
	 * @param ctx the parse tree
	 */
	void exitPathSelection(MetricQueryParser.PathSelectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dottedPathElements}
	 * labeled alternative in {@link MetricQueryParser#pathElements}.
	 * @param ctx the parse tree
	 */
	void enterDottedPathElements(MetricQueryParser.DottedPathElementsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dottedPathElements}
	 * labeled alternative in {@link MetricQueryParser#pathElements}.
	 * @param ctx the parse tree
	 */
	void exitDottedPathElements(MetricQueryParser.DottedPathElementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#pathElement}.
	 * @param ctx the parse tree
	 */
	void enterPathElement(MetricQueryParser.PathElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#pathElement}.
	 * @param ctx the parse tree
	 */
	void exitPathElement(MetricQueryParser.PathElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#elementName}.
	 * @param ctx the parse tree
	 */
	void enterElementName(MetricQueryParser.ElementNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#elementName}.
	 * @param ctx the parse tree
	 */
	void exitElementName(MetricQueryParser.ElementNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#pathElementName}.
	 * @param ctx the parse tree
	 */
	void enterPathElementName(MetricQueryParser.PathElementNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#pathElementName}.
	 * @param ctx the parse tree
	 */
	void exitPathElementName(MetricQueryParser.PathElementNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#anyElement}.
	 * @param ctx the parse tree
	 */
	void enterAnyElement(MetricQueryParser.AnyElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#anyElement}.
	 * @param ctx the parse tree
	 */
	void exitAnyElement(MetricQueryParser.AnyElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code applicationComponentSelection}
	 * labeled alternative in {@link MetricQueryParser#componentSelection}.
	 * @param ctx the parse tree
	 */
	void enterApplicationComponentSelection(MetricQueryParser.ApplicationComponentSelectionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code applicationComponentSelection}
	 * labeled alternative in {@link MetricQueryParser#componentSelection}.
	 * @param ctx the parse tree
	 */
	void exitApplicationComponentSelection(MetricQueryParser.ApplicationComponentSelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#componentIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterComponentIdentifier(MetricQueryParser.ComponentIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#componentIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitComponentIdentifier(MetricQueryParser.ComponentIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#ansiDate}.
	 * @param ctx the parse tree
	 */
	void enterAnsiDate(MetricQueryParser.AnsiDateContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#ansiDate}.
	 * @param ctx the parse tree
	 */
	void exitAnsiDate(MetricQueryParser.AnsiDateContext ctx);
}