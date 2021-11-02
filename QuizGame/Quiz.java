package QuizGame;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener {

    //create a string array containing all the questions
    String[] questions = {
            "What is the Name of the Coffee shop in Friends?",
            "What was the Turkish city of Istanbul called before 1930?",
            "What is the smallest planet in our solar system?",
            "What element is denoted by the chemical symbol in the periodic table?"
    };

    //create a string array array containing all possible answers for each question
    String[][] options = {
            {"Hard Rock", "New York Coffee", "Central Perk", "Starbucks"},
            {"Byzantium", "Kostantiniyye", "Islambol", "Constantinople"},
            {"Mercury", "Jupiter", "Venus", "Earth"},
            {"Scandium", "Tin", "Iron", "Gold"}
    };
    //create a char array containing correct answers for each question
    char[] answers = {'C', 'D', 'A', 'B'};

    char answer;
    int index;
    int correctGuesses = 0;
    double resultPercent;
    int totalQuestions = questions.length;
    int seconds = 10;

    //create frame
    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();

    //create buttons for options
    JButton buttonA = new JButton("A");
    JButton buttonB = new JButton("B");
    JButton buttonC = new JButton("C");
    JButton buttonD = new JButton("D");

    //create labels for options
    JLabel answerLabelA = new JLabel();
    JLabel answerLabelB = new JLabel();
    JLabel answerLabelC = new JLabel();
    JLabel answerLabelD = new JLabel();

    //create label for time
    JLabel timeLabel = new JLabel();

    //create label for seconds left
    JLabel secondsLeft = new JLabel();

    //create textField to display correct number of guesses
    JTextField correctGuessNumber = new JTextField();

    //create textField to display correct percentage of guesses
    JTextField correctGuessPercentage = new JTextField();

    //initialize a timer which will decrement seconds remaining by 1 every second,
    //and will display results, then move to next question if you run out of time
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            secondsLeft.setText(String.valueOf(seconds));
            if(seconds<=0){
                displayAnswers();
            }
        }
    });

    public Quiz() {

        //set up frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(0xF7F4F3));
        frame.setLayout(null);
        frame.setResizable(false);

        //set up text field
        textField.setBounds(0, 0, 650, 50);
        textField.setBackground(new Color(0x5B2333));
        textField.setForeground(new Color(0xFCFCFC));
        textField.setFont(new Font("Ariel", Font.PLAIN, 30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);

        //set up text area
        textArea.setBounds(0, 50, 650, 100);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(0x5B2333));
        textArea.setForeground(new Color(0xFCFCFC));
        textArea.setFont(new Font("Ariel", Font.PLAIN, 25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);

        //set up button A
        buttonA.setBounds(0, 150, 100, 100);
        buttonA.setFont(new Font("Ariel", Font.PLAIN, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        //set up button B
        buttonB.setBounds(0, 250, 100, 100);
        buttonB.setFont(new Font("Ariel", Font.PLAIN, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        //set up button C
        buttonC.setBounds(0, 350, 100, 100);
        buttonC.setFont(new Font("Ariel", Font.PLAIN, 35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        //set up button D
        buttonD.setBounds(0, 450, 100, 100);
        buttonD.setFont(new Font("Ariel", Font.PLAIN, 35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        //set up option label A
        answerLabelA.setBounds(125, 160, 300, 75);
        answerLabelA.setForeground(new Color(0X1D0B11));
        answerLabelA.setFont(new Font("Ariel", Font.PLAIN, 35));

        //set up option label B
        answerLabelB.setBounds(125, 260, 300, 75);
        answerLabelB.setForeground(new Color(0X1D0B11));
        answerLabelB.setFont(new Font("Ariel", Font.PLAIN, 35));

        //set up option label C
        answerLabelC.setBounds(125, 360, 300, 75);
        answerLabelC.setForeground(new Color(0X1D0B11));
        answerLabelC.setFont(new Font("Ariel", Font.PLAIN, 35));

        //set up option label D
        answerLabelD.setBounds(125, 460, 300, 75);
        answerLabelD.setForeground(new Color(0X1D0B11));
        answerLabelD.setFont(new Font("Ariel", Font.PLAIN, 35));

        //set up label for seconds left
        secondsLeft.setBounds(535, 510, 100, 100);
        secondsLeft.setForeground(new Color(0x5B2333));
        secondsLeft.setFont(new Font("Ariel", Font.PLAIN, 60));
        secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
        secondsLeft.setHorizontalAlignment(JTextField.CENTER);
        secondsLeft.setText(String.valueOf(seconds));

        //set up label for time
        timeLabel.setBounds(535, 475, 100, 25);
        timeLabel.setForeground(new Color(0x5B2333));
        timeLabel.setFont(new Font("Ariel", Font.BOLD, 20));
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        timeLabel.setText("Timer");

        //set up label for correct number of guesses
        correctGuessNumber.setBounds(225, 225, 200, 100);
        correctGuessNumber.setBackground(new Color(0x5B2333));
        correctGuessNumber.setForeground(new Color(0xFCFCFC));
        correctGuessNumber.setFont(new Font("Ariel", Font.PLAIN, 50));
        correctGuessNumber.setHorizontalAlignment(JTextField.CENTER);
        correctGuessNumber.setEditable(false);
        correctGuessNumber.setBorder(BorderFactory.createBevelBorder(1));

        //set up label for correct percentage of guesses
        correctGuessPercentage.setBounds(225, 325, 200, 100);
        correctGuessPercentage.setBackground(new Color(0x5B2333));
        correctGuessPercentage.setForeground(new Color(0xFCFCFC));
        correctGuessPercentage.setFont(new Font("Ariel", Font.PLAIN, 50));
        correctGuessPercentage.setHorizontalAlignment(JTextField.CENTER);
        correctGuessPercentage.setEditable(false);
        correctGuessPercentage.setBorder(BorderFactory.createBevelBorder(1));

        //add items to the frame
        frame.add(timeLabel);
        frame.add(secondsLeft);
        frame.add(answerLabelA);
        frame.add(answerLabelB);
        frame.add(answerLabelC);
        frame.add(answerLabelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textArea);
        frame.add(textField);
        frame.setVisible(true);

        //start quiz by calling next question method
        nextQuestion();
    }

    public void nextQuestion() {
        //if we run out of questions,call results method to display results
        //else, set text field to Question number,set text area to Question text,
        //set up option labels for that question,start the timer
        if (index >= totalQuestions) {
            results();
        } else {
            textField.setText("Question : " + (index + 1));
            textArea.setText(questions[index]);
            answerLabelA.setText(options[index][0]);
            answerLabelB.setText(options[index][1]);
            answerLabelC.setText(options[index][2]);
            answerLabelD.setText(options[index][3]);
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //when a button is clicked,first disable all the buttons
        //then check which button is pressed, if button pressed is correct
        //increment the number of correct guesses by 1
        //then call display answers method
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        if (e.getSource().equals(buttonA)) {
            answer = 'A';
            if (answer == answers[index]) {
                correctGuesses++;
            }
        }
        if (e.getSource().equals(buttonB)) {
            answer = 'B';
            if (answer == answers[index]) {
                correctGuesses++;
            }
        }
        if (e.getSource().equals(buttonC)) {
            answer = 'C';
            if (answer == answers[index]) {
                correctGuesses++;
            }
        }
        if (e.getSource().equals(buttonD)) {
            answer = 'D';
            if (answer == answers[index]) {
                correctGuesses++;
            }
        }
        displayAnswers();
    }

    public void displayAnswers() {
        //stop the timer,disable all buttons
        //change color of all wrong options to red
        //wait for 3 seconds, then set back option colors, set answer to an empty char,
        //set remaining time to 10, display updated remaining time and enable all buttons
        //then increment the index by 1 and call the next question method
        //to prevent the pause timer to repeating, use setRepeats(false)
        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        if (answer != 'A') {
            answerLabelA.setForeground(Color.red);
        }
        if (answer != 'B') {
            answerLabelB.setForeground(Color.red);
        }
        if (answer != 'C') {
            answerLabelC.setForeground(Color.red);
        }
        if (answer != 'D') {
            answerLabelD.setForeground(Color.red);
        }

        Timer pause = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerLabelA.setForeground(new Color(0X1D0B11));
                answerLabelB.setForeground(new Color(0X1D0B11));
                answerLabelC.setForeground(new Color(0X1D0B11));
                answerLabelD.setForeground(new Color(0X1D0B11));

                answer = ' ';
                seconds = 10;
                secondsLeft.setText(String.valueOf(seconds));

                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);

                index++;

                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }

    public void results() {
        //disable all buttons, calculate correct answers percentage
        //set all option labels, textField and textArea to an empty string
        //set correct guess number label to display the number of correct guesses / total questions
        //set correct guess percentage lage to display correct guess percentage %
        //add correct guess number label and correct guess percentage label to the frame
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        resultPercent = (correctGuesses/totalQuestions)*100;

        textField.setText("Results");
        textArea.setText("");
        answerLabelA.setText("");
        answerLabelB.setText("");
        answerLabelC.setText("");
        answerLabelD.setText("");
        correctGuessNumber.setText(correctGuesses + " / " + totalQuestions);
        correctGuessPercentage.setText(resultPercent + "%");

        frame.add(correctGuessPercentage);
        frame.add(correctGuessNumber);
    }
}
