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
import javaFxDriver.Animation;
import javaFxDriver.TimerTaskClass;

import javaFxDriver.PopulationDriver;
import javaFxDriver.PopulationManager;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Aditya
 */
public class FXMLDocumentController  implements Initializable {
    
    int  noSwarm;
    int noParticle;
    int maxim;
    private long lastTime;
    private BorderPane mainBorderPane = new BorderPane();
    private BorderPane activeGraphicsPane = new BorderPane();
    private PopulationManager popMngr = new PopulationManager();
    Animation basic3D;
    Timer timer;
    private int noSwarms;
    private int noParticles;
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
    private int costWebA;
    private int costWebB;
    private int costWebC;
    private int costWebD;
    private int costWebE;
    private int costWebF;
    private int[] viewsArray = new int[6];
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
    @FXML
    private Button button;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
    }
   
    @FXML
    private void handleButtonAction(MouseEvent event) {
        if(noSwarmTextField.getText().equals("")||noParticleTextField.getText().equals("")||
                costCTxtField.getText().equals("")||costDTxtField.getText().equals("")||costETxtField.getText().equals("")||
                costFTxtField.getText().equals("")||costATxtField.getText().equals("")||costBTxtField.getText().equals("")
                ||budgetTextField.getText().equals("")||viewATextField.getText().equals("")||viewBTextField.getText().equals("")
                ||viewCTextField.getText().equals("")||viewDTextField.getText().equals("")||viewETextField.getText().equals("")
                ||viewFTextField.getText().equals("")){
             JOptionPane.showMessageDialog(null,"One or more fields are empty");
        }else{
        if( Integer.valueOf(noSwarmTextField.getText())<0){
            JOptionPane.showMessageDialog(null,"Enter a positive value for total no of Swarms");
        }else{
        noSwarms = Integer.valueOf(noSwarmTextField.getText());
        
        if(Integer.valueOf(noParticleTextField.getText())<0){
         JOptionPane.showMessageDialog(null,"Enter a positive value for total no of Particles");
        
        }else {
            noParticles = Integer.valueOf(noParticleTextField.getText());
        
        if(Integer.valueOf(costCTxtField.getText())<0){
           JOptionPane.showMessageDialog(null,"Enter a positive cost");
        }else{
              costWebC = Integer.valueOf(costCTxtField.getText());
        
        if(Integer.valueOf(costATxtField.getText())<0){
            JOptionPane.showMessageDialog(null,"Enter a positive cost");
        }else{
              costWebA = Integer.valueOf(costATxtField.getText());
        
        if(Integer.valueOf(costBTxtField.getText())<0){
            JOptionPane.showMessageDialog(null,"Enter a positive cost");
        }else{
              costWebB = Integer.valueOf(costBTxtField.getText());
        
        if(Integer.valueOf(costDTxtField.getText())<0){
            JOptionPane.showMessageDialog(null,"Enter a positive cost");
        }else{
              costWebD = Integer.valueOf(costDTxtField.getText());
        
        if(Integer.valueOf(costETxtField.getText())<0){
            JOptionPane.showMessageDialog(null,"Enter a positive cost");
        }else{
              costWebE = Integer.valueOf(costETxtField.getText());
        
        if(Integer.valueOf(costFTxtField.getText())<0){
           JOptionPane.showMessageDialog(null,"Enter a positive cost");
        }else{
              costWebF = Integer.valueOf(costFTxtField.getText());
        
  
        if(Integer.valueOf(budgetTextField.getText())<0){
            JOptionPane.showMessageDialog(null,"Enter a positive budget");
        }else{
            maxim = Integer.valueOf(budgetTextField.getText());
        
        if(Integer.valueOf(viewATextField.getText())<0){
           JOptionPane.showMessageDialog(null,"Enter a positive value for views");
        }else{
            viewsArray[0] = Integer.valueOf(viewATextField.getText());
        
        if(Integer.valueOf(viewBTextField.getText())<0){
          JOptionPane.showMessageDialog(null,"Enter a positive value for views");
        }else{
            viewsArray[1] = Integer.valueOf(viewBTextField.getText());
        
        if(Integer.valueOf(viewCTextField.getText())<0l){
           JOptionPane.showMessageDialog(null,"Enter a positive value for views");
        }else{
            viewsArray[2] = Integer.valueOf(viewCTextField.getText());
        
        if(Integer.valueOf(viewDTextField.getText())<0){
          JOptionPane.showMessageDialog(null,"Enter a positive value for views");
        }else{
            viewsArray[3] = Integer.valueOf(viewDTextField.getText());
        
        if(Integer.valueOf(viewETextField.getText())<0){
           JOptionPane.showMessageDialog(null,"Enter a positive value for views");
        }else{
            viewsArray[4] = Integer.valueOf(viewETextField.getText());
        
        if(Integer.valueOf(viewFTextField.getText())<0){
          JOptionPane.showMessageDialog(null,"Enter a positive value for views");
        }else{
            viewsArray[5] = Integer.valueOf(viewFTextField.getText());
        
                  
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
	PopulationDriver basic3D = new Animation(searchSpace, initGoal, -1, new int[100],noSwarms,noParticles,inertiaFactor,cw,sw,gw);
        this.popMngr.addDriver("basic3D", basic3D);
	this.popMngr.setActiveDriver("basic3D");
		
		//---SET MAIN GRAPHICS PANE---//
	this.activeGraphicsPane.setCenter(this.popMngr.getActiveDriver().getUiNode());
	this.activeGraphicsPane.setStyle("" +
			"-fx-background-color: #ffffff;" +
			"-fx-border-color: #333333;" + 
			"-fx-border-width: 2px;" +
			"-fx-border-radius: 4px;"
	); 
                
        this.lastTime = System.nanoTime();
	timer = new Timer();
        //System.out.println("********************************************called once");
	timer.schedule(new TimerTaskClass(maxim,popMngr,timer,costWebA,costWebB,costWebC,costWebD,costWebE,costWebF,viewsArray), 0,600);
	mainBorderPane.setCenter(this.activeGraphicsPane);
	scene.setRoot(mainBorderPane);
	stage.show();
        }
                
    }}}}}}}}}
        }
        }
        }
        }
        }
        }
        
        
    } 
    
    
}
