package lemonadedash;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.media.MediaPlayer.INDEFINITE;
import javafx.scene.text.Text;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author kmgauthier
 */
public class MainMenuScreen extends Screen{
     Pane setup = new Pane();
     private GridPane gpane;
     //private Pane pane;
     //private Label welcome;
     private Button newGame, leaderboard, quit, options;
     
     public GridPane initScreen(){
         //????
         return gpane;
     }
     
     public MainMenuScreen() {
        
        super();
        
        //pane= new Pane();
        gpane = new GridPane();
        gpane.setAlignment(Pos.CENTER);
        gpane.setHgap(10);
        gpane.setVgap(10);
        gpane.setPadding(new Insets(0, 10, 0, 10));
        ImageView title = new ImageView(new Image("file:resource/image/main-menu-title.png", 600, 600, true, true));
         
        //Opening music 
        
        String musicFile = "opening.wav";
        int s= INDEFINITE;
        Media sound= new Media(new File(musicFile).toURI().toString());
        
        MediaPlayer mp= new MediaPlayer(sound);
        
        mp.setVolume(0.5f);
        mp.setCycleCount(s);
        mp.play();
        
        //welcome = new Label("Welcome to Lemonade Dash!");
        newGame = new Button("New Game");
        leaderboard = new Button("Leaderboard");
        quit = new Button("Quit");
        options = new Button("Options");
        
        
        gpane.add(title, 0, 0);
        //gpane.getChildren().add(welcome);
        
        gpane.add(newGame, 0, 1);
        gpane.setHalignment(newGame, HPos.CENTER);
        gpane.add(leaderboard, 0, 2);
        gpane.setHalignment(leaderboard, HPos.CENTER);
        gpane.add(options, 0, 3);
        gpane.setHalignment(options, HPos.CENTER);
        gpane.add(quit, 0, 4);
        gpane.setHalignment(quit, HPos.CENTER);
        
        
        //gpane.setVisible(true);
        
        
        
        newGame.setOnAction(e->{
            ScreenSwapper.getInstance().setState(ScreenSwapper.STATE.SETUP);
        });
        
        leaderboard.setOnAction(e->{
            //go to Leaderboard screen
            ScreenSwapper.getInstance().setState(ScreenSwapper.STATE.HIGHSCORES);
        });
        
        options.setOnAction(e->{
            //go to options screen
            ScreenSwapper.getInstance().setState(ScreenSwapper.STATE.OPTIONS);
        });
        
        quit.setOnAction(e->{
            System.exit(0);
        });
        
        
        
    }

    private void drawText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void drawButtons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}