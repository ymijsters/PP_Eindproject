package test;

import static org.junit.Assert.assertEquals;
import grammar.GrammarLexer;
import grammar.GrammarParser;
import grammar.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import compiler.Checker;
import compiler.Result;
import compiler.Type;

public class GrammarTreeListenerTest {
	private Checker checker = new Checker();



	@Test
	public void setUpTest() throws ParseException{
		ParseTree tree = parse(new File("C:/eclipse/Workspace/PP-Eindprojec/src/sample/Test1.ogt"));
		typeTest1(tree);
		System.out.println(checker.check(tree).getType(tree.getChild(0).getChild(2)));
	}
	public void typeTest1(ParseTree tree) throws ParseException{
		Result result = checker.check(tree);
		assertEquals(Type.INT, result.getType(tree.getChild(0).getChild(3)));
		assertEquals(Type.INT, result.getType(tree.getChild(1).getChild(3)));
		assertEquals(Type.INT, result.getType(tree.getChild(2).getChild(3)));


	}
	public ParseTree parse(File file){
		try {
			Lexer lexer = new GrammarLexer(new ANTLRInputStream(new FileReader(file)));
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
