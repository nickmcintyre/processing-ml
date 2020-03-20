package template.library;


import org.tensorflow.DataType;
import org.tensorflow.Graph;
import org.tensorflow.Operation;
import org.tensorflow.Tensor;

import processing.core.*;

/**
 * This is a template class and can be used to start a new processing Library.
 * Make sure you rename this class as well as the name of the example package 'template' 
 * to your own Library naming convention.
 * 
 * (the tag example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 * @example Hello 
 */

public class HelloLibrary {
	
	// myParent is a reference to the parent sketch
	
	
	public final static String VERSION = "##library.prettyVersion##";
	

	public static void main(String[] args) {
		
		createModel();
	}
	public HelloLibrary(PApplet theParent) {
		
	}
	public static void createModel() {
		Graph graph=new Graph();
		Operation a = graph.opBuilder("Const", "a")
				  .setAttr("dtype", DataType.fromClass(Double.class))
				  .setAttr("value", Tensor.<Double>create(3.0, Double.class))
				  .build();     
		Operation b = graph.opBuilder("Const", "b")
				  .setAttr("dtype", DataType.fromClass(Double.class))
				  .setAttr("value", Tensor.<Double>create(2.0, Double.class))
				  .build();
		Operation x = graph.opBuilder("Placeholder", "x")
						  .setAttr("dtype", DataType.fromClass(Double.class))
						  .build();         
		Operation y = graph.opBuilder("Placeholder", "y")
						  .setAttr("dtype", DataType.fromClass(Double.class))
						  .build();		
		Operation ax = graph.opBuilder("Mul", "ax")
				  .addInput(a.output(0))
				  .addInput(x.output(0))
				  .build();         
		Operation by = graph.opBuilder("Mul", "by")
				  .addInput(b.output(0))
				  .addInput(y.output(0))
				  .build();
		Operation z = graph.opBuilder("Add", "z")
				  .addInput(ax.output(0))
				  .addInput(by.output(0))
				  .build();
		System.out.println(z.output(0));
	}
	
	
	public String sayHello() {
		return "hello library.";
	}
	
	public static String version() {
		return VERSION;
	}


}

