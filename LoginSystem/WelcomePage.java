package LoginSystem;

import javax.swing.*;
import java.awt.*;

public class WelcomePage{
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel();

    WelcomePage(String userID){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        welcomeLabel.setBounds(0,0,200,35);
        welcomeLabel.setFont(new Font("Ariel", Font.PLAIN,25));
        welcomeLabel.setText("Hello " + userID + "!");

        frame.add(welcomeLabel);
        frame.setVisible(true);
    }
}
