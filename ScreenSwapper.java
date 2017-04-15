package lemonadedash;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Ryan
 */
public class ScreenSwapper {
    Pane current_screen;
    Pane store, recipe, setup, mainMenu, options, leaderboard, game;
    STATE state = STATE.START;
    private static volatile ScreenSwapper instance;
    
    private ScreenSwapper(){
        store = new StoreScreen().initScreen();
        recipe = new RecipeScreen().initScreen();
        setup = new SetupScreen().initScreen();
        mainMenu = new MainMenuScreen().initScreen();
        options = new OptionsScreen().initScreen();
        leaderboard = new LeaderboardScreen().initScreen();
        game = new GameScreen().initScreen();
        current_screen = mainMenu;
    }
    
    public static synchronized ScreenSwapper getInstance(){
        if(instance == null){
            instance = new ScreenSwapper();
        }
        return instance;
    }
    
    public Pane getCurrentScreen(){
        return current_screen;
    }
    
    public void setCurrentScreen(Pane p){
        current_screen = p;
    }
    
    public void setState(STATE s){
        state = s;
    }
    
    public STATE getState(){
        return state;
    }
    
    public static enum STATE{
        START,
        SETUP,
        STORE,
        RECIPE,
        GAME,
        STATS,
        OVER,
        HIGHSCORES,
        OPTIONS
    };
}
