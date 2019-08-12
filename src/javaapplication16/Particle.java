/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication16;

import java.util.Arrays;

/**
 *
 * @author Aditya
 */
public class Particle {

	
	
	
	private long[] position;
	private long[] position2=new long[3];


	private long[] speed;


	private double fitness;

	private long[] bestPosition;

	private double bestFitness = Double.NEGATIVE_INFINITY;

	public Particle(long[] initialPosition, long[] initialSpeed) {
		this.position = initialPosition;
		this.speed = initialSpeed;
	}


	public long[] getPosition() {
		return position;
	}
	public long[] getPosition2() {
		return position2;
	}

	public long[] getSpeed() {
		return speed;
	}


	public double getFitness() {
		return fitness;
	}

	public long[] getBestPosition() {
		return bestPosition;
	}

	public double getBestFitness() {
		return bestFitness;
	}


	public void setPosition(long[] position) {
		this.position = position;
	}
	
	public void setPosition2(long[] position2) {
		this.position2 = position2;
	}

	public void setSpeed(long[] speed) {
		this.speed = speed;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	
	public void setBestPosition(long[] bestPosition) {
		this.bestPosition = bestPosition;
	}

	
	public void setBestFitness(double bestFitness) {
		this.bestFitness = bestFitness;
	}

	
	@Override
	public String toString() {
		return "Particle [position=" + Arrays.toString(position) + ", speed=" + Arrays.toString(speed) + ", fitness="
				+ fitness + ", bestPosition=" + Arrays.toString(bestPosition) + ", bestFitness=" + bestFitness + "]";
	}

}
