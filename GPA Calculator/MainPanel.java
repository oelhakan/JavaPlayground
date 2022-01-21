import javax.swing.*;

public class MainPanel extends JPanel {

    MyPanel myPanel = new MyPanel();
    DisplayPanel displayPanel = new DisplayPanel();

    MainPanel() {
        this.add(myPanel);
        this.add(displayPanel);
    }
}
