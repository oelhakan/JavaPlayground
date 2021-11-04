import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class MyPanel extends JPanel implements ActionListener{

    List<String> courseNames;
    List<Integer> courseCredits;
    List<Double> courseGrades;
    Thread thread;
    JLabel nameLabel;
    JLabel creditLabel;
    JLabel gradeLabel;
    JTextField nameField;
    JTextField creditField;
    JTextField gradeField;
    JButton calculateButton;
    JButton addCourseButton;
    JLabel message;

    MyPanel() {

        message = new JLabel();
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        message.setForeground(new Color(0x60993E));
        message.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        courseNames = new ArrayList();
        courseCredits = new ArrayList();
        courseGrades = new ArrayList();

        nameLabel = new JLabel();
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setText("Course Name");
        nameLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        nameLabel.setForeground(new Color(0xFAF3DD));
        nameLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(300,30));
        nameField.setMaximumSize(nameField.getPreferredSize());

        creditLabel = new JLabel();
        creditLabel.setHorizontalAlignment(JLabel.CENTER);
        creditLabel.setText("Course Credits(ECTS)");
        creditLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        creditLabel.setForeground(new Color(0xFAF3DD));
        creditLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        creditField = new JTextField();
        creditField.setPreferredSize(new Dimension(300,30));
        creditField.setMaximumSize(creditField.getPreferredSize());

        gradeLabel = new JLabel();
        gradeLabel.setHorizontalAlignment(JLabel.CENTER);
        gradeLabel.setText("Your Grade");
        gradeLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        gradeLabel.setForeground(new Color(0xFAF3DD));
        gradeLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        gradeField = new JTextField();
        gradeField.setPreferredSize(new Dimension(300,30));
        gradeField.setMaximumSize(gradeField.getPreferredSize());

        addCourseButton = new JButton("Add Course");
        addCourseButton.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        addCourseButton.addActionListener(this);
        calculateButton = new JButton("Calculate GPA");
        calculateButton.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        calculateButton.addActionListener(this);

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
        this.add(calculateButton);
        this.add(Box.createRigidArea(new Dimension(0,20)));
        this.add(message);


        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(new Color(0x5E6472));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    }

    public int getTotalCredits(){
        int temp = 0;
        for (Integer courseCredit : courseCredits) {
            temp += courseCredit;
        }
        return temp;
    }

    public double getGradeMulCredit(){
        double temp = 0;
        for(int i = 0; i<courseGrades.size();i++){
            temp += courseGrades.get(i) * courseCredits.get(i);
        }
        return temp;
    }

    @Override
    public void actionPerformed(ActionEvent e) throws NumberFormatException {

        if(e.getSource().equals(addCourseButton)){

            //add items from the textFields to lists
            courseNames.add(nameField.getText());
            courseCredits.add(Integer.parseInt(creditField.getText()));
            courseGrades.add(Double.parseDouble(gradeField.getText()));

            //set textFields to empty
            nameField.setText("");
            creditField.setText("");
            gradeField.setText("");

            //display a message for 3 seconds

            thread = new Thread();
            thread.start();
            message.setText("Course Added Successfully!");
            Timer timer = new Timer(2000, a -> message.setText(null));
            timer.setRepeats(false);
            timer.start();
        }

        if(e.getSource().equals(calculateButton)){
            double result = getGradeMulCredit()/getTotalCredits();
            message.setText(result + "");
            Timer timer = new Timer(10000, a -> {
                message.setText(null);
                System.exit(0);
            });
            timer.setRepeats(false);
            timer.start();
        }
    }
}
