package Playground.TwoDGraphics;

import javax.swing.*;
import java.awt.*;

public class TwoDGraphicsPanel extends JPanel {
    Image image;
    TwoDGraphicsPanel(){
        image = new ImageIcon("sky.png").getImage();
    this.setPreferredSize(new Dimension(500,500));
    }
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.blue);

        g2d.setStroke(new BasicStroke(5));
//        g2d.drawLine(0,0,500,500);
//        g2d.drawRect(0,0,100,200);
//        g2d.fillRect(0,0,100,200);
        g2d.setPaint(Color.pink);
//        g2d.fillOval(150,150,100,100);
        g2d.setPaint(Color.red);
//        g2d.drawArc(10,10,100,100,0,180);
//        g2d.fillArc(10,10,100,100,0,180);
        g2d.setPaint(Color.white);
//        g2d.drawArc(10,10,100,100,180,180);
//        g2d.fillArc(10,10,100,100,180,180);

//        int[] xPoints = {150,250,350};
//        int[] yPoints = {300,150,300};
        g2d.setPaint(Color.orange);
//        g2d.fillPolygon(xPoints,yPoints,3);
        g2d.setFont(new Font("Noteworthy",Font.BOLD,50));
        g2d.drawString("U R A WINNER",50,50);
        g2d.drawImage(image,0,0,null);
    }
}
