package App;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MyPanel extends JPanel implements ActionListener{

    ArrayList<String> courseNames;
    ArrayList<Integer> courseCredits;
    ArrayList<Double> courseGrades;
    Thread thread;
    JLabel nameLabel;
    JLabel creditLabel;
    JLabel gradeLabel;
    JTextField nameField;
    JTextField creditField;
    JTextField gradeField;
    JButton addCourseButton;
    JButton resetButton;
    JLabel message;

    DisplayPanel displayPanel;

    double result = 0;
    int tempInt = 0;
    double tempDouble = 0;

    MyPanel(DisplayPanel displayPanel) {

        this.displayPanel = displayPanel;

        message = new JLabel();
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setFont(new Font("Helvetica Neue", Font.PLAIN, 35));
        message.setForeground(new Color(0xA1683A));
        message.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        courseNames = new ArrayList();
        courseCredits = new ArrayList();
        courseGrades = new ArrayList();

        nameLabel = new JLabel();
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setText("Course Name");
        nameLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        nameLabel.setForeground(new Color(0xA1683A));
        nameLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(300,30));
        nameField.setMaximumSize(nameField.getPreferredSize());

        creditLabel = new JLabel();
        creditLabel.setHorizontalAlignment(JLabel.CENTER);
        creditLabel.setText("Course Credits(ECTS)");
        creditLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        creditLabel.setForeground(new Color(0xA1683A));
        creditLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        creditField = new JTextField();
        creditField.setPreferredSize(new Dimension(300,30));
        creditField.setMaximumSize(creditField.getPreferredSize());

        gradeLabel = new JLabel();
        gradeLabel.setHorizontalAlignment(JLabel.CENTER);
        gradeLabel.setText("Your Grade");
        gradeLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        gradeLabel.setForeground(new Color(0xA1683A));
        gradeLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        gradeField = new JTextField();
        gradeField.setPreferredSize(new Dimension(300,30));
        gradeField.setMaximumSize(gradeField.getPreferredSize());


        resetButton = new JButton("Reset");
        resetButton.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        resetButton.addActionListener(this);
        addCourseButton = new JButton("Add Course");
        addCourseButton.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        addCourseButton.addActionListener(this);

        //spacing and adding the elements
        this.add(Box.createRigidArea(new Dimension(0,20)));
        this.add(nameLabel);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(nameField);
        this.add(Box.createRigidArea(new Dimension(0,20)));
        this.add(creditLabel);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(creditField);
        this.add(Box.createRigidArea(new Dimension(0,20)));
        this.add(gradeLabel);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(gradeField);
        this.add(Box.createRigidArea(new Dimension(0,20)));
        this.add(addCourseButton);
        this.add(Box.createRigidArea(new Dimension(0,5)));
        this.add(resetButton);
        this.add(Box.createRigidArea(new Dimension(0,30)));
        this.add(message);

        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(new Color(0xEED2CC));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    }

    //calculate the GPA
    public double calculateGPA(){
        for (Integer courseCredit : courseCredits) {
            tempInt += courseCredit;
        }
        for(int i = 0; i<courseGrades.size();i++){
            tempDouble += courseGrades.get(i) * courseCredits.get(i);
        }
        return tempDouble/tempInt;
    }

    @Override
    public void actionPerformed(ActionEvent e) throws NumberFormatException {

        if(e.getSource().equals(addCourseButton)){

            //add items from the textFields to lists
            String tempText = nameField.getText();
            int tempCredit = Integer.parseInt(creditField.getText());
            double tempGrade = Double.parseDouble(gradeField.getText());
            courseNames.add(tempText);
            courseCredits.add(tempCredit);
            courseGrades.add(tempGrade);

            //set textFields to empty
            nameField.setText("");
            creditField.setText("");
            gradeField.setText("");

            //display a message for 3 seconds
            thread = new Thread();
            thread.start();
            message.setText("Course Added Successfully!");
            Timer timer = new Timer(3000, a -> message.setText(null));
            timer.setRepeats(false);
            timer.start();

            //add to table panel
            displayPanel.setLabelText(courseNames,courseCredits,courseGrades,calculateGPA());
        }

        //clear the lists,text fields and the message
        //get rid of the table panel
        if(e.getSource().equals(resetButton)){
            courseNames.clear();
            courseGrades.clear();
            courseCredits.clear();
            tempDouble = 0;
            tempInt = 0;
            displayPanel.resetDisplay();
            nameField.setText("");
            creditField.setText("");
            gradeField.setText("");
            message.setText(null);
        }
    }
}
