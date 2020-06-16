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

        RESTAccess a = new RESTAccess("controller3.demo.appdynamics.com","80",false,"demouser","XXXX","customer1");

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

A nice little feature was added in the latest release which is called metric aliases. With this you can specify an alias for the metric you are pulling. This is useful if you want to do further calculations on your metrics and don't want to write the original name (which can be long) all the time .
Please see an example query below using a metric alias (same as the example above just with the alias):

```
export 'Calls per Minute' as calls from 'Overall Application Performance' on Application 'Bundy Online Shoes' for 2 days

```