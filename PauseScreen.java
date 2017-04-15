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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Sagun
 */
public class PauseScreen extends Screen

{
    Pane pause = new Pane();
    VBox layout = new VBox();
    VBox corner_info = new VBox();
        
    
    public PauseScreen(){
        super();
        
        layout.setPrefSize(Scaling.windowWidth(), Scaling.windowHeight());
        layout.setAlignment(Pos.TOP_CENTER);
    
        drawText();
        drawButtons();
        
        pause.getChildren().add(layout);
    }
    
    public Pane initScreen(){
        return pause;
    }
    
    public void drawText(){

        ImageView title = new ImageView(new Image("file:resource/image/recipe-title.png", 250, 200, true, true));
        title.setTranslateY(30);
        
    }

     public void drawButtons()
     {
           Button resume= new Button ("Resume");
           resume.setTranslateY(120);
           
           layout.getChildren().add(resume);
           Button graphics= new Button ("Graphics");
           graphics.setTranslateY(150);
           
           layout.getChildren().add(graphics);
           Button sound= new Button ("Sound");
           
           sound.setTranslateY(180);
           layout.getChildren().add(sound);
           
           Button quit= new Button ("Quit");
           quit.setTranslateY(210);
           layout.getChildren().add(quit);
           
           
           quit.setOnAction(e->{
           System.exit(0);
        
           
           });
        
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
