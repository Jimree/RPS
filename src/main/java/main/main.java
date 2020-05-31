package main;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

/**
 * This is the main class that has the whole program.
 * Simplicity in the lack of time was the key ingredient when designing.
 */

public class main {
    JFrame RPS;
    JButton Rock, Paper, Scissors;
    JTextField humanTF;
    JTextField compTF;
    JTextField counter;
    JPanel mainPanel;
    char hChoice = ' ';
    char cChoice = ' ';
    char[] cc = {'R', 'P', 'S'};
    int r3;
    int tie = 0;
    int computerwins = 0;
    int humanwins = 0;
    Random random = new Random();

    /**
     * This is the main game method which contains the creation
     * of GUI elements, and sets up the panel for the game to run on
     */
    public main() {

        RPS = new JFrame("Rock, Paper, Scissors");
        RPS.setSize(600, 600);
        Rock = new JButton();
        Rock.setFocusPainted(false);
        Image rockIcon = new ImageIcon(this.getClass().getResource("/rockicon.png")).getImage();
        Rock.setIcon(new ImageIcon(rockIcon));
        Paper = new JButton();
        Paper.setFocusPainted(false);
        Image paperIcon = new ImageIcon(this.getClass().getResource("/papericon.png")).getImage();
        Paper.setIcon(new ImageIcon(paperIcon));
        Scissors = new JButton();
        Scissors.setFocusPainted(false);
        Image scissorsIcon = new ImageIcon(this.getClass().getResource("/scissorsicon.png")).getImage();
        Scissors.setIcon(new ImageIcon(scissorsIcon));
        mainPanel = new JPanel();
        humanTF = new JTextField(20);
        humanTF.setEditable(false);
        compTF = new JTextField(20);
        compTF.setEditable(false);
        counter = new JTextField(30);
        counter.setEditable(false);

        /**
         * ActionListener for the Rock Button
         * listens for an action
         */
        Rock.addActionListener(new ActionListener() {
            /**
             * actionPerformed method, which detects whether an
             * action was preformed or not
             * @param e parameter is the performed action
             * Sets the textField according to the user's choice
             * and re-runs the play method
             */
            public void actionPerformed(ActionEvent e) {
                humanTF.setText("You Chose Rock");
                hChoice = 'R';
                play();
            }
        });

        /**
         * ActionListener for the Paper Button
         * listens for an action
         */
        Paper.addActionListener(new ActionListener() {
            /**
             * actionPerformed method, which detects whether an
             * action was preformed or not
             * @param e parameter is the performed action
             * Sets the textField according to the user's choice
             * and re-runs the play method
             */
            public void actionPerformed(ActionEvent e) {
                humanTF.setText("You Chose Paper");
                hChoice = 'P';
                play();
            }
        });

        /**
         * ActionListener for the Scissors Button
         * listens for an action
         */
        Scissors.addActionListener(new ActionListener() {
            /**
             * actionPerformed method, which detects whether an
             * action was preformed or not
             * @param e parameter is the performed action
             * Sets the textField according to the user's choice
             * and re-runs the play method
             */
            public void actionPerformed(ActionEvent e) {
                humanTF.setText("You Chose Scissors");
                hChoice = 'S';
                play();
            }
        });

        /**
         * Setting up Layout for the mainPanel and adding elements
         */
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(humanTF);
        mainPanel.add(compTF);
        mainPanel.add(counter);
        mainPanel.add(Rock);
        mainPanel.add(Paper);
        mainPanel.add(Scissors);
        RPS.getContentPane().add(mainPanel, BorderLayout.CENTER);
        RPS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RPS.pack();
        RPS.setVisible(true);
    }

    /**
     * Play method that contains the running part of the game itself
     * Takes the user's choice and generates a random choice for the computer
     */
    private void play() {
        r3 = random.nextInt(3);
        cChoice = cc[r3];

        switch (cChoice) {
            case 'R':
                compTF.setText("Computer Chose Rock");
                break;

            case 'P':
                compTF.setText("Computer Chose Paper");
                break;

            case 'S':
                compTF.setText("Computer Chose Scisssors");
                break;

        }
        /**
         * This part decides whether if the user won, the computer won or
         * if it's a tie game, and adds the score to the scoreboard
         */
        if (hChoice == cChoice) {
            tie++;
        }

        if (hChoice == 'R' && cChoice == 'S') {
            humanwins++;
        }

        if (hChoice == 'P' && cChoice == 'R') {
            humanwins++;
        }

        if (hChoice == 'S' && cChoice == 'P') {
            humanwins++;
        }

        if (cChoice == 'R' && hChoice == 'S') {
            computerwins++;
        }

        if (cChoice == 'P' && hChoice == 'R') {
            computerwins++;
        }

        if (cChoice == 'S' && hChoice == 'P') {
            computerwins++;
        }

        counter.setText("Ties =  " + tie + ",   Human Wins = " + humanwins + ",   Computer Wins = " + computerwins);

    }

    /**
     * Standard main method
     *
     * @param args
     */
    public static void main(String[] args) {
        main application = new main();
    }
}