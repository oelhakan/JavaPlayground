package App;

import javax.swing.*;

public class MainPanel extends JPanel {

    DisplayPanel displayPanel = new DisplayPanel();
    MyPanel myPanel = new MyPanel(displayPanel);

    MainPanel() {
        this.add(myPanel);
        this.add(displayPanel);
    }
}
