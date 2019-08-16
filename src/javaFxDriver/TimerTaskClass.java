/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFxDriver;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author Aditya
 */
public  class TimerTaskClass extends TimerTask {
    int maxim;
    int flag;
    PopulationManager popMgr;
    Timer timer;
    public int costWebA;
    public int costWebB;
    public int costWebC;
    public int costWebD;
    public int costWebE;
    public int costWebF;
     int[] viewsArray = new int[6];
           
           static int cnt = 0;
             static int cnt1 = 0;
         public  TimerTaskClass(int maxim,   PopulationManager pogMgr, Timer timer,int costWebA, int costWebB,int costWebC,int costWebD,int costWebE,int costWebF,int[] viewsArray)
           {
               this.maxim=maxim;
               this.popMgr=pogMgr;
               this.timer = timer;
               t2.start();
               this.costWebA=costWebA;
               this.costWebB=costWebB;
               this.costWebC=costWebC;
               this.costWebD=costWebD;
               this.costWebE=costWebE;
               this.costWebF=costWebF;
               this.viewsArray=viewsArray;
           }

            Thread t2 = new Thread(){
                    public void run(){
                        try{
                        while(true){
                            t2.sleep(100);
		            float elapsedTime = 0;
                            flag=0;
                            popMgr.update(elapsedTime, flag, maxim,costWebA,costWebB,costWebC,costWebD,costWebE,costWebF,viewsArray);
		           
	                }  
                        }catch(Exception e){
                            System.out.println("exception in javafx");
                        }
                    }
 };

@Override    
// run method of timer task
public void run() {
    cnt++;
    if (cnt == 1000){
        System.out.println("******************************************* Stopping the timer **********************************");
        timer.cancel();
         }
    float elapsedTime = 0;
    flag=1;
    popMgr.update(elapsedTime,flag,maxim,costWebA,costWebB,costWebC,costWebD,costWebE,costWebF,viewsArray); 
         }
    }