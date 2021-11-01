package Playground.TwoDGraphics;

import javax.swing.*;
import java.awt.*;

public class TwoDGraphicsFrame extends JFrame {

    TwoDGraphicsPanel panel;

    TwoDGraphicsFrame(){

        panel = new TwoDGraphicsPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setSize(500,500);

        this.add(panel);

        this.pack();
        this.setLocationRelativeTo(null); //ALLOWS THE FRAME TO APPEAR IN THE MIDDLE OF THE SCREEN
        this.setVisible(true);
    }

}
