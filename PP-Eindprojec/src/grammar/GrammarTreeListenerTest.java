package grammar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.junit.Test;
import grammar.GrammarBaseListener.*;
import grammar.GrammarParser.*;
import static org.junit.Assert.assertEquals;

public class GrammarTreeListenerTest {
	private GrammarTreeListenerCheck compiler = new GrammarTreeListenerCheck();



	@Test
	public void setUpTest(){
		ParseTree tree = parse(new File("C:/eclipse/Workspace/PP-Eindprojec/src/sample/Test1.ogt"));
		typeTest1(tree);
		System.out.println(compiler.check(tree).get(tree.getChild(0).getChild(2)));
	}
	public void typeTest1(ParseTree tree){
		ParseTreeProperty<Type> types = compiler.check(tree);
		assertEquals(Type.INT, types.get(tree.getChild(0).getChild(3)));
		assertEquals(Type.INT, types.get(tree.getChild(1).getChild(3)));
		assertEquals(Type.INT, types.get(tree.getChild(2).getChild(3)));


	}
	public ParseTree parse(File file){
		try {
			return compiler.parse(new ANTLRInputStream(new FileReader(file)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
