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
    TextField stand_name;
    UserInventory ui = UserInventory.getInstance();
    
    public SetupScreen(){
        super();
        layout.setPrefSize(Scaling.windowWidth(), Scaling.windowHeight());
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
        stand_name = formatTextField(100, 0, 120);
        
        
        layout.getChildren().addAll(title, prompt, stand_name, buttons);
    }
    
    public void drawButtons(){
        Button day7 = new Button("7 Day");
        day7.setOnAction(e->{
            ui.setName(stand_name.getText());
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
}
