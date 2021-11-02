import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DragPanel extends JPanel {

    ImageIcon image = new ImageIcon("smile.png");
    final int WIDTH = image.getIconWidth();
    final int HEIGHT = image.getIconHeight();
    Point imageCorner;
    Point previousPoint;
    boolean dragValid = false;

    DragPanel() {

        imageCorner = new Point(0, 0);

        ClickListener clickListener = new ClickListener();

        DragListener dragListener = new DragListener();

        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        image.paintIcon(this, g, (int) imageCorner.getX(), (int) imageCorner.getY());
    }

    private class ClickListener extends MouseAdapter{
        public void mousePressed(MouseEvent e) {
            previousPoint = e.getPoint();
            dragValid = (e.getPoint().getX() > imageCorner.getX()) &&
                    (e.getPoint().getX() < (imageCorner.getX() + WIDTH)) &&
                    (e.getPoint().getY() > imageCorner.getY()) &&
                    (e.getPoint().getY() < (imageCorner.getY() + HEIGHT));
        }
    }



    private class DragListener extends MouseMotionAdapter{
        public void mouseDragged(MouseEvent e) {
            if(dragValid){
                Point currentPt = e.getPoint();
                imageCorner.translate(
                        (int)(currentPt.getX() - previousPoint.getX()),
                        (int)(currentPt.getY() - previousPoint.getY())
                );
                previousPoint = currentPt;
                repaint();
            }
        }
    }
}