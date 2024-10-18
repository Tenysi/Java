package com.idk;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JFrame 
{

    private JButton[][] Board = new JButton[3][3];
    private String player1 = "x";
    private String player2 = "o";
    private String currentPlayer = player1;

    private JPanel boardPanel;
    private JPanel winPanel;
    private JLabel winTxt;

    public static void main(String[] args) 
    {
        GameScreen();
    }

    public static void GameScreen() 
    {
        Game game = new Game();
        game.setupGame();
    }

    public void setupGame() 
    {
        JFrame tictactoe = new JFrame("GAME");
        JButton Back = new JButton("Back");
        boardPanel = new JPanel();
        winPanel = new JPanel();

        tictactoe.setLayout(null);
        tictactoe.setTitle("TicE TacO Toes");
        tictactoe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        tictactoe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tictactoe.setLocationRelativeTo(null);

        Back.setBounds(910, 100, 110, 60);
        Back.setFont(new Font("ComicSans", Font.PLAIN, 25));
        Back.addActionListener((ActionEvent arg0) -> 
        {
            new Main();
            tictactoe.setVisible(false);
        });

        tictactoe.add(Back);

        boardPanel.setLayout(new GridLayout(3, 3));
        boardPanel.setBackground(Color.darkGray);
        boardPanel.setBounds(610, 200, 700, 700);
        tictactoe.add(boardPanel);

        winPanel.setLayout(null);
        winPanel.setBackground(Color.green);
        winPanel.setBounds(610, 200, 700, 700);
        tictactoe.add(winPanel);
        winPanel.setVisible(false);

        winTxt = new JLabel((currentPlayer) + " wins!");
        winTxt.setBounds(150, 300, 400, 100);
        winTxt.setFont(new Font("ComicSans", Font.PLAIN, 50));
        winPanel.add(winTxt);

        tictactoe.setVisible(true);

        for (int r = 0; r < 3; r++) 
        {
            for (int c = 0; c < 3; c++) 
            {
                JButton Tile = new JButton();
                Board[r][c] = Tile;
                boardPanel.add(Tile);
                Tile.setFont(new Font("ComicSans", Font.PLAIN, 50));

                Tile.addActionListener((ActionEvent e) -> 
                {
                    if (Tile.getText().isEmpty()) 
                    {
                        Tile.setText(currentPlayer);
                        currentPlayer = currentPlayer.equals(player1) ? player2 : player1;

                        //do an r or c ++ so u can do each row and collumn
                        //vertical 
                        for (int i = 0; i < 3; i++) 
                        {
                            //vertical
                            if((Board[0][i].getText().equals("x")) && (Board[1][i].getText().equals("x")) && (Board[2][i].getText().equals("x")) || (Board[0][i].getText().equals("o")) && (Board[1][i].getText().equals("o")) && (Board[2][i].getText().equals("o")))
                            {
                                win();                      
                            }
                        }

                        for (int i = 0; i < 3; i++) 
                        {
                            //horizontal
                            if((Board[i][0].getText().equals("x")) && (Board[i][1].getText().equals("x")) && (Board[i][2].getText().equals("x")) || (Board[i][0].getText().equals("o")) && (Board[i][1].getText().equals("o")) && (Board[i][2].getText().equals("o")))
                            {
                                win();
                            }
                        }  

                        //diagonalley
                        if((Board[0][0].getText().equals("x")) && (Board[1][1].getText().equals("x")) && (Board[2][2].getText().equals("x")) || (Board[0][0].getText().equals("o")) && (Board[1][1].getText().equals("o")) && (Board[2][2].getText().equals("o")) ||
                        (Board[0][2].getText().equals("x")) && (Board[1][1].getText().equals("x")) && (Board[2][0].getText().equals("x")) || (Board[0][2].getText().equals("o")) && (Board[1][1].getText().equals("o")) && (Board[2][0].getText().equals("o")))
                        {
                            {
                                win();
                            } 
                        }
                    }
                });
            }
        }
    }

    private void win() {
        boardPanel.setVisible(false);
        winPanel.setVisible(true);
        winPanel.revalidate();
        winPanel.repaint();
    }
}
