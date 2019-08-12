/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication16;

/**
 *
 * @author Aditya
 */
public class LolFitnessFunction implements FitnessFunction {


	@Override
	public double getFitness(long[] particlePosition) {

		long health = particlePosition[0];
		long armor = particlePosition[1];
		long x=particlePosition[2];
                long x1=particlePosition[3];
                long x2=particlePosition[4];
                long x3=particlePosition[5];
                //long x3=particlePosition[2];
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

		
		double cost = (health * 10) + (armor * 10)+(x*10)+(x1*10)+(x2*10)+(x3*10);
        if (cost > 10000) {
            return 10000 - cost;
        } else {
        
            long fitness = health*500+armor*500+x*500+(x1*500)+(x2*500)+(x3*500);
            return fitness;
        }
	}

}