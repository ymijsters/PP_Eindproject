//grammar Grammar;
//
//program: stat+;
//
//stat: type ID (ASSIGN expr)? SEMI				#declStat
//    | target ASSIGN expr SEMI            		#assignStat
//	| IF LPAR expr RPAR stat (ELSE stat)?		#ifStat
//	| LCURLY stat+ RCURLY						#blockStat
//	| WHILE LPAR expr RPAR stat					#whileStat
//	; 
//type: INT | BOOL;
//target
//	: ID	             #idTarget
//    ;
//expr: expr (PLUS | MINUS | TIMES | DIVIDE) expr	#arithExpr
//	| expr AND expr								#andExpr
//	| expr OR expr								#orExpr
//	| expr (GT | GE | LT | LE | EQ | NE ) expr	#compExpr
//	| (NUM | TRUE | FALSE)						#varExpr
//	| ID										#idExpr
//	| NOT expr									#notExpr
//	;
//
//fragment LETTER: [a-zA-Z];
//fragment DIGIT: [0-9];
//
//ID  : LETTER (LETTER | DIGIT)*;
//
//NUM: '0'|([1-9] DIGIT*);
//INT : 'int';
//BOOL: 'boolean';
//ASSIGN: '=';
//SEMI: ';';
//IF: 'if';
//LPAR: '(';
//RPAR: ')';
//ELSE: 'else';
//LCURLY: '{';
//RCURLY: '}';
//WHILE: 'while';
//PLUS: '+';
//MINUS: '-';
//TIMES: '*';
//DIVIDE: '/';
//AND: '&&';
//OR: '||';
//GT: '>';
//GE: '>=';
//EQ: '==';
//NE: '!=';
//LT: '<';
//LE: '<=';
//TRUE: 'true';
//FALSE: 'false';
//NOT: '!';
//LSQ: '[';
//RSQ: ']';
//WS : [ \t\n\r] -> skip;
grammar Grammar;


program: stat+ EOF;

stat: type ID (ASSIGN expr)? SEMI         #decl
    | target ASSIGN expr SEMI             #assignStat
    | IF LPAR expr RPAR stat (ELSE stat)? #ifStat 
    | WHILE LPAR expr RPAR stat           #whileStat 
    | FOR LPAR ID ASSIGN expr SEMI
               expr SEMI
               ID ASSIGN expr RPAR stat   #forStat 
    | LCURLY stat* RCURLY                 #blockStat
    | PRINT LPAR STRING (COMMA ID)* RPAR SEMI #printStat
    | BREAK SEMI                          #breakStat
    | CONTINUE SEMI                       #contStat
    ;

target
    : ID              #idTarget
    | ID LSQ expr RSQ #arrayTarget
    ;

expr: expr (PLUS | MINUS | TIMES | DIVIDE) expr	#arithExpr
	| expr AND expr								#andExpr
	| expr OR expr								#orExpr
	| expr (GT | GE | LT | LE | EQ | NE ) expr	#compExpr
	| (NUM | TRUE | FALSE)						#varExpr
	| ID										#idExpr
	| NOT expr									#notExpr
	;
type: INT | BOOL;

DOT: '.';
SEMI: ';';
COMMA: ',';
LSQ: '[';
RSQ: ']';
ASSIGN: '=';
NOT: '!';
OR: '||';
AND: '&&';
BIT_OR: '|';
BIT_AND: '&';
PLUS: '+';
MINUS: '-';
LT: '<';
GT: '>';
EQ: '==';
NE: '!=';
LCURLY: '{';
RCURLY: '}';
LPAR: '(';
RPAR: ')';

IN: 'in';
PRINT: 'printf';
BOOL: 'boolean';
FOR: 'for';
INT: 'int';
WHILE: 'while';
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

WS: [ \t\r\n]+ -> skip;
