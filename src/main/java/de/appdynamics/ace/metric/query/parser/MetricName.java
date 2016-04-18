package de.appdynamics.ace.metric.query.parser;

import de.appdynamics.ace.metric.query.MetricQueryParser;

/**
 * Created by stefan.marx on 18.04.16.
 */
public class MetricName {

    private String _name;
    private String _alias;

    public MetricName(String name) {
        //TODO :

        _name = name;
    }

    public String getName() {
        return _name;
    }

    public void setAlias(String alias) {
        _alias = alias;
    }

    public String getAlias() {
        return _alias;
    }

    @Override
    public String toString() {
        if(isAliased() ) return _name+" ("+_alias+")";
        return _name;
    }

    public boolean isAliased() {
        //TODO :
        return (_alias != null && _alias.length()>0);
    }
}
