package javaFxDriver;

import java.util.ArrayList;

import javafx.scene.Node;
import pso.FitnessFunction;
import javaFxDriver.PsoConfigOptions;
import pso.MultiSwarm;
import pso.Swarm;

/*
 * Parent class for population drivers
 */
public abstract class PopulationDriver {
	
	protected FitnessFunction fitnessFunction;
	protected ArrayList<PsoConfigOptions> opts = new ArrayList<PsoConfigOptions>();
	protected ArrayList<Swarm> populations = new ArrayList<Swarm>();
        protected int numDimensions = 0; //Number of dimensions to represent
	protected double[] paramMult;	 //individual parameter multipliers
	protected String[] paramList;	 //parameter labels
	protected int numPopulations;	 //number of populations
	protected int width = 900;
	protected int height = 675;
	
	public PopulationDriver (int[] searchSpaceDimensions, int[] initGoal, int numPopulations, int[] popSizes) {
		this.numPopulations = numPopulations;
	}
	
	protected double getColor (double d, int size) {
		if (d < 0) return 0;
		if (d > size) return 1;
		return d / (size * 1.0);
	}
	
	public PsoConfigOptions getOptions (int index) {
		if (index < 0 || index >= this.opts.size()) {
			System.out.println("PopulationDriver.getOptions indexOutOfBounds");
			return null;
		}
		return this.opts.get(index);
	}
	
	public int getNumDims () {
		return this.numDimensions;
	}
	
	public void setParamMult (int index, double val) {
		if (index < 0 || index >= this.paramMult.length) {
			System.out.println("PopulationDriver.setParamMult indexOutOfBounds");
			return;
		}
		this.paramMult[index] = val;
		System.out.println("param index: " + index + ", val: " + this.paramMult[index]);
	}
	
	public Swarm getPopulation (int index) {
		if (index < 0 || index >= this.populations.size()) {
			System.out.println("PopulationDriver.getPopulation indexOutOfBounds");
			return null;
		}
		return this.populations.get(index);
	}
	
	public String getParamLabel (int index) {
		if (index < 0 || index >= this.paramList.length) {
			System.out.println("PopulationDriver.getParamLabel indexOutOfBounds");
			return null;
		}
		return this.paramList[index];
	}
	
	public abstract void setFullscreen (boolean isFullscreen, double w, double h);
	
	
	public abstract Node getUiNode ();
	
	public  abstract void update (float elapsedTime, int flag,int maxim,int costWebA, int costWebB,int costWebC,int costWebD,int costWebE,int costWebF, int[] viewsArray);
        
       // public abstract MultiSwarm getMultiSwarm();
	
}
