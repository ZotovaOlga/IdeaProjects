package zov.snakeage;

import zov.snake.objects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Измерение on 20.09.2016.
 */
public class SnakeGame extends JPanel implements ActionListener{

    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int SPEED = 5;

    Snake s = new Snake(10,10, 9, 10);
    Timer t = new Timer(1000/SPEED, this);

    public SnakeGame(){

        t.start();
        addKeyListener(new Keyboard());
        setFocusable(true);
    }

    public void paint(Graphics g){
        g.setColor(color(5, 50, 10));
        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
        g.setColor(color(255, 216, 0));

        for(int xx = 0; xx <= WIDTH*SCALE; xx+=SCALE){

            g.drawLine(xx, 8, xx, WIDTH*SCALE);
        }
        for(int yy = 0; yy <= HEIGHT*SCALE; yy+=SCALE){

            g.drawLine(0, yy, HEIGHT*SCALE, yy);
        }
        for(int d = 0;d < s.lenghth; d++){
            g.setColor(color(20,30,150));
            g.fillRect(s.snakeX[d]*SCALE+1, s.snakeY[d]*SCALE+1,SCALE-1,SCALE-1);

        }
    }
    public Color color(int red,int green, int blue){
        return new Color(red, green, blue);
    }
    public static void main(String[] args){
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(WIDTH * SCALE+7, HEIGHT * SCALE+30);
        f.setLocationRelativeTo(null);
        f.add(new SnakeGame());
        f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        s.move();
        repaint();
    }

    private class Keyboard extends KeyAdapter{
        public void KeyPressed(KeyEvent kEvt){

            int key = kEvt.getKeyCode();

            if((key == KeyEvent.VK_RIGHT)& s.direction!= 2) s.direction = 0;
            if ((key == KeyEvent.VK_DOWN)& s.direction!= 3) s.direction = 1;
            if ((key == KeyEvent.VK_LEFT)& s.direction!= 0) s.direction = 2;
            if ((key == KeyEvent.VK_UP)& s.direction!= 1) s.direction = 3;
        }
    }
}
