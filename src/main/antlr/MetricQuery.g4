

/** Metric Query Parser
 ** */

 grammar MetricQuery;



 options {
     // antlr will generate java lexer and parser
     language = Java;

 }



query  : EXPORT METRIC? AGGREGATED? exportStatement timeStatement? EOF   ;








exportStatement : fieldList FROM pathSelection ON componentSelection ;
timeStatement : 'for' NUMBER_NO_LEADING_ZEROS TIME_UNIT timeShiftingStatement? # relativeTimerange
              | 'starting' ansiDate 'ending' ansiDate             # absoluteTimerange
;

timeShiftingStatement returns [int value]:
               'starting' 'at' ansiDate    # absoluteTimerangeOffset
              | 'ending' 'at' ansiDate     # absoluteTimerangeOffset
              | 'starting' NUMBER_NO_LEADING_ZEROS TIME_UNIT 'ago' # relativeTimerangeOffset
              | 'ending'? NUMBER_NO_LEADING_ZEROS TIME_UNIT 'ago' # relativeTimerangeOffset;


fieldList: anyField
           | metriclist;

anyField : STAR;

metriclist: metric
            | metric (COMMA metric)+
            ;

metric returns [String metricName]:
          '"' metricname '"' ('as' pathElementName)? {$metricName = $metricname.text;}
        |'\'' metricname '\'' ('as' pathElementName)? {$metricName = $metricname.text;}    ;

metricname: ( ~('\\'|'"' | '\'') )+;

pathSelection : pathElements;


pathElements : pathElement ( '.' pathElement)*   #dottedPathElements
;


pathElement returns [String elementText]:
            anyElement  ('as' pathElementName)?
            |'"' elementName '"' ('as' pathElementName)? { $elementText = $elementName.text;}
            |'\'' elementName '\'' ('as' pathElementName)? { $elementText = $elementName.text;}
             ;

elementName: ( ~( '"' | '\''  ) )+;

pathElementName: ID ;

anyElement : '*'  ;

componentSelection : APPLICATION componentIdentifier # applicationComponentSelection
                   ;
componentIdentifier returns [String compName]:
                    '"' elementName '"' {$compName = $elementName.text;}
                      | '\'' elementName '\'' {$compName = $elementName.text;}
                      ;

ansiDate : ANSIDATE  ANSITIME  TIMEZONE?
    ;



fragment DIGIT: ('0'..'9');
fragment DIGIT_NOT_ZERO: ('1'..'9');
NUMBER_NO_LEADING_ZEROS: DIGIT | (DIGIT_NOT_ZERO DIGIT+);

TIME_UNIT : ('minute''s'?)|('hour''s'?)|('day''s'?)|('week''s'?)|('month''s'?);

ANSIDATE : DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT;
ANSITIME : DIGIT DIGIT  ':' DIGIT DIGIT ':' DIGIT DIGIT;
TIMEZONE : '(' ('A'..'Z') ('A'..'Z') ('A'..'Z') ')';


EXPORT : ('e'|'E') 'xport';
METRIC : ('m'|'M') 'etric''s'?;
AGGREGATED : 'aggregated';
FROM: 'from';
ON: 'on';
WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        )+     -> channel(HIDDEN)
    ;


COMMA : ',' ;

STAR : '*';
PLAINSTRING : ~('\"' | '\'');
APPLICATION : ('a'|'A')'pplication' ;
ID : (('A'..'Z') | ('a'..'z')) (('A'..'Z') | ('a'..'z') | ('0'..'9'))* ;
