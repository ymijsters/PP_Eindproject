package compiler;

import grammar.GrammarLexer;
import grammar.GrammarParser;
import grammar.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import program.Program;

/**
 * This class compiles a source program to SPROCKELL instructions.
 *
 */
public class Compiler {
	private Checker checker = new Checker();
	private Generator generator = new Generator();

	public String compile(File file) {
		ParseTree tree = parse(file);
		try {
			Result result = checker.check(tree);
			Program p = generator.generate(tree, result);
			return p.toString();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("USAGE: Compiler <INPUTFILE> <OUTPUTFILE>");
		}
		Compiler compiler = new Compiler();

		String s = compiler.compile(new File(args[0]));
		PrintWriter out = null;
		try {
			out = new PrintWriter(args[1]);
			out.print(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			out.close();
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