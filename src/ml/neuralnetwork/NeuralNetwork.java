package ml.neuralnetwork;

import org.tensorflow.DataType;
import org.tensorflow.Graph;
import org.tensorflow.Operation;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;

/**
 * 
 * @author Nick McIntyre
 * @exmple HelloTensorFlow
 *
 */
public class NeuralNetwork {
	public static final String TFVERSION = TensorFlow.version();
	
	public static void demoGraph() {
		Graph graph = new Graph();
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
}
