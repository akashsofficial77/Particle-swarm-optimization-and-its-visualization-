
package pso;

import java.awt.Toolkit;
import java.util.Arrays;
import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;

/**
 *
 * @author Aditya
 */
public class MultiSwarm {
	int count=0;

	private Swarm[] swarms;

	private long[] bestPosition;

	private double bestFitness = Double.NEGATIVE_INFINITY;

	private Random random = new Random();

	private FitnessFunction fitnessFunction;
        Toolkit toolkit;
	Timer timer;
        

	public MultiSwarm(int numSwarms, int particlesPerSwarm, FitnessFunction fitnessFunction) {
		this.fitnessFunction = fitnessFunction;
		this.swarms = new Swarm[numSwarms];
		for (int i = 0; i < numSwarms; i++) {
			swarms[i] = new Swarm(particlesPerSwarm);
		}
                /* toolkit = Toolkit.getDefaultToolkit();
		 timer = new Timer();
	         timer.schedule(new CrunchifyReminder(), 1000, // initial delay
				1 * 1500); // subsequent rate
		*/
                
               
	}

        public Swarm getSwarm(){
            return swarms[0];
        }
        
       /*  class CrunchifyReminder extends TimerTask {
		int loop=0;

 
		public void run() {
			if (loop < 5) {
				toolkit.beep();
				float elapsedTime = 0;
                                mainLoop(loop);
				loop++;
			} else {
				toolkit.beep();
				System.out.format("\nThat's it.. Done..!");
				timer.cancel();
			}
		}
                
        }
        */
    
        
	public void mainLoop(int i) {
                 if(i!=-1){
		//for (Swarm swarm : swarms) {
			for (Particle particle : swarms[i].getParticles()) {

				long[] particleOldPosition = particle.getPosition().clone();

				// Calculate the particle fitness.
				particle.setFitness(fitnessFunction.getFitness(particleOldPosition));

				// Check if a new best position has been found for the particle
				// itself, within the swarm and the multiswarm.
				if (particle.getFitness() > particle.getBestFitness()) {
					particle.setBestFitness(particle.getFitness());
					particle.setBestPosition(particleOldPosition);

					if (particle.getFitness() > swarms[i].getBestFitness()) {
						swarms[i].setBestFitness(particle.getFitness());
						swarms[i].setBestPosition(particleOldPosition);

						if (swarms[i].getBestFitness() > bestFitness) {
							bestFitness = swarms[i].getBestFitness();
							bestPosition = swarms[i].getBestPosition().clone();
						}

					}
				}

				// Updates the particle position by adding the speed to the
				// actual position.
				long[] position = particle.getPosition();
				//long[] position2 = particle.getPosition2();
				long[] speed = particle.getSpeed();
				
				long x=position[0];
				long y=position[1];
				long z=position[2];
				
				
				position[0] += speed[0];
                                position[1] += speed[1];
                                position[2] += speed[2];
                                position[3] += speed[3];
                                position[4] += speed[4];
                                position[5] += speed[5];
                
                                  speed[0] = getNewParticleSpeedForIndex(particle, swarms[i], 0);
                                  speed[1] = getNewParticleSpeedForIndex(particle, swarms[i], 1);
                                  speed[2] = getNewParticleSpeedForIndex(particle, swarms[i], 2);
                                  speed[3] = getNewParticleSpeedForIndex(particle, swarms[i], 3);
                                  speed[4] = getNewParticleSpeedForIndex(particle, swarms[i], 4);
                                  speed[5] = getNewParticleSpeedForIndex(particle, swarms[i], 5);
 

				
				
			}
                 }
		//}
	}

	
	private int getNewParticleSpeedForIndex(Particle particle, Swarm swarm, int index) {

		return (int) ((Constants.INERTIA_FACTOR * particle.getSpeed()[index])
				+ (randomizePercentage(Constants.COGNITIVE_WEIGHT)
						* (particle.getBestPosition()[index] - particle.getPosition()[index]))
				+ (randomizePercentage(Constants.SOCIAL_WEIGHT)
						* (swarm.getBestPosition()[index] - particle.getPosition()[index]))
				+ (randomizePercentage(Constants.GLOBAL_WEIGHT)
						* (bestPosition[index] - particle.getPosition()[index])));
	}


	private double randomizePercentage(double value) {
		Double xx= random.nextDouble();
		//System.out.println(xx);
		
		return xx* value;
	}

	public long[] getBestPosition() {
		return bestPosition;
	}

	
	public double getBestFitness() {
		return bestFitness;
	}

	
	@Override
	public String toString() {
		return "Multiswarm [swarms=" + Arrays.toString(swarms) + ", bestPosition=" + Arrays.toString(bestPosition)
				+ ", bestFitness=" + bestFitness + ", random=" + random + ", fitnessFunction=" + fitnessFunction + "]";
	}

}
