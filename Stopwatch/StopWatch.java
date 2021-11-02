package Stopwatch;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class StopWatch implements ActionListener {

    JFrame frame = new JFrame();
    JButton startButton = new JButton("Start");
    JButton resetButton = new JButton("Reset");
    JLabel timeLabel = new JLabel();
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;
    String seconds_String = String.format("%02d", seconds); //if seconds is 0, display only two zeroes
    String minutes_String = String.format("%02d", minutes);
    String hours_String = String.format("%02d", hours);
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //this is what our timer is going to do every 1000 miliseconds
            elapsedTime += 1;
            hours = (elapsedTime) / 3600;
            minutes = (elapsedTime / 60) % 60;
            seconds = (elapsedTime / 1) % 60;

            seconds_String = String.format("%02d", seconds);
            minutes_String = String.format("%02d", minutes);
            hours_String = String.format("%02d", hours);

            timeLabel.setText(hours_String+":"+minutes_String+":"+seconds_String);
        }
    });

    StopWatch() {

        timeLabel.setText(hours_String + ":" + minutes_String + ":" + seconds_String);
        timeLabel.setBounds(100, 100, 200, 100);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(100, 200, 100, 50);
        startButton.setFont(new Font("Arial", Font.PLAIN, 20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        resetButton.setBounds(200, 200, 100, 50);
        resetButton.setFont(new Font("Arial", Font.PLAIN, 20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setTitle("Stopwatch");
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        frame.add(timeLabel);
        frame.add(startButton);
        frame.add(resetButton);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(startButton)){
            if(!started){
                started = true;
                startButton.setText("Stop");
                start();
            }else{
                started = false;
                startButton.setText("Start");
                stop();
            }
        }
        if(e.getSource().equals(resetButton)){
            started = false;
            startButton.setText("Start");
            reset();
        }
    }

    void start() {
        timer.start();
    }

    void stop() {
        timer.stop();
    }

    void reset() {
        timer.stop();
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;

        seconds_String = String.format("%02d", seconds);
        minutes_String = String.format("%02d", minutes);
        hours_String = String.format("%02d", hours);

        timeLabel.setText(hours_String+":"+minutes_String+":"+seconds_String);
    }
}
