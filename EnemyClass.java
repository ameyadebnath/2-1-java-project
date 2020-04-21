/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

import static game1.GameScene.playerScore;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.Callable;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javax.swing.JOptionPane;


public class EnemyClass extends GameScene{
  public static void enemyChar(Rectangle rect,Group layout,Label plrScore) throws FileNotFoundException{
       Rectangle rect2 = new Rectangle(20,20,40,40);//creating anime object
        //adding pictures to rectangle below:
        FileInputStream input = new FileInputStream("F:\\Project\\2-1 java\\2_1 project\\My project\\src\\rocksteady.png");
        Image img3 = new Image(input);
        ImagePattern image_pattern = new ImagePattern(img3, 20, 20, 1, 1, true);
       rect2.setFill(image_pattern);
       javafx.scene.shape.Path path = new javafx.scene.shape.Path();//creating path for the enemy to move
        path.getElements().add(new MoveTo(274,25));//passing coordinates of the ending and starting point of the line
        path.getElements().add(new LineTo(274,167));
        path.getElements().add(new LineTo(215,167));
        path.getElements().add(new LineTo(215,90));
        path.getElements().add(new LineTo(30,90));
        path.getElements().add(new LineTo(30,540));
        path.getElements().add(new LineTo(90,540));
        path.getElements().add(new LineTo(90,390));
        path.getElements().add(new LineTo(156,390));
        path.getElements().add(new LineTo(156,540));
        path.getElements().add(new LineTo(276,540));
        path.getElements().add(new LineTo(276,391));
        path.getElements().add(new LineTo(206,391));
        path.getElements().add(new LineTo(206,225.64));
        path.getElements().add(new LineTo(277,225.64));
        path.getElements().add(new LineTo(277,335));
        path.getElements().add(new LineTo(330,335));
        path.getElements().add(new LineTo(330,465));
        path.getElements().add(new LineTo(440,465));
       // path.getElements().add(new LineTo(300,465));

        javafx.animation.PathTransition pathTransition = new javafx.animation.PathTransition();
        pathTransition.setDuration(Duration.millis(10000));//setting path duration time , sending it as parameter
        Node cbTypeCrc;
        pathTransition.setNode(rect2);//passing rect2 as parameter and selecting it as the node for path transition
        pathTransition.setPath(path);//selecting path for the enemy to move
        pathTransition.setOrientation(javafx.animation.PathTransition.OrientationType.NONE);
        pathTransition.setCycleCount(Timeline.INDEFINITE);//setting that the enemy would move indefinitely
        pathTransition.setOrientation(javafx.animation.PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setAutoReverse(true);//the enemy also would reversely move
        pathTransition.play();
        layout.getChildren().add(rect2);//passing enemy object as parameter and adding it to the layoout
        
        
        
          ObservableBooleanValue colliding = Bindings.createBooleanBinding(new Callable<Boolean>() {

        @Override
        public Boolean call() throws Exception {
            return rect.getBoundsInParent().intersects(rect2.getBoundsInParent());
        }

    }, rect.boundsInLocalProperty(), rect2.boundsInLocalProperty());

   colliding.addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> obs,
                Boolean oldValue, Boolean newValue) {
            if (newValue) {
                JOptionPane.showMessageDialog(null, "Game over");
                System.out.println("colliding2");
                GameScene.playerScore=0;//setting the score to zero when rect will collide with rect3
                int zero=0;
                plrScore.setText(Integer.toString(zero));
            } 
            else
                System.out.println("not collidiing");
        }
    });
    rect2.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
        @Override
        public void changed(ObservableValue<? extends Bounds> arg0,Bounds oldValue, Bounds newValue) {
            if(rect.getBoundsInParent().intersects(newValue)){
               // System.out.println("Collide ============= Collide");
                JOptionPane.showMessageDialog(null, "Game over");
                //setting the score to zero when rect will collide with rect3
                int zero=0;
                plrScore.setText(Integer.toString(zero));
            }
        }
    });
        
    }
 
    
}
