package test;

import grammar.GrammarLexer;
import grammar.GrammarParser;
import grammar.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import junit.framework.Assert;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import compiler.Checker;

@SuppressWarnings("deprecation")
public class SyntaxTest {
	public final static int NUM_SUCCESS_FILES = 8;
	private Checker checker = new Checker();
	private final static String TEST_DIR = "src/sample/";
	private static final int NUM_FAIL_FILES = 5;

	public void testSuccess(String file) {
		try {
			ParseTree tree = parse(new File(TEST_DIR + file));
			checker.check(tree);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	public void testFail(String file) {
		try {
			ParseTree tree = parse(new File(TEST_DIR + file));
			checker.check(tree);
			Assert.fail();
		} catch (Exception e) {
		}
	}

	@Test
	public void testSuccessFiles() {
		for (int i = 0; i < NUM_SUCCESS_FILES; i++) {
			testSuccess("syntaxTestSuccess" + (i + 1) + ".ogt");
		}
	}

	@Test
	public void testFailFiles() {
		for (int i = 0; i < NUM_FAIL_FILES; i++) {
			testFail("syntaxTestFail" + (i + 1) + ".ogt");
		}
	}

	public ParseTree parse(File file) {
		try {
			Lexer lexer = new GrammarLexer(new ANTLRInputStream(new FileReader(
					file)));
			TokenStream tokens = new CommonTokenStream(lexer);
			GrammarParser parser = new GrammarParser(tokens);
			ParseTree result = parser.program();
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
