/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lemonadedash;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Ryan
 */
public class StoreScreen extends Screen{
    Pane store = new Pane();
    VBox layout = new VBox();
    VBox owned = new VBox();
    VBox purchase = new VBox();
    HBox total = new HBox();
    VBox corner_info = new VBox();
    
    TextField cup_amt, lemon_amt, ice_amt, sugar_amt;
    Text cups_owned, ice_owned, sugar_owned, lemons_owned, money;
    
    double cup_price = 0.1;
    double lemon_price = 0.5;
    double sugar_price = 1;
    double ice_price = 0.05;
    
    int cup_input, lemon_input, sugar_input, ice_input;
    Text title = new Text("STORE");
    UserInventory ui = UserInventory.getInstance();
    
    
    public StoreScreen(){
        super();
        
        layout.setPrefSize(800,600);
        layout.setAlignment(Pos.TOP_CENTER);
        
        owned.setPrefSize(600,300);
        owned.setAlignment(Pos.TOP_CENTER);
        
        purchase.setPrefSize(600,300);
        purchase.setAlignment(Pos.TOP_CENTER);
        
        drawText();
        drawButtons();
        
        store.getChildren().add(layout);
    }
    
    public Pane initScreen(){
        return store;
    }
    
    public void drawText(){
        title.setTranslateY(50);
        title.setFont(Font.font("Calibri", 50));
        
        Text subtitle1 = formatText("Owned", "Calibri", 25, 0, 100);
        Text subtitle2 = formatText("Purchase", "Calibri", 25, 0, 100);
        
        cups_owned = formatText((ui.getCups() + " Cups"), "Calibri", 15, 0, 120);
        lemons_owned = formatText((ui.getLemons() + " Lemons"), "Calibri", 15, 0, 130);
        sugar_owned = formatText((ui.getSugar() + " Sugar"), "Calibri", 15, 0, 140);
        ice_owned = formatText((ui.getIce() + " Ice Cubes"), "Calibri", 15, 0, 150);
        
        HBox cups_purchase = new HBox();
        HBox lemons_purchase = new HBox();
        HBox sugar_purchase = new HBox();
        HBox ice_purchase = new HBox();
        
        cup_amt = formatTextField(50, 100, 120);
        lemon_amt = formatTextField(50, 100, 120);
        sugar_amt = formatTextField(50, 100, 120);
        ice_amt = formatTextField(50, 100, 120);
        
        Text cup_cost = formatText("  Cups ($0.10/each)", "Calibri", 15, 100, 120);
        Text lemon_cost = formatText("  Lemons ($0.50/each)", "Calibri", 15, 100, 120);
        Text sugar_cost = formatText("  Sugar ($1.00/each)", "Calibri", 15, 100, 120);
        Text ice_cost = formatText("  Ice ($0.05/each)", "Calibri", 15, 100, 120);
        
        
        cups_purchase.getChildren().addAll(cup_amt, cup_cost);
        lemons_purchase.getChildren().addAll(lemon_amt, lemon_cost);
        sugar_purchase.getChildren().addAll(sugar_amt, sugar_cost);
        ice_purchase.getChildren().addAll(ice_amt, ice_cost);
        
        
        money = formatText(("Money: $" + ui.getMoney()), "Calibri", 15, -350, 200);
        
        owned.getChildren().addAll(subtitle1, cups_owned, lemons_owned, sugar_owned, ice_owned);
        purchase.getChildren().addAll(subtitle2, cups_purchase, lemons_purchase, sugar_purchase, ice_purchase);
        
        total.getChildren().addAll(owned, purchase);
        layout.getChildren().addAll(title, total, money);
    }
    
    public void drawButtons(){
        Button buy = new Button("Buy");
        buy.setTranslateY(150);
        purchase.getChildren().add(buy);
        
        //TODO: LIMIT INPUT: NO CHARACTERS, NO STRINGS, NO NEGATIVES
        buy.setOnAction(e -> {
            System.out.println(ui.getName());
            if(!cup_amt.getText().isEmpty()){
                cup_input = Integer.valueOf(cup_amt.getText());
                if((cup_input * cup_price) <= ui.getMoney()){
                    ui.setCups(ui.getCups() + cup_input);
                    ui.setMoney(ui.getMoney() - (cup_input * cup_price));
                    updateCups();
                }
            }
            
            if(!lemon_amt.getText().isEmpty()){
                lemon_input = Integer.valueOf(lemon_amt.getText());
                if((lemon_input * lemon_price) <= ui.getMoney()){
                    ui.setLemons(ui.getLemons() + lemon_input);
                    ui.setMoney(ui.getMoney() - (lemon_input * lemon_price));
                    updateLemons();
                }
            }
                
            if(!ice_amt.getText().isEmpty()){
                ice_input = Integer.valueOf(ice_amt.getText());
                if((ice_input * ice_price) <= ui.getMoney()){
                    ui.setIce(ui.getIce() + ice_input);
                    ui.setMoney(ui.getMoney() - (ice_input * ice_price));
                    updateIce();
                }
            }
            if(!sugar_amt.getText().isEmpty()){
                sugar_input = Integer.valueOf(sugar_amt.getText());
                if((sugar_input * sugar_price) <= ui.getMoney()){
                    ui.setSugar(ui.getSugar() + sugar_input);
                    ui.setMoney(ui.getMoney() - (sugar_input * sugar_price));
                    updateSugar();
                }
            }
            
            cup_amt.clear();
            lemon_amt.clear();
            ice_amt.clear();
            sugar_amt.clear();
            
            updateMoney();
                
        });
    }
    
    public void updateMoney(){
        money.setText("Money: $" + ui.getMoney());
    }
    
    public void updateCups(){
        cups_owned.setText(ui.getCups() + " Cups");
    }
    
    public void updateLemons(){
        lemons_owned.setText(ui.getLemons() + " Lemons");
    }
   
    public void updateIce(){
        ice_owned.setText(ui.getIce() + " Ice");
    }
    
    public void updateSugar(){
        sugar_owned.setText(ui.getSugar() + " Sugar");
    }
    
}
