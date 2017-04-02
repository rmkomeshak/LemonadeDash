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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Ryan
 */
public class StoreScreen extends Node{
    Pane store = new Pane();
    VBox layout = new VBox();
    VBox owned = new VBox();
    VBox purchase = new VBox();
    HBox total = new HBox();
    VBox corner_info = new VBox();
    
    UserInventory ui = new UserInventory();
    
    Text title = new Text("STORE");
    
    
    
    public StoreScreen(){
        super();
        
        layout.setPrefSize(800,600);
        layout.setAlignment(Pos.TOP_CENTER);
        
        owned.setPrefSize(600,300);
        owned.setAlignment(Pos.TOP_CENTER);
        
        purchase.setPrefSize(600,300);
        purchase.setAlignment(Pos.TOP_CENTER);
        
        corner_info.setPrefSize(800,600);
        corner_info.setAlignment(Pos.BOTTOM_LEFT);
        
        drawText();
        
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
        Text cups_owned = formatText((ui.getCups() + " Cups"), "Calibri", 15, 0, 120);
        Text lemons_owned = formatText((ui.getLemons() + " Lemons"), "Calibri", 15, 0, 130);
        Text sugar_owned = formatText((ui.getSugar() + " Sugar"), "Calibri", 15, 0, 140);
        Text ice_owned = formatText((ui.getIce() + " Ice Cubes"), "Calibri", 15, 0, 150);
        
        Text money = formatText(("Money: $" + ui.getMoney()), "Calibri", 15, -350, 200);
        
        owned.getChildren().addAll(subtitle1, cups_owned, lemons_owned, sugar_owned, ice_owned);
        purchase.getChildren().add(subtitle2);
        
        total.getChildren().addAll(owned, purchase);
        layout.getChildren().addAll(title, total, money);
        
        
    }
    
    
    public Text formatText(String text, String font, int size, int x, int y){
        Text temp = new Text(text);
        temp.setFont(Font.font(font, size));
        temp.setTranslateX(x);
        temp.setTranslateY(y);
        
        return temp;
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
