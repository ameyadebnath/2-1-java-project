/*
 * File:GAME1.java
 */
package game1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.Callable;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 * This class works with the destination object.
 * @author Tahsina Bintay Azam
 * 
 */
public class BossFarmer extends GameScene {
    /**
     * creates and return the object that the player needs to reach
     * @param rect
     * @param layout
     * @return javafx.scene.shape.Rectangle
     * @throws FileNotFoundException 
     */
     public static Rectangle BossChar(Rectangle rect,Group layout) throws FileNotFoundException{
       Rectangle rect2 = new Rectangle(555,550,40,40);
        /**adding pictures to rectangle below:*/
        FileInputStream input = new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\farm.png");
        Image img3 = new Image(input);
        ImagePattern image_pattern = new ImagePattern(img3, 570, 575, 1, 1, true);
       rect2.setFill(image_pattern);
       
        layout.getChildren().add(rect2);
        GameScene.lifeLine=100; 
                 Label life= GameScene.getLabel();
                       Label life2=LevelTwo.getLabels();
                       Label life3=LevelThree.getLabelso();
                       life.setText(Integer.toString(GameScene.lifeLine)); 
                       life2.setText(Integer.toString(GameScene.lifeLine));
                       life3.setText(Integer.toString(GameScene.lifeLine));
                     
        
     return rect2;//returning the object of bossfarmer for further control check
        
    }
    
}
