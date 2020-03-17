/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  
import javafx.stage.Stage; 
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author AMEYA DEBNATH
 */
public class MyProject extends Application {
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        // taking background image input
         Image image = new Image(new FileInputStream("F:\\java basic\\2_1 project\\MyProject\\src\\myproject\\interface.jpg"));  
      
      ImageView imageView = new ImageView(image); 
      //setting size
      imageView.setX(20); 
      imageView.setY(20); 

      imageView.setFitHeight(660); 
      imageView.setFitWidth(600); 
    
      imageView.setPreserveRatio(true);  
        //creating button
      Button btn=new Button("continue to play");
        //setting button size
      btn.setLayoutX(250);
      btn.setLayoutY(390);
      
      Group root = new Group();
        //adding image and button to the screen
      root.getChildren().add(imageView);  
      root.getChildren().add(btn);  
      //declaring scene size
      Scene scene = new Scene(root, 650, 650);  
    
     
      primaryStage.setScene(scene);
       JFrame f=new JFrame();
        //taking player's name from user
        String name=JOptionPane.showInputDialog(f,"Player's name?");
       primaryStage.setTitle(" WELCOME "+name+" to the gaming world");  
        //showing stage
      primaryStage.show(); 
      
    }

    public static void main(String[] args) {
        launch(args);
       
    }
    
}
