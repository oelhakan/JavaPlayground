package Playground.ProgressBars;

import java.awt.*;
import javax.swing.*;

public class ProgressBarDemo {

    JFrame frame = new JFrame();
    JProgressBar bar = new JProgressBar();

    ProgressBarDemo() {

        bar.setValue(0);
        bar.setBounds(0, 0, 420, 100);
        bar.setStringPainted(true);
        bar.setFont(new Font("Noteworthy",Font.BOLD,25));
        bar.setForeground(new Color(0xffa500));
        bar.setBackground(Color.black);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.add(bar);
        frame.setVisible(true);

        fill();
    }

    public void fill() {
        int counter = 0;
        while(counter<=100){
            bar.setValue(counter);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter+=1;
        }
        bar.setString("DONE!");
    }
}
