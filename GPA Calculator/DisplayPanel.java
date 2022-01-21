import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel {

    public DisplayPanel() {
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(new Color(0xEED2CC));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    }
    public void reset(){
        this.setVisible(false);
    }
}
