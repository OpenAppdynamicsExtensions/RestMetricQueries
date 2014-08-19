RestMetricQueries
=================

This is a nice and new way to query Metrics using a Query Language.


Sample

```
package de.query.test;

import de.appdynamics.ace.metric.query.data.DataMap;
import de.appdynamics.ace.metric.query.parser.CompiledRestMetricQuery;
import de.appdynamics.ace.metric.query.parser.MetricParserException;
import de.appdynamics.ace.metric.query.parser.MetricQuery;
import de.appdynamics.ace.metric.query.parser.QueryException;
import org.appdynamics.appdrestapi.RESTAccess;

/**
 * Created by stefan.marx on 19.08.14.
 */
public class Main {
    public static void main(String[] args) {

        RESTAccess a = new RESTAccess("controller3.demo.appdynamics.com","80",false,"demouser","apm13ad3r","customer1");

        try {
            MetricQuery mq = new MetricQuery();
            String query = "export 'Calls per Minute' from 'Overall Application Performance' on Application 'Bundy Online Shoes' for 2 days";

            CompiledRestMetricQuery erg = mq.parse( query);
            DataMap result = erg.execute(a);

            System.out.println(result.dumpData());

        } catch (MetricParserException e) {
            e.printStackTrace();
        } catch (QueryException e) {
            e.printStackTrace();
        }

    }
}
``` 
