import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame{

    MainPanel mainPanel;

    MyFrame(){
        mainPanel = new MainPanel();

        this.add(mainPanel);
        this.setTitle("GPA Calculator");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.pack();
        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }

}
