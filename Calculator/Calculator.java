package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subtractButton, multiplyButton, divideButton, decimalButton, equalsButton, deleteButton, clearButton, negativeButton;
    JPanel panel;

    Font font = new Font("Avenir Next", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public Calculator() {

        //instantiate the frame,set default close operation,size,layout,locationRelativeTo
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        //instantiate the text field, set bounds,font and editable
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(font);
        textField.setEditable(false);

        //instantiate the buttons
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        decimalButton = new JButton(".");
        equalsButton = new JButton("=");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        negativeButton = new JButton("(-)");

        //add buttons to the functionButtons array
        functionButtons[0] = addButton;
        functionButtons[1] = subtractButton;
        functionButtons[2] = multiplyButton;
        functionButtons[3] = divideButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalsButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = clearButton;
        functionButtons[8] = negativeButton;

        //add an action listener, set font and focusable for each element of functionButtons
        for (JButton functionButton : functionButtons) {
            functionButton.addActionListener(this);
            functionButton.setFont(font);
            functionButton.setFocusable(false);
        }

        //instantiate each element of the numberButtons array to the value of index number,
        //then add an action listener, set font and focusable for each element of numberButtons
        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);
        }

        //these three function buttons will not be on our panel's grid layout, so set the bounds for them individually
        negativeButton.setBounds(50, 430, 100, 50);
        deleteButton.setBounds(150, 430, 100, 50);
        clearButton.setBounds(250, 430, 100, 50);


        //instantiate the panel, set bounds,layout
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        //add the buttons to the grid layout panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subtractButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplyButton);
        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(equalsButton);
        panel.add(divideButton);

        //add the elements to the frame then set its visibility to true
        frame.add(panel);
        frame.add(negativeButton);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //for each number button pressed, concat text on the text field with the value of the number button which is pressed
        for (int i = 0; i < numberButtons.length; i++) {
            if (e.getSource().equals(numberButtons[i])) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        //when decimal operator is pressed, concat the text on the textField with a dot
        if (e.getSource().equals(decimalButton)) {
            textField.getText().concat(".");
        }
        //when add button is pressed, set number 1 to the value on the text field
        //set the operator to + and set the text field to an empty string
        if (e.getSource().equals(addButton)) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        //when subtract button is pressed, set number 1 to the value on the text field
        //set the operator to - and set the text field to an empty string
        if (e.getSource().equals(subtractButton)) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        //when multiply button is pressed, set number 1 to the value on the text field
        //set the operator to * and set the text field to an empty string
        if (e.getSource().equals(multiplyButton)) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        //when divide button is pressed, set number 1 to the value on the text field
        //set the operator to / and set the text field to an empty string
        if (e.getSource().equals(divideButton)) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        //when the equal button is pressed, set number 2 to the value on the text field
        //then perform an operation depending on the operator, set textFields value to the result
        //and set number 1 to the result so that we can keep using operations on the result given.
        if (e.getSource().equals(equalsButton)) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        //when clear button is pressed, clear all the text on the textField
        if (e.getSource().equals(clearButton)) {
            textField.setText("");
        }
        /* when clear button is pressed, clear last index of the text on the textField */
        if (e.getSource().equals(deleteButton)) {
           String string = textField.getText();
           textField.setText("");
           for(int i =0;i<string.length()-1;i++){
                textField.setText(textField.getText() + string.charAt(i));
           }
        }
        //when negative button is pressed, store the value on the text field on a temp variable
        //multiply by -1 to flip the sign, then set the value of the textField to the flipped value.
        if (e.getSource().equals(negativeButton)) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}
