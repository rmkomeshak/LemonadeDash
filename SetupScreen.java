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
import javafx.scene.text.Text;

/**
 *
 * @author asdas
 */
public class SetupScreen extends Screen{
    Pane setup = new Pane();
    VBox layout = new VBox();
    HBox buttons = new HBox();
    Text title;
    
    public SetupScreen(){
        super();
        layout.setPrefSize(800, 600);
        layout.setAlignment(Pos.TOP_CENTER);
        buttons.setTranslateY(200);
        drawText();
        drawButtons();
        setup.getChildren().addAll(layout);
    }
    
    public Pane initScreen(){
        return setup;
    }
    
    public void drawText(){
        title = formatText("SETUP", "Calibri", 50, 0, 50);
        Text prompt = formatText("Name your lemonade stand", "Calibri", 25, 0, 100);
        TextField stand_name = formatTextField(100, 0, 120);
        
        
        layout.getChildren().addAll(title, prompt, stand_name, buttons);
    }
    
    public void drawButtons(){
        Button day7 = new Button("7 Day");
        
        day7.setOnAction(e->{
            swapScene();
        });
        day7.setTranslateX(200);
        
        Button day14 = new Button("14 Days");
        
        day14.setOnAction(e->{
            swapScene();
        });
        
        day14.setTranslateX(300);
        
        Button day30 = new Button("30 Days");
        day30.setOnAction(e->{
            swapScene();
        });
        day30.setTranslateX(400);
        buttons.getChildren().addAll(day7, day14, day30);
    }
    
    
    public String swapScene(){
        return "invest";
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
