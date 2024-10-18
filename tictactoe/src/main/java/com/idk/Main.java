package com.idk;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame 
{

    // Constructor to set up the JFrame
    public Main() 
    {
        setLayout(null);
        // Set the title of the window
        setTitle("TicE TacO Toes");
        // Set the size of the window to max
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        // Terminates when closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Center the window on the screen
        setLocationRelativeTo(null);

        JLabel Title = new JLabel("Tic Tac Toe");
        Title.setBounds(860, 200, 400, 400);
        Title.setFont(new Font("ComicSans", Font.PLAIN, 40));
        add(Title);

        JButton Play = new JButton("Play");
        Play.setBounds(910, 550, 110, 60);
        Play.setFont(new Font("ComicSans", Font.PLAIN, 25));
        Play.addActionListener((ActionEvent arg0) -> {
            Game.GameScreen();
            setVisible(false);
        });
        add(Play);

        // Make the window visible after all components have been added
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}