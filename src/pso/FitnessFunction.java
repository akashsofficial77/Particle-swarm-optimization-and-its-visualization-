/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso;

/**
 *
 * @author Aditya
 */
public class FitnessFunction implements FitnessFunctionInterface {


	@Override
	public double getFitness(long[] particlePosition,int maxim,int costWebA, int costWebB,int costWebC,int costWebD,int costWebE,int costWebF, int[] viewsArray) {

		long health = particlePosition[0];
		long armor = particlePosition[1];
		long x=particlePosition[2];
                long x1=particlePosition[3];
                long x2=particlePosition[4];
                long x3=particlePosition[5];
               
		// No negatives values accepted.
		if (health < 0 && armor < 0 && x<0 && x1<0 && x2<0 && x3<0) {
			return -(x*health*armor*x1*x2*x3);
		}
                else if(health < 0 && armor < 0 && x<0){
                    return (x*health*armor);
                }
                else if(health < 0 && armor < 0 && x1<0){
                    return (health*armor*x1);
                }else if (health < 0 && armor < 0 && x2<0){
                    return (health*armor*x2);
                }else if(health < 0 && armor < 0 && x3<0){
                     return (health*armor*x3);
                }else if(health < 0 && x<0 && x1<0){
                    return(health*x*x1);
                }else if(health < 0 && x<0 && x2<0){
                    return(health*x*x2);
                }else if(health < 0 && x<0 && x3<0){
                    return(health*x*x3);
                }else if(health < 0 && x1<0 && x2<0){
                    return(health*x1*x2);
                }else if(health < 0 && x1<0 && x3<0){
                    return(health*x1*x3);
                }else if(health<0 && x2<0 && x3<0){
                    return(health*x2*x3);
                }
                else if(armor < 0 && x<0 && x1<0){
                    return(armor*x*x1);
                }else if( armor < 0 && x<0 && x2<0){
                    return(armor*x*x2);
                }else if(armor < 0 && x<0 && x3<0){
                    return(armor*x*x3);
                }else if (armor < 0 && x1<0 && x2<0){
                    return(armor*x1*x2);
                }else if(armor < 0 && x1<0 && x3<0){
                    return(armor*x1*x3);
                }else if(armor < 0 && x2<0 && x3<0){
                    return(armor*x2*x3);
                }else if( x<0 && x1<0 && x2<0){
                    return(x*x1*x2);
                }else if(x<0 && x1<0 && x3<0){
                     return(x*x1*x3);
                }else if(x<0 && x2<0 && x3<0){
                     return(x*x2*x3);
                }
                else if (health < 0 && x<0) {
			return -(health*x);
		}else if(health < 0 && x1<0){
                    return -(health*x1);
                }else if(health < 0 && x2<0){
                    return -(health*x2);
                }else if(health < 0 && x3<0){
                    return -(health*x3);
                }else if(armor < 0 && x1<0){
                    return -(armor*x1);
                }else if(armor < 0 && x2<0){
                     return -(armor*x2);
                }else if(armor < 0 && x3<0){
                     return -(armor*x3);
                }else if(x<0 && x1<0){
                    return -(x*x1);
                }else if(x<0 && x2<0){
                    return -(x*x2);
                }else if(x<0 && x3<0){
                    return -(x*x3);
                }else if(x1<0 && x2<0){
                    return -(x1*x2);
                }else if(x1<0 && x3<0){
                    return -(x1*x3);
                }else if(x2<0 && x3<0){
                    return -(x2*x3);
                }
                else if (armor < 0 && x<0) {
			return -(armor*x);
		} else if (health < 0 && armor<0) {
			return -(health*armor);
		} else if (health < 0 ) {
			return (health);
		} else if (armor<0) {
			return armor;
		} else if (x<0) {
			return x;
		} else if(x1<0){
                    return x1;
                }else if(x2<0){
                    return x2;
                }else if(x3<0){
                    return x3;
                }

		
		double cost = (health * costWebA) + (armor * costWebB)+(x*costWebC)+(x1*costWebD)+(x2*costWebE)+(x3*costWebF);
        if (cost > maxim) {
            return maxim - cost;
        } else {
        
            long fitness = health*viewsArray[0]+armor*viewsArray[1]+x*viewsArray[2]+(x1*viewsArray[3])+(x2*viewsArray[4])+(x3*viewsArray[5]);
            return fitness;
        }
	}

}