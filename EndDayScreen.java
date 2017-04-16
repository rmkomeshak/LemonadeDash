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
import javafx.geometry.Pos;

/**
 *
 * @author Colin
 */
public class EndDayScreen extends Node
{
   
    Pane report = new Pane();
    VBox layout = new VBox();
    VBox purchase = new VBox();  
    
    VBox corner_info = new VBox();
    
    UserInventory ui = new UserInventory();
    
    Text title = new Text("END OF DAY REPORT");
    
    
    
    
    public EndDayScreen(){
        super();
        
        layout.setPrefSize(800,600);
        layout.setAlignment(Pos.TOP_CENTER);
    
        
        purchase.setPrefSize(800, 600);
        purchase.setAlignment(Pos.TOP_CENTER);
        
        drawText();
        drawButtons();
        
        report.getChildren().add(layout);
        
        
    }
    
     public Pane initScreen(){
        return report;
    }
    
    public void drawText(){
        title.setTranslateY(50);
        title.setFont(Font.font("Calibri", 50));
        
        Text scoreText = formatText("Score:", "Calibri", 25, 0, 0);
        Text incomeText = formatText("Income: ", "Calibri",27, 200, 120);
        Text expensesText = formatText("Expenses:", "Calibri", 27, 200, 130);
        Text profitText = formatText("Profit:", "Calibri", 27, 200, 140);
        
        Text scoreValue = formatText("Temp", "Calibri", 20, 70, -21);
        Text incomeValue = formatText(Double.toString(ui.getMoney()) + " Temp", "Calibri", 20, 300, 97);
        Text expensesValue = formatText("Temp", "Calibri", 20, 312, 107);
        Text profitValue = formatText("Temp", "Calibri", 20, 275, 117);
        
        Text dayText = formatText("Day:", "Calibri", 25, 0, 150);
        Text moneyText = formatText("Money:", "Calibri", 25, 0, 150);
        Text weatherText = formatText("Weather:", "Calibri", 25, 0, 150);
        
        Text dayValue = formatText("Temp", "Calibri", 25, 51, 125);
        Text moneyValue = formatText("Temp", "Calibri", 25, 80, 125);
        Text weatherValue = formatText("Temp", "Calibri", 25, 100, 125);
         
        
        HBox income_box = new HBox();
        income_box.getChildren().addAll(incomeText);
        
        HBox expenses_box = new HBox();
        expenses_box.getChildren().addAll(expensesText);
        
        HBox profit_box = new HBox();
        profit_box.getChildren().addAll(profitText);
        
        HBox score_box = new HBox();
        score_box.getChildren().addAll(scoreText);
        
        HBox day_box = new HBox();
        day_box.getChildren().addAll(dayText);
        
        HBox money_box = new HBox();
        money_box.getChildren().addAll(moneyText);
        
        HBox weather_box = new HBox();
        weather_box.getChildren().addAll(weatherText);
        
        
        HBox income_value_box = new HBox();
        income_value_box.getChildren().addAll(incomeValue);
        
        HBox expenses_value_box = new HBox();
        expenses_value_box.getChildren().addAll(expensesValue);
        
        HBox profit_value_box = new HBox();
        profit_value_box.getChildren().addAll(profitValue);
        
         HBox score_value_box = new HBox();
         score_value_box.getChildren().addAll(scoreValue);
         
         HBox day_value_box = new HBox();
         day_value_box.getChildren().addAll(dayValue);
         
         HBox money_value_box = new HBox();
         money_value_box.getChildren().addAll(moneyValue);
         
         HBox weather_value_box = new HBox();
         weather_value_box.getChildren().addAll(weatherValue);
         
        
        
        
        purchase.getChildren().addAll(score_box, score_value_box, income_box, income_value_box, expenses_box,
                expenses_value_box, profit_box, profit_value_box, day_box, day_value_box, money_box, money_value_box,
                weather_box, weather_value_box);
        
        layout.getChildren().addAll(title, purchase);
        
        
    }
    
    
    
    public Text formatText(String text, String font, int size, int x, int y){
        Text temp = new Text(text);
        temp.setFont(Font.font(font, size));
        temp.setTranslateX(x);
        temp.setTranslateY(y);
        
        return temp;
    }
    
    public TextField formatTextField(int width, int x, int y){
       TextField tf = new TextField();
       tf.setPrefWidth(width);
       tf.setTranslateX(x);
       tf.setTranslateY(y);
       
       return tf;
    }
    
     public void drawButtons()
     {
        Button begin_next_day = new Button ("Begin Next Day");
        begin_next_day.setTranslateX(-25);
        begin_next_day.setTranslateY(100);
        
        begin_next_day.setOnAction(e-> {
            
            ui.setIncome(0.0);
            ui.setDay(ui.getDay() + 1);
            ui.setExpenses(0.0);
            
            /*(if ui.getDay() < ui.getDayLimit()){
                ScreenSwapper.getInstance().setState(ScreenSwapper.STATE.STORE);
            }*/
             
        });
        
        
        purchase.getChildren().add(begin_next_day);
     }
    
    
    @Override
    protected NGNode impl_createPeer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BaseBounds impl_computeGeomBounds(BaseBounds bounds, BaseTransform tx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean impl_computeContains(double localX, double localY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object impl_processMXNode(MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
