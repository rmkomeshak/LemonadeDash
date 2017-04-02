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
public class RecipeScreen extends Node{
    Pane recipe = new Pane();
    VBox layout = new VBox();
    VBox purchase = new VBox();
    HBox total = new HBox();
    HBox lemonInput= new HBox();
    
    VBox corner_info = new VBox();
    
    UserInventory ui = new UserInventory();
    
    Text title = new Text("RECIPE");
    
    
    
    public RecipeScreen(){
        super();
        
        layout.setPrefSize(800,600);
        layout.setAlignment(Pos.TOP_CENTER);
    
        
        purchase.setPrefSize(600,300);
        purchase.setAlignment(Pos.TOP_CENTER);
        
        corner_info.setPrefSize(800,600);
        corner_info.setAlignment(Pos.BOTTOM_LEFT);
        
        drawText();
        
        recipe.getChildren().add(layout);
    }
    
    public Pane initScreen(){
        return recipe;
    }
    
    public void drawText(){
        title.setTranslateY(50);
        title.setFont(Font.font("Calibri", 50));
        
        Text subtitle1 = formatText("Lemons per pitcher: ", "Calibri",15, 0, 120);
        Text subtitle2 = formatText("Sugar per pitcher:", "Calibri", 15, 0, 130);
        Text subtitle3 = formatText("Ice per Cup:", "Calibri", 15, 0, 140);
        Text subtitle4 = formatText("Price per Cup:", "Calibri", 15, 0, 150);
            
        TextField subtitle5= formatTextField(5, 30, 60);
        TextField subtitle6= formatTextField(5, 30, 70);
        TextField subtitle7= formatTextField(5, 30, 80);
        TextField subtitle8= formatTextField(5, 30, 90);
        Text subtitle9 = formatText("Lemons ", "Calibri",5, 35, 120);
        Text subtitle10= formatText("Cups", "Calibri",5, 35, 120);
        Text subtitle11 = formatText("Cubes ", "Calibri",5, 35, 120);
        Text subtitle12 = formatText("Cent", "Calibri",5, 35, 120);
        
        Text money = formatText(("Money: $" + ui.getMoney()), "Calibri", 15, -350, 200);
        
        purchase.getChildren().add(subtitle1);
        purchase.getChildren().add(subtitle2);
        purchase.getChildren().add(subtitle3);
        purchase.getChildren().add(subtitle4);
        purchase.getChildren().add(subtitle5);
        purchase.getChildren().add(subtitle6);
        purchase.getChildren().add(subtitle7);
       
        
        total.getChildren().addAll(purchase);
        layout.getChildren().addAll(title, total, money);
        
        
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