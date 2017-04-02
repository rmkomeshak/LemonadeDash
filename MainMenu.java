
import java.awt.*;
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
public class MainMenu {
    
    private JFrame frame;
    private JLabel welcome;
    private JButton newGame, leaderboard, quit, options;
    
    public MainMenu() {
        
        frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(10, 50, 10, 50);
        
        welcome = new JLabel("Welcome to Lemonade Dash!");
        newGame = new JButton("New Game");
        leaderboard = new JButton("Leaderboard");
        quit = new JButton("Quit");
        options = new JButton("Options");
        
        gc.gridx = 0; gc.gridy = 0;
        frame.add(welcome, gc);
        
        gc.gridx = 0; gc.gridy=1;
        frame.add(newGame, gc);
        
        gc.gridx = 0; gc.gridy = 2;
        frame.add(leaderboard, gc);
        
        gc.gridx = 0; gc.gridy = 3;
        frame.add(options, gc);
        
        gc.gridx = 0; gc.gridy = 4;
        frame.add(quit, gc);
        
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                //new WhateverNextScreenWeWant();
            }
        });
        
        leaderboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Leaderboard();
            }
        });
        
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Options();
            }
        });
        
        
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
 
}
