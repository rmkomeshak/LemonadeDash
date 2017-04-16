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
public class EndGameScreen extends Node
{
   
    Pane report = new Pane();
    VBox layout = new VBox();
    VBox purchase = new VBox();  
    
    VBox corner_info = new VBox();
    
    UserInventory ui = new UserInventory();
    
    Text title = new Text("END OF PERIOD REPORT");
    
    
    
    
    public EndGameScreen(){
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
        
        Text scoreValue = formatText(Double.toString(ui.getScore()), "Calibri", 20, 70, -21);
        Text incomeValue = formatText(Double.toString(ui.getMoney()), "Calibri", 20, 300, 97);
        Text expensesValue = formatText(Double.toString(ui.getExpenses()), "Calibri", 20, 312, 107);
        
        double profit = (ui.getIncome() - ui.getExpenses());
        Text profitValue = formatText(Double.toString(profit), "Calibri", 20, 275, 117);
        

        HBox income_box = new HBox();
        income_box.getChildren().addAll(incomeText);
        
        HBox expenses_box = new HBox();
        expenses_box.getChildren().addAll(expensesText);
        
        HBox profit_box = new HBox();
        profit_box.getChildren().addAll(profitText);
        
        HBox score_box = new HBox();
        score_box.getChildren().addAll(scoreText);
        
        
        HBox income_value_box = new HBox();
        income_value_box.getChildren().addAll(incomeValue);
        
        HBox expenses_value_box = new HBox();
        expenses_value_box.getChildren().addAll(expensesValue);
        
        HBox profit_value_box = new HBox();
        profit_value_box.getChildren().addAll(profitValue);
        
         HBox score_value_box = new HBox();
         score_value_box.getChildren().addAll(scoreValue);
         
         
        
        
        
        purchase.getChildren().addAll(score_box, score_value_box, income_box, income_value_box, expenses_box,
                expenses_value_box, profit_box, profit_value_box);
        
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
        Button end_game = new Button ("Return To Menu");
       // begin_next_day.setTranslateX(-25);
        end_game.setTranslateY(200);
        
        end_game.setOnAction(e-> {
            
            ui.setIncome(0.0);
            ui.setDay(ui.getDay() + 1);
            ui.setExpenses(0.0);
            
           
            ScreenSwapper.getInstance().setState(ScreenSwapper.STATE.START);
            
             
        });
        
        purchase.getChildren().add(end_game);
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
