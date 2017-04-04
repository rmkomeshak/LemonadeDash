/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lemonadedash;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 *
 * @author kmgauthier
 */
public class LeaderboardScreen extends Screen {
    private Pane pane;
    private GridPane gpane;
    
    //private Label header;
    private Button back, quit;
    
    public Pane initScreen(){
         //????
         return gpane;
     }
    
    public LeaderboardScreen(){
        super();
        
        pane= new Pane();
        gpane = new GridPane();
        gpane.setHgap(10);
        gpane.setVgap(10);
        gpane.setPadding(new Insets(0, 10, 0, 10));
        Text title = new Text("Leaderboard");
        
        //header = new Label("Leaderboard");
        back = new Button("Back");
        quit = new Button("Quit");
        
        
        
        gpane.add(title, 0, 0);
        //gpane.add(header,1, 0 );
        gpane.add(back, 1, 0);
        gpane.add(quit, 1, 1);
        
        
        //gpane.setVisible(true);
        
        back.setOnAction(e->{
            //go to main menu screen 
        });
        
        quit.setOnAction(e->{
            System.exit(0);
        });
        
        
        
    }
    
}
