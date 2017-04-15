/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lemonadedash;

import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import lemonadedash.ScreenSwapper.STATE;

/**
 *
 * @author Ryan
 */
public class GameScreen extends Screen{
    GridPane game = new GridPane();
    
    
    public GameScreen(){
        super();
    }
    
    public Pane initScreen(){
        return game;
    }
    
}
