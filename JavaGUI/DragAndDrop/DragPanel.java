package Playground.DragAndDrop;

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

    private class ClickListener extends MouseAdapter {
        public void MousePressed(MouseEvent e) {
            previousPoint.equals(e.getPoint());
        }
    }

    private class DragListener extends MouseMotionAdapter {
        public void MouseDragged(MouseEvent e) {
            Point currentPoint = e.getPoint();

            imageCorner.translate((int)(currentPoint.getX()-previousPoint.getX()),(int)(currentPoint.getY() - previousPoint.getY()));

            previousPoint = currentPoint;
            repaint();
        }
    }
}
