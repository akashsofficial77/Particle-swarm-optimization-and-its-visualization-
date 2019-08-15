package javaFxDriver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Platform;

import pso.LolFitnessFunction;
import pso.Particle;
import pso.Swarm;
import pso.MultiSwarm;
//import src.pso.Position;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SubScene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.SceneAntialiasing;
import javax.swing.Timer;

public class Basic3dDriver extends PopulationDriver {
         int sColor=1;
	private Group root = new Group();
	private Group boundryGroup = new Group();
	private Xform world = new Xform();
	private PerspectiveCamera camera = new PerspectiveCamera(true);
	private Xform cameraXform = new Xform();
	private Xform cameraXform2 = new Xform();
	private Xform cameraXform3 = new Xform();
	private double cameraDistance = 2500;

	private Xform particleGroup = new Xform();
	private ArrayList<Cube> particles = new ArrayList<Cube>();
	private int size = 500;
	private int halfSize = size;

	private SubScene scene;
	private Cube goalCube = new Cube(20, 20, 20);
	private int particleSize = 70;
	
	private double mousePosX;
	private double mousePosY;
	private double mouseOldX;
	private double mouseOldY;
	private double mouseDeltaX;
	private double mouseDeltaY;
        private int noSwarms;
        private int noParticles;
        private double inertiaFactor;
        private double cw;
        private double sw;
        private double gw;
	private LolFitnessFunction fitnessFunction = new LolFitnessFunction();
         MultiSwarm multiswarm;
        private Swarm[] ss;
	
	public Basic3dDriver(int[] searchSpaceDimensions, int[] initGoal, int numPopulations, int[] popSizes, int noSwarms, int noParticle,double inertiaFactor, double cw, double sw, double gw) {
		super(searchSpaceDimensions, initGoal, numPopulations, popSizes);
                this.noSwarms = noSwarms;
                this.noParticles = noParticles;
                this.inertiaFactor=inertiaFactor;
                this.cw=cw;
                this.sw=sw;
                this.gw=gw;
	        multiswarm = new MultiSwarm(noSwarms, noParticle, new LolFitnessFunction(),inertiaFactor,cw,sw,gw);
		//---swarm setup---//
		this.paramList = new String[]{"X", "Y", "Z", "Red", "Green", "Blue", "Alpha", "Beta", "Gamma"};
		this.numDimensions = 9; //TODO: Set dynamically
		this.paramMult = new double[this.numDimensions];
		Arrays.fill(this.paramMult, 1);
		ss= multiswarm.getSwarm();
                root.getChildren().add(world);
                this.buildCamera();
                this.buildParticles();  
                this.scene = new SubScene(root, width, height, true, SceneAntialiasing.BALANCED);
		this.scene.setFill(Color.color(0.85, 0.85, 1.0));
		this.scene.setCamera(camera);
       
		
		
	}
    
        public MultiSwarm getMultiSwarm(){
            return multiswarm;
        }

	private void buildCamera() {
		root.getChildren().add(cameraXform);
		cameraXform.getChildren().add(cameraXform2);
		cameraXform2.getChildren().add(cameraXform3);
		cameraXform3.getChildren().add(camera);
		cameraXform3.setRotateZ(180.0);
                camera.setNearClip(0.1);
		camera.setFarClip(10000.0);
		camera.setTranslateZ(-cameraDistance);
		cameraXform.ry.setAngle(320.0);
	}

	//---BUILDS CUBE SKELETON FOR VISUAL SPATIAL REFERENCE---//


	private void buildParticles () {
		for (Swarm p : ss) {
                   
            
			for (Particle particle : p.getParticles()) {
                  
				Color color = Color.color(
					1,
					 1,
					1
				);
				Cube box = new Cube(this.particleSize, this.particleSize, this.particleSize, color, color);
				box.translate(
					 particle.getPosition2()[0],
					 particle.getPosition2()[1],
					 particle.getPosition2()[2]
				);
				particles.add(box);
			}
                             sColor++;
		}
           
	
		for (Cube particle : particles) {
			this.particleGroup.getChildren().addAll(particle.getBox());
		}
		this.world.getChildren().addAll(this.particleGroup);

        }

	private int getPosNeg () {
		return (Math.random() < 0.5) ? 1 : -1;
	}

	@Override
	public void update (float elapsedTime,int flag, int maxim,int costWebA, int costWebB,int costWebC,int costWebD,int costWebE,int costWebF, int[] viewsArray) {
               //int totParticleCnt = 0;
             //  System.out.println("update method called");
                if(flag!=0){
			multiswarm.mainLoop(maxim,costWebA,costWebB,costWebC,costWebD,costWebE,costWebF,viewsArray);
                        } 
                else{
                    int totParticleCnt = 0;
		for (Swarm p : ss) {
    
                     for (int i = totParticleCnt; i < totParticleCnt + p.getParticles().length; i++) {
                         try{
				Particle particle = p.getParticles()[(i - totParticleCnt)];
				Cube cube = particles.get(i);
				//int[] position = particle.getPosition().getVector();
				//---SET POSITION---//
                             //   Platform.runLater(() -> {
                               
				cube.translate(particle.getPosition()[0], particle.getPosition()[1], particle.getPosition()[2]);
				//---SET COLOR---//
                             //   }  );
                         }catch(Exception e){
                             System.out.println(" Some issue in Java FX thread********************************************************************** ");
                           
                         }
			}   
                        
                        totParticleCnt += p.getParticles().length;
                        
                         
                        }
			
			
		}
        }
		
	

	
	@Override
	public Node getUiNode () {
		return this.scene;
	}
	
	public void setFullscreen (boolean isFullscreen, double w, double h) {
		if (isFullscreen) {
			this.scene.setWidth(w);
			this.scene.setHeight(h);
		}
		else {
			this.scene.setWidth(width);
			this.scene.setHeight(height);
		}
	}
	
	public String toString () {
		return "basic3D";
	}
	
}
