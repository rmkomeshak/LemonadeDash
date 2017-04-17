package lemonadedash;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import java.text.DecimalFormat;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
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
    private Pane store = new Pane();
    private VBox layout = new VBox();
    private VBox owned = new VBox();
    private VBox purchase = new VBox();
    private HBox total = new HBox();
    private VBox corner_info = new VBox();
    private ImageView title = new ImageView();
    double expenses = 0;
    private TextField cup_amt, lemon_amt, ice_amt, sugar_amt;
    Text cups_owned, ice_owned, sugar_owned, lemons_owned, money;
    DecimalFormat df = new DecimalFormat("0.00##");
    
    double cup_price = 0.1;
    double lemon_price = 0.5;
    double sugar_price = 0.5;
    double ice_price = 0.01;
    
    int cup_input, lemon_input, sugar_input, ice_input;
    //Text title = new Text("STORE");
    
    
    public StoreScreen(){
        super();
        //store.setId("pane");
        //store.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        title.setImage(new Image("file:resource/image/store-title.png", 200, 100, true, true));
        layout.setPrefSize(Scaling.windowWidth(), Scaling.windowHeight());
        layout.setAlignment(Pos.TOP_CENTER);
        ui.setExpenses(0);
        
        owned.setPrefSize(Scaling.windowWidth(), Scaling.windowHeight());
        owned.setAlignment(Pos.TOP_CENTER);
        
        purchase.setPrefSize(Scaling.windowWidth(), Scaling.windowHeight());
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
        //title.setFont(Font.font("Calibri", 50));
        
        Text subtitle1 = formatText("Owned", 25, 0, 100);
        Text subtitle2 = formatText("Purchase", 25, 0, 100);
        
        cups_owned = formatText((ui.getCups() + " Cups"), 15, 0, 120);
        lemons_owned = formatText((ui.getLemons() + " Lemons"), 15, 0, 130);
        sugar_owned = formatText((ui.getSugar() + " Sugar"), 15, 0, 140);
        ice_owned = formatText((ui.getIce() + " Ice Cubes"), 15, 0, 150);
        
        HBox cups_purchase = new HBox();
        HBox lemons_purchase = new HBox();
        HBox sugar_purchase = new HBox();
        HBox ice_purchase = new HBox();
        
        cup_amt = formatTextField(50, 100, 120);
        lemon_amt = formatTextField(50, 100, 120);
        sugar_amt = formatTextField(50, 100, 120);
        ice_amt = formatTextField(50, 100, 120);
        
        Text cup_cost = formatText("  Cups ($0.10/each)", 15, 100, 120);
        Text lemon_cost = formatText("  Lemons ($0.50/each)", 15, 100, 120);
        Text sugar_cost = formatText("  Sugar ($0.50/each)", 15, 100, 120);
        Text ice_cost = formatText("  Ice ($0.01/each)", 15, 100, 120);
        
        
        cups_purchase.getChildren().addAll(cup_amt, cup_cost);
        lemons_purchase.getChildren().addAll(lemon_amt, lemon_cost);
        sugar_purchase.getChildren().addAll(sugar_amt, sugar_cost);
        ice_purchase.getChildren().addAll(ice_amt, ice_cost);
        
        
        money = formatText(("Money: $" + df.format(ui.getMoney())), 15, -350, 0);
        
        owned.getChildren().addAll(subtitle1, cups_owned, lemons_owned, sugar_owned, ice_owned);
        purchase.getChildren().addAll(subtitle2, cups_purchase, lemons_purchase, sugar_purchase, ice_purchase);
        
        total.getChildren().addAll(owned, purchase);
        layout.getChildren().addAll(title, total, money);
    }
    
    public void drawButtons(){
        Button buy = new Button("Buy");
        Button next = new Button("Next");
        buy.setId("record-sales");
        buy.setTranslateY(150);
        purchase.getChildren().add(buy);
        layout.getChildren().add(next);
        
        next.setTranslateY(-100);
        next.setOnAction(e->{
            ScreenSwapper.getInstance().setState(ScreenSwapper.STATE.RECIPE);
        });
        //TODO: LIMIT INPUT: NO CHARACTERS, NO STRINGS, NO NEGATIVES 
        buy.setOnAction(e -> {
            
            
            System.out.println(ui.getName());
            if(!cup_amt.getText().isEmpty() && isNumericCharValid(cup_amt.getText()))
            
            {
                cup_input = Integer.valueOf(cup_amt.getText());
                if((cup_input * cup_price) <= ui.getMoney() && cup_input>=0){
                    ui.setCups(ui.getCups() + cup_input);
                    //ui.setExpenses(cup_input * cup_price);
                    ui.setMoney(ui.getMoney() - (cup_input * cup_price));
                    updateCups();
                }
            }
            
            if(!lemon_amt.getText().isEmpty()&&isNumericCharValid(lemon_amt.getText()))
            {
                lemon_input = Integer.valueOf(lemon_amt.getText());
                if((lemon_input * lemon_price) <= ui.getMoney()&&lemon_input>=0){
                    ui.setLemons(ui.getLemons() + lemon_input);
                    //ui.setExpenses(lemon_input * lemon_price);
                    ui.setMoney(ui.getMoney() - (lemon_input * lemon_price));
                    updateLemons();
                }
            }
                
            if(!ice_amt.getText().isEmpty() && isNumericCharValid(ice_amt.getText())){
                ice_input = Integer.valueOf(ice_amt.getText());
                if((ice_input * ice_price) <= ui.getMoney() &&ice_input>=0){
                    ui.setIce(ui.getIce() + ice_input);
                    //ui.setExpenses(ice_input * ice_price);
                    ui.setMoney(ui.getMoney() - (ice_input * ice_price));
                    updateIce();
                }
            }
            if(!sugar_amt.getText().isEmpty()&& isNumericCharValid(sugar_amt.getText())){
                sugar_input = Integer.valueOf(sugar_amt.getText());
                if((sugar_input * sugar_price) <= ui.getMoney()&&sugar_input>=0){
                    ui.setSugar(ui.getSugar() + sugar_input);
                    //ui.setExpenses(sugar_input * sugar_price);
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
        money.setText("Money: $" + df.format(ui.getMoney()));
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
    
    //Does not allow the user to continue if negative values are inputted 
    
       //Does not allow the user to continue if negative values are inputted or characters/ special characters  are inputted
    
    public boolean isNumericCharValid(String str)
    {
        if(str.length()<=0 || str.length()>3)
        {
            return false;
        }
        
        for(int i = 0; i < str.length(); i++)
        {
            if(Character.isAlphabetic(str.charAt(i))|| !Character.isDigit(str.charAt(i)))
            {
              return false;
              
            }
        }
       
       return true;
        }
    
}
