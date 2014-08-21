package de.appdynamics.ace.metric.query.parser;

import de.appdynamics.ace.metric.query.MetricQueryBaseVisitor;
import de.appdynamics.ace.metric.query.MetricQueryParser;
import org.antlr.v4.runtime.misc.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;

/**
 * Created by stefan.marx on 18.07.14.
 */
public class MetricQueryCompiler extends MetricQueryBaseVisitor <String>{

    private final MetricQueryParser.QueryContext _queryCtx;
    private final Stack<Object> _stack;
    private final CompiledRestMetricQuery _compiledQuery;
    private final String _src;

    private final static SimpleDateFormat shortDF = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
    private final static SimpleDateFormat longDF = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss(zzz)");


    public MetricQueryCompiler(String query, MetricQueryParser.QueryContext ctx) {
        _src = query;
        _queryCtx = ctx;
        _stack = new Stack<Object>();
        _compiledQuery = new CompiledRestMetricQuery(_src);
    }

    public CompiledRestMetricQuery compile() {
        visit(_queryCtx);

        return _compiledQuery;
    }



    /* VISITOR ELEMENTS To build tree

     */

    @Override
    public String visitQuery(@NotNull MetricQueryParser.QueryContext ctx) {

        _compiledQuery.setAggregated(!ctx.getTokens(MetricQueryParser.AGGREGATED).isEmpty());
        return super.visitQuery(ctx);
    }


    @Override
    public String visitFieldList(@NotNull MetricQueryParser.FieldListContext ctx) {
        CompiledRestMetricQuery.Fields fields = new CompiledRestMetricQuery.Fields();

        _stack.push(fields);

        String erg = super.visitFieldList(ctx);

        fields = (CompiledRestMetricQuery.Fields) _stack.pop();
        _compiledQuery.setFields(fields);

        return erg;
    }

    @Override
    public String visitAnyField(@NotNull MetricQueryParser.AnyFieldContext ctx) {
        CompiledRestMetricQuery.Fields fieldList = peekStack(CompiledRestMetricQuery.Fields.class);

        assert(fieldList != null);

        fieldList.setAll(true);
        return super.visitAnyField(ctx);
    }

    @Override
    public String visitMetriclist(@NotNull MetricQueryParser.MetriclistContext ctx) {
        ArrayList<String> list = new ArrayList<String>();
        _stack.push(list);
        String erg = super.visitMetriclist(ctx);

        list = popStack(list.getClass());


        CompiledRestMetricQuery.Fields fields = peekStack(CompiledRestMetricQuery.Fields.class);

        assert (list != null);
        assert (fields != null);
        fields.setFieldList(list);
        return erg;
    }

    @Override
    public String visitMetric(@NotNull MetricQueryParser.MetricContext ctx) {
        ArrayList list = peekStack(ArrayList.class);
        assert(list != null);
        list.add(ctx.metricName);

        String erg = super.visitMetric(ctx);
        return erg;
    }



    @Override
    public String visitDottedPathElements(@NotNull MetricQueryParser.DottedPathElementsContext ctx) {
        ArrayList<String> list = new ArrayList<String>();
        _stack.push(list);
        String erg = super.visitDottedPathElements(ctx);

        list = popStack(list.getClass());
        CompiledRestMetricQuery.Path path = peekStack(CompiledRestMetricQuery.Path.class);

        assert (list != null);
        assert (path != null);
        path.setPathList(list);
        return erg;
    }

    @Override
    public String visitPathElement(@NotNull MetricQueryParser.PathElementContext ctx) {
        ArrayList list = peekStack(ArrayList.class);
        assert(list != null);
        if (ctx.elementText != null)    list.add(ctx.elementText);

        String erg = super.visitPathElement(ctx);
        return erg;
    }


    @Override
    public String visitAnyElement(@NotNull MetricQueryParser.AnyElementContext ctx) {
        ArrayList list = peekStack(ArrayList.class);
        assert(list != null);
        list.add("*");
        return super.visitAnyElement(ctx);
    }

    @Override
    public String visitPathSelection(@NotNull MetricQueryParser.PathSelectionContext ctx) {
        CompiledRestMetricQuery.Path path = new CompiledRestMetricQuery.Path();

        _stack.push(path);

        String erg = super.visitPathSelection(ctx);

        path = (CompiledRestMetricQuery.Path) _stack.pop();

        _compiledQuery.setPath(path);

        return erg;
    }


    @Override
    public String visitApplicationComponentSelection(@NotNull MetricQueryParser.ApplicationComponentSelectionContext ctx) {
        String erg = super.visitApplicationComponentSelection(ctx);
        _compiledQuery.getPath().setComponent(PathComponents.APPLICATION,ctx.componentIdentifier().compName);
        return erg;
    }

    public <T > T popStack(Class <T> type) {
        if (_stack.isEmpty()) return null;
        Object o = _stack.pop();


        if (o.getClass().isAssignableFrom(type)) return (T) o;
        else return null;
    }
    public <T > T peekStack(Class <T> type) {
        if (_stack.isEmpty()) return null;
        Object o = _stack.peek();


        if (o.getClass().isAssignableFrom(type)) return (T) o;
        else return null;
    }

    @Override
    public String visitAbsoluteTimerange(@NotNull MetricQueryParser.AbsoluteTimerangeContext ctx) {

        MetricQueryParser.AnsiDateContext d1 = ctx.ansiDate(0);
        MetricQueryParser.AnsiDateContext d2 = ctx.ansiDate(1);

        try {
            _compiledQuery.getTimerange().setStartDate(convertToDate(d1));
            _compiledQuery.getTimerange().setEndDate(convertToDate(d1));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return super.visitAbsoluteTimerange(ctx);
    }


    @Override
    public String visitRelativeTimerange(@NotNull MetricQueryParser.RelativeTimerangeContext ctx) {
        String unit = ctx.TIME_UNIT().getText();
        long timerange = Long.parseLong(ctx.NUMBER_NO_LEADING_ZEROS().getText());

        TimeshiftHelper th = new TimeshiftHelper(timerange, unit);

        _stack.push(th);

        super.visitRelativeTimerange(ctx);

        th = (TimeshiftHelper) _stack.pop();

        Date startDate = th.getStartDate() ;
        Date endDate = th.getEndDate() ;
        _compiledQuery.getTimerange().setStartDate(startDate);
        _compiledQuery.getTimerange().setEndDate(endDate);

        return "";
    }

    @Override
    public String visitRelativeTimerangeOffset(@NotNull MetricQueryParser.RelativeTimerangeOffsetContext ctx) {

        boolean starting = ctx.getText().startsWith("starting");
        long num = Long.parseLong(ctx.NUMBER_NO_LEADING_ZEROS().getText());
        String unit = ctx.TIME_UNIT().getText();
        TimeshiftHelper th = peekStack(TimeshiftHelper.class);

        if (starting) {
         th.setRelativeStartDate(num,unit);
        }  else {
            th.setRelativeEndDate(num,unit);
        }

        return super.visitRelativeTimerangeOffset(ctx);
    }

    @Override
    public String visitAbsoluteTimerangeOffset(@NotNull MetricQueryParser.AbsoluteTimerangeOffsetContext ctx) {
        TimeshiftHelper th = peekStack(TimeshiftHelper.class);

        boolean starting = ctx.getText().startsWith("starting");
        try {
            Date dat = convertToDate(ctx.ansiDate());
            if (starting) {
                th.setFixedStartDate(dat);
            }   else {
                th.setFixedEndDate(dat);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return super.visitAbsoluteTimerangeOffset(ctx);
    }

    private Date convertToDate(MetricQueryParser.AnsiDateContext d1) throws ParseException {

        if (d1.getText().endsWith(")")) {
            return longDF.parse(d1.getText());
        }else {
            return shortDF.parse(d1.getText());
        }

    }
}
