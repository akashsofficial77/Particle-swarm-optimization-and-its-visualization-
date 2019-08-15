
package pso;

/**
 *
 * @author Aditya
 */
public interface FitnessFunction {


	public double getFitness(long[] particlePosition, int maxim,int costWebA, int costWebB,int costWebC,int costWebD,int costWebE,int costWebF, int[] viewsArray);

}