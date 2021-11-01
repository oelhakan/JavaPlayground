package Playground.SwingGUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FrameLabel {
    public static void main(String[] args) {
        //JFrame = A GUI Window to add components to
        JFrame frame = new JFrame(); //creates a frame

        ImageIcon image = new ImageIcon("logo.png");    //create an ImageIcon
        frame.setIconImage(image.getImage());   //change icon of the frame
        frame.getContentPane().setBackground(Color.red);   //change background color

        Border border = BorderFactory.createLineBorder(Color.yellow, 3);

        JLabel label = new JLabel();    // create a label
        label.setText("A NEW LABEL");   //set text of label
        label.setIcon(image); //set icon of label
        label.setHorizontalTextPosition(JLabel.CENTER);// set text LEFT,CENTER,RIGHT of imageIcon
        label.setVerticalTextPosition(JLabel.TOP);  // set text BOTTOM,CENTER,TOP of imageIcon
        label.setForeground(new Color(0xFF5733));   //set font color of text
        label.setFont(new Font("Futura", Font.PLAIN, 20));  //set font of text
        label.setIconTextGap(-100);   //set gap of text to image
        label.setBackground(Color.white);   //set background color
        label.setOpaque(true);  //display background color
        label.setBorder(border);    //set border of the label
        label.setVerticalAlignment(JLabel.CENTER);  //set vertical position of icon+text within the frame
        label.setHorizontalAlignment(JLabel.LEFT);//set horizonal position of icon+text within the frame
//        label.setBounds(0,0,600,600); //set x,y position within the frame as well as dimensions

//        frame.setSize(1000,1000); //set the x and y dimensions of the frame
//        frame.setLayout(null);
        frame.setTitle("A NEW FRAME"); //sets the title frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        frame.setResizable(true);  //prevent frame from being resized
        frame.setVisible(true); //make the frame visible
        frame.add(label);
        frame.pack();
    }
}
