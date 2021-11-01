package Playground.ListenerKey;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerFrame extends JFrame implements KeyListener {

    JLabel label;
    ImageIcon icon;

    KeyListenerFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);

        icon = new ImageIcon("rocket.png");

        this.addKeyListener(this);

        label = new JLabel();
        label.setBounds(0,0,100,100);
        label.setIcon(icon);
//        label.setBackground(Color.red);
//        label.setOpaque(true);

        this.getContentPane().setBackground(Color.black); //set background of the frame
        this.add(label);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {  //INVOKED WHEN A KEY IS TYPED, USES KeyChar, Char output
        switch(e.getKeyChar()){
            case 'a' : label.setLocation(label.getX() -10,label.getY());
                break;
            case 'w' : label.setLocation(label.getX(),label.getY()-10);
                break;
            case 's' : label.setLocation(label.getX() ,label.getY()+10);
                break;
            case 'd' : label.setLocation(label.getX() +10,label.getY());
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {    //INVOKED WHEN A PHYSICAL KEY IS PRESSED DOWN. Uses KeyCode, int output
        switch(e.getKeyCode()){
            case 37 : label.setLocation(label.getX() -10,label.getY());
                break;
            case 38 : label.setLocation(label.getX(),label.getY()-10);
                break;
            case 40 : label.setLocation(label.getX() ,label.getY()+10);
                break;
            case 39 : label.setLocation(label.getX() +10,label.getY());
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {   //CALLED WHENEVER A BUTTON IS RELEASED
        System.out.println("You Released Key Char : " + e.getKeyChar());
        System.out.println("You Released Key Code : " + e.getKeyCode());
    }
}
