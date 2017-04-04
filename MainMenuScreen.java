/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lemonadedash;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
        Text title = new Text("Welcome to Lemonade Dash!");
        
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
            //go to Setup screen
            gpane.setVisible(false);
            new SetupScreen();
        });
        
        leaderboard.setOnAction(e->{
            //go to Leaderboard screen
            gpane.setVisible(false);
            new LeaderboardScreen();
        });
        
        options.setOnAction(e->{
            //go to options screen
            gpane.setVisible(false);
            new OptionsScreen();
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