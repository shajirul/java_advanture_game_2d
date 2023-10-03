package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    // SCREEN SETTINGS
    final int orginalTilseSize = 16; // 16X16 Tile
    final int scale = 3;
    final int tileSize= orginalTilseSize * scale;  // 48*48 Tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 786 pixel
    final int screenHight = tileSize * maxScreenRow; // 576 pixel

    Thread gameThread;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (gameThread != null){
            // 1. UPDATE: update information such as charecter position
            update();

            // 2.  Draw: draw the screen with updated information
            repaint();

        }
    }

    public void update(){

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.fillRect(100,100,tileSize,tileSize);
        g2.dispose();

    }
}
