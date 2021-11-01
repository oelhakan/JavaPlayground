package Playground.ListenerMouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerFrame extends JFrame implements MouseListener {
    JLabel label;
    ImageIcon smile;
    ImageIcon pain;
    ImageIcon nervous;
    ImageIcon dizzy;

    MouseListenerFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);

        smile = new ImageIcon("smile.png");
        pain = new ImageIcon("pain.png");
        nervous = new ImageIcon("nervous.png");
        dizzy = new ImageIcon("dizzy.png");

        label = new JLabel();
        label.setBounds(0,0,100,100);
        label.setBackground(Color.black);
        label.setOpaque(true);
        label.setIcon(smile);
        label.addMouseListener(this);

        this.add(label);

        this.setLayout(new FlowLayout());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //INVOKED WHEN THE MOUSE BUTTON HAS BEEN CLICKED(PRESSED AND RELEASED) ON A COMPONENT

//        System.out.println("You Clicked The Mouse");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //INVOKED WHEN THE MOUSE BUTTON HAS BEEN PRESSED ON A COMPONENT
        label.setIcon(pain);
//        System.out.println("You Pressed The Mouse");
//        label.setBackground(Color.yellow);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //INVOKED WHEN THE MOUSE BUTTON HAS BEEN RELEASED ON A COMPONENT
        label.setIcon(dizzy);
//        System.out.println("You Released The Mouse");
//        label.setBackground(Color.green);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //INVOKED WHEN THE MOUSE ENTERS A COMPONENT
        label.setIcon(nervous);
//        System.out.println("You Entered The Component");
//        label.setBackground(Color.blue);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //INVOKED WHEN THE MOUSE EXITS A COMPONENT
        label.setIcon(smile);
//        System.out.println("You Exited The Component");
//        label.setBackground(Color.red);
    }
}
