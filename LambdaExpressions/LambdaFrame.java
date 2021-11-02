package LambdaExpressions;

import javax.swing.*;

public class LambdaFrame extends JFrame {

    JButton button1 = new JButton("Button 1");
    JButton button2 = new JButton("Button 2");

    LambdaFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        button1.setBounds(100,100,200,100);
        button1.addActionListener(
                (e) -> System.out.println("You Clicked The First Button!")
        );
        button2.setBounds(100,200,200,100);
        button2.addActionListener(
                (e) -> System.out.println("You Clicked The Second Button!")
        );

        this.add(button1);
        this.add(button2);
        this.setVisible(true);
    }
}
