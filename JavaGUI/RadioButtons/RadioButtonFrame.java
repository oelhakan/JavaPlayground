package Playground.RadioButtons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonFrame extends JFrame implements ActionListener {

    //JRadioButton = One or more buttons in a grouping in which only 1 may be selected per group
    JRadioButton pizzaButton;
    JRadioButton hamburgerButton;
    JRadioButton hotDogButton;
    ImageIcon pizza;
    ImageIcon hamburger;
    ImageIcon hotDog;

    RadioButtonFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        pizza = new ImageIcon("pizza.png");
        hamburger = new ImageIcon("hamburger.png");
        hotDog = new ImageIcon("hotdog.png");

        pizzaButton = new JRadioButton("pizza");
        pizzaButton.addActionListener(this);
        pizzaButton.setIcon(pizza);

        hamburgerButton = new JRadioButton("hamburger");
        hamburgerButton.addActionListener(this);
        hamburgerButton.setIcon(hamburger);

        hotDogButton = new JRadioButton("hotdog");
        hotDogButton.addActionListener(this);
        hotDogButton.setIcon(hotDog);

        ButtonGroup group = new ButtonGroup();
        group.add(pizzaButton);
        group.add(hamburgerButton);
        group.add(hotDogButton);

        this.add(pizzaButton);
        this.add(hamburgerButton);
        this.add(hotDogButton);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(pizzaButton)) {
            System.out.println("You Ordered A Pizza");
        } else if (e.getSource().equals(hamburgerButton)) {
            System.out.println("You Ordered A Hamburger");
        } else if (e.getSource().equals(hotDogButton)) {
            System.out.println("You Ordered A HotDog");
        }
    }
}
