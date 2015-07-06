grammar Grammar;


program: stat+ EOF;

stat: type ID (ASSIGN expr)? SEMI         			  #decl
	| type TIMES ID (ASSIGN expr)? SEMI         	  #pointerDecl
	| type LSQ NUM RSQ ID 
	(ASSIGN LSQ expr (COMMA expr)* RSQ)? SEMI		  #arrayDecl
    | IF LPAR expr RPAR stat (ELSE stat)? 			  #ifStat 
    | WHILE LPAR expr RPAR stat          			  #whileStat 
    | target LSQ expr RSQ ASSIGN expr SEMI     		  #arrayElemAssignStat
    | FOR LPAR ID ASSIGN expr SEMI
               expr SEMI
               ID ASSIGN expr RPAR stat   			  #forStat 
    | LCURLY stat* RCURLY                			  #blockStat
    | PRINT LPAR expr RPAR SEMI #printStat
    | BREAK SEMI                         			  #breakStat
    | expr SEMI                          			  #exprStat
    | CONTINUE SEMI                       #contStat
    ;

target
    : ID              #idTarget
    ;

expr: expr (PLUS | MINUS | TIMES | DIVIDE | MOD) expr	#arithExpr
	| target LSQ expr RSQ						#arrayElemExpr
	| expr AND expr								#andExpr
	| expr OR expr								#orExpr
	| target ASSIGN expr						#assignExpr
	| TIMES target ASSIGN expr					#pointerAssignExpr
	| expr (GT | GE | LT | LE | EQ | NE ) expr	#compExpr
	| expr TIF expr TELSE expr					#ternaryExpr
	| TIMES target								#dereferenceExpr
	| ADDRESS target							#addressExpr
	| (NUM | TRUE | FALSE)						#varExpr
	| target (DECR | INCR)						#postEdit
	| (DECR | INCR)	target 						#preEdit
	| ID										#idExpr
	| NOT expr									#notExpr
	| target DOT LENGTH							#arrayLength
	| LPAR expr RPAR							#parExpr
	| MINUS expr								#negExpr
	;
type: INT | BOOL;

DOT: '.';
TIMES: '*';
INCR: '++';
DECR: '--';
DIVIDE: '/';
GE: '>=';
LE: '<=';
SEMI: ';';
COMMA: ',';
LSQ: '[';
RSQ: ']';
ASSIGN: '=';
NOT: '!';
OR: '||';
AND: '&&';
ADDRESS: '&';

PLUS: '+';
MINUS: '-';
MOD: '%';
LT: '<';
GT: '>';
EQ: '==';
NE: '!=';
TELSE: ':';
TIF: '?';
LCURLY: '{';
RCURLY: '}';
LPAR: '(';
RPAR: ')';

PRINT: 'println';
BOOL: 'boolean';
FOR: 'for';
INT: 'int';
WHILE: 'while';
LENGTH: 'length';
IF: 'if';
ELSE: 'else';
TRUE: 'true';
FALSE: 'false';
BREAK: 'break';
CONTINUE: 'continue';

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];

ID: LETTER (LETTER | DIGIT)*;
NUM: DIGIT+;
STRING: '"' (~["\\] | '\\'.)* '"';

COMMENT:'/*'.*?'*/' -> skip;
WS: [ \t\r\n]+ -> skip;
