/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.awt.Toolkit;
import java.util.Timer;
import javaFxDriver.Basic3dDriver;
import javaFxDriver.CrunchifyReminder;
import javaFxDriver.MainControllerPane;
import javaFxDriver.PopulationDriver;
import javaFxDriver.PopulationManager;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Aditya
 */
public class JavaFXApplication4 extends Application {
    
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
	private void buildMainPane () {
		
	}
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene1 = new Scene(root1);
        
        stage.setScene(scene1);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
   