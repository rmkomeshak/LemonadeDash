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
    
        
        purchase.setPrefSize(800, 600);
        purchase.setAlignment(Pos.TOP_CENTER);
        
        drawText();
        
        recipe.getChildren().add(layout);
    }
    
    public Pane initScreen(){
        return recipe;
    }
    
    public void drawText(){
        title.setTranslateY(50);
        title.setFont(Font.font("Calibri", 50));
        
        Text subtitle1 = formatText("Lemons per pitcher: ", "Calibri",15, 200, 120);
        Text subtitle2 = formatText("Sugar per pitcher:", "Calibri", 15, 200, 130);
        Text subtitle3 = formatText("Ice per Cup:", "Calibri", 15, 200, 140);
        Text subtitle4 = formatText("Price per Cup:", "Calibri", 15, 200, 150);
            
        TextField subtitle5= formatTextField(50, 200, 120);
        TextField subtitle6= formatTextField(50, 200, 130);
        TextField subtitle7= formatTextField(50, 200, 140);
        TextField subtitle8= formatTextField(50, 200, 150);
        Text subtitle9 = formatText("Lemons ", "Calibri",5, 35, 120);
        Text subtitle10= formatText("Cups", "Calibri",5, 35, 120);
        Text subtitle11 = formatText("Cubes ", "Calibri",5, 35, 120);
        Text subtitle12 = formatText("Cent", "Calibri",5, 35, 120);
        
        HBox lemon_box = new HBox();
        lemon_box.getChildren().addAll(subtitle1, subtitle5);
        
        HBox sugar_box = new HBox();
        sugar_box.getChildren().addAll(subtitle2, subtitle6);
        
        HBox ice_box = new HBox();
        ice_box.getChildren().addAll(subtitle3, subtitle7);
        
        HBox price_box = new HBox();
        price_box.getChildren().addAll(subtitle4, subtitle8);
       
        purchase.getChildren().addAll(lemon_box, sugar_box, ice_box, price_box);
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