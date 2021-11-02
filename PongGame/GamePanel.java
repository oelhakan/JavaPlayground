package PongGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GamePanel extends JPanel implements Runnable {

    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)((GAME_WIDTH) * (0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;

    GamePanel() {

     //create paddles and a ball at start
     newPaddles();
     newBall();

     //create score
     score = new Score(GAME_WIDTH,GAME_HEIGHT);

     //set up panel
     this.setFocusable(true);
     this.addKeyListener(new AL());
     this.setPreferredSize(SCREEN_SIZE);

     //set up and start game thread
     gameThread = new Thread(this);
     gameThread.start();

    }

    public void newBall() {
        //instantiate and set starting position for the ball
        random = new Random();
//        random.nextInt(GAME_HEIGHT-BALL_DIAMETER)
        ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
    }
    public void newPaddles() {

        //instantiate and set starting positions for the paddles
        paddle1 = new Paddle(0,((GAME_HEIGHT/2)-(PADDLE_HEIGHT/2)), PADDLE_WIDTH,PADDLE_HEIGHT,1);
        paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH,((GAME_HEIGHT/2)-(PADDLE_HEIGHT/2)), PADDLE_WIDTH,PADDLE_HEIGHT,2);

    }
    public void paint(Graphics g) {
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }
    public void draw(Graphics g){
        //draw components on the panel
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
        Toolkit.getDefaultToolkit().sync(); //helps with the animation
    }
    public void move(){
        //move elements after each iteration of the game loop
        paddle1.move();
        paddle2.move();
        ball.move();
    }
    public void checkCollision(){

        //bounce the ball of the paddles

        if(ball.intersects(paddle1)){
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity ++; //increase speed each time ball touches paddles to increase difficulty
            if(ball.yVelocity > 0){
                ball.yVelocity ++;
            }else
                ball.yVelocity--;
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }

        if(ball.intersects(paddle2)){
            ball.xVelocity *= -1;
            //increase speed each time ball touches paddles to increase difficulty
            ball.xVelocity ++;
            if(ball.yVelocity > 0){
                ball.yVelocity ++;
            }else
                ball.yVelocity--;
            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);

        }

        //bounce the ball of the top and bottom edges

        if(ball.y <=0){
            ball.setYDirection(-ball.yVelocity);
        }

        if(ball.y >=GAME_HEIGHT-BALL_DIAMETER){
            ball.setYDirection(-ball.yVelocity);
        }

        //stops paddles at edges

        if(paddle1.y<=0){
            paddle1.y = 0;
        }

        if(paddle1.y>=GAME_HEIGHT-PADDLE_HEIGHT){
            paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
        }

        if(paddle2.y<=0){
            paddle2.y = 0;
        }

        if(paddle2.y>=GAME_HEIGHT-PADDLE_HEIGHT){
            paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;
        }

        //give a player one point and create new paddles and ball
        if(ball.x <= 0){
            score.player2++;
            newPaddles();
            newBall();
//            System.out.println("Player 2 Score!");
//            System.out.println("Total Score : " + score.player1 + " - " + score.player2);
        }
        if(ball.x >= GAME_WIDTH-BALL_DIAMETER){
            score.player1++;
            newPaddles();
            newBall();
//            System.out.println("Player 1 Score!");
//            System.out.println("Player 1 : " + score.player1 + " - Player 2 : " + score.player2);
        }
    }
    public void run(){

        //declare/instantiate game loop variables
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double nanoSeconds = 1000000000/amountOfTicks;
        double delta = 0;

        //create game loop to :
        //move elements - check collision - repaint frame
        while(true){
            long currentTime = System.nanoTime();
            delta += (currentTime-lastTime)/nanoSeconds;
            lastTime = currentTime;
            if(delta>=1){
                move();
                checkCollision();
                repaint();
                delta -=1;
            }
        }

    }
    public class AL extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }
    }
}
