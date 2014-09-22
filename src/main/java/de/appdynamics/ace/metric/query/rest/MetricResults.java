package de.appdynamics.ace.metric.query.rest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stefan.marx on 28.08.14.
 */
public class MetricResults {
    public List<MetricData> getMetricData() {
        return metricData;
    }

    public void setMetricData(List<MetricData> metricData) {
        this.metricData = metricData;
    }

    private List<MetricData> metricData = new ArrayList<MetricData> ();

    public void addMetricData(MetricData[] data) {
        for (MetricData d : data) {
            metricData.add(d);
        }
    }
}
