package javaapplication16;
import java.awt.Dimension;
import pso.Constants;
import pso.MultiSwarm;


import javax.swing.JFrame;

//import pso.PsoConfigOptions;



public class Init2D {

	public static void main (String[] args) {
                //MultiswarmUnitTestTest testRun = new MultiswarmUnitTestTest();
                //testRun.runSwarm();
		int w = 5000000;
		int h = 5000000;
                int wM = -500000;
                int hM = -500000;
		Constants c = new Constants();
		PsoConfigOptions options = new PsoConfigOptions();
		options.c1 = 0.1f;
		options.c2 = 0.0001f;
		options.speedLimit = 10.0f;
		
		//UiControls2D c = new UiControls2D(options);
		Driver2d swarmDriver = new Driver2d(w, h, options);
		
		JFrame imgFrame = new JFrame();
		imgFrame.add(swarmDriver);
		imgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		imgFrame.setSize(w, h);
		swarmDriver.setMinimumSize(new Dimension(wM,hM));
		swarmDriver.setPreferredSize(new Dimension(5000000, 5000000));
		imgFrame.pack();
		imgFrame.setLocation(440, 10);
		imgFrame.setVisible(true);
		
		swarmDriver.start();
	}
	
}
