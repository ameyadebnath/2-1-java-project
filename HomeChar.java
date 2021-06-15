/*
 * File:GAME1.java
 */
package game1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * This class deals with another destination object
 * @author Tahsina Bintay Azam
 */
public class HomeChar {
    /**
     * This class creates a object that the player has to reach to complete the level
     * @param rect
     * @param layout
     * @return javafx.scene.shape.Rectangle
     * @throws FileNotFoundException 
     */
    public static Rectangle homeChar(Rectangle rect,Group layout) throws FileNotFoundException{
       Rectangle rect2 = new Rectangle(788,680,50,50);
        /**adding pictures to rectangle below:*/
        FileInputStream input = new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\farmhouse.png");
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
                       return rect2;/**returning the object of bossfarmer for further control check*/
        
    }
    
}
