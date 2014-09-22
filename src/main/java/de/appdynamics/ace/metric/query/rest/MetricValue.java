package de.appdynamics.ace.metric.query.rest;

/**
 * Created by stefan.marx on 28.08.14.
 */
public class MetricValue {
   private long count;
    private long current;
    private long max;
    private long min;


    private long occurrences;
    private long standardDeviation;
    private long startTimeInMillis;
    private long sum;
    private boolean useRange;



    private long value;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getCurrent() {
        return current;
    }

    public void setCurrent(long current) {
        this.current = current;
    }

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public long getMin() {
        return min;
    }

    public void setMin(long min) {
        this.min = min;
    }

    public long getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(long occurrences) {
        this.occurrences = occurrences;
    }

    public long getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(long standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

    public long getStartTimeInMillis() {
        return startTimeInMillis;
    }

    public void setStartTimeInMillis(long startTimeInMillis) {
        this.startTimeInMillis = startTimeInMillis;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public boolean isUseRange() {
        return useRange;
    }

    public void setUseRange(boolean useRange) {
        this.useRange = useRange;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
