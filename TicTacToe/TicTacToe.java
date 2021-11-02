package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TicTacToe() {
        //set up the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(0x2F2F2F));
        frame.setLayout(new BorderLayout());

        //set up the textField
        textField.setBackground(new Color(0x525252));
        textField.setForeground(Color.white);
        textField.setFont(new Font("Graphik", Font.PLAIN, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic Tac Toe");
        textField.setOpaque(true);

        //set up the title panel
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        //add textField to title panel
        title_panel.add(textField);

        //set up button panel
        button_panel.setLayout(new GridLayout(3, 3));

        /* instantiate each element of the buttons list to new JButtons and set up buttons */
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Graphik", Font.PLAIN, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
        frame.setVisible(true);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //if the button is pressed, if the button pressed is empty, set text of button to players sign,
        //skip players turn and check for winning conditions
        for (JButton button : buttons) {
            if (e.getSource().equals(button)) {
                if (player1_turn) {
                    if (button.getText().equals("")) {
                        button.setForeground(Color.red);
                        button.setText("X");
                        player1_turn = false;
                        textField.setText("O's Turn");
                        check();
                    }
                } else {
                    if (button.getText().equals("")) {
                        button.setForeground(Color.green);
                        button.setText("O");
                        player1_turn = true;
                        textField.setText("X's Turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() {

        //Show the tic-tac-toe title for 2 seconds before showing whose turn it is
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //generate a random integer between 0 and 1 inclusive
        //if it's 1 then its player 1's turn, else it's player 2's turn
        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textField.setText("X's Turn");
        } else {
            player1_turn = false;
            textField.setText("O's Turn");
        }
    }

    public void check() {
        //check X's win conditions
        if ((buttons[0].getText().equals("X")) && (buttons[1].getText().equals("X")) && (buttons[2].getText().equals("X"))) {
            xWins(0,1,2);
        }
        if ((buttons[3].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[5].getText().equals("X"))) {
            xWins(3,4,5);
        }
        if ((buttons[6].getText().equals("X")) && (buttons[7].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWins(6,7,8);
        }
        if ((buttons[0].getText().equals("X")) && (buttons[3].getText().equals("X")) && (buttons[6].getText().equals("X"))) {
            xWins(0,3,6);
        }
        if ((buttons[1].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[7].getText().equals("X"))) {
            xWins(1,4,7);
        }
        if ((buttons[2].getText().equals("X")) && (buttons[5].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWins(2,5,8);
        }
        if ((buttons[0].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWins(0,4,8);
        }
        if ((buttons[2].getText().equals("X")) && (buttons[5].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWins(2,5,8);
        }
        if ((buttons[2].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[6].getText().equals("X"))) {
            xWins(2,4,6);
        }

        //check O's win conditions
        if ((buttons[0].getText().equals("O")) && (buttons[1].getText().equals("O")) && (buttons[2].getText().equals("O"))) {
            oWins(0,1,2);
        }
        if ((buttons[3].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[5].getText().equals("O"))) {
            oWins(3,4,5);
        }
        if ((buttons[6].getText().equals("O")) && (buttons[7].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWins(6,7,8);
        }
        if ((buttons[0].getText().equals("O")) && (buttons[3].getText().equals("O")) && (buttons[6].getText().equals("O"))) {
            oWins(0,3,6);
        }
        if ((buttons[1].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[7].getText().equals("O"))) {
            oWins(1,4,7);
        }
        if ((buttons[2].getText().equals("O")) && (buttons[5].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWins(2,5,8);
        }
        if ((buttons[0].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWins(0,4,8);
        }
        if ((buttons[2].getText().equals("O")) && (buttons[5].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWins(2,5,8);
        }
        if ((buttons[2].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[6].getText().equals("O"))) {
            oWins(2,4,6);
        }
    }
    //highlight the winning buttons, disable all buttons, then set textField to the winner
    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.yellow);
        buttons[b].setBackground(Color.yellow);
        buttons[c].setBackground(Color.yellow);

        buttons[a].setOpaque(true);
        buttons[b].setOpaque(true);
        buttons[c].setOpaque(true);

        for (JButton button : buttons) {
            button.setEnabled(false);
        }

        textField.setText("X Wins");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.yellow);
        buttons[b].setBackground(Color.yellow);
        buttons[c].setBackground(Color.yellow);

        buttons[a].setOpaque(true);
        buttons[b].setOpaque(true);
        buttons[c].setOpaque(true);

        for (JButton button : buttons) {
            button.setEnabled(false);
        }

        textField.setText("O Wins");
    }
}
