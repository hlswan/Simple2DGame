package main;

import UI.UI;
import dialogue.DialogueHandler;
import entity.Entity;
import entity.Player;
import object.SuperObject;
import sound.Sound;
import tile.TileManager;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    final static int originalTileSize = 16; // 16x tile
    final static int scale = 3;

    public static final int tileSize = originalTileSize * scale; // 48x tile
    public static final int maxScreenCol = 32; // 32 tiles
    public static final int maxScreenRow = 18; // 18 tiles
    public static final int screenWidth = tileSize * maxScreenCol; // 1536 pixels
    public static final int screenHeight = tileSize * maxScreenRow; // 864 pixels

    // WORLD SETTINGS
    public static final int maxWorldCol = 34;
    public static final int maxWorldRow = 35;
    public static final int worldWidth = tileSize * maxWorldCol;
    public static final int worldHeight = tileSize * maxWorldRow;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler(this);
    public Thread gameThread;
    //collision
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    //ui
    public UI ui = new UI(this);
    public DialogueHandler dh = new DialogueHandler(this);
    //player
    public Player player = new Player(this,keyH);
    //items on the ground
    public SuperObject[] obj = new SuperObject[3];
    public Entity[] NPC = new Entity[3];
    public AssetSetter aSetter = new AssetSetter(this);

    // frames per second
    final double FPS = 60;

    public int gameState;
    public final int playState = 1;
    public final int pausedState = 2;
    public final int dialogueState = 3;




    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void setupGame() {
        aSetter.setObject();
        aSetter.setNPC();
        //playMusic(); //play "Blue Boy Adventure"
        gameState = playState;
    }
    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;


        while(gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }


        }
    }
    public void update() {
        if (gameState == playState) {
            player.update();
        }
        if (gameState == pausedState) {

        }
        if (gameState == dialogueState) {

        }

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        //debug
        long drawStart = 0;
        if(keyH.debugCheckDrawTime) {
            drawStart = System.nanoTime();
        }

        tileM.draw(g2);
        for (SuperObject superObject : obj) {
            if (superObject != null) {
                superObject.draw(g2, this);
            }
        }
        for (Entity entity : NPC) {
            if (entity != null) {
                entity.draw(g2);
            }
        }
        player.draw(g2);
        ui.draw(g2);
        dh.draw(g2);

        //debug
        if(keyH.debugCheckDrawTime) {
            long drawEnd = System.nanoTime();
            long tPassed = drawEnd - drawStart;
            g2.setColor(Color.white);
            g2.drawString("Draw Time: " + tPassed, tileSize, tileSize*15);
            System.out.println("Draw Time: " + tPassed);
        }

        g2.dispose();
    }
    public void playMusic() {
        Sound.BLUE_BOY_ADVENTURE.play();
    }
    public void stopMusic() {
        Sound.BLUE_BOY_ADVENTURE.stop();
    }
}