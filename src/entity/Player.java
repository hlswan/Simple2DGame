package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;



    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();

        screenX = gp.screenWidth/2 -(gp.tileSize/2);
        screenY = gp.screenHeight/2 -(gp.tileSize/2);

        solidArea = new Rectangle(12, 18, 30,18);

    }
    public void setDefaultValues() {

        worldX = gp.tileSize * 2;
        worldY = gp.tileSize * 1;
        speed = 3;
        direction = "down";
        isSwimming = false;
    }
    public void getPlayerImage() {

        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_down_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_right_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_left_2.png"));
            upStationary = ImageIO.read(getClass().getResourceAsStream("/player/duck_stationary_up.png"));
            downStationary = ImageIO.read(getClass().getResourceAsStream("/player/duck_stationary_down.png"));

        } catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
    public void update() {


        if (keyH.upPressed || keyH.downPressed || keyH.rightPressed || keyH.leftPressed) {
            isStationary = false;
            /*if (keyH.rightPressed && keyH.upPressed) {
                direction = "right";
                worldX += speed - 1;
                worldY -= speed - 1;

            }
            else if (keyH.leftPressed && keyH.upPressed) {
                direction = "left";
                worldX -= speed - 1;
                worldY -= speed - 1;
            }
            else if (keyH.rightPressed && keyH.downPressed) {
                direction = "right";
                worldX += speed - 1;
                worldY += speed - 1;
            }
            else if (keyH.leftPressed && keyH.downPressed) {
                direction = "left";
                worldX -= speed - 1;
                worldY += speed - 1;
            }
            */
           if (keyH.upPressed) {
                direction = "up";
            }
            else if (keyH.downPressed) {
                direction = "down";
            }
            else if (keyH.leftPressed) {
                direction = "left";
            }
            else {
                direction = "right";
            }
            spriteCounter++;
            if(spriteCounter > 7) {
                if(spriteNum == 1) {
                    spriteNum = 2;
                }
                else if (spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
            // Collision checker
            collisionOn = false;
            gp.collisionChecker.checkTile(this); //checks if the tile you want to move into is passable or swimmable etc...

            if (!collisionOn) {
                switch (direction) {
                    case "up": worldY -= speed; break;
                    case "down": worldY += speed; break;
                    case "left": worldX -= speed; break;
                    case "right": worldX += speed; break;
                }
            } else if (isSwimming) {
                speed = 6;
                System.out.println("isSwimming = true");
                switch (direction) {
                    case "up": worldY -= speed; break;
                    case "down": worldY += speed; break;
                    case "left": worldX -= speed; break;
                    case "right": worldX += speed; break;
                }
            }
        } else {
            isStationary = true;
        }

    }
    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (isStationary) {
                    image = upStationary;
                }
                else if (spriteNum == 1) {
                    image = up1;
                }
                else {
                    image = up2;
                }
                break;
            case "down":
                if (isStationary) {
                    image = downStationary;
                }
                else if (spriteNum == 1) {
                    image = down1;
                }
                else {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1 || isStationary) {
                    image = left1;
                }
                else {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1 || isStationary) {
                    image = right1;
                }
                else {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
