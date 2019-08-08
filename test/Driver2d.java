/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication16;

import javaapplication16.PsoConfigOptions;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javaapplication16.LolFitnessFunction;

import javax.swing.JPanel;
import javax.swing.Timer;



import javaapplication16.Particle;
import javaapplication16.Swarm;
import javaapplication16.MultiSwarm;
import javaapplication16.Constants;


public class Driver2d extends JPanel {

	private MultiSwarm ms;
        private Swarm p;
	private Timer timer;
	private int animationStepTime = 33;
	//private IFitness fitnessFunction = new FitnessDistance(255, 255);
	private LolFitnessFunction fitnessFunction = new LolFitnessFunction();
	private int iterationCnt = 0;
	//private int convergenceThresh = 50;
        private PsoConfigOptions c;
	private int goalRadius = 10;
	private int numDimensions;
	MultiSwarm multiswarm = new MultiSwarm(1, 1000, new LolFitnessFunction());
	public Driver2d (int width, int height, PsoConfigOptions c) {
		//this.addMouseListener(this);
		this.setBackground(new Color(255, 255, 255));
		this.c = c;
                p = multiswarm.getSwarm();
		//Position size = new Position(new int[]{width, height});
		//this.p = new Population(, populationSize, fitnessFunction, c);
		//this.c.PARTICLE_UPPER_BOUND = p;
		this.timer = new Timer(animationStepTime, new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	    		iterate();
	        }
	    });
	}
	
	public void start () {
		this.timer.start();
	}
	
	private void iterate () {
		this.iterationCnt++;
		

		// Iterates 1000 times through the main loop and prints the result.
		
			multiswarm.mainLoop();
		
		repaint();
	}
	
	
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		//render goal
		g2d.setColor(new Color(50, 200, 50));
		
		g2d.setColor(new Color(50, 50, 50));
		g2d.setStroke(new BasicStroke(2));
		for (Particle particle : p.getParticles()) {
                    int healthPos = (int) particle.getPosition()[0];
                    //healthPos= Math.abs(healthPos/1000);
                    int armourPos = (int) particle.getPosition()[1];
                    System.out.println(healthPos+"h");
                    //armourPos= Math.abs(armourPos/1000);
                    System.out.println(armourPos+"p");
			g.fillOval(
                    healthPos, armourPos,
                    3,3
            );
                        healthPos = 0;
                        armourPos = 0;
		}
	}

	
}

