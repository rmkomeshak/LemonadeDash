/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lemonadedash;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LemonadeDash extends Application {
    
    private STATE state = STATE.STORE;
    
    StoreScreen store = new StoreScreen();
    
    public Pane initStore(){
        return store.initScreen();
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        Scene scene = new Scene(initStore(), 800, 600);
        
        primaryStage.setTitle("Lemonade Dash");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    //use this to show the current state of the game
    public static enum STATE{
        START,
        SETUP,
        STORE,
        RECIPE,
        GAME,
        STATS,
        OVER,
        HIGHSCORES
    };
    
}
