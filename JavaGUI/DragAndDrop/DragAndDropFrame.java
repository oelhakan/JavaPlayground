import javax.swing.*;

public class DragAndDropFrame extends JFrame {

    DragPanel dragPanel = new DragPanel();

    DragAndDropFrame(){

        this.add(dragPanel);
        this.setTitle("Drag & Drop Demo");
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.add(dragPanel);

        this.setVisible(true);

    }
}
