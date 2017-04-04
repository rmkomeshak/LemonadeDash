package lemonadedash;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kmgauthier
 */
public class OptionsScreen extends Screen {
    private Pane pane;
    private GridPane gpane;
    
    private Button back, quit, saveSettings;
    private Label soundLabel, displayLabel; //header;
    
    public Pane initScreen(){
         //????
         return gpane;
     }
    
    public OptionsScreen(){
        super();
        
        //header = new Label("Options");
        back = new Button("Back");
        quit = new Button("Quit");
        saveSettings = new Button("Save Settings");
        soundLabel = new Label("Sound");
        displayLabel = new Label("Display");
        
        pane= new Pane();
        gpane = new GridPane();
        gpane.setHgap(10);
        gpane.setVgap(10);
        gpane.setPadding(new javafx.geometry.Insets(0, 10, 0, 10));
        Text title = new Text("Options");
        
        gpane.add(title, 0, 0);
        //gpane.getChildren().add(header);
        gpane.add(back, 3, 0);
        gpane.add(quit, 3, 2);
        gpane.add(saveSettings, 3, 1);
        gpane.add(soundLabel, 1, 0);
        gpane.add(displayLabel, 2, 0);
        
        
        //gpane.setVisible(true);
        
        back.setOnAction(e->{
            //go to MainMenuScreen
            gpane.setVisible(false);
            new MainMenuScreen();
        });
        
        quit.setOnAction(e->{
            System.exit(0);
        });
        
        saveSettings.setOnAction(e->{
            //save the settings
            savePrompt(); //may need to edit the savePrompt method
        });
        
    }
    
        private void savePrompt() {
        JFrame save = new JFrame("Success");
        JButton ok = new JButton("OK");
        JLabel success = new JLabel("Your settings have been saved.");

        save.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        save.setLayout(new GridBagLayout());

        GridBagConstraints sc = new GridBagConstraints();
        sc.fill = GridBagConstraints.HORIZONTAL;
        sc.insets = new Insets(10, 2, 10, 2); //TOP, LEFT, BOTTOM, RIGHT

        sc.gridx = 0;
        sc.gridy = 0;
        save.add(success, sc);
        sc.gridx = 0;
        sc.gridy = 1;
        save.add(ok, sc);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save.setVisible(false);
                new OptionsScreen();
            }
        });

        save.pack();
        save.setLocationRelativeTo(null);
        gpane.setVisible(false);
        save.setVisible(true);
    }
    
}
