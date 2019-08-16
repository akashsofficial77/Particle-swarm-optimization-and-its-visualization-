
package pso;

import java.awt.Toolkit;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;;
import javax.swing.JOptionPane;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Aditya
 */
public class MultiSwarm {

        long[] positionFixed=new long [10];
	private Swarm[] swarms;
        long[] output=new long [10];
	private long[] bestPosition;
        long ff;
        long views;
        long outViews=-2147483648 ;
        long outff=-2147483648 ;
	private double bestFitness = Double.NEGATIVE_INFINITY;

	private Random random = new Random();

	private FitnessFunctionInterface fitnessFunction;
        Toolkit toolkit;
	Timer timer;
        private double inertiaFactor;
        private double cw;
        private double sw;
        private double gw;
        private static  int count=0 ;
   
         XYSeriesCollection dataset = new XYSeriesCollection();
	 XYSeries series = new XYSeries("Graphical Analysis");
         XYSeriesCollection dataset1 = new XYSeriesCollection();
	 XYSeries series1 = new XYSeries("Graphical Analysis");
        

	public MultiSwarm(int numSwarms, int particlesPerSwarm, FitnessFunctionInterface fitnessFunction,double inertiaFactor, double cw, double sw, double gw) {
		this.fitnessFunction = fitnessFunction;
                this.inertiaFactor=inertiaFactor;
                this.cw=cw;
                this.sw=sw;
                this.gw=gw;
		this.swarms = new Swarm[numSwarms];
		for (int i = 0; i < numSwarms; i++) {
			swarms[i] = new Swarm(particlesPerSwarm);
		}
   
               
	}

        public Swarm[] getSwarm(){
            return swarms;
        }
        

        
	public void mainLoop(int maxim,int costWebA, int costWebB,int costWebC,int costWebD,int costWebE,int costWebF, int[] viewsArray) {
               
		for (Swarm swarm : swarms) {
			for (Particle particle : swarm.getParticles()) {

				long[] particleOldPosition = particle.getPosition().clone();

				// Calculate the particle fitness.
				particle.setFitness(fitnessFunction.getFitness(particleOldPosition,maxim,costWebA,costWebB,costWebC,costWebD,costWebE,costWebF,viewsArray));

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
				long[] position = particle.getPosition();
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
                                
                                if(count%100000==0)
                                {
                                    System.out.println(count);
                                }
                                     
                                for(int uu=0;uu<position.length;uu++)
                                {
                                    positionFixed[uu]=position[uu];
                                    if(positionFixed[uu]<0)
                                        positionFixed[uu]=0;
                                    
                                }
                                
                                   ff= (positionFixed[0] * costWebA) + (positionFixed[1] * costWebB)+(positionFixed[2]*costWebC)+(positionFixed[3]*costWebD)+(positionFixed[4]*costWebE)+(positionFixed[5]*costWebF);
                                   views = (positionFixed[0] * viewsArray[0]) + (positionFixed[1] * viewsArray[1])+(positionFixed[2]*viewsArray[2])+(positionFixed[3]*viewsArray[3])+(positionFixed[4]*viewsArray[4])+(positionFixed[5]*viewsArray[5]);
                                   if((maxim-ff)<(maxim-outff) && (maxim-ff)>=0 )
                                    {
                                       if(outViews<views)
                                       {
                                       outViews=views;
                                       outff=ff;
                                       output[0]=positionFixed[0];
                                       output[1]=positionFixed[1];
                                       output[2]=positionFixed[2];
                                       output[3]=positionFixed[3];
                                       output[4]=positionFixed[4];
                                       output[5]=positionFixed[5];
                                       
                                       System.out.println("XX"+count +"out"+outff+"  "+output[0]+","+output[1]+","+output[2]+","+output[3]+","+output[4]+","+output[5]);
                                       }
                                   }
                                  series.add(count,ff);
                                  series1.add(maxim,views);
                               if(count==((((swarms.length*swarms[0].getParticles().length*1000)/4))*0.75)-1)
                               {
                                   
                                   if(outViews<0 || outff<0)
                                   {
                                       JOptionPane.showMessageDialog(null,"Try again with more number of swamrs");
                                   }
                                   
                                   else
                                   {
                                       
                                       
                                        if(costWebA==0 && viewsArray[0]==0){
                                            output[0]=0;
           }
                                        if(costWebB==0 && viewsArray[1]==0){
                                            output[1]=0;
           }
                                        if(costWebC==0 && viewsArray[2]==0){
                                            output[2]=0;
           }
                                        if(costWebD==0 && viewsArray[3]==0){
                                            output[3]=0;
           }
                                        if(costWebE==0 && viewsArray[4]==0){
                                            output[4]=0;
           }
                                        if(costWebF==0 && viewsArray[5]==0){
                                            output[5]=0;
           }
                                       
                                       
                                       
                                  try{
                                  JOptionPane.showMessageDialog(null,"The max no of views are(try)"+outViews+"within the budget of"+outff+"having ads  "+output[0]+","+output[1]+","+output[2]+","+output[3]+","+output[4]+","+output[5]);
                                  }
                                  catch(Exception e)
                                  {
                                      JOptionPane.showMessageDialog(null,"The max no of views are(catch)"+outViews+"within the budget of "+outff+"having ads  "+positionFixed[0]+","+positionFixed[1]+","+positionFixed[2]+","+positionFixed[3]+","+positionFixed[4]+","+positionFixed[5]);
                                  
                                      System.out.println(positionFixed[0]+","+positionFixed[1]+","+positionFixed[2]+","+positionFixed[3]+","+positionFixed[4]+","+positionFixed[5]);
                                  }
                                  dataset.addSeries(series);
                                  dataset1.addSeries(series1);
                                   Chart chart = new Chart(
                                   "Cost VS No of Iterations" ,
                                   "Cost VS No of Iterations", dataset);
                                   chart.pack( );
                              
                                   chart.setVisible( true ); 
                                   Chart chart1 = new Chart(
                                   "No of Views VS Cost" ,
                                   "No of Views  VS Cost", dataset1);
                                   chart1.pack( );
                              
                                   chart1.setVisible( true ); 
                                   break;
                                   }
                                  
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

}
