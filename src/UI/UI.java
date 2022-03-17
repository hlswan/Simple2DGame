package UI;

import main.GamePanel;
import object.KeyObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class UI {
    GamePanel gp;
    Font ariel_40;
    BufferedImage keyImage;
    BufferedImage speedIcon;


    public UI(GamePanel gp) {
        this.gp = gp;

        ariel_40 = new Font("Ariel", Font.PLAIN, 40);
        KeyObject key = new KeyObject(gp);
        keyImage = key.image;
        try {
            speedIcon = ImageIO.read(getClass().getResourceAsStream("/icons/speed_icon.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error when reading resource location at UI 24");
        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);
        drawIcons(g2);
        if (gp.player.gameFinished) {
            g2.drawString("Congratulations!, you beat the game!", gp.player.worldX +20, gp.player.worldY -30);
        }
    }

    private void drawIcons(Graphics2D g2) {
        if (gp.player.keysInInventory == 1) {
            g2.drawImage(keyImage, gp.tileSize / 3 , gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
        } else if (gp.player.keysInInventory == 2) {
            g2.drawImage(keyImage, gp.tileSize / 3, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
            g2.drawImage(keyImage, gp.tileSize+9, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
        }
        if (gp.player.powerUp) {
            g2.drawImage(speedIcon,gp.tileSize / 3 , gp.tileSize + (gp.tileSize/2), gp.tileSize, gp.tileSize, null);
        }
    }
}
