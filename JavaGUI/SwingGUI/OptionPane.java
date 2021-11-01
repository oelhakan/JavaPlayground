package Playground.SwingGUI;

import javax.swing.*;

public class OptionPane {
    //JOptionPane = pop up a standard dialog box that prompts the user for a value or informs them of something
    public static void main(String[] args) {
//        JOptionPane.showMessageDialog(null,"THIS IS SOME USELESS INFO", "INFO", JOptionPane.PLAIN_MESSAGE);
     //   JOptionPane.showMessageDialog(null,"HERE IS SOME MORE USELESS INFO", "INFO", JOptionPane.INFORMATION_MESSAGE);
      //  JOptionPane.showMessageDialog(null,"REALLY?", "INFO", JOptionPane.QUESTION_MESSAGE);
//        JOptionPane.showMessageDialog(null,"YOUR COMPUTER HAS A VIRUS", "INFO", JOptionPane.WARNING_MESSAGE);
//        JOptionPane.showMessageDialog(null,"CALL TECH SUPPORT NOW OR ELSE", "INFO", JOptionPane.ERROR_MESSAGE);

       // int value = JOptionPane.showConfirmDialog(null,"Bro do you even code?", "This is my title", JOptionPane.YES_NO_CANCEL_OPTION);
   //     String name = JOptionPane.showInputDialog("What is your name?");
//        System.out.println(name + " HELLO");
        String[] responses = {"No, you're awesome!","Thank you.","*blush*"};
        ImageIcon icon = new ImageIcon("button.png");

        JOptionPane.showOptionDialog(null,
                "You Are Awesome",
                "Secret Message",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                icon,
                responses,
                0);

    }
}
