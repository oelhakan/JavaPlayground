package PongGame;

import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle {

    int id;
    int yVelocity;
    int speed = 5;

    Paddle(int x, int y, int width, int height, int id){
        super(x,y,width,height);
        this.id = id;
    }

    public void keyPressed(KeyEvent e) {
        //if up or down keys are pressed , move paddle two
        //if w or s keys are pressed, move paddle one
        switch (id) {
            case 1 -> {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(-speed);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(speed);
                    move();
                }
            }
            case 2 -> {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(-speed);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(speed);
                    move();
                }
            }
        }
    }

    public void keyReleased(KeyEvent e) {

        //stop moving when key is released
        switch (id) {
            case 1 -> {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(0);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(0);
                    move();
                }
            }
            case 2 -> {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(0);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(0);
                    move();
                }
            }
        }
    }

    //set y velocity
    public void setYDirection(int yDirection){

        yVelocity = yDirection;
    }

    //make the y position change depending on the velocity
    public void move(){

        y += yVelocity;
    }

    public void draw(Graphics g){
        //draw paddles
        if(id == 1){
            g.setColor(Color.blue);
        }else{
            g.setColor(Color.red);
        }
        g.fillRect(x,y,width,height);

    }
}
