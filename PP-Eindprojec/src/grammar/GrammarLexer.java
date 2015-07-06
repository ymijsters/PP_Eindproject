// Generated from Grammar.g4 by ANTLR 4.5
package grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"DOT", "TIMES", "INCR", "DECR", "DIVIDE", "GE", "LE", "SEMI", "COMMA", 
		"LSQ", "RSQ", "ASSIGN", "NOT", "OR", "AND", "ADDRESS", "PLUS", "MINUS", 
		"MOD", "LT", "GT", "EQ", "NE", "TELSE", "TIF", "LCURLY", "RCURLY", "LPAR", 
		"RPAR", "PRINT", "BOOL", "FOR", "INT", "WHILE", "LENGTH", "IF", "ELSE", 
		"TRUE", "FALSE", "BREAK", "CONTINUE", "LETTER", "DIGIT", "ID", "NUM", 
		"STRING", "COMMENT", "WS"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\60\u011d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3!\3"+
		"!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3%\3%\3"+
		"%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)"+
		"\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3,\3,\3-\3-\3-\7-\u00f4\n-\f-\16"+
		"-\u00f7\13-\3.\6.\u00fa\n.\r.\16.\u00fb\3/\3/\3/\3/\7/\u0102\n/\f/\16"+
		"/\u0105\13/\3/\3/\3\60\3\60\3\60\3\60\7\60\u010d\n\60\f\60\16\60\u0110"+
		"\13\60\3\60\3\60\3\60\3\60\3\60\3\61\6\61\u0118\n\61\r\61\16\61\u0119"+
		"\3\61\3\61\3\u010e\2\62\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U\2W\2Y,[-]._/a\60\3"+
		"\2\6\4\2C\\c|\3\2\62;\4\2$$^^\5\2\13\f\17\17\"\"\u0121\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2"+
		"\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K"+
		"\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2Y\3\2\2\2\2[\3\2"+
		"\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\3c\3\2\2\2\5e\3\2\2\2\7g\3\2\2\2"+
		"\tj\3\2\2\2\13m\3\2\2\2\ro\3\2\2\2\17r\3\2\2\2\21u\3\2\2\2\23w\3\2\2\2"+
		"\25y\3\2\2\2\27{\3\2\2\2\31}\3\2\2\2\33\177\3\2\2\2\35\u0081\3\2\2\2\37"+
		"\u0084\3\2\2\2!\u0087\3\2\2\2#\u0089\3\2\2\2%\u008b\3\2\2\2\'\u008d\3"+
		"\2\2\2)\u008f\3\2\2\2+\u0091\3\2\2\2-\u0093\3\2\2\2/\u0096\3\2\2\2\61"+
		"\u0099\3\2\2\2\63\u009b\3\2\2\2\65\u009d\3\2\2\2\67\u009f\3\2\2\29\u00a1"+
		"\3\2\2\2;\u00a3\3\2\2\2=\u00a5\3\2\2\2?\u00ad\3\2\2\2A\u00b5\3\2\2\2C"+
		"\u00b9\3\2\2\2E\u00bd\3\2\2\2G\u00c3\3\2\2\2I\u00ca\3\2\2\2K\u00cd\3\2"+
		"\2\2M\u00d2\3\2\2\2O\u00d7\3\2\2\2Q\u00dd\3\2\2\2S\u00e3\3\2\2\2U\u00ec"+
		"\3\2\2\2W\u00ee\3\2\2\2Y\u00f0\3\2\2\2[\u00f9\3\2\2\2]\u00fd\3\2\2\2_"+
		"\u0108\3\2\2\2a\u0117\3\2\2\2cd\7\60\2\2d\4\3\2\2\2ef\7,\2\2f\6\3\2\2"+
		"\2gh\7-\2\2hi\7-\2\2i\b\3\2\2\2jk\7/\2\2kl\7/\2\2l\n\3\2\2\2mn\7\61\2"+
		"\2n\f\3\2\2\2op\7@\2\2pq\7?\2\2q\16\3\2\2\2rs\7>\2\2st\7?\2\2t\20\3\2"+
		"\2\2uv\7=\2\2v\22\3\2\2\2wx\7.\2\2x\24\3\2\2\2yz\7]\2\2z\26\3\2\2\2{|"+
		"\7_\2\2|\30\3\2\2\2}~\7?\2\2~\32\3\2\2\2\177\u0080\7#\2\2\u0080\34\3\2"+
		"\2\2\u0081\u0082\7~\2\2\u0082\u0083\7~\2\2\u0083\36\3\2\2\2\u0084\u0085"+
		"\7(\2\2\u0085\u0086\7(\2\2\u0086 \3\2\2\2\u0087\u0088\7(\2\2\u0088\"\3"+
		"\2\2\2\u0089\u008a\7-\2\2\u008a$\3\2\2\2\u008b\u008c\7/\2\2\u008c&\3\2"+
		"\2\2\u008d\u008e\7\'\2\2\u008e(\3\2\2\2\u008f\u0090\7>\2\2\u0090*\3\2"+
		"\2\2\u0091\u0092\7@\2\2\u0092,\3\2\2\2\u0093\u0094\7?\2\2\u0094\u0095"+
		"\7?\2\2\u0095.\3\2\2\2\u0096\u0097\7#\2\2\u0097\u0098\7?\2\2\u0098\60"+
		"\3\2\2\2\u0099\u009a\7<\2\2\u009a\62\3\2\2\2\u009b\u009c\7A\2\2\u009c"+
		"\64\3\2\2\2\u009d\u009e\7}\2\2\u009e\66\3\2\2\2\u009f\u00a0\7\177\2\2"+
		"\u00a08\3\2\2\2\u00a1\u00a2\7*\2\2\u00a2:\3\2\2\2\u00a3\u00a4\7+\2\2\u00a4"+
		"<\3\2\2\2\u00a5\u00a6\7r\2\2\u00a6\u00a7\7t\2\2\u00a7\u00a8\7k\2\2\u00a8"+
		"\u00a9\7p\2\2\u00a9\u00aa\7v\2\2\u00aa\u00ab\7n\2\2\u00ab\u00ac\7p\2\2"+
		"\u00ac>\3\2\2\2\u00ad\u00ae\7d\2\2\u00ae\u00af\7q\2\2\u00af\u00b0\7q\2"+
		"\2\u00b0\u00b1\7n\2\2\u00b1\u00b2\7g\2\2\u00b2\u00b3\7c\2\2\u00b3\u00b4"+
		"\7p\2\2\u00b4@\3\2\2\2\u00b5\u00b6\7h\2\2\u00b6\u00b7\7q\2\2\u00b7\u00b8"+
		"\7t\2\2\u00b8B\3\2\2\2\u00b9\u00ba\7k\2\2\u00ba\u00bb\7p\2\2\u00bb\u00bc"+
		"\7v\2\2\u00bcD\3\2\2\2\u00bd\u00be\7y\2\2\u00be\u00bf\7j\2\2\u00bf\u00c0"+
		"\7k\2\2\u00c0\u00c1\7n\2\2\u00c1\u00c2\7g\2\2\u00c2F\3\2\2\2\u00c3\u00c4"+
		"\7n\2\2\u00c4\u00c5\7g\2\2\u00c5\u00c6\7p\2\2\u00c6\u00c7\7i\2\2\u00c7"+
		"\u00c8\7v\2\2\u00c8\u00c9\7j\2\2\u00c9H\3\2\2\2\u00ca\u00cb\7k\2\2\u00cb"+
		"\u00cc\7h\2\2\u00ccJ\3\2\2\2\u00cd\u00ce\7g\2\2\u00ce\u00cf\7n\2\2\u00cf"+
		"\u00d0\7u\2\2\u00d0\u00d1\7g\2\2\u00d1L\3\2\2\2\u00d2\u00d3\7v\2\2\u00d3"+
		"\u00d4\7t\2\2\u00d4\u00d5\7w\2\2\u00d5\u00d6\7g\2\2\u00d6N\3\2\2\2\u00d7"+
		"\u00d8\7h\2\2\u00d8\u00d9\7c\2\2\u00d9\u00da\7n\2\2\u00da\u00db\7u\2\2"+
		"\u00db\u00dc\7g\2\2\u00dcP\3\2\2\2\u00dd\u00de\7d\2\2\u00de\u00df\7t\2"+
		"\2\u00df\u00e0\7g\2\2\u00e0\u00e1\7c\2\2\u00e1\u00e2\7m\2\2\u00e2R\3\2"+
		"\2\2\u00e3\u00e4\7e\2\2\u00e4\u00e5\7q\2\2\u00e5\u00e6\7p\2\2\u00e6\u00e7"+
		"\7v\2\2\u00e7\u00e8\7k\2\2\u00e8\u00e9\7p\2\2\u00e9\u00ea\7w\2\2\u00ea"+
		"\u00eb\7g\2\2\u00ebT\3\2\2\2\u00ec\u00ed\t\2\2\2\u00edV\3\2\2\2\u00ee"+
		"\u00ef\t\3\2\2\u00efX\3\2\2\2\u00f0\u00f5\5U+\2\u00f1\u00f4\5U+\2\u00f2"+
		"\u00f4\5W,\2\u00f3\u00f1\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4\u00f7\3\2\2"+
		"\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6Z\3\2\2\2\u00f7\u00f5"+
		"\3\2\2\2\u00f8\u00fa\5W,\2\u00f9\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb"+
		"\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\\\3\2\2\2\u00fd\u0103\7$\2\2"+
		"\u00fe\u0102\n\4\2\2\u00ff\u0100\7^\2\2\u0100\u0102\13\2\2\2\u0101\u00fe"+
		"\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2\2\2\u0103"+
		"\u0104\3\2\2\2\u0104\u0106\3\2\2\2\u0105\u0103\3\2\2\2\u0106\u0107\7$"+
		"\2\2\u0107^\3\2\2\2\u0108\u0109\7\61\2\2\u0109\u010a\7,\2\2\u010a\u010e"+
		"\3\2\2\2\u010b\u010d\13\2\2\2\u010c\u010b\3\2\2\2\u010d\u0110\3\2\2\2"+
		"\u010e\u010f\3\2\2\2\u010e\u010c\3\2\2\2\u010f\u0111\3\2\2\2\u0110\u010e"+
		"\3\2\2\2\u0111\u0112\7,\2\2\u0112\u0113\7\61\2\2\u0113\u0114\3\2\2\2\u0114"+
		"\u0115\b\60\2\2\u0115`\3\2\2\2\u0116\u0118\t\5\2\2\u0117\u0116\3\2\2\2"+
		"\u0118\u0119\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b"+
		"\3\2\2\2\u011b\u011c\b\61\2\2\u011cb\3\2\2\2\n\2\u00f3\u00f5\u00fb\u0101"+
		"\u0103\u010e\u0119\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}