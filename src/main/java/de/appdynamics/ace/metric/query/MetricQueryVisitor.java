// Generated from /vlab/development/github/RestMetricQueries/src/main/antlr/MetricQuery.g4 by ANTLR 4.3
package de.appdynamics.ace.metric.query;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MetricQueryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MetricQueryVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#anyElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyElement(@NotNull MetricQueryParser.AnyElementContext ctx);

	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#elementName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementName(@NotNull MetricQueryParser.ElementNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#fieldList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldList(@NotNull MetricQueryParser.FieldListContext ctx);

	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(@NotNull MetricQueryParser.QueryContext ctx);

	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#pathSelection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathSelection(@NotNull MetricQueryParser.PathSelectionContext ctx);

	/**
	 * Visit a parse tree produced by the {@code dottedPathElements}
	 * labeled alternative in {@link MetricQueryParser#pathElements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDottedPathElements(@NotNull MetricQueryParser.DottedPathElementsContext ctx);

	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#metricname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetricname(@NotNull MetricQueryParser.MetricnameContext ctx);

	/**
	 * Visit a parse tree produced by the {@code relativeTimerange}
	 * labeled alternative in {@link MetricQueryParser#timeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelativeTimerange(@NotNull MetricQueryParser.RelativeTimerangeContext ctx);

	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#anyField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyField(@NotNull MetricQueryParser.AnyFieldContext ctx);

	/**
	 * Visit a parse tree produced by the {@code relativeTimerangeOffset}
	 * labeled alternative in {@link MetricQueryParser#timeShiftingStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelativeTimerangeOffset(@NotNull MetricQueryParser.RelativeTimerangeOffsetContext ctx);

	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#exportStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportStatement(@NotNull MetricQueryParser.ExportStatementContext ctx);

	/**
	 * Visit a parse tree produced by the {@code absoluteTimerange}
	 * labeled alternative in {@link MetricQueryParser#timeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsoluteTimerange(@NotNull MetricQueryParser.AbsoluteTimerangeContext ctx);

	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#metric}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetric(@NotNull MetricQueryParser.MetricContext ctx);

	/**
	 * Visit a parse tree produced by the {@code absoluteTimerangeOffset}
	 * labeled alternative in {@link MetricQueryParser#timeShiftingStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsoluteTimerangeOffset(@NotNull MetricQueryParser.AbsoluteTimerangeOffsetContext ctx);

	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#pathElementName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathElementName(@NotNull MetricQueryParser.PathElementNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#pathElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathElement(@NotNull MetricQueryParser.PathElementContext ctx);

	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#metriclist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetriclist(@NotNull MetricQueryParser.MetriclistContext ctx);

	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#componentIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentIdentifier(@NotNull MetricQueryParser.ComponentIdentifierContext ctx);

	/**
	 * Visit a parse tree produced by the {@code applicationComponentSelection}
	 * labeled alternative in {@link MetricQueryParser#componentSelection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplicationComponentSelection(@NotNull MetricQueryParser.ApplicationComponentSelectionContext ctx);

	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#ansiDate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnsiDate(@NotNull MetricQueryParser.AnsiDateContext ctx);
}