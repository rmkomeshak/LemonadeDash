
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kmgauthier
 */
public class Options {
    
    private JFrame frame;
    private JLabel title, soundLabel, displayLabel;
    private JButton backButton, quit, saveSettings;
    
    public Options() {
        
        frame  = new JFrame("Options");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(10, 50, 10, 50);
        
        title = new JLabel("Options");
        soundLabel = new JLabel("Sound");
        displayLabel = new JLabel("Display");
        backButton = new JButton("Back");
        quit = new JButton("Quit");
        saveSettings = new JButton("Save Settings");
        
        gc.gridx = 0; gc.gridy = 0;
        frame.add(title, gc);
        
        gc.gridx = 0; gc.gridy = 1;
        frame.add(soundLabel, gc);
        
        gc.gridx = 0; gc.gridy = 2;
        frame.add(displayLabel, gc);
        
        gc.gridx = 0; gc.gridy = 3;
        frame.add(backButton, gc);
        
        gc.gridx = 1; gc.gridy = 3;
        frame.add(saveSettings, gc);
        
        gc.gridx = 2; gc.gridy = 3;
        frame.add(quit, gc);
        
        saveSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //call method to save the settings
                savePrompt(); //tells the user that settings were saved
                
            }
        });
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MainMenu();
            }
        });
        
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
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
                new Options();
            }
        });

        save.pack();
        save.setLocationRelativeTo(null);
        frame.setVisible(false);
        save.setVisible(true);
    }
}
