package LoginSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Log In");
    JButton resetButton = new JButton("Reset");
    JTextField userIdField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIdLabel = new JLabel("User ID");
    JLabel userPasswordLabel = new JLabel("Password");
    JLabel messageLabel = new JLabel();
    HashMap<String, String> loginInfo = new HashMap();

    LoginPage(HashMap<String, String> loginInfoOriginal) {

        loginInfo = loginInfoOriginal;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        userIdLabel.setBounds(50, 100, 75, 25);

        userPasswordLabel.setBounds(50, 150, 75, 25);

        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font("Ariel", Font.ITALIC, 25));

        userIdField.setBounds(125, 100, 200, 25);

        userPasswordField.setBounds(125, 150, 200, 25);

        loginButton.setBounds(125, 200, 100, 25);
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);

        resetButton.setBounds(225, 200, 100, 25);
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);

        frame.add(userIdLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIdField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //clear the user id and password fields when reset button is pressed
        if (e.getSource().equals(resetButton)) {
            userIdField.setText("");
            userPasswordField.setText("");
        }
        /*
        if the login button is pressed, store the text on the userID field on a variable and
        the text on the passwordField on another. Check if the loginInfo hashMap contains the userName.
        If it does not, print a message "user not found", if it does check the password, if the password matches,
        then print a "log in successful" message, dispose current frame and instantiate a new welcome page,
         if not print a message "wrong password"
        */
        if (e.getSource().equals(loginButton)) {
            String userID = userIdField.getText();
            String userPassword = String.valueOf(userPasswordField.getPassword());

            if (loginInfo.containsKey(userID)) {
                if (loginInfo.get(userID).equals(userPassword)) {
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Log In Successful!");
                    frame.dispose();
                    WelcomePage welcomePage = new WelcomePage(userID);
                }else{
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong Password!");
                }
            }else{
                messageLabel.setForeground(Color.red);
                messageLabel.setText("User Not Found");
            }
        }
    }
}
