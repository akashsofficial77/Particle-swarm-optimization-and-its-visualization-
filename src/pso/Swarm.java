/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Aditya
 */
public class Swarm {

	private Particle[] particles;

	private long[] bestPosition;

	private double bestFitness = Double.NEGATIVE_INFINITY;

	private Random random = new Random();

	public Swarm(int numParticles) {
		particles = new Particle[numParticles];
		
	}

	public Particle[] getParticles() {
		return particles;
	}

	public long[] getBestPosition() {
		return bestPosition;
	}

	public double getBestFitness() {
		return bestFitness;
	}


	public void setBestPosition(long[] bestPosition) {
		this.bestPosition = bestPosition;
	}

	public void setBestFitness(double bestFitness) {
		this.bestFitness = bestFitness;
	}


	

}
