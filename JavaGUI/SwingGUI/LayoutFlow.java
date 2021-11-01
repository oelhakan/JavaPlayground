package Playground.SwingGUI;
import java.awt.*;
import javax.swing.*;
public class LayoutFlow { //DEFAULT FOR PANELS
    //Layout Manager = Defines the Natural Layout for components within a container
    //Flow Layout = Places components in a row, sized at their preferred size.
    //If the horizontal space in the container is too small, the FlowLayout class uses the next available row.
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,0,50));

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(250,250));
        panel.setBackground(Color.lightGray);

//        JButton button1 = new JButton();
        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        panel.add(new JButton("7"));
        panel.add(new JButton("8"));
        panel.add(new JButton("9"));
        frame.add(panel);
        frame.setVisible(true);
    }
}
