/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFxDriver;

import java.util.TimerTask;

/**
 *
 * @author Aditya
 */
       public  class CrunchifyReminder extends TimerTask {
           int maxim;
           PopulationManager popMgr;
           CrunchifyReminder(int maxim, PopulationManager pogMgr)
           {
               this.maxim=maxim;
               this.popMgr=pogMgr;
               t2.start();
           }
		int loop=0;
              //  private PopulationManager popMngr = new PopulationManager();


                 Thread t1 = new Thread(){
                      public void run(){
                          
                          while(true){
                          //toolkit.beep();
                          System.out.println("swarm movement loop");
                          float elapsedTime = 0;
                          if (loop>=0){
                          popMgr.update(elapsedTime,loop,maxim);
                          loop--;
                          }
                          else{
                            loop=0;  
                          }
                         
                        }
                      }
                      
                  };

                                Thread t2 = new Thread(){
                                public void run(){
                                while(true){
				//toolkit.beep();
                                
                                System.out.println("cube movement loop");
				float elapsedTime = 0;
                                loop=-1;
                                popMgr.update(elapsedTime,loop, maxim);
				//loop++;
			}           
     }
 };

@Override    
// run method of timer task
public void run() {
    
    
   int loop=0;
       System.out.println("swarm movement loop");
                          float elapsedTime = 0;
                          if (loop>=0){
                          popMgr.update(elapsedTime,loop,maxim);
                          loop--;
                          }
                          else{
                            loop=0;  
                          }
    
    
}
       }