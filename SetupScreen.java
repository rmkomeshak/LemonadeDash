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
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author asdas
 */
public class SetupScreen extends Screen{
    GridPane setup = new GridPane();
    VBox layout = new VBox();
    HBox buttons = new HBox();
    ImageView title = new ImageView();
    TextField stand_name;
    
    public SetupScreen(){
        super();
        title.setImage(new Image("file:resource/image/setup-title.png", 200, 100, true, true));
        setup.setPrefSize(Scaling.windowWidth(), Scaling.windowHeight());
        setup.setAlignment(Pos.CENTER);
        setup.setHgap(10);
        setup.setVgap(10);
        setup.setPadding(new Insets(0, 10, 0, 10));
        layout.setPrefSize(Scaling.windowWidth(), Scaling.windowHeight());
        layout.setAlignment(Pos.CENTER);
        //buttons.setTranslateY(200);
        drawText();
        drawButtons();
        //setup.setAlignment(Pos.TOP_CENTER);
        //setup.getChildren().addAll(layout);
        //setup.add(title, 0, 0);
    }
    
    public Pane initScreen(){
        return setup;
    }
    
    public void drawText(){
        //title = formatText("\nSETUP", 50);
        Text prompt = formatText("\nName your lemonade stand", 25);
        title.setTranslateY(-100);
        prompt.setTranslateY(-75);
        stand_name = formatTextField(1, 0, 0);
        stand_name.setTranslateY(-75);
        
        setup.add(title, 1, 0);
        setup.setHalignment(title, HPos.CENTER);
        setup.setValignment(title, VPos.BOTTOM);
        setup.add(prompt, 1, 1);
        setup.setHalignment(prompt, HPos.CENTER);
        setup.add(stand_name, 1, 2);
        setup.setHalignment(stand_name, HPos.CENTER);
        
        //layout.getChildren().addAll(title, prompt, stand_name, buttons);
    }
    
    public void drawButtons(){
        Button day7 = new Button("7 Day");
        //day7.setTranslateX(200);
        day7.setOnAction(e->{
            buttonAction(7);
        });
        
        Button day14 = new Button("14 Days");
        //day14.setTranslateX(300);
        day14.setOnAction(e->{
            buttonAction(14);
        });
 
        Button day30 = new Button("30 Days");
        //day30.setTranslateX(400);
        day30.setOnAction(e->{
            buttonAction(30);
        });
        
        //buttons.getChildren().addAll(day7, day14, day30);
        setup.add(day7, 0, 4);
        setup.add(day14, 1, 4);
        setup.add(day30, 2, 4);
        setup.setHalignment(day7, HPos.CENTER);
        setup.setHalignment(day14, HPos.CENTER);
        setup.setHalignment(day30, HPos.CENTER);
    }
    
    
    public void buttonAction(int day){
        ui.setDay(day);
        ScreenSwapper.getInstance().setState(ScreenSwapper.STATE.STORE);
        ui.setName(stand_name.getText());
        stand_name.clear();
    }
}