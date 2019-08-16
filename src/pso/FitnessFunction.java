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

		long adA = particlePosition[0];
		long adB = particlePosition[1];
		long adC=particlePosition[2];
                long adD=particlePosition[3];
                long adE=particlePosition[4];
                long adF=particlePosition[5];
               
		// No negatives values accepted.
		if (adA < 0 && adB < 0 && adC<0 && adD<0 && adE<0 && adF<0) {
			return -(adC*adA*adB*adD*adE*adF);
		}
                else if(adA < 0 && adB < 0 && adC<0){
                    return (adC*adA*adB);
                }
                else if(adA < 0 && adB < 0 && adD<0){
                    return (adA*adB*adD);
                }else if (adA < 0 && adB < 0 && adE<0){
                    return (adA*adB*adE);
                }else if(adA < 0 && adB < 0 && adF<0){
                     return (adA*adB*adF);
                }else if(adA < 0 && adC<0 && adD<0){
                    return(adA*adC*adD);
                }else if(adA < 0 && adC<0 && adE<0){
                    return(adA*adC*adE);
                }else if(adA < 0 && adC<0 && adF<0){
                    return(adA*adC*adF);
                }else if(adA < 0 && adD<0 && adE<0){
                    return(adA*adD*adE);
                }else if(adA < 0 && adD<0 && adF<0){
                    return(adA*adD*adF);
                }else if(adA<0 && adE<0 && adF<0){
                    return(adA*adE*adF);
                }
                else if(adB < 0 && adC<0 && adD<0){
                    return(adB*adC*adD);
                }else if( adB < 0 && adC<0 && adE<0){
                    return(adB*adC*adE);
                }else if(adB < 0 && adC<0 && adF<0){
                    return(adB*adC*adF);
                }else if (adB < 0 && adD<0 && adE<0){
                    return(adB*adD*adE);
                }else if(adB < 0 && adD<0 && adF<0){
                    return(adB*adD*adF);
                }else if(adB < 0 && adE<0 && adF<0){
                    return(adB*adE*adF);
                }else if( adC<0 && adD<0 && adE<0){
                    return(adC*adD*adE);
                }else if(adC<0 && adD<0 && adF<0){
                     return(adC*adD*adF);
                }else if(adC<0 && adE<0 && adF<0){
                     return(adC*adE*adF);
                }
                else if (adA < 0 && adC<0) {
			return -(adA*adC);
		}else if(adA < 0 && adD<0){
                    return -(adA*adD);
                }else if(adA < 0 && adE<0){
                    return -(adA*adE);
                }else if(adA < 0 && adF<0){
                    return -(adA*adF);
                }else if(adB < 0 && adD<0){
                    return -(adB*adD);
                }else if(adB < 0 && adE<0){
                     return -(adB*adE);
                }else if(adB < 0 && adF<0){
                     return -(adB*adF);
                }else if(adC<0 && adD<0){
                    return -(adC*adD);
                }else if(adC<0 && adE<0){
                    return -(adC*adE);
                }else if(adC<0 && adF<0){
                    return -(adC*adF);
                }else if(adD<0 && adE<0){
                    return -(adD*adE);
                }else if(adD<0 && adF<0){
                    return -(adD*adF);
                }else if(adE<0 && adF<0){
                    return -(adE*adF);
                }
                else if (adB < 0 && adC<0) {
			return -(adB*adC);
		} else if (adA < 0 && adB<0) {
			return -(adA*adB);
		} else if (adA < 0 ) {
			return adA;
		} else if (adB<0) {
			return adB;
		} else if (adC<0) {
			return adC;
		} else if(adD<0){
                    return adD;
                }else if(adE<0){
                    return adE;
                }else if(adF<0){
                    return adF;
                }

		
		double cost = (adA * costWebA) + (adB * costWebB)+(adC*costWebC)+(adD*costWebD)+(adE*costWebE)+(adF*costWebF);
        if (cost > maxim) {
            return maxim - cost;
        } else {
        
            long fitness = adA*viewsArray[0]+adB*viewsArray[1]+adC*viewsArray[2]+(adD*viewsArray[3])+(adE*viewsArray[4])+(adF*viewsArray[5]);
            return fitness;
        }
	}

}