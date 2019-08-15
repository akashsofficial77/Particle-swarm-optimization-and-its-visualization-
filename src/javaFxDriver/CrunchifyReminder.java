/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFxDriver;

import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Aditya
 */
       public  class CrunchifyReminder extends TimerTask {
           int maxim;
           int flag;
           PopulationManager popMgr;
           Timer timer;
           
           static int cnt = 0;
             static int cnt1 = 0;
         public  CrunchifyReminder(int maxim, PopulationManager pogMgr, Timer timer)
           {
               this.maxim=maxim;
               this.popMgr=pogMgr;
               this.timer = timer;
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
                              //  cnt1++;
                            //   if(cnt1==300) break;
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
    
        cnt++;
    System.out.println("swarm movement loop with count = "+cnt+"***************************");
    
    if (cnt == 5){
        System.out.println("******************************************* Stopping the timer **********************************");
        timer.cancel();
          
    }
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