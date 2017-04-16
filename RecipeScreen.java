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
import java.io.File;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.media.MediaPlayer.INDEFINITE;
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
    TextField lemons;
    TextField cups;
    TextField ice;
    TextField priceCup;
    
    
        
    
    VBox corner_info = new VBox();
    //Text title = new Text("RECIPE");
      
    
    public RecipeScreen(){
        super();
        
        layout.setPrefSize(Scaling.windowWidth(), Scaling.windowHeight());
        layout.setAlignment(Pos.TOP_CENTER);
    
        
        purchase.setPrefSize(Scaling.windowWidth(), Scaling.windowHeight());
        purchase.setAlignment(Pos.TOP_CENTER);
        
        drawText();
        drawButtons();
        
        recipe.getChildren().add(layout);
        
         //Opening music 
        
        String musicFile = "opening.wav";
        int s= INDEFINITE;
        Media sound= new Media(new File(musicFile).toURI().toString());
        
        MediaPlayer mp= new MediaPlayer(sound);
        
        mp.setVolume(0.5f);
        mp.setCycleCount(s);
        mp.play();
    }
    
    public Pane initScreen(){
        return recipe;
    }
    
    public void drawText(){
        //title.setTranslateY(50);
        //title.setFont(Font.font("Calibri", 50));
        ImageView title = new ImageView(new Image("file:resource/image/recipe-title.png", 250, 200, true, true));
        title.setTranslateY(30);
        
        Text subtitle1 = formatText("Lemons per pitcher:", 27, 200, 120);
        Text subtitle2 = formatText("Sugar per pitcher:", 27, 200, 130);
        Text subtitle3 = formatText("Ice per Cup:", 27, 200, 140);
        Text subtitle4 = formatText("Price per Cup:", 27, 200, 150);
            
         lemons= formatTextField(50, 200, 120);
         cups= formatTextField(50, 200, 130);
         ice= formatTextField(50, 200, 140);
         priceCup= formatTextField(50, 200, 150);
        
        Text subtitle9 = formatText("Lemons ",20, 485, 97);
        Text subtitle10= formatText("Cups",20, 460, 107);
        Text subtitle11 = formatText("Cubes ",20, 395, 117);
        Text subtitle12 = formatText("Cent",20, 415, 127);
        
        
        
        HBox lemon_box = new HBox();
        lemon_box.getChildren().addAll(subtitle1, lemons);
        
        HBox sugar_box = new HBox();
        sugar_box.getChildren().addAll(subtitle2, cups);
        
        HBox ice_box = new HBox();
        ice_box.getChildren().addAll(subtitle3, ice);
        
        HBox price_box = new HBox();
        price_box.getChildren().addAll(subtitle4, priceCup);
        
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
    //Do I have to do all of the possible combinations right???
     public void drawButtons()
     {
       Button begin_day = new Button ("Begin Day");
       begin_day.setTranslateY(200);
       
       begin_day.setOnAction(e-> {
           if(isNumericCharValid(lemons.getText()) && isNumericCharValid(cups.getText())
          && isNumericCharValid(ice.getText()) && isNumericCharValid(priceCup.getText())){
               ui.setRecipeLemons(Integer.valueOf(lemons.getText()));
               ui.setRecipeIce(Integer.valueOf(ice.getText()));
               ui.setRecipeSugar(Integer.valueOf(cups.getText()));
               ui.setPrice(Integer.valueOf(priceCup.getText()));
               
               ui.generateOptimalRecipe();
               ui.calculateDifference();
               ui.generateScore();
               
               ScreenSwapper.getInstance().setState(ScreenSwapper.STATE.GAME);
           }
       });
       
       
       purchase.getChildren().add(begin_day);
                
     }
     
     
     //Does not allow the user to continue if negative values are inputted or characters are inputted
    
    public boolean isNumericCharValid(String str)
    {
        if(str.length()<=0 || str.length()>3)
        {
            return false;
        }
        
        for(int i = 0; i < str.length(); i++)
        {
            if(Character.isAlphabetic(str.charAt(i))|| !Character.isDigit(str.charAt(i)))
            {
              return false;
              
            }
        }
       
       return true;
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