/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso;

/**
 *
 * @author tinyteddybear
 */
public class FitnessFunction {

	public double getFitness(long[] particlePosition) {

		long a = particlePosition[0];
		long b = particlePosition[1];

		
                long fitness = (a * (100 + b)) / 100;
		return fitness;
		
	}

}
