package UI;

import main.GamePanel;
import main.UtilityTool;



import java.awt.*;
import java.awt.image.BufferedImage;


public class UI {
    GamePanel gp;
    Font ariel_40;
    Graphics2D g2;

    BufferedImage keyImage;
    BufferedImage speedIcon;



    public UI(GamePanel gp) {
        this.gp = gp;

        ariel_40 = new Font("Ariel", Font.PLAIN, 40);
//        KeyObject key = new KeyObject(gp);
//        keyImage = key.image;
//        try {
//            speedIcon = ImageIO.read(getClass().getResourceAsStream("/icons/speed_icon.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("Error when reading resource location at UI 24");
//        }
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        g2.setFont(ariel_40);
        g2.setColor(Color.white);

        if (gp.gameState == gp.pausedState) {
            drawPauseScreen();
        }


//        drawIcons(g2);
    }

    private void drawPauseScreen() {
        UtilityTool uTool = new UtilityTool();
        String text = "paused!";
        int x = uTool.getXToCenterText(text, g2);
        int y = GamePanel.screenHeight/2;
        g2.drawString(text, x, y);

    }



//    private void drawIcons(Graphics2D g2) {
//
//            if (gp.player.keysInInventory == 1) {
//                g2.drawImage(keyImage, GamePanel.tileSize / 3, GamePanel.tileSize / 2, GamePanel.tileSize, GamePanel.tileSize, null);
//            } else if (gp.player.keysInInventory == 2) {
//                g2.drawImage(keyImage, GamePanel.tileSize / 3, GamePanel.tileSize / 2, GamePanel.tileSize, GamePanel.tileSize, null);
//                g2.drawImage(keyImage, GamePanel.tileSize + 9, GamePanel.tileSize / 2, GamePanel.tileSize, GamePanel.tileSize, null);
//            }
//            if (gp.player.powerUp) {
//                g2.drawImage(speedIcon, GamePanel.tileSize / 3, GamePanel.tileSize + (GamePanel.tileSize / 2), GamePanel.tileSize, GamePanel.tileSize, null);
//            }
//    }
}
