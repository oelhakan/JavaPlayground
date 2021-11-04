import javax.swing.*;

public class MyFrame extends JFrame {

    MyPanel myPanel;

    MyFrame(){
          myPanel = new MyPanel();

        this.add(myPanel);
        this.setTitle("GPA Calculator");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }
}
