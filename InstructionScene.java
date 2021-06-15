/*
 * File:GAME1.java
 */
package game1;

import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *This class gives instructions about how to play the game.
 * @author Tahsina Bintay Azam
 */
public class InstructionScene extends Scene{
    private Parent layout2;
    private Button playButton;
    private TextField nickNameField;
    private ImageView backgroundImg;
/**
 * Gets the Parent
 * @return javafx.scene.Parent
 */
    public Parent getLayout() {
        return layout2;
    }
    /**
     * Sets the layout
     * @param layout 
     */
    public void setLayout(Parent layout) {
        this.layout2 = layout;
    }
    /**
     * Gets the play button
     * @return javafx.scene.control.Button
     */
    public Button getPlayButton() {
        return playButton;
    }
    /**
     * Sets the play button
     * @param playButton 
     */
    public void setPlayButton(Button playButton) {
        this.playButton = playButton;
    }
    /**
     * get the text field 	
     * @return javafx.scene.control.TextField 
     */
    public TextField getNickNameField() {
        return nickNameField;
    }
    /**
     * Sets the nick name field
     * @param nickNameField 
     */
    public void setNickNameField(TextField nickNameField) {
        this.nickNameField = nickNameField;
    }
    /**
     * Gets the background image
     * @return javafx.scene.image.ImageView
     */
    public ImageView getBackgroundImg() {
        return backgroundImg;
    }
    /**
     * Sets the background image
     * @param backgroundImg 
     */
    public void setBackgroundImg(ImageView backgroundImg) {
       this.backgroundImg = backgroundImg;
    }
    
    /**
     * This constructor works to assemble the components of the instruction scene.
     * @param layout2
     * @param width
     * @param height 
     */
    public InstructionScene(Group layout2, double width, double height)  {
        super(layout2, width, height);

        try {
            this.layout2 = layout2;
            
            //image1 specification starts:
            /*  Image image;
            try {
            image = new Image(new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\Untitled4.gif")); //path of the image is given here for first scene;

            this.backgroundImg = new ImageView(image);

            backgroundImg.setFitHeight(600);
            backgroundImg.setFitWidth(600); //these values are set so that the image can fit the stage/scene;*/
            
            
            //this string is used for making button a little bit round and setting background color
            Image image1 = new Image(new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\Capture1.png")) ;
            Image image2 = new Image(new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\Capture2.png"))  ;
            Image image3 = new Image(new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\Capture.PNG"))  ;
            Image image4 = new Image(new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\Capture3.png"))  ;
            Image image5 = new Image(new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\Capture4.png"))  ;
            Image image6 = new Image(new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\Capture5.png"))  ;
            Image image7 = new Image(new FileInputStream("C:\\Users\\USER\\Documents\\NetBeansProjects\\GAME1\\src\\Capture6.png"))  ;
            ImageView imageView = new ImageView();
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(imageView.imageProperty(), image1)),
                    new KeyFrame(Duration.seconds(3), new KeyValue(imageView.imageProperty(), image2)),
                    new KeyFrame(Duration.seconds(7), new KeyValue(imageView.imageProperty(), image3)),
                    new KeyFrame(Duration.seconds(11), new KeyValue(imageView.imageProperty(), image4)),
                    new KeyFrame(Duration.seconds(15), new KeyValue(imageView.imageProperty(), image5)),
                    new KeyFrame(Duration.seconds(19), new KeyValue(imageView.imageProperty(), image6)),
                    new KeyFrame(Duration.seconds(23), new KeyValue(imageView.imageProperty(), image7)),
                    new KeyFrame(Duration.seconds(27), new KeyValue(imageView.imageProperty(), null))
            );
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
            
            Button arrowButton=new Button();
            String stylesNeed=
                    "-fx-background-color:LIGHTBLUE;"
                    //+"-fx-background-insets: 1 1 1 1, 0;"
                    // +"-fx-padding: 0.50em;"
                    +"-fx-shape: \"M 0 -3.5 v 7 l 4 -3.5 z\";";
            String styleProxy=
                    "-fx-background-color:RED;"
                    //+"-fx-background-insets: 1 1 1 1, 0;"
                    // +"-fx-padding: 0.50em;"
                    +"-fx-shape: \"M 0 -3.5 v 7 l 4 -3.5 z\";";
            arrowButton.setLayoutX(550);
            arrowButton.setLayoutY(50);
            arrowButton.setStyle(stylesNeed);
            
            layout2.getChildren().addAll(imageView,arrowButton);
            
            arrowButton.setOnMouseClicked(event -> {
                
                if(timeline.getStatus()==Animation.Status.PAUSED){
                    timeline.play();
                    arrowButton.setStyle(stylesNeed);
                }
                else
                {
                    timeline.pause();
                    arrowButton.setStyle(styleProxy);
                }
                
            });
            String styles =
                    "-fx-background-radius:100;"
                    +"-fx-background-color:LIGHTBLUE"
                    ;
            
            this.playButton = new Button("READY TO PLAY");//clicking on this playButton takes you to the next screen;
            playButton.setLayoutX(225);//position in the x axis.
            playButton.setLayoutY(470);//position in the Y axix;
            playButton.setStyle(styles);
           // layout2.getChildren().add(backgroundImg);//here the image1 is being added to the layout.
            layout2.getChildren().add(playButton);
            
            /* } catch (FileNotFoundException ex) {
            Logger.getLogger(InstructionScene.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InstructionScene.class.getName()).log(Level.SEVERE, null, ex);
        }
    
   
    }
    
}
