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
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import compiler.Checker;
import compiler.Result;
import compiler.Type;

@SuppressWarnings("deprecation")
public class GrammarTreeListenerTest {
	private Checker checker = new Checker();
	private final static String TEST_DIR = "src/sample/";

	@Test
	public void testSuccess1() {
		try {
			ParseTree tree = parse(new File(TEST_DIR
					+ "checkerTestSuccess1.ogt"));
			Result result = checker.check(tree);
			ParseTree line3 = tree.getChild(2);
			ParseTree z = line3.getChild(1);
			ParseTree whyle = tree.getChild(3);
			ParseTree cond = whyle.getChild(2);
			ParseTree condY = cond.getChild(0);
			ParseTree xPlusY = line3.getChild(3);
			Assert.assertEquals(Type.INT, result.getType(xPlusY));
			Assert.assertEquals(Type.BOOL, result.getType(cond));
			Assert.assertEquals(2, result.getOffset(z));
			Assert.assertEquals(1, result.getOffset(condY));
		} catch (ParseException e) {
			Assert.fail();
		}
	}

	@Test
	public void testSuccess2() {
		try {
			ParseTree tree = parse(new File(TEST_DIR
					+ "checkerTestSuccess2.ogt"));
			Result result = checker.check(tree);
		} catch (ParseException e) {
			Assert.fail();
		}
	}
	@Test
	public void testSuccess3() {
		try {
			ParseTree tree = parse(new File(TEST_DIR
					+ "checkerTestSuccess3.ogt"));
			Result result = checker.check(tree);
		} catch (ParseException e) {
			Assert.fail();
		}
	}
	@Test
	public void testSuccess4() {
		try {
			ParseTree tree = parse(new File(TEST_DIR
					+ "checkerTestSuccess4.ogt"));
			Result result = checker.check(tree);
		} catch (ParseException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	@Test
	public void testFail1() {
		try {
			ParseTree tree = parse(new File(TEST_DIR + "checkerTestFail1.ogt"));
			Result result = checker.check(tree);
		} catch (ParseException e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void testFail2() {
		try {
			ParseTree tree = parse(new File(TEST_DIR + "checkerTestFail2.ogt"));
			Result result = checker.check(tree);
		} catch (ParseException e) {
			return;
		}
		Assert.fail();
	}
	@Test
	public void testFail3() {
		try {
			ParseTree tree = parse(new File(TEST_DIR + "checkerTestFail3.ogt"));
			Result result = checker.check(tree);
		} catch (ParseException e) {
			return;
		}
		Assert.fail();
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
