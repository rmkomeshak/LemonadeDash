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
import java.text.DecimalFormat;
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
import lemonadedash.ScreenSwapper.STATE;

/**
 *
 * @author Colin
 */
public class EndDayScreen extends Screen
{
   
    Pane report = new Pane();
    VBox layout = new VBox();
    VBox purchase = new VBox();  
    Button begin_next_day;
    
    VBox corner_info = new VBox();
    DecimalFormat df = new DecimalFormat("0.00##");
    Button main_menu = new Button("Main Menu");
    
    Text title = new Text("END OF DAY REPORT");
    
    
    
    
    public EndDayScreen(){
        super();
        
        layout.setPrefSize(800,600);
        layout.setAlignment(Pos.TOP_CENTER);
    
        main_menu.setTranslateX(75);
        main_menu.setTranslateY(120);
        
        purchase.setPrefSize(800, 600);
        purchase.setAlignment(Pos.TOP_CENTER);
        begin_next_day = new Button("Begin Next Day");
         main_menu.setOnAction(e->{
             ui.resetResources();
             ScreenSwapper.getInstance().goStore();
             ScreenSwapper.getInstance().setState(STATE.START);
         });
         
         System.out.println(ui.getDay());
         if(ui.getDay() > 1){
            main_menu.setVisible(false);
            begin_next_day.setVisible(true);
        }
        if(ui.getDay() == 1){
            begin_next_day.setVisible(false);
            main_menu.setVisible(true);
        }
         
         
        drawText();
        drawButtons();
        
       
        report.getChildren().add(layout);
        
        
    }
    
     public Pane initScreen(){
        return report;
    }
    
    public void drawText(){
        title.setTranslateY(50);
        title.setTranslateX(200);
        title.setFont(Font.font("Calibri", 50));
        

        Text incomeText = formatText("Income: ", "Calibri",27, 400, 120);
        Text expensesText = formatText("Expenses:", "Calibri", 27, 400, 130);
        Text profitText = formatText("Profit:", "Calibri", 27, 400, 140);
        
        Text incomeValue = formatText(Double.toString(ui.getIncome()), "Calibri", 20, 520, 97);
        Text expensesValue = formatText(Double.toString(ui.getExpenses()), "Calibri", 20, 520, 107);
        
        double profit = (ui.getIncome() - ui.getExpenses());
        Text profitValue = formatText(Double.toString(profit), "Calibri", 20, 520, 117);
        
        Text dayText = formatText("Day:", "Calibri", 25, 400, 150);
        Text moneyText = formatText("Money:", "Calibri", 25, 400, 150);
        Text weatherText = formatText("Weather:", "Calibri", 25, 400, 150);
        Text dayValue = formatText(String.valueOf(ui.getDay()), "Calibri", 25, 520, 125);
        Text moneyValue = formatText("$" + df.format(ui.getMoney()), "Calibri", 25, 520, 125);
        Text weatherValue = formatText("Sunny", "Calibri", 25, 520, 125);
         
        
        HBox income_box = new HBox();
        income_box.getChildren().addAll(incomeText);
        
        HBox expenses_box = new HBox();
        expenses_box.getChildren().addAll(expensesText);
        
        HBox profit_box = new HBox();
        profit_box.getChildren().addAll(profitText);
        
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
        
         
         HBox day_value_box = new HBox();
         day_value_box.getChildren().addAll(dayValue);
         
         HBox money_value_box = new HBox();
         money_value_box.getChildren().addAll(moneyValue);
         
         HBox weather_value_box = new HBox();
         weather_value_box.getChildren().addAll(weatherValue);
         
        
        
        
        purchase.getChildren().addAll(income_box, income_value_box, expenses_box,
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
        begin_next_day.setTranslateX(75);
        begin_next_day.setTranslateY(150);
        
        begin_next_day.setOnAction(e-> {
            
            ui.setIncome(0.0);
            ui.setDay(ui.getDay() - 1);
            ui.setExpenses(0.0);
                ScreenSwapper.getInstance().goStore();
                ScreenSwapper.getInstance().setState(STATE.STORE);
                
                
            /*(if ui.getDay() < ui.getDayLimit()){
                ScreenSwapper.getInstance().setState(ScreenSwapper.STATE.STORE);
            }*/
             
        });
        
        purchase.getChildren().add(begin_next_day);
        purchase.getChildren().add(main_menu);
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
