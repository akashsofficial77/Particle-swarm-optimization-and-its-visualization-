/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import javaFxDriver.Basic3dDriver;
import javaFxDriver.CrunchifyReminder;
import javaFxDriver.MainControllerPane;
import javaFxDriver.PopulationDriver;
import javaFxDriver.PopulationManager;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Aditya
 */
public class FXMLDocumentController  implements Initializable {
    
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TextField txtField;
    
    int  noSwarm;
    int noParticle;
      int maxim=5000;
	private long lastTime;
	private BorderPane mainBorderPane = new BorderPane();
	private BorderPane activeGraphicsPane = new BorderPane();
	private PopulationManager popMngr = new PopulationManager();
        Basic3dDriver basic2D;
	private boolean isFullscreen = false;
        Toolkit toolkit;
	Timer timer;
        private int noSwarms;
        private int noParticles;
        private int timerDelay;
          private double cw;
       private double sw;
       private double gw;
       private double inertiaFactor;
  

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
        noSwarms = Integer.valueOf(txtField.getText());
        int noParticles = 1;
        double inertiaFactor = 0.79;
        double cw = 0.3;
        double sw= 0.01;
        double gw = 0.9;
        Group root = new Group();
        Stage stage = new Stage();
        Scene scene = new Scene(root, 1154, 680, Color.WHITE);
		stage.setScene(scene);
		stage.setTitle("Particle Swarm Optimization Visualization");
       int[] searchSpace = new int[]{900, 675, 255, 255, 255};
		int[] initGoal = new int[]{255, 255, 255, 255, 255};
		PopulationDriver basic2D = new Basic3dDriver(searchSpace, initGoal, -1, new int[100],noSwarms,noParticles,inertiaFactor,cw,sw,gw);
                
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
                
                  this.lastTime = System.nanoTime();
                  toolkit = Toolkit.getDefaultToolkit();
		 timer = new Timer();
                 System.out.println("********************************************called once");
	        timer.schedule(new CrunchifyReminder(maxim,popMngr), 0, // initial delay
				100);
             //   MainControllerPane mpc = new MainControllerPane(this.popMngr, timer, this.activeGraphicsPane);
		
	//	mainBorderPane.setLeft(mpc.getPane());
		mainBorderPane.setCenter(this.activeGraphicsPane);
		scene.setRoot(mainBorderPane);
		stage.show();
                
    }
    
    
    
    
}
