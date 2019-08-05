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
public class Particle {


	private long[] particlePosition;
	private long[] particleSpeed;
	private double particleFitness;
	private long[] particleBestPosition;
        private double particleBestFitness;
        
	public Particle(long[] initialPosition, long[] initialSpeed) {
		this.particlePosition = initialPosition;
		this.particleSpeed = initialSpeed;
	}
        
	public long[] getParticlePosition() {
		return particlePosition;
	}
        
	public long[] getParticleSpeed() {
		return particleSpeed;
	}
	public double getParticleFitness() {
		return particleFitness;
	}
	public long[] getParticleBestPosition() {
		return particleBestPosition;
	}
	public double getParticleBestFitness() {
		return particleBestFitness;
	}
	public void setParticlePosition(long[] position) {
		this.particlePosition = position;
	}
	public void setParticleSpeed(long[] speed) {
		this.particleSpeed = speed;
	}
	public void setParticleFitness(double fitness) {
		this.particleFitness = fitness;
	}
	public void setParticleBestPosition(long[] bestPosition) {
		this.particleBestPosition = bestPosition;
	}
	public void setParticleBestFitness(double bestFitness) {
		this.particleBestFitness = bestFitness;
	}
	

}