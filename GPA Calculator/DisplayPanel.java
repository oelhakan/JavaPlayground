package App;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DisplayPanel extends JPanel {

    JLabel coursesLabel;
    JLabel headerLabel;
    JLabel gpaLabel;
    StringBuilder sb;

    public DisplayPanel() {

        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(new Color(0xEED2CC));

        gpaLabel = new JLabel();
        gpaLabel.setHorizontalAlignment(JLabel.CENTER);
        gpaLabel.setVerticalAlignment(JLabel.BOTTOM);
        gpaLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        gpaLabel.setForeground(new Color(0xA1683A));
        gpaLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        
        coursesLabel = new JLabel();
        coursesLabel.setHorizontalAlignment(JLabel.LEFT);
        coursesLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        coursesLabel.setForeground(new Color(0xA1683A));
        coursesLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        headerLabel = new JLabel();
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        headerLabel.setVerticalAlignment(JLabel.TOP);
        headerLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        headerLabel.setForeground(new Color(0xA1683A));
        headerLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        this.add(headerLabel);
        this.add(coursesLabel);
        this.add(gpaLabel);
        headerLabel.setText("|Course Name|\t|Course Credits|\t|Your Grade|");
    }

    public void resetDisplay(){
        sb.setLength(0);
        coursesLabel.setText(sb.toString());
    }

    public void setLabelText(ArrayList<String> courseNames, ArrayList<Integer> courseCredits, ArrayList<Double> courseGrades, double gpa) {
        sb = new StringBuilder();

        for(String name : courseNames){
            sb.append("<br/>|" +name + "|\t|" + courseCredits.get(courseNames.indexOf(name)) + "|\t|" + courseGrades.get(courseNames.indexOf(name)) + "|");
        }
        sb.append("<br/><br/>Your Current GPA Is : " + gpa);
        coursesLabel.setText("<html>" +sb + "</html>");
    }
}
