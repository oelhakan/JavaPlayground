package Playground.SwingGUI;

import javax.swing.*;
import java.awt.*;

public class Panel {
    public static void main(String[] args) {
        //JPanel = A GUI component that functions as a container to hold other components
        ImageIcon icon = new ImageIcon("logo.png");
        JLabel label = new JLabel();
//        label.setVerticalTextPosition(JLabel.TOP);
//        label.setHorizontalTextPosition(JLabel.CENTER);
//        label.setText("Hi");
        label.setIcon(icon);
//        label.setVerticalAlignment(JLabel.BOTTOM);
//        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setBounds(100,50,150,150);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0, 0, 250, 250);
        redPanel.setLayout(null);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(250, 0, 250, 250);
        bluePanel.setLayout(null);

        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.yellow);
        yellowPanel.setBounds(0, 250, 500, 250);
        yellowPanel.setLayout(null);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(750, 750);
        yellowPanel.add(label);
        frame.add(redPanel);
        frame.add(bluePanel);
        frame.add(yellowPanel);
        frame.setVisible(true);
    }

}
