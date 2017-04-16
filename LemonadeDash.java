package lemonadedash;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LemonadeDash extends Application {
    ScreenSwapper ss = ScreenSwapper.getInstance();
    Scene scene;
    AnimationTimer timer;
    
    @Override
    public void start(Stage primaryStage) {
        
        scene = new Scene(ss.getCurrentScreen(), Scaling.windowWidth(), Scaling.windowHeight());
        primaryStage.setTitle("Lemonade Dash");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                switch(ss.state){
                    case START: 
                        scene.setRoot(ss.mainMenu);
                        break;
                    case SETUP:
                        scene.setRoot(ss.setup); 
                        break;
                    case STORE:
                        scene.setRoot(ss.store);
                        break;
                    case RECIPE:
                        scene.setRoot(ss.recipe);
                        break;
                    case HIGHSCORES:
                        scene.setRoot(ss.leaderboard);
                        break;
                    case OPTIONS:
                        scene.setRoot(ss.options);
                        break;
                    case GAME:
                        scene.setRoot(ss.game);
                        break;
                    default:
                }
            }
        };
        timer.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}