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
public class RecipeScreen extends Screen{
    Pane recipe = new Pane();
    VBox layout = new VBox();
    VBox purchase = new VBox();
    HBox total = new HBox();
    HBox lemonInput= new HBox();
    
    VBox corner_info = new VBox();
    Text title = new Text("RECIPE");
    
    
    
    public RecipeScreen(){
        super();
        
        layout.setPrefSize(Scaling.windowWidth(), Scaling.windowHeight());
        layout.setAlignment(Pos.TOP_CENTER);
    
        
        purchase.setPrefSize(Scaling.windowWidth(), Scaling.windowHeight());
        purchase.setAlignment(Pos.TOP_CENTER);
        
        drawText();
        drawButtons();
        
        recipe.getChildren().add(layout);
    }
    
    public Pane initScreen(){
        return recipe;
    }
    
    public void drawText(){
        title.setTranslateY(50);
        title.setFont(Font.font("Calibri", 50));
        
        Text subtitle1 = formatText("Lemons per pitcher:", 27, 200, 120);
        Text subtitle2 = formatText("Sugar per pitcher:", 27, 200, 130);
        Text subtitle3 = formatText("Ice per Cup:", 27, 200, 140);
        Text subtitle4 = formatText("Price per Cup:", 27, 200, 150);
            
        TextField subtitle5= formatTextField(50, 200, 120);
        TextField subtitle6= formatTextField(50, 200, 130);
        TextField subtitle7= formatTextField(50, 200, 140);
        TextField subtitle8= formatTextField(50, 200, 150);
        
        Text subtitle9 = formatText("Lemons ",20, 485, 97);
        Text subtitle10= formatText("Cups",20, 460, 107);
        Text subtitle11 = formatText("Cubes ",20, 395, 117);
        Text subtitle12 = formatText("Cent",20, 415, 127);
        
        
        
        HBox lemon_box = new HBox();
        lemon_box.getChildren().addAll(subtitle1, subtitle5);
        
        HBox sugar_box = new HBox();
        sugar_box.getChildren().addAll(subtitle2, subtitle6);
        
        HBox ice_box = new HBox();
        ice_box.getChildren().addAll(subtitle3, subtitle7);
        
        HBox price_box = new HBox();
        price_box.getChildren().addAll(subtitle4, subtitle8);
        
        HBox lemons = new HBox();
        lemons.getChildren().addAll(subtitle9);
        
        HBox cups = new HBox();
        cups.getChildren().addAll(subtitle10);
        
        HBox cubes = new HBox();
        cubes.getChildren().addAll(subtitle11);
        
        HBox cent = new HBox();
        cent.getChildren().addAll(subtitle12);
       
        purchase.getChildren().addAll(lemon_box, lemons, sugar_box, cups, ice_box, cubes,  price_box, cent);
        layout.getChildren().addAll(title, purchase);
        
        
    }
    
     public void drawButtons()
     {
        Button begin_day = new Button ("Begin Day");
        begin_day.setTranslateY(200);
        purchase.getChildren().add(begin_day);
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
