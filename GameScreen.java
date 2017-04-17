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
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
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
    int sale_num = 0;
    int i = 0;
    int time = 20;
    int size = 30;
    String sales = "Sales: " + sale_num;
    HBox test = new HBox();
    Text s = new Text(sales);
    Text lemons = new Text();
    Text ice = new Text();
    Text sugar = new Text();
    Text cups = new Text();
    Text money = new Text();
    Text day = new Text();
    int cycle = 0;
    DecimalFormat df = new DecimalFormat("0.00##");
    ColumnConstraints c1, c2, c3, c4, c5, c6, c7;
    Rectangle r = new Rectangle(1280, 50);
    int col_width = 160;
    Button end_day = new Button("End Day");
    Button main_menu = new Button("Return to Main Menu");
    
    public GameScreen(){
        super();
        i = 0;
        time = 20;
        sale_num = 0;
        cycle = 0;
        day.setText("Days: " + ui.getDay());
        //test.getChildren().addAll(s, lemons, ice, sugar, cups, money);
        //game.getChildren().add(test);
        game.getChildren().add(r);
        c1 = new ColumnConstraints(col_width);
        c2 = new ColumnConstraints(col_width);
        c3 = new ColumnConstraints(col_width);
        c4 = new ColumnConstraints(col_width);
        c5 = new ColumnConstraints(col_width);
        c6 = new ColumnConstraints(col_width);
        c7 = new ColumnConstraints(col_width);
        
        game.add(s, 0, 0);
        game.setHalignment(s, HPos.CENTER);
        game.add(lemons, 1, 0);
        game.setHalignment(lemons, HPos.CENTER);
        game.add(ice, 2, 0);
        game.setHalignment(ice, HPos.CENTER);
        game.add(sugar, 3, 0);
        game.setHalignment(sugar, HPos.CENTER);
        game.add(cups, 4, 0);
        game.setHalignment(cups, HPos.CENTER);
        game.add(money, 5, 0);
        game.setHalignment(money, HPos.CENTER);
        game.add(end_day, 3, 1);
        game.setHalignment(end_day, HPos.CENTER);
        game.add(main_menu, 3, 1);
        game.setHalignment(main_menu, HPos.CENTER);
        game.add(day, 6, 0);
        game.setHalignment(day, HPos.CENTER);
        end_day.setTranslateY(25);
        end_day.setVisible(false);
        main_menu.setTranslateY(25);
        main_menu.setVisible(false);
        
        s.setFill(Color.WHITE);
        lemons.setFill(Color.WHITE);
        ice.setFill(Color.WHITE);
        sugar.setFill(Color.WHITE);
        cups.setFill(Color.WHITE);
        money.setFill(Color.WHITE);
        day.setFill(Color.WHITE);
        
        s.setFont(Font.font("Calibri", size));
        lemons.setFont(Font.font("Calibri", size));
        ice.setFont(Font.font("Calibri", size));
        sugar.setFont(Font.font("Calibri", size));
        cups.setFont(Font.font("Calibri", size));
        money.setFont(Font.font("Calibri", size));
        day.setFont(Font.font("Calibri", size));
        

        game.getColumnConstraints().addAll(c1, c2, c3, c4, c5, c6, c7);
        
        
        start_sugar = ui.getSugar();
        start_lemons = ui.getLemons();
        initButtons();
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
               cycle++;
               
               if((customer_val < cur_score) && (ui.getIce() >= ui.getRecipeIce()) &&
                       ui.getCups() > 0 && (ui.getLemons() >= ui.getRecipeLemons()) &&
                       (ui.getSugar() >= ui.getRecipeSugar())){
                   cups_sold++;
                   sale_num++;
                   s.setText("Sales: " + sale_num);
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
               
               if(cycle == 80 || (ui.getIce() < ui.getRecipeIce()) ||
                       ui.getCups() <= 0 || (ui.getLemons() < ui.getRecipeLemons()) ||
                       (ui.getSugar() < ui.getRecipeSugar())){
                   ui.setIce(0);
                   if(ui.getDay() != 0){
                    end_day.setVisible(true);
                   }
                   /*else{
                       main_menu.setVisible(true);
                       ui.resetResources();
                   }*/
                   dayTime.stop();
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
        money.setText("$" + df.format(ui.getMoney()));
    }
    
    //subtract lemons & sugar if you dont use a whole pitcher
    public void checkResources(){
        if((ui.getSugar() == start_sugar) && (start_sugar != 0))
            ui.setSugar(ui.getSugar() - 1);
        if((ui.getLemons() == start_lemons) && (start_lemons != 0))
            ui.setLemons(ui.getLemons() - 1);
    }
    
    public void initButtons(){
        end_day.setOnAction(e->{
           ScreenSwapper.getInstance().goEndDay();
           ScreenSwapper.getInstance().setState(STATE.STATS);
        });
        
       /* main_menu.setOnAction(e->{
            ScreenSwapper.getInstance().goStore();
            ScreenSwapper.getInstance().setState(STATE.START);
        });*/
    }
}
