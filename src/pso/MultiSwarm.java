
package pso;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Aditya
 */
public class MultiSwarm {
	//int count=0;
        
	private Swarm[] swarms;
        long[] output;
	private long[] bestPosition;
        long ff;
        long views;
        long outViews=-999999999;
        long outff=-999999999;
	private double bestFitness = Double.NEGATIVE_INFINITY;

	private Random random = new Random();

	private FitnessFunction fitnessFunction;
        Toolkit toolkit;
	Timer timer;
        private double inertiaFactor;
        private double cw;
        private double sw;
        private double gw;
        private static  int count=0 ;
       // ArrayList<long []> a1 = new ArrayList<long[]>();
         XYSeriesCollection dataset = new XYSeriesCollection();
	 XYSeries series1 = new XYSeries("Graphical Analysis");
        

	public MultiSwarm(int numSwarms, int particlesPerSwarm, FitnessFunction fitnessFunction,double inertiaFactor, double cw, double sw, double gw) {
		this.fitnessFunction = fitnessFunction;
                this.inertiaFactor=inertiaFactor;
                this.cw=cw;
                this.sw=sw;
                this.gw=gw;
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

        public Swarm[] getSwarm(){
            return swarms;
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
    
        
	public void mainLoop(int maxim,int costWebA, int costWebB,int costWebC,int costWebD,int costWebE,int costWebF, int[] viewsArray) {
               
		for (Swarm swarm : swarms) {
			for (Particle particle : swarm.getParticles()) {

				long[] particleOldPosition = particle.getPosition().clone();

				// Calculate the particle fitness.
				particle.setFitness(fitnessFunction.getFitness(particleOldPosition,maxim,costWebA,costWebB,costWebC,costWebD,costWebE,costWebF,viewsArray));

				// Check if a new best position has been found for the particle
				// itself, within the swarm and the multiswarm.
				if (particle.getFitness() > particle.getBestFitness()) {
					particle.setBestFitness(particle.getFitness());
					particle.setBestPosition(particleOldPosition);

					if (particle.getFitness() > swarm.getBestFitness()) {
						swarm.setBestFitness(particle.getFitness());
						swarm.setBestPosition(particleOldPosition);

						if (swarm.getBestFitness() > bestFitness) {
							bestFitness = swarm.getBestFitness();
							bestPosition = swarm.getBestPosition().clone();
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
                                count++;
                              // System.out.println(swarms.length*swarms[0].getParticles().length*1000-1);

                                   
                                   
                                  // a1.add(particle.getPosition());
                                   ff= (position[0] * costWebA) + (position[1] * costWebB)+(position[2]*costWebC)+(position[3]*costWebD)+(position[4]*costWebE)+(position[5]*costWebF);
                                   views = (position[0] * viewsArray[0]) + (position[1] * viewsArray[1])+(position[2]*viewsArray[2])+(position[3]*viewsArray[3])+(position[4]*viewsArray[4])+(position[5]*viewsArray[5]);
                                   if((maxim-ff)<(maxim-outff) && (maxim-ff)>=0)
                                   {
                                       if(outViews<views)
                                       {
                                       outViews=views;
                                       outff=ff;
                                       output=particle.getPosition();
                                       }
                                   }
                                   //System.out.println(ff+"      "+position[0]+","+position[1]+","+position[2]+","+position[3]+","+position[4]+","+position[5]);
                                   //System.out.println("xx "+outff+"      "+output[0]+","+output[1]+","+output[2]+","+output[3]+","+output[4]+","+output[5]);
                                   //JOptionPane.showMessageDialog(null,position[0]+","+position[1]+","+position[2]+","+position[3]+","+position[4]+","+position[5]);
                                   
                                   //System.out.println(al.get(xxx-1)[0]+","+al.get(xxx-1)[1]+","+al.get(xxx-1)[2]+","+al.get(xxx-1)[3]+","+al.get(xxx-1)[4]+","+al.get(xxx-1)[5]+",");

                                  series1.add(count,(position[0]+position[1]+position[2]+position[3]+position[4]+position[5])*10); 
                                    //JOptionPane.showMessageDialog(null,position[0]+","+position[1]+","+position[2]+","+position[3]+","+position[4]+","+position[5]);
                                   //System.out.println(al.get(xxx-1)[0]+","+al.get(xxx-1)[1]+","+al.get(xxx-1)[2]+","+al.get(xxx-1)[3]+","+al.get(xxx-1)[4]+","+al.get(xxx-1)[5]+",");
                               
                               
                               if(count==((swarms.length*swarms[0].getParticles().length*1000)/2)-1)
                               {
                                  JOptionPane.showMessageDialog(null,outViews+" "+outff+"   "+output[0]+","+output[1]+","+output[2]+","+output[3]+","+output[4]+","+output[5]);
                                   dataset.addSeries(series1);
                                   Chart chart = new Chart(
                                   "Element No Vs Time Required" ,
                                   "Element No  vs Time Required", dataset);
                                   chart.pack( );
                                     // RefineryUtilities.centerFrameOnScreen( chart );
                                   chart.setVisible( true ); 
                              
                               }
                               
                
                                  speed[0] = getNewParticleSpeedForIndex(particle, swarm, 0);
                                  speed[1] = getNewParticleSpeedForIndex(particle, swarm, 1);
                                  speed[2] = getNewParticleSpeedForIndex(particle, swarm, 2);
                                  speed[3] = getNewParticleSpeedForIndex(particle, swarm, 3);
                                  speed[4] = getNewParticleSpeedForIndex(particle, swarm, 4);
                                  speed[5] = getNewParticleSpeedForIndex(particle, swarm, 5);
                                   //System.out.println("main loop print SWARM");
                                   
                                   

				
				
			
                 }
		}
	}

	
	private int getNewParticleSpeedForIndex(Particle particle, Swarm swarm, int index) {

		return (int) ((inertiaFactor * particle.getSpeed()[index])
				+ (randomizePercentage(cw)
						* (particle.getBestPosition()[index] - particle.getPosition()[index]))
				+ (randomizePercentage(sw)
						* (swarm.getBestPosition()[index] - particle.getPosition()[index]))
				+ (randomizePercentage(gw)
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
