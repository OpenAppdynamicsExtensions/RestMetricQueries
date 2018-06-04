// Generated from /vlab/development/github/RestMetricQueries/src/main/antlr/MetricQuery.g4 by ANTLR 4.5.3
package de.appdynamics.ace.metric.query;
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
	 * Visit a parse tree produced by {@link MetricQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(MetricQueryParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#exportStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportStatement(MetricQueryParser.ExportStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relativeTimerange}
	 * labeled alternative in {@link MetricQueryParser#timeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelativeTimerange(MetricQueryParser.RelativeTimerangeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code absoluteTimerange}
	 * labeled alternative in {@link MetricQueryParser#timeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsoluteTimerange(MetricQueryParser.AbsoluteTimerangeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code absoluteTimerangeOffset}
	 * labeled alternative in {@link MetricQueryParser#timeShiftingStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsoluteTimerangeOffset(MetricQueryParser.AbsoluteTimerangeOffsetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relativeTimerangeOffset}
	 * labeled alternative in {@link MetricQueryParser#timeShiftingStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelativeTimerangeOffset(MetricQueryParser.RelativeTimerangeOffsetContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#fieldList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldList(MetricQueryParser.FieldListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#anyField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyField(MetricQueryParser.AnyFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#metriclist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetriclist(MetricQueryParser.MetriclistContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#metric}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetric(MetricQueryParser.MetricContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#metricname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetricname(MetricQueryParser.MetricnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#pathSelection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathSelection(MetricQueryParser.PathSelectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dottedPathElements}
	 * labeled alternative in {@link MetricQueryParser#pathElements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDottedPathElements(MetricQueryParser.DottedPathElementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#pathElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathElement(MetricQueryParser.PathElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#elementName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementName(MetricQueryParser.ElementNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#pathElementName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathElementName(MetricQueryParser.PathElementNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#anyElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyElement(MetricQueryParser.AnyElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code applicationComponentSelection}
	 * labeled alternative in {@link MetricQueryParser#componentSelection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplicationComponentSelection(MetricQueryParser.ApplicationComponentSelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#componentIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentIdentifier(MetricQueryParser.ComponentIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetricQueryParser#ansiDate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnsiDate(MetricQueryParser.AnsiDateContext ctx);
}