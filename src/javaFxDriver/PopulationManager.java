package javaFxDriver;

import java.util.HashMap;

/*
 * PopulationManager manages and abstract the communication
 * between the UI and the population drivers
 */
public class PopulationManager {
	
	private HashMap<String, PopulationDriver> drivers = new HashMap<String, PopulationDriver>();
	private PopulationDriver activeDriver = null;
	
	public PopulationManager () {}
	
	public void addDriver (String name, PopulationDriver driver) {
		this.drivers.put(name, driver);
	}
	
	public void setActiveDriver (String name) {
		this.activeDriver = this.drivers.get(name);
	}
	
	public PopulationDriver getActiveDriver () {
		return this.activeDriver;
	}
	
	public  void update (float elapsedTime, int flag,int maxim,int costWebA, int costWebB,int costWebC,int costWebD,int costWebE,int costWebF,int[] viewsArray) {
		if (this.activeDriver == null) return;
		this.activeDriver.update(elapsedTime,flag, maxim,costWebA,costWebB,costWebC,costWebD,costWebE,costWebF,viewsArray);
	}
	
	public void setC1 (int popIndex, float val) {
		if (this.activeDriver == null) return;
		this.activeDriver.getOptions(popIndex).c1 = val;
	}
	
	public void setC2 (int popIndex, float val) {
		if (this.activeDriver == null) return;
		this.activeDriver.getOptions(popIndex).c2 = val;
	}
	
	public void setSpeedLimit (int popIndex, float val) {
		if (this.activeDriver == null) return;
		this.activeDriver.getOptions(popIndex).speedLimit = val;
	}
	
	public void clearPopulations () {
		this.drivers.clear();
	}
	
	public void setFullscreen (boolean isFullscreen, double w, double h) {
		this.activeDriver.setFullscreen(isFullscreen, w, h);
	}

}
