
package pso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Aditya
 */
public class Swarm {
        static int count=0;
	int  sNumber;
	private Particle[] particles;
        private ArrayList<Particle> particleList = new ArrayList<Particle>();
       // ArrayList<Particle> particlesList;

	
	private long[] bestPosition;

	private double bestFitness = Double.NEGATIVE_INFINITY;

	
	private Random random = new Random();


	public Swarm(int numParticles) {
            
            sNumber =count++;
        particles = new Particle[numParticles];
        for (int i = 0; i < numParticles; i++) {
            long[] initialParticlePosition = { random.nextInt(1000),
                    random.nextInt(1000),random.nextInt(1000),random.nextInt(1000),random.nextInt(1000),random.nextInt(1000) };
            long[] initialParticleSpeed = { 1,
                    1,1,1,1,1 };
            particles[i] = new Particle(initialParticlePosition, initialParticleSpeed);
        }
    }

        public int getSNumber()
        {
            return sNumber;
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