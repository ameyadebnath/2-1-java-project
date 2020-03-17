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
        		
         Image image = new Image(new FileInputStream("F:\\java basic\\2_1 project\\MyProject\\src\\myproject\\interface.jpg"));  
      
      ImageView imageView = new ImageView(image); 
      
      imageView.setX(20); 
      imageView.setY(20); 

      imageView.setFitHeight(660); 
      imageView.setFitWidth(600); 
    
      imageView.setPreserveRatio(true);  
      Button btn=new Button("continue to play");
      btn.setLayoutX(250);
      btn.setLayoutY(390);
      
      Group root = new Group();
      root.getChildren().add(imageView);  
      root.getChildren().add(btn);  
      
      Scene scene = new Scene(root, 650, 650);  
    
     
      primaryStage.setScene(scene);
       JFrame f=new JFrame();
        String name=JOptionPane.showInputDialog(f,"Player's name?");
       primaryStage.setTitle(" WELCOME "+name+" to the gaming world");  
      primaryStage.show(); 
      
    }

    public static void main(String[] args) {
        launch(args);
       
    }
    
}
