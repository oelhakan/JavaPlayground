package Playground.TwoDAnimations;

import javax.swing.*;

public class TwoDAnimationsFrame extends JFrame {

    TwoDAnimationsPanel panel;

    TwoDAnimationsFrame() {

        panel = new TwoDAnimationsPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
