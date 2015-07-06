// Generated from Grammar.g4 by ANTLR 4.5
package grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOT=1, TIMES=2, INCR=3, DECR=4, DIVIDE=5, GE=6, LE=7, SEMI=8, COMMA=9, 
		LSQ=10, RSQ=11, ASSIGN=12, NOT=13, OR=14, AND=15, ADDRESS=16, PLUS=17, 
		MINUS=18, MOD=19, LT=20, GT=21, EQ=22, NE=23, TELSE=24, TIF=25, LCURLY=26, 
		RCURLY=27, LPAR=28, RPAR=29, PRINT=30, BOOL=31, FOR=32, INT=33, WHILE=34, 
		LENGTH=35, IF=36, ELSE=37, TRUE=38, FALSE=39, BREAK=40, CONTINUE=41, ID=42, 
		NUM=43, STRING=44, COMMENT=45, WS=46;
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_target = 2, RULE_expr = 3, RULE_type = 4;
	public static final String[] ruleNames = {
		"program", "stat", "target", "expr", "type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'*'", "'++'", "'--'", "'/'", "'>='", "'<='", "';'", "','", 
		"'['", "']'", "'='", "'!'", "'||'", "'&&'", "'&'", "'+'", "'-'", "'%'", 
		"'<'", "'>'", "'=='", "'!='", "':'", "'?'", "'{'", "'}'", "'('", "')'", 
		"'println'", "'boolean'", "'for'", "'int'", "'while'", "'length'", "'if'", 
		"'else'", "'true'", "'false'", "'break'", "'continue'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DOT", "TIMES", "INCR", "DECR", "DIVIDE", "GE", "LE", "SEMI", "COMMA", 
		"LSQ", "RSQ", "ASSIGN", "NOT", "OR", "AND", "ADDRESS", "PLUS", "MINUS", 
		"MOD", "LT", "GT", "EQ", "NE", "TELSE", "TIF", "LCURLY", "RCURLY", "LPAR", 
		"RPAR", "PRINT", "BOOL", "FOR", "INT", "WHILE", "LENGTH", "IF", "ELSE", 
		"TRUE", "FALSE", "BREAK", "CONTINUE", "ID", "NUM", "STRING", "COMMENT", 
		"WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10);
				stat();
				}
				}
				setState(13); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TIMES) | (1L << INCR) | (1L << DECR) | (1L << NOT) | (1L << ADDRESS) | (1L << MINUS) | (1L << LCURLY) | (1L << LPAR) | (1L << PRINT) | (1L << BOOL) | (1L << FOR) | (1L << INT) | (1L << WHILE) | (1L << IF) | (1L << TRUE) | (1L << FALSE) | (1L << BREAK) | (1L << CONTINUE) | (1L << ID) | (1L << NUM))) != 0) );
			setState(15);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ForStatContext extends StatContext {
		public TerminalNode FOR() { return getToken(GrammarParser.FOR, 0); }
		public TerminalNode LPAR() { return getToken(GrammarParser.LPAR, 0); }
		public List<TerminalNode> ID() { return getTokens(GrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GrammarParser.ID, i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(GrammarParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(GrammarParser.ASSIGN, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(GrammarParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(GrammarParser.SEMI, i);
		}
		public TerminalNode RPAR() { return getToken(GrammarParser.RPAR, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public ForStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterForStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitForStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitForStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStatContext extends StatContext {
		public TerminalNode WHILE() { return getToken(GrammarParser.WHILE, 0); }
		public TerminalNode LPAR() { return getToken(GrammarParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(GrammarParser.RPAR, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public WhileStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitWhileStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayDeclContext extends StatContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> LSQ() { return getTokens(GrammarParser.LSQ); }
		public TerminalNode LSQ(int i) {
			return getToken(GrammarParser.LSQ, i);
		}
		public TerminalNode NUM() { return getToken(GrammarParser.NUM, 0); }
		public List<TerminalNode> RSQ() { return getTokens(GrammarParser.RSQ); }
		public TerminalNode RSQ(int i) {
			return getToken(GrammarParser.RSQ, i);
		}
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(GrammarParser.SEMI, 0); }
		public TerminalNode ASSIGN() { return getToken(GrammarParser.ASSIGN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GrammarParser.COMMA, i);
		}
		public ArrayDeclContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArrayDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArrayDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitArrayDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintStatContext extends StatContext {
		public TerminalNode PRINT() { return getToken(GrammarParser.PRINT, 0); }
		public TerminalNode LPAR() { return getToken(GrammarParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(GrammarParser.RPAR, 0); }
		public TerminalNode SEMI() { return getToken(GrammarParser.SEMI, 0); }
		public PrintStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterPrintStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitPrintStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitPrintStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStatContext extends StatContext {
		public TerminalNode IF() { return getToken(GrammarParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(GrammarParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(GrammarParser.RPAR, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(GrammarParser.ELSE, 0); }
		public IfStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitIfStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprStatContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(GrammarParser.SEMI, 0); }
		public ExprStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterExprStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitExprStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExprStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStatContext extends StatContext {
		public TerminalNode LCURLY() { return getToken(GrammarParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(GrammarParser.RCURLY, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public BlockStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterBlockStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitBlockStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitBlockStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PointerDeclContext extends StatContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode TIMES() { return getToken(GrammarParser.TIMES, 0); }
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(GrammarParser.SEMI, 0); }
		public TerminalNode ASSIGN() { return getToken(GrammarParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PointerDeclContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterPointerDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitPointerDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitPointerDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContStatContext extends StatContext {
		public TerminalNode CONTINUE() { return getToken(GrammarParser.CONTINUE, 0); }
		public TerminalNode SEMI() { return getToken(GrammarParser.SEMI, 0); }
		public ContStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterContStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitContStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitContStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakStatContext extends StatContext {
		public TerminalNode BREAK() { return getToken(GrammarParser.BREAK, 0); }
		public TerminalNode SEMI() { return getToken(GrammarParser.SEMI, 0); }
		public BreakStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterBreakStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitBreakStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitBreakStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayElemAssignStatContext extends StatContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode LSQ() { return getToken(GrammarParser.LSQ, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RSQ() { return getToken(GrammarParser.RSQ, 0); }
		public TerminalNode ASSIGN() { return getToken(GrammarParser.ASSIGN, 0); }
		public TerminalNode SEMI() { return getToken(GrammarParser.SEMI, 0); }
		public ArrayElemAssignStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArrayElemAssignStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArrayElemAssignStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitArrayElemAssignStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclContext extends StatContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(GrammarParser.SEMI, 0); }
		public TerminalNode ASSIGN() { return getToken(GrammarParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		int _la;
		try {
			setState(113);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new DeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(17);
				type();
				setState(18);
				match(ID);
				setState(21);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(19);
					match(ASSIGN);
					setState(20);
					expr(0);
					}
				}

				setState(23);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new PointerDeclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				type();
				setState(26);
				match(TIMES);
				setState(27);
				match(ID);
				setState(30);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(28);
					match(ASSIGN);
					setState(29);
					expr(0);
					}
				}

				setState(32);
				match(SEMI);
				}
				break;
			case 3:
				_localctx = new ArrayDeclContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(34);
				type();
				setState(35);
				match(LSQ);
				setState(36);
				match(NUM);
				setState(37);
				match(RSQ);
				setState(38);
				match(ID);
				setState(51);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(39);
					match(ASSIGN);
					setState(40);
					match(LSQ);
					setState(41);
					expr(0);
					setState(46);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(42);
						match(COMMA);
						setState(43);
						expr(0);
						}
						}
						setState(48);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(49);
					match(RSQ);
					}
				}

				setState(53);
				match(SEMI);
				}
				break;
			case 4:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(55);
				match(IF);
				setState(56);
				match(LPAR);
				setState(57);
				expr(0);
				setState(58);
				match(RPAR);
				setState(59);
				stat();
				setState(62);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(60);
					match(ELSE);
					setState(61);
					stat();
					}
					break;
				}
				}
				break;
			case 5:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(64);
				match(WHILE);
				setState(65);
				match(LPAR);
				setState(66);
				expr(0);
				setState(67);
				match(RPAR);
				setState(68);
				stat();
				}
				break;
			case 6:
				_localctx = new ArrayElemAssignStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(70);
				target();
				setState(71);
				match(LSQ);
				setState(72);
				expr(0);
				setState(73);
				match(RSQ);
				setState(74);
				match(ASSIGN);
				setState(75);
				expr(0);
				setState(76);
				match(SEMI);
				}
				break;
			case 7:
				_localctx = new ForStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(78);
				match(FOR);
				setState(79);
				match(LPAR);
				setState(80);
				match(ID);
				setState(81);
				match(ASSIGN);
				setState(82);
				expr(0);
				setState(83);
				match(SEMI);
				setState(84);
				expr(0);
				setState(85);
				match(SEMI);
				setState(86);
				match(ID);
				setState(87);
				match(ASSIGN);
				setState(88);
				expr(0);
				setState(89);
				match(RPAR);
				setState(90);
				stat();
				}
				break;
			case 8:
				_localctx = new BlockStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(92);
				match(LCURLY);
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TIMES) | (1L << INCR) | (1L << DECR) | (1L << NOT) | (1L << ADDRESS) | (1L << MINUS) | (1L << LCURLY) | (1L << LPAR) | (1L << PRINT) | (1L << BOOL) | (1L << FOR) | (1L << INT) | (1L << WHILE) | (1L << IF) | (1L << TRUE) | (1L << FALSE) | (1L << BREAK) | (1L << CONTINUE) | (1L << ID) | (1L << NUM))) != 0)) {
					{
					{
					setState(93);
					stat();
					}
					}
					setState(98);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(99);
				match(RCURLY);
				}
				break;
			case 9:
				_localctx = new PrintStatContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(100);
				match(PRINT);
				setState(101);
				match(LPAR);
				setState(102);
				expr(0);
				setState(103);
				match(RPAR);
				setState(104);
				match(SEMI);
				}
				break;
			case 10:
				_localctx = new BreakStatContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(106);
				match(BREAK);
				setState(107);
				match(SEMI);
				}
				break;
			case 11:
				_localctx = new ExprStatContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(108);
				expr(0);
				setState(109);
				match(SEMI);
				}
				break;
			case 12:
				_localctx = new ContStatContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(111);
				match(CONTINUE);
				setState(112);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TargetContext extends ParserRuleContext {
		public TargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_target; }
	 
		public TargetContext() { }
		public void copyFrom(TargetContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IdTargetContext extends TargetContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public IdTargetContext(TargetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterIdTarget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitIdTarget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitIdTarget(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetContext target() throws RecognitionException {
		TargetContext _localctx = new TargetContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_target);
		try {
			_localctx = new IdTargetContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AndExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(GrammarParser.AND, 0); }
		public AndExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DereferenceExprContext extends ExprContext {
		public TerminalNode TIMES() { return getToken(GrammarParser.TIMES, 0); }
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public DereferenceExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterDereferenceExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitDereferenceExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitDereferenceExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayLengthContext extends ExprContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode DOT() { return getToken(GrammarParser.DOT, 0); }
		public TerminalNode LENGTH() { return getToken(GrammarParser.LENGTH, 0); }
		public ArrayLengthContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArrayLength(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArrayLength(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitArrayLength(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public IdExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitIdExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitIdExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarExprContext extends ExprContext {
		public TerminalNode NUM() { return getToken(GrammarParser.NUM, 0); }
		public TerminalNode TRUE() { return getToken(GrammarParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(GrammarParser.FALSE, 0); }
		public VarExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterVarExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitVarExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitVarExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddressExprContext extends ExprContext {
		public TerminalNode ADDRESS() { return getToken(GrammarParser.ADDRESS, 0); }
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public AddressExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAddressExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAddressExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAddressExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TernaryExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode TIF() { return getToken(GrammarParser.TIF, 0); }
		public TerminalNode TELSE() { return getToken(GrammarParser.TELSE, 0); }
		public TernaryExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTernaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTernaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitTernaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignExprContext extends ExprContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(GrammarParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAssignExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GT() { return getToken(GrammarParser.GT, 0); }
		public TerminalNode GE() { return getToken(GrammarParser.GE, 0); }
		public TerminalNode LT() { return getToken(GrammarParser.LT, 0); }
		public TerminalNode LE() { return getToken(GrammarParser.LE, 0); }
		public TerminalNode EQ() { return getToken(GrammarParser.EQ, 0); }
		public TerminalNode NE() { return getToken(GrammarParser.NE, 0); }
		public CompExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCompExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCompExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitCompExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(GrammarParser.OR, 0); }
		public OrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParExprContext extends ExprContext {
		public TerminalNode LPAR() { return getToken(GrammarParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(GrammarParser.RPAR, 0); }
		public ParExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterParExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitParExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitParExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PostEditContext extends ExprContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode DECR() { return getToken(GrammarParser.DECR, 0); }
		public TerminalNode INCR() { return getToken(GrammarParser.INCR, 0); }
		public PostEditContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterPostEdit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitPostEdit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitPostEdit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PreEditContext extends ExprContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode DECR() { return getToken(GrammarParser.DECR, 0); }
		public TerminalNode INCR() { return getToken(GrammarParser.INCR, 0); }
		public PreEditContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterPreEdit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitPreEdit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitPreEdit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegExprContext extends ExprContext {
		public TerminalNode MINUS() { return getToken(GrammarParser.MINUS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNegExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNegExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitNegExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PointerAssignExprContext extends ExprContext {
		public TerminalNode TIMES() { return getToken(GrammarParser.TIMES, 0); }
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(GrammarParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PointerAssignExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterPointerAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitPointerAssignExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitPointerAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(GrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(GrammarParser.MINUS, 0); }
		public TerminalNode TIMES() { return getToken(GrammarParser.TIMES, 0); }
		public TerminalNode DIVIDE() { return getToken(GrammarParser.DIVIDE, 0); }
		public TerminalNode MOD() { return getToken(GrammarParser.MOD, 0); }
		public ArithExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArithExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArithExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitArithExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayElemExprContext extends ExprContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode LSQ() { return getToken(GrammarParser.LSQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RSQ() { return getToken(GrammarParser.RSQ, 0); }
		public ArrayElemExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArrayElemExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArrayElemExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitArrayElemExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExprContext extends ExprContext {
		public TerminalNode NOT() { return getToken(GrammarParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new AssignExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(118);
				target();
				setState(119);
				match(ASSIGN);
				setState(120);
				expr(14);
				}
				break;
			case 2:
				{
				_localctx = new PointerAssignExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(122);
				match(TIMES);
				setState(123);
				target();
				setState(124);
				match(ASSIGN);
				setState(125);
				expr(13);
				}
				break;
			case 3:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(127);
				match(NOT);
				setState(128);
				expr(4);
				}
				break;
			case 4:
				{
				_localctx = new NegExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(129);
				match(MINUS);
				setState(130);
				expr(1);
				}
				break;
			case 5:
				{
				_localctx = new ArrayElemExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(131);
				target();
				setState(132);
				match(LSQ);
				setState(133);
				expr(0);
				setState(134);
				match(RSQ);
				}
				break;
			case 6:
				{
				_localctx = new DereferenceExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136);
				match(TIMES);
				setState(137);
				target();
				}
				break;
			case 7:
				{
				_localctx = new AddressExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(138);
				match(ADDRESS);
				setState(139);
				target();
				}
				break;
			case 8:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << NUM))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 9:
				{
				_localctx = new PostEditContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				target();
				setState(142);
				_la = _input.LA(1);
				if ( !(_la==INCR || _la==DECR) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 10:
				{
				_localctx = new PreEditContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144);
				_la = _input.LA(1);
				if ( !(_la==INCR || _la==DECR) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(145);
				target();
				}
				break;
			case 11:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(146);
				match(ID);
				}
				break;
			case 12:
				{
				_localctx = new ArrayLengthContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(147);
				target();
				setState(148);
				match(DOT);
				setState(149);
				match(LENGTH);
				}
				break;
			case 13:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(151);
				match(LPAR);
				setState(152);
				expr(0);
				setState(153);
				match(RPAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(177);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(175);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ArithExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(157);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(158);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TIMES) | (1L << DIVIDE) | (1L << PLUS) | (1L << MINUS) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(159);
						expr(19);
						}
						break;
					case 2:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(160);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(161);
						match(AND);
						setState(162);
						expr(17);
						}
						break;
					case 3:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(163);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(164);
						match(OR);
						setState(165);
						expr(16);
						}
						break;
					case 4:
						{
						_localctx = new CompExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(166);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(167);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GE) | (1L << LE) | (1L << LT) | (1L << GT) | (1L << EQ) | (1L << NE))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(168);
						expr(13);
						}
						break;
					case 5:
						{
						_localctx = new TernaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(169);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(170);
						match(TIF);
						setState(171);
						expr(0);
						setState(172);
						match(TELSE);
						setState(173);
						expr(12);
						}
						break;
					}
					} 
				}
				setState(179);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(GrammarParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(GrammarParser.BOOL, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_la = _input.LA(1);
			if ( !(_la==BOOL || _la==INT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 18);
		case 1:
			return precpred(_ctx, 16);
		case 2:
			return precpred(_ctx, 15);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\60\u00b9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\6\2\16\n\2\r\2\16\2\17\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\5\3\30\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3!\n\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3/\n\3\f\3\16\3\62\13\3\3\3"+
		"\3\3\5\3\66\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3A\n\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3a\n\3\f\3\16\3d\13\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3t\n\3\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\5\5\u009e\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u00b2\n\5\f\5\16\5\u00b5\13\5\3\6\3\6\3"+
		"\6\2\3\b\7\2\4\6\b\n\2\7\4\2()--\3\2\5\6\5\2\4\4\7\7\23\25\4\2\b\t\26"+
		"\31\4\2!!##\u00d6\2\r\3\2\2\2\4s\3\2\2\2\6u\3\2\2\2\b\u009d\3\2\2\2\n"+
		"\u00b6\3\2\2\2\f\16\5\4\3\2\r\f\3\2\2\2\16\17\3\2\2\2\17\r\3\2\2\2\17"+
		"\20\3\2\2\2\20\21\3\2\2\2\21\22\7\2\2\3\22\3\3\2\2\2\23\24\5\n\6\2\24"+
		"\27\7,\2\2\25\26\7\16\2\2\26\30\5\b\5\2\27\25\3\2\2\2\27\30\3\2\2\2\30"+
		"\31\3\2\2\2\31\32\7\n\2\2\32t\3\2\2\2\33\34\5\n\6\2\34\35\7\4\2\2\35 "+
		"\7,\2\2\36\37\7\16\2\2\37!\5\b\5\2 \36\3\2\2\2 !\3\2\2\2!\"\3\2\2\2\""+
		"#\7\n\2\2#t\3\2\2\2$%\5\n\6\2%&\7\f\2\2&\'\7-\2\2\'(\7\r\2\2(\65\7,\2"+
		"\2)*\7\16\2\2*+\7\f\2\2+\60\5\b\5\2,-\7\13\2\2-/\5\b\5\2.,\3\2\2\2/\62"+
		"\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\63\3\2\2\2\62\60\3\2\2\2\63\64\7"+
		"\r\2\2\64\66\3\2\2\2\65)\3\2\2\2\65\66\3\2\2\2\66\67\3\2\2\2\678\7\n\2"+
		"\28t\3\2\2\29:\7&\2\2:;\7\36\2\2;<\5\b\5\2<=\7\37\2\2=@\5\4\3\2>?\7\'"+
		"\2\2?A\5\4\3\2@>\3\2\2\2@A\3\2\2\2At\3\2\2\2BC\7$\2\2CD\7\36\2\2DE\5\b"+
		"\5\2EF\7\37\2\2FG\5\4\3\2Gt\3\2\2\2HI\5\6\4\2IJ\7\f\2\2JK\5\b\5\2KL\7"+
		"\r\2\2LM\7\16\2\2MN\5\b\5\2NO\7\n\2\2Ot\3\2\2\2PQ\7\"\2\2QR\7\36\2\2R"+
		"S\7,\2\2ST\7\16\2\2TU\5\b\5\2UV\7\n\2\2VW\5\b\5\2WX\7\n\2\2XY\7,\2\2Y"+
		"Z\7\16\2\2Z[\5\b\5\2[\\\7\37\2\2\\]\5\4\3\2]t\3\2\2\2^b\7\34\2\2_a\5\4"+
		"\3\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2\2\2db\3\2\2\2et\7\35"+
		"\2\2fg\7 \2\2gh\7\36\2\2hi\5\b\5\2ij\7\37\2\2jk\7\n\2\2kt\3\2\2\2lm\7"+
		"*\2\2mt\7\n\2\2no\5\b\5\2op\7\n\2\2pt\3\2\2\2qr\7+\2\2rt\7\n\2\2s\23\3"+
		"\2\2\2s\33\3\2\2\2s$\3\2\2\2s9\3\2\2\2sB\3\2\2\2sH\3\2\2\2sP\3\2\2\2s"+
		"^\3\2\2\2sf\3\2\2\2sl\3\2\2\2sn\3\2\2\2sq\3\2\2\2t\5\3\2\2\2uv\7,\2\2"+
		"v\7\3\2\2\2wx\b\5\1\2xy\5\6\4\2yz\7\16\2\2z{\5\b\5\20{\u009e\3\2\2\2|"+
		"}\7\4\2\2}~\5\6\4\2~\177\7\16\2\2\177\u0080\5\b\5\17\u0080\u009e\3\2\2"+
		"\2\u0081\u0082\7\17\2\2\u0082\u009e\5\b\5\6\u0083\u0084\7\24\2\2\u0084"+
		"\u009e\5\b\5\3\u0085\u0086\5\6\4\2\u0086\u0087\7\f\2\2\u0087\u0088\5\b"+
		"\5\2\u0088\u0089\7\r\2\2\u0089\u009e\3\2\2\2\u008a\u008b\7\4\2\2\u008b"+
		"\u009e\5\6\4\2\u008c\u008d\7\22\2\2\u008d\u009e\5\6\4\2\u008e\u009e\t"+
		"\2\2\2\u008f\u0090\5\6\4\2\u0090\u0091\t\3\2\2\u0091\u009e\3\2\2\2\u0092"+
		"\u0093\t\3\2\2\u0093\u009e\5\6\4\2\u0094\u009e\7,\2\2\u0095\u0096\5\6"+
		"\4\2\u0096\u0097\7\3\2\2\u0097\u0098\7%\2\2\u0098\u009e\3\2\2\2\u0099"+
		"\u009a\7\36\2\2\u009a\u009b\5\b\5\2\u009b\u009c\7\37\2\2\u009c\u009e\3"+
		"\2\2\2\u009dw\3\2\2\2\u009d|\3\2\2\2\u009d\u0081\3\2\2\2\u009d\u0083\3"+
		"\2\2\2\u009d\u0085\3\2\2\2\u009d\u008a\3\2\2\2\u009d\u008c\3\2\2\2\u009d"+
		"\u008e\3\2\2\2\u009d\u008f\3\2\2\2\u009d\u0092\3\2\2\2\u009d\u0094\3\2"+
		"\2\2\u009d\u0095\3\2\2\2\u009d\u0099\3\2\2\2\u009e\u00b3\3\2\2\2\u009f"+
		"\u00a0\f\24\2\2\u00a0\u00a1\t\4\2\2\u00a1\u00b2\5\b\5\25\u00a2\u00a3\f"+
		"\22\2\2\u00a3\u00a4\7\21\2\2\u00a4\u00b2\5\b\5\23\u00a5\u00a6\f\21\2\2"+
		"\u00a6\u00a7\7\20\2\2\u00a7\u00b2\5\b\5\22\u00a8\u00a9\f\16\2\2\u00a9"+
		"\u00aa\t\5\2\2\u00aa\u00b2\5\b\5\17\u00ab\u00ac\f\r\2\2\u00ac\u00ad\7"+
		"\33\2\2\u00ad\u00ae\5\b\5\2\u00ae\u00af\7\32\2\2\u00af\u00b0\5\b\5\16"+
		"\u00b0\u00b2\3\2\2\2\u00b1\u009f\3\2\2\2\u00b1\u00a2\3\2\2\2\u00b1\u00a5"+
		"\3\2\2\2\u00b1\u00a8\3\2\2\2\u00b1\u00ab\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\t\3\2\2\2\u00b5\u00b3\3\2\2\2"+
		"\u00b6\u00b7\t\6\2\2\u00b7\13\3\2\2\2\r\17\27 \60\65@bs\u009d\u00b1\u00b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}