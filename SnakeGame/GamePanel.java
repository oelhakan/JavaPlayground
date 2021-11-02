package SnakeGame;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 75;
    final int[] x = new int[GAME_UNITS];
    final int[] y = new int[GAME_UNITS];
    int bodyParts = 6;
    int applesEaten = 0;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;

    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(new Color(0x080F0F));
        this.setFocusable(true);
        this.addKeyListener(new SnakeKeyAdapter());
        startGame();
    }

    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running){
            //PAINT GRIDS
            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
                g.setColor(new Color(0xA4BAB7));
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
            }
            //DRAW SNAKES BODY AND HEAD
            for (int i = 0; i < bodyParts; i++) {
                // i=0 is the head of the snake
                if (i == 0) {
                    g.setColor(new Color(0xB1CC74));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    g.setColor(new Color(0xE8FCC2));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            //DRAW APPLE
            g.setColor(new Color(0xA52422));
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            //SCORE TEXT
            g.setColor(new Color(0xA52422));
            g.setFont(new Font("DIN Alternate", Font.BOLD, 40));
            //SET TEXT POSITION TO TOP CENTER
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score : " + applesEaten, (SCREEN_WIDTH-metrics.stringWidth("Score : " + applesEaten)) /2 , g.getFont().getSize());
        }else{
            gameOver(g);
        }
    }

    public void newApple() {
        //GENERATE RANDOM COORDINATES FOR THE APPLE
        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            //shifting all the coordinates of the snakes body by 1
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        //move snakes head to different directions
        switch (direction) {
            case 'U':
                y[0] -= UNIT_SIZE;
                break;
            case 'D':
                y[0] += UNIT_SIZE;
                break;
            case 'L':
                x[0] -= UNIT_SIZE;
                break;
            case 'R':
                x[0] += UNIT_SIZE;
                break;
        }
    }

    public void checkApple() {
        if((x[0] == appleX) && (y[0] == appleY)){
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }

    public void checkCollisions() {
        //CHECK IF THE SNAKES HEAD COLLIDES WITH BODY
        for(int i = bodyParts; i>0; i--){
            if((x[0] == x[i]) && (y[0] == y[i])){
                running = false;
            }
        }
        //CHECK IF THE SNAKES HEAD TOUCHES LEFT BORDER
        if(x[0]<0){
            running = false;
        }
        //CHECK IF THE SNAKES HEAD TOUCHES RIGHT BORDER
        if(x[0]>SCREEN_WIDTH){
            running = false;
        }
        //CHECK IF THE SNAKES HEAD TOUCHES TOP BORDER
        if(y[0]<0){
            running = false;
        }
        //CHECK IF THE SNAKES HEAD TOUCHES BOTTOM BORDER
        if(y[0]>SCREEN_HEIGHT){
            running = false;
        }
        if(!running){
            timer.stop();
        }
    }

    public void gameOver(Graphics g) {
        //SCORE TEXT
        g.setColor(new Color(0xA52422));
        g.setFont(new Font("DIN Alternate", Font.BOLD, 40));
        //SET TEXT POSITION TO TOP CENTER
        FontMetrics metricsScore = getFontMetrics(g.getFont());
        g.drawString("Score : " + applesEaten, (SCREEN_WIDTH-metricsScore.stringWidth("Score : " + applesEaten)) /2 , g.getFont().getSize());
        //GAME OVER TEXT
        g.setColor(new Color(0xA52422));
        g.setFont(new Font("DIN Alternate", Font.BOLD, 75));
        //SET TEXT POSITION TO CENTER
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("GAME OVER", (SCREEN_WIDTH-metrics.stringWidth("GAME OVER")) /2 , SCREEN_HEIGHT/2);

    }

    public class SnakeKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()){
                case KeyEvent.VK_UP :
                    if (direction != 'D'){
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN :
                    if (direction != 'U'){
                        direction = 'D';
                    }
                    break;
                case KeyEvent.VK_LEFT :
                    if (direction != 'R'){
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT :
                    if (direction != 'L'){
                        direction = 'R';
                    }
                    break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }
}
