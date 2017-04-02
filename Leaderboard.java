
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class Leaderboard {
    
    private JFrame frame;
    private JLabel title;
    private JButton backButton, quit;
   
    public Leaderboard(){
        
        frame = new JFrame("Leaderboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(10, 50, 10, 50);
        
        title = new JLabel("High Scores");
        backButton = new JButton("Back");
        quit = new JButton("quit");
        
        gc.gridx = 0; gc.gridy = 0;
        frame.add(title, gc);
        
        gc.gridx = 0; gc.gridy = 2;
        frame.add(backButton, gc);
        
        gc.gridx = 1; gc.gridy = 2;
        frame.add(quit, gc);
        
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
}
