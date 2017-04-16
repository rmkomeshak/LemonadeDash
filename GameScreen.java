/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lemonadedash;

import java.text.DecimalFormat;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javax.management.timer.Timer;
import lemonadedash.ScreenSwapper.STATE;

/**
 *
 * @author Ryan
 */
public class GameScreen extends Screen{
    GridPane game = new GridPane();
    Timeline dayTime, buyTime;
    int customer_val;
    int cur_score;
    int cups_sold;
    int start_sugar, start_lemons;
    int i = 0;
    String sales = "Sales: ";
    VBox test = new VBox();
    Text s = new Text("Sales: ");
    Text lemons = new Text();
    Text ice = new Text();
    Text sugar = new Text();
    Text cups = new Text();
    Text money = new Text();
    DecimalFormat df = new DecimalFormat("0.00##");
    
    public GameScreen(){
        super();
        test.getChildren().addAll(s, lemons, ice, sugar, cups, money);
        game.getChildren().add(test);
        start_sugar = ui.getSugar();
        start_lemons = ui.getLemons();
        updateResources();
        startDay();
        checkResources();
    }
    
    public Pane initScreen(){
        return game;
    }
    
    public void startDay(){
        dayTime = new Timeline(new KeyFrame(Duration.seconds(0.25), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
               customer_val = (int) ((Math.random() * 10000) % 7000 + 1000);
               ui.calculateDifference();
               cur_score = ui.getScore();
               
               if((customer_val < cur_score) && (ui.getIce() >= ui.getRecipeIce()) &&
                       ui.getCups() > 0 && (ui.getLemons() >= ui.getRecipeLemons()) &&
                       (ui.getSugar() >= ui.getRecipeSugar())){
                   cups_sold++;
                   sales += " $ ";
                   s.setText(sales);
                   ui.setCups(ui.getCups() - 1);
                   ui.setIce(ui.getIce() - ui.getRecipeIce());
                   if(cups_sold % 5 == 0 && cups_sold != 0){
                       ui.setLemons(ui.getLemons() - ui.getRecipeLemons());
                       ui.setSugar(ui.getSugar() - ui.getRecipeSugar());
                   }
                   
                   if(ui.getIce() <= 0)
                       ui.setIce(0);
                   if(ui.getCups() <= 0)
                       ui.setCups(0);
                   if(ui.getLemons() <= 0)
                       ui.setLemons(0);
                   if(ui.getSugar() <= 0)
                       ui.setSugar(0);
                   ui.setMoney(ui.getMoney() + (double)(ui.getPrice()/100.0));
                   updateResources();
               }
            }
        }));
        dayTime.setCycleCount(80);
        dayTime.play();
    }
    
    public void updateResources(){
        cups.setText("Cups: " + ui.getCups());
        ice.setText("Ice: " + ui.getIce());
        sugar.setText("Sugar: " + ui.getSugar());
        lemons.setText("Lemons: " + ui.getLemons());
        money.setText("Money: $" + df.format(ui.getMoney()));
    }
    
    //subtract lemons & sugar if you dont use a whole pitcher
    public void checkResources(){
        if(ui.getSugar() == start_sugar)
            ui.setSugar(ui.getSugar() - 1);
        if(ui.getLemons() == start_lemons)
            ui.setLemons(ui.getLemons() - 1);
    }
}
