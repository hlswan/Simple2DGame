package entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gp;

    public int worldX, worldY;
    public int speed;

    public BufferedImage walkingUp1, walkingUp2, walkingDown1, walkingDown2, walkingLeft1, walkingLeft2, walkingRight1, walkingRight2, walkingUpStationary, walkingDownStationary;
    public BufferedImage swimmingUp1, swimmingUp2, swimmingDown1, swimmingDown2, swimmingLeft1, swimmingLeft2, swimmingRight1, swimmingRight2;

    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
    public boolean isStationary = true;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public boolean collisionOn = false;
    public boolean isSwimming = false;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean interactable;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }
    public void setAction() {

    }
    public void update() {

    }
    public void draw(Graphics2D g2) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if (isStationary) {
                    image = walkingUpStationary;
                } else if (spriteNum == 1) {
                    image = walkingUp1;
                } else {
                    image = walkingUp2;
                }
                break;
            case "down":
                if (isStationary) {
                    image = walkingDownStationary;
                } else if (spriteNum == 1) {
                    image = walkingDown1;
                } else {
                    image = walkingDown2;
                }
                break;
            case "left":
                if (spriteNum == 1 || isStationary) {
                    image = walkingLeft1;
                } else {
                    image = walkingLeft2;
                }
                break;
            case "right":
                if (spriteNum == 1 || isStationary) {
                    image = walkingRight1;
                } else {
                    image = walkingRight2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, GamePanel.tileSize, GamePanel.tileSize, null);
    }
}
