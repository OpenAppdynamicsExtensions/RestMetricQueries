package de.appdynamics.ace.metric.query.rest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stefan.marx on 28.08.14.
 */
public class MetricData {
    public String getFrequency() {
        return _frequency;
    }

    public void setFrequency(String frequency) {
        _frequency = frequency;
    }

    public String getMetricName() {
        return _metricName;
    }

    public void setMetricName(String metricName) {
        _metricName = metricName;
    }

    public String getMetricPath() {
        return _metricPath;
    }

    public void setMetricPath(String metricPath) {
        _metricPath = metricPath;
    }

    public List<MetricValue> getMetricValues() {
        return _metricValues;
    }

    public void setMetricValues(List<MetricValue> metricValues) {
        _metricValues = metricValues;
    }

    private String _frequency;
    private String _metricName;
    private String _metricPath;
    private List<MetricValue> _metricValues = new ArrayList<MetricValue>();

    public String getMetricId() {
        return metricId;
    }

    public void setMetricId(String metricId) {
        this.metricId = metricId;
    }

    private String metricId;
}
