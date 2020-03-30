
package myproject;


import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.ENTER;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author USER
 */
public class MyProject extends Application{
    Stage window;//window is a stage type variable
    Scene scn,scn1;//scn and scn1 are two scene type variables
    private int x=30;
    private int y=550;
    private int speedX=1;
    private int speedY=1;
    

    
    @Override
    public void start(Stage primaryStage)throws FileNotFoundException {
        window=primaryStage;
        
        //image1 specification starts:
         Image image = new Image(new FileInputStream("F:\\java basic\\2_1 project\\MyProject\\src\\myproject\\interface.jpg"));  
//path of the image is given here for first scene;
      
      ImageView imageView = new ImageView(image); 
      
      imageView.setFitHeight(600); 
      imageView.setFitWidth(600); //these values are set so that the image can fit the stage/scene;
    
      imageView.setPreserveRatio(true); 
      //image2 specification ends..
      //->button1 specification starts:
        Button btn1= new Button("CLICK TO PLAY");//clicking on this button takes you to the next screen;
        btn1.setLayoutX(250);//position in the x axis.
      btn1.setLayoutY(350);//position in the Y axix;
        btn1.setOnAction(e->window.setScene(scn));//here i used lambda expression to switch between the scenes;
        
        //->here i am joining the button with enter key below.
        btn1.setOnKeyPressed(
        event->{
            switch(event.getCode()){
                case ENTER:
                 window.setScene(scn) ;  
            }
        }
        );
        //<<joining the button1 with keyboard's enter key is complete..
        
        //here we are adding a text field to take name as input from the user
         TextField jt= new TextField("Enter your nickname:\n");
      jt.setAlignment(Pos.CENTER);
    jt.setPrefWidth(300);
    jt.setLayoutX(150);
    jt.setLayoutY(300);
   //adding completed..
        
       //<<button1 specification ends..
        Group layout1=new Group();
        layout1.getChildren().add(imageView);//here the image1 is being added to the layout.
        layout1.getChildren().add(btn1);//here button1 is being added to the layout.
         layout1.getChildren().add(jt);//here we are adding the textfield to the layout.
         
        scn1=new Scene(layout1,600,600);//here all the components of scene1 is being integrated.
        
        
        //image2
        Image image1= new Image(new FileInputStream("F:\\java basic\\2_1 project\\MyProject\\src\\myproject\\Mymazesiva.png"));//image2 file path is given here.
       ImageView img = new ImageView(image1);
       
     //adding pictures to rectangle below:
     FileInputStream input = new FileInputStream("F:\\java basic\\2_1 project\\MyProject\\src\\myproject\\labour.jpg"); 
     Image img3=new Image(input);
     ImagePattern image_pattern = new ImagePattern(img3, x, y,40,40, false);
      Rectangle rect = new Rectangle(x, y, 40, 40); 
      rect.setFill(image_pattern); 
       
   
       
      //image2 specification starts:
       img.setFitHeight(600);
       img.setFitWidth(600);
       img.setPreserveRatio(true);
       //image2 specification ends.
        
        Button btn2=new Button("switch");
        btn2.setOnAction(e->window.setScene(scn1));
        Group layout2=new Group();
        layout2.getChildren().add(img);
        layout2.getChildren().add(rect);
        scn=new Scene(layout2,600,600);
        window.setScene(scn1);
        window.show();
       //keyboard controls are added below for the main character to move left,right,up and down: 
        scn.setOnKeyPressed(new EventHandler<javafx.scene.input.KeyEvent>(){
  @Override
  public void handle(javafx.scene.input.KeyEvent event){

    if (event.getCode() == KeyCode.RIGHT) {
        rect.setLayoutX(rect.getLayoutX() + 10);
    } else if (event.getCode() == KeyCode.LEFT) {
        rect.setLayoutX(rect.getLayoutX() - 10);
    }else if(event.getCode() == KeyCode.UP){
         rect.setLayoutY(rect.getLayoutY() - 10);
    }else if(event.getCode()==KeyCode.DOWN){
        rect.setLayoutY(rect.getLayoutY() + 10); 
    }
  }
});
  //keyboard control is completed..      
    }

    
    public static void main(String[] args) {
        GAME1("F:\\java basic\\2_1 project\\MyProject\\src\\myproject\\short_message_tone.wav");
        launch(args);
    }
    //adding audio to the file:
    public static void GAME1(String Filepath){
        InputStream music;
        try{
            music=new FileInputStream(new File("F:\\java basic\\2_1 project\\MyProject\\src\\myproject\\short_message_tone.wav"));
            AudioStream audios=new AudioStream(music);
            AudioPlayer.player.start(audios);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"error");
        }
        
    }
    
    

    
}

      
      
  