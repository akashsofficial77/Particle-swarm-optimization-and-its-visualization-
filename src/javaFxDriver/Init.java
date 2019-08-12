package javaFxDriver;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import pso.MultiSwarm;


public class Init extends Application {
	
    
        int maxim=5000;
	private long lastTime;
	private BorderPane mainBorderPane = new BorderPane();
	private BorderPane activeGraphicsPane = new BorderPane();
	private PopulationManager popMngr = new PopulationManager();
        Basic3dDriver basic2D;
	private boolean isFullscreen = false;
        Toolkit toolkit;
	Timer timer;
	private void buildMainPane () {
		
	}
	
	@Override
	public void start (Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root, 1154, 680, Color.WHITE);
		stage.setScene(scene);
		stage.setTitle("Particle Swarm Optimization Visualization");
		
		//---BUILD POPULATION DRIVERS---//
		/*
		 * Right now the graphics pane needs a live populationManager
		 * uiPane ... need to refactor
		 */
		int[] searchSpace = new int[]{900, 675, 255, 255, 255};
		int[] initGoal = new int[]{255, 255, 255, 255, 255};
		PopulationDriver basic2D = new Basic3dDriver(searchSpace, initGoal, -1, new int[100]);
                
		this.popMngr.addDriver("basic2D", basic2D);
		this.popMngr.setActiveDriver("basic2D");
		
		//---SET MAIN GRAPHICS PANE---//
		this.activeGraphicsPane.setCenter(this.popMngr.getActiveDriver().getUiNode());
		this.activeGraphicsPane.setStyle("" +
			"-fx-background-color: #ffffff;" +
			"-fx-border-color: #333333;" + 
			"-fx-border-width: 2px;" +
			"-fx-border-radius: 4px;"
		);

		//---CREATE TIMER AND START---//
                this.lastTime = System.nanoTime();
                  toolkit = Toolkit.getDefaultToolkit();
		 timer = new Timer();
                 System.out.println("********************************************called once");
	        timer.schedule(new CrunchifyReminder(maxim,popMngr), 0, // initial delay
				50);
            //     timer.schedule(new CrunchifyReminder2(), 500, // initial delay
		//		1 * 500);// subsequent rate
		AnimationTimer timer = new AnimationTimer() {
			public void handle(long now) {
				float elapsedTime = (float) ((now - lastTime) / 1000000.0);
				lastTime = now;
				//popMngr.update(elapsedTime,0,maxim);
			}
		};
		
		//---FINISH BUILDING UI---//
		//---CONTROLLER PANEL ON THE LEFT---//
		MainControllerPane mpc = new MainControllerPane(this.popMngr, timer, this.activeGraphicsPane);
		
		mainBorderPane.setLeft(mpc.getPane());
		mainBorderPane.setCenter(this.activeGraphicsPane);
		scene.setRoot(mainBorderPane);
		stage.show();
		
		//---KEY LISTENERS---//
		scene.setOnKeyPressed((KeyEvent e) -> {
			//---FULLSCREEN: F / ESC---//
			if (e.getCode() == KeyCode.F) {
				isFullscreen = !isFullscreen;
				stage.setFullScreen(isFullscreen);
				popMngr.setFullscreen(isFullscreen, stage.getWidth(), stage.getHeight());
				VBox vb = new VBox();
				if (isFullscreen) {
					vb.getChildren().add(popMngr.getActiveDriver().getUiNode());
				}
				else {
					//mpc.rebuildPane();
					vb.getChildren().add(mainBorderPane);
				}
				scene.setRoot(vb);
			}	
		});
                
            
		
	}
        

           

	public static void main (String[] args) {
		launch(args);
	}

}