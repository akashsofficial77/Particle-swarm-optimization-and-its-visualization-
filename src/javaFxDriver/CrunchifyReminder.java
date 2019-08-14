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
           int flag;
           PopulationManager popMgr;
         public  CrunchifyReminder(int maxim, PopulationManager pogMgr)
           {
               this.maxim=maxim;
               this.popMgr=pogMgr;
               t2.start();
           }
		//int loop=0;
              //  private PopulationManager popMngr = new PopulationManager();

/*
                 Thread t1 = new Thread(){
                      public void run(){
                          
                          while(true){
                          //toolkit.beep();
                         
                        }
                      }
                      
                  };
*/
                                Thread t2 = new Thread(){
                                public void run(){
                                while(true){
				//toolkit.beep();
                                
                               // System.out.println("cube movement loop");
				float elapsedTime = 0;
                                flag=0;
                                popMgr.update(elapsedTime, flag, maxim);
				//loop++;
			}           
     }
 };

@Override    
// run method of timer task
public void run() {
    
    
    //System.out.println("swarm movement loop");
                          float elapsedTime = 0;
                          //if (loop>=0){
                          flag=1;
                          popMgr.update(elapsedTime,flag,maxim);
                          //loop--;
                         // }
                         // else{
                           // loop=0;  
                         // }
                         
    
    
}
       }