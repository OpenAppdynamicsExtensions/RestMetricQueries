// Generated from /vlab/development/github/RestMetricQueries/src/main/antlr/MetricQuery.g4 by ANTLR 4.3
package de.appdynamics.ace.metric.query;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MetricQueryParser}.
 */
public interface MetricQueryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#anyElement}.
	 * @param ctx the parse tree
	 */
	void enterAnyElement(@NotNull MetricQueryParser.AnyElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#anyElement}.
	 * @param ctx the parse tree
	 */
	void exitAnyElement(@NotNull MetricQueryParser.AnyElementContext ctx);

	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#elementName}.
	 * @param ctx the parse tree
	 */
	void enterElementName(@NotNull MetricQueryParser.ElementNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#elementName}.
	 * @param ctx the parse tree
	 */
	void exitElementName(@NotNull MetricQueryParser.ElementNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#fieldList}.
	 * @param ctx the parse tree
	 */
	void enterFieldList(@NotNull MetricQueryParser.FieldListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#fieldList}.
	 * @param ctx the parse tree
	 */
	void exitFieldList(@NotNull MetricQueryParser.FieldListContext ctx);

	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(@NotNull MetricQueryParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(@NotNull MetricQueryParser.QueryContext ctx);

	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#pathSelection}.
	 * @param ctx the parse tree
	 */
	void enterPathSelection(@NotNull MetricQueryParser.PathSelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#pathSelection}.
	 * @param ctx the parse tree
	 */
	void exitPathSelection(@NotNull MetricQueryParser.PathSelectionContext ctx);

	/**
	 * Enter a parse tree produced by the {@code dottedPathElements}
	 * labeled alternative in {@link MetricQueryParser#pathElements}.
	 * @param ctx the parse tree
	 */
	void enterDottedPathElements(@NotNull MetricQueryParser.DottedPathElementsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dottedPathElements}
	 * labeled alternative in {@link MetricQueryParser#pathElements}.
	 * @param ctx the parse tree
	 */
	void exitDottedPathElements(@NotNull MetricQueryParser.DottedPathElementsContext ctx);

	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#metricname}.
	 * @param ctx the parse tree
	 */
	void enterMetricname(@NotNull MetricQueryParser.MetricnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#metricname}.
	 * @param ctx the parse tree
	 */
	void exitMetricname(@NotNull MetricQueryParser.MetricnameContext ctx);

	/**
	 * Enter a parse tree produced by the {@code relativeTimerange}
	 * labeled alternative in {@link MetricQueryParser#timeStatement}.
	 * @param ctx the parse tree
	 */
	void enterRelativeTimerange(@NotNull MetricQueryParser.RelativeTimerangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relativeTimerange}
	 * labeled alternative in {@link MetricQueryParser#timeStatement}.
	 * @param ctx the parse tree
	 */
	void exitRelativeTimerange(@NotNull MetricQueryParser.RelativeTimerangeContext ctx);

	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#anyField}.
	 * @param ctx the parse tree
	 */
	void enterAnyField(@NotNull MetricQueryParser.AnyFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#anyField}.
	 * @param ctx the parse tree
	 */
	void exitAnyField(@NotNull MetricQueryParser.AnyFieldContext ctx);

	/**
	 * Enter a parse tree produced by the {@code relativeTimerangeOffset}
	 * labeled alternative in {@link MetricQueryParser#timeShiftingStatement}.
	 * @param ctx the parse tree
	 */
	void enterRelativeTimerangeOffset(@NotNull MetricQueryParser.RelativeTimerangeOffsetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relativeTimerangeOffset}
	 * labeled alternative in {@link MetricQueryParser#timeShiftingStatement}.
	 * @param ctx the parse tree
	 */
	void exitRelativeTimerangeOffset(@NotNull MetricQueryParser.RelativeTimerangeOffsetContext ctx);

	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#exportStatement}.
	 * @param ctx the parse tree
	 */
	void enterExportStatement(@NotNull MetricQueryParser.ExportStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#exportStatement}.
	 * @param ctx the parse tree
	 */
	void exitExportStatement(@NotNull MetricQueryParser.ExportStatementContext ctx);

	/**
	 * Enter a parse tree produced by the {@code absoluteTimerange}
	 * labeled alternative in {@link MetricQueryParser#timeStatement}.
	 * @param ctx the parse tree
	 */
	void enterAbsoluteTimerange(@NotNull MetricQueryParser.AbsoluteTimerangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code absoluteTimerange}
	 * labeled alternative in {@link MetricQueryParser#timeStatement}.
	 * @param ctx the parse tree
	 */
	void exitAbsoluteTimerange(@NotNull MetricQueryParser.AbsoluteTimerangeContext ctx);

	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#metric}.
	 * @param ctx the parse tree
	 */
	void enterMetric(@NotNull MetricQueryParser.MetricContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#metric}.
	 * @param ctx the parse tree
	 */
	void exitMetric(@NotNull MetricQueryParser.MetricContext ctx);

	/**
	 * Enter a parse tree produced by the {@code absoluteTimerangeOffset}
	 * labeled alternative in {@link MetricQueryParser#timeShiftingStatement}.
	 * @param ctx the parse tree
	 */
	void enterAbsoluteTimerangeOffset(@NotNull MetricQueryParser.AbsoluteTimerangeOffsetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code absoluteTimerangeOffset}
	 * labeled alternative in {@link MetricQueryParser#timeShiftingStatement}.
	 * @param ctx the parse tree
	 */
	void exitAbsoluteTimerangeOffset(@NotNull MetricQueryParser.AbsoluteTimerangeOffsetContext ctx);

	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#pathElementName}.
	 * @param ctx the parse tree
	 */
	void enterPathElementName(@NotNull MetricQueryParser.PathElementNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#pathElementName}.
	 * @param ctx the parse tree
	 */
	void exitPathElementName(@NotNull MetricQueryParser.PathElementNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#pathElement}.
	 * @param ctx the parse tree
	 */
	void enterPathElement(@NotNull MetricQueryParser.PathElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#pathElement}.
	 * @param ctx the parse tree
	 */
	void exitPathElement(@NotNull MetricQueryParser.PathElementContext ctx);

	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#metriclist}.
	 * @param ctx the parse tree
	 */
	void enterMetriclist(@NotNull MetricQueryParser.MetriclistContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#metriclist}.
	 * @param ctx the parse tree
	 */
	void exitMetriclist(@NotNull MetricQueryParser.MetriclistContext ctx);

	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#componentIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterComponentIdentifier(@NotNull MetricQueryParser.ComponentIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#componentIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitComponentIdentifier(@NotNull MetricQueryParser.ComponentIdentifierContext ctx);

	/**
	 * Enter a parse tree produced by the {@code applicationComponentSelection}
	 * labeled alternative in {@link MetricQueryParser#componentSelection}.
	 * @param ctx the parse tree
	 */
	void enterApplicationComponentSelection(@NotNull MetricQueryParser.ApplicationComponentSelectionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code applicationComponentSelection}
	 * labeled alternative in {@link MetricQueryParser#componentSelection}.
	 * @param ctx the parse tree
	 */
	void exitApplicationComponentSelection(@NotNull MetricQueryParser.ApplicationComponentSelectionContext ctx);

	/**
	 * Enter a parse tree produced by {@link MetricQueryParser#ansiDate}.
	 * @param ctx the parse tree
	 */
	void enterAnsiDate(@NotNull MetricQueryParser.AnsiDateContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetricQueryParser#ansiDate}.
	 * @param ctx the parse tree
	 */
	void exitAnsiDate(@NotNull MetricQueryParser.AnsiDateContext ctx);
}