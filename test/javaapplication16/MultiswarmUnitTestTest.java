/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication16;

import javaapplication16.LolFitnessFunction;
import javaapplication16.LolFitnessFunction;
import javaapplication16.MultiSwarm;
import javaapplication16.MultiSwarm;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Aditya
 */
public class MultiswarmUnitTestTest {
    
    public MultiswarmUnitTestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of givenMultiswarm_whenThousandIteration_thenSolutionFound method, of class MultiswarmUnitTest.
     */
    
  	public void runSwarm() {
		MultiSwarm multiswarm = new MultiSwarm(50, 1000, new LolFitnessFunction());

		// Iterates 1000 times through the main loop and prints the result.
		for (int i = 0; i < 1000; i++) {
			multiswarm.mainLoop();
		}

		System.out.println("Best fitness found: " + multiswarm.getBestFitness() + "[" + multiswarm.getBestPosition()[0]
				+ "," + multiswarm.getBestPosition()[1] + "]");
		
	}
    
}
