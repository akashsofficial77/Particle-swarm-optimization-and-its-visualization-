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
    private TextField txtField;
    
    int  noSwarm;
    int noParticle;
      int maxim;
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
    @FXML
    private TextField noSwarmTextField;
    @FXML
    private TextField noParticleTextField;
    @FXML
    private TextField budgetTextField;
    @FXML
    private TextField costCTxtField;
    @FXML
    private TextField costBTxtField;
    @FXML
    private TextField costDTxtField;
    @FXML
    private TextField costETxtField;
    @FXML
    private TextField costATxtField;
    @FXML
    private TextField costFTxtField;
 
    public int noWebsites;
    public int budget;
    public int costWebA;
    public int costWebB;
    public int costWebC;
    public int costWebD;
    public int costWebE;
    public int costWebF;
    int[] viewsArray = new int[6];
   // public int budget;
    @FXML
    private TextField viewBTextField;
    @FXML
    private TextField viewCTextField;
    @FXML
    private TextField viewDTextField;
    @FXML
    private TextField viewETextField;
    @FXML
    private TextField viewFTextField;
    @FXML
    private TextField viewATextField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
        
        if(noSwarmTextField.getText()==null){
            noSwarms = 0;
        }else{
        noSwarms = Integer.valueOf(noSwarmTextField.getText());
        }
        if(noParticleTextField.getText()==null){
            noParticles=0;
        
        }else {
            noParticles = Integer.valueOf(noParticleTextField.getText());
        }
        if(costCTxtField.getText()==null){
            costWebC=0;
        }else{
              costWebC = Integer.valueOf(costCTxtField.getText());
        }
          if(costATxtField.getText()==null){
            costWebA=0;
        }else{
              costWebA = Integer.valueOf(costATxtField.getText());
        }
            if(costBTxtField.getText()==null){
            costWebB=0;
        }else{
              costWebB = Integer.valueOf(costBTxtField.getText());
        }
              if(costDTxtField.getText()==null){
            costWebD=0;
        }else{
              costWebD = Integer.valueOf(costDTxtField.getText());
        }
                if(costETxtField.getText()==null){
            costWebE=0;
        }else{
              costWebE = Integer.valueOf(costETxtField.getText());
        }
                  if(costFTxtField.getText()==null){
            costWebF=0;
        }else{
              costWebF = Integer.valueOf(costFTxtField.getText());
        }
        if(budgetTextField.getText()==null){
            costWebF=0;
        }else{
              costWebF = Integer.valueOf(costFTxtField.getText());
        }
        if(budgetTextField.getText()==null){
            maxim=0;
        }else{
            maxim = Integer.valueOf(budgetTextField.getText());
        }
          if(viewATextField.getText()==null){
            viewsArray[0]=0;
        }else{
            viewsArray[0] = Integer.valueOf(viewATextField.getText());
        }
             if(viewBTextField.getText()==null){
            viewsArray[1]=0;
        }else{
            viewsArray[1] = Integer.valueOf(viewBTextField.getText());
        }
                if(viewCTextField.getText()==null){
            viewsArray[2]=0;
        }else{
            viewsArray[2] = Integer.valueOf(viewCTextField.getText());
        }
                   if(viewDTextField.getText()==null){
            viewsArray[3]=0;
        }else{
            viewsArray[3] = Integer.valueOf(viewDTextField.getText());
        }
                      if(viewETextField.getText()==null){
            viewsArray[4]=0;
        }else{
            viewsArray[4] = Integer.valueOf(viewETextField.getText());
        }
                         if(viewFTextField.getText()==null){
            viewsArray[5]=0;
        }else{
            viewsArray[5] = Integer.valueOf(viewFTextField.getText());
        }
                  
        
        
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
	        timer.schedule(new CrunchifyReminder(maxim,popMngr,timer,costWebA,costWebB,costWebC,costWebD,costWebE,costWebF,viewsArray), 0, // initial delay
				200);
             //   MainControllerPane mpc = new MainControllerPane(this.popMngr, timer, this.activeGraphicsPane);
		
	//	mainBorderPane.setLeft(mpc.getPane());
		mainBorderPane.setCenter(this.activeGraphicsPane);
		scene.setRoot(mainBorderPane);
		stage.show();
                
    }
    
    
    
    
}
