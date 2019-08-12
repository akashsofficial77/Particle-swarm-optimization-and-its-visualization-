
package javaapplication16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Aditya
 */
public class Swarm {

	
	private Particle[] particles;
        private ArrayList<Particle> particleList = new ArrayList<Particle>();
       // ArrayList<Particle> particlesList;

	
	private long[] bestPosition;

	private double bestFitness = Double.NEGATIVE_INFINITY;

	
	private Random random = new Random();


	public Swarm(int numParticles) {
        particles = new Particle[numParticles];
        for (int i = 0; i < numParticles; i++) {
            long[] initialParticlePosition = { random.nextInt(Constants.PARTICLE_UPPER_BOUND),
                    random.nextInt(Constants.PARTICLE_UPPER_BOUND),random.nextInt(Constants.PARTICLE_UPPER_BOUND),random.nextInt(Constants.PARTICLE_UPPER_BOUND),random.nextInt(Constants.PARTICLE_UPPER_BOUND),random.nextInt(Constants.PARTICLE_UPPER_BOUND) };
            long[] initialParticleSpeed = { 1,
                    1,1,1,1,1 };
            particles[i] = new Particle(initialParticlePosition, initialParticleSpeed);
        }
    }


	public Particle[] getParticles() {
		return particles;
	}
        public ArrayList<Particle> getParticlesList () {
		return this.particleList;
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

	
	@Override
	public String toString() {
		return "Swarm [particles=" + Arrays.toString(particles) + ", bestPosition=" + Arrays.toString(bestPosition)
				+ ", bestFitness=" + bestFitness + ", random=" + random + "]";
	}

}