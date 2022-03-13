package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    private final int walkingSpeed = 3;
    private final int swimmingSpeed = 4;
    int keysInInventory = 0;



    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();

        screenX = gp.screenWidth/2 -(gp.tileSize/2);
        screenY = gp.screenHeight/2 -(gp.tileSize/2);

        solidArea = new Rectangle(12, 18, 30,29); //HITBOX!!

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

    }
    public void setDefaultValues() {
        worldX = gp.tileSize * 2;
        worldY = gp.tileSize * 2;
        speed = 3;
        direction = "down";
        isSwimming = false;
    }
    public void getPlayerImage() {

        try {

            walkingUp1 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_up_1.png"));
            walkingUp2 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_up_2.png"));
            walkingDown1 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_down_1.png"));
            walkingDown2 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_down_2.png"));
            walkingRight1 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_right_1.png"));
            walkingRight2 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_right_2.png"));
            walkingLeft1 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_left_1.png"));
            walkingLeft2 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_left_2.png"));
            swimmingUp1 = ImageIO.read(getClass().getResourceAsStream("/player/duck_swimming_up_1.png"));
            swimmingUp2 = ImageIO.read(getClass().getResourceAsStream("/player/duck_swimming_up_2.png"));
            swimmingDown1 = ImageIO.read(getClass().getResourceAsStream("/player/duck_swimming_down_1.png"));
            swimmingDown2 = ImageIO.read(getClass().getResourceAsStream("/player/duck_swimming_down_2.png"));
            swimmingRight1 = ImageIO.read(getClass().getResourceAsStream("/player/duck_swimming_right_1.png"));
            swimmingRight2 = ImageIO.read(getClass().getResourceAsStream("/player/duck_swimming_right_2.png"));
            swimmingLeft1 = ImageIO.read(getClass().getResourceAsStream("/player/duck_swimming_left_1.png"));
            swimmingLeft2 = ImageIO.read(getClass().getResourceAsStream("/player/duck_swimming_left_2.png"));
            walkingUpStationary = ImageIO.read(getClass().getResourceAsStream("/player/duck_stationary_up.png"));
            walkingDownStationary = ImageIO.read(getClass().getResourceAsStream("/player/duck_stationary_down.png"));

        } catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
    public void update() {
        if (keyH.upPressed || keyH.downPressed || keyH.rightPressed || keyH.leftPressed) {
            isStationary = false;
            /* if (keyH.rightPressed && keyH.upPressed) {
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
            } */

           if (keyH.upPressed) {
                direction = "up";
            }
            else if (keyH.downPressed) {
                direction = "down";
            }
            else if (keyH.leftPressed) {
                direction = "left";
            }
            else if (keyH.rightPressed) {
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

            //checks if the tile you want to move into is passable or swimmable etc...
            gp.collisionChecker.checkTile(this); //checks if the tile you want to move into is passable or swimmable etc...
            //checks if the tile you want to move into is occupied by an object
            int objIndex = gp.collisionChecker.checkObject(this, true);
            pickUpObject(objIndex);

            if (collisionOn) {
                // can't walk thru walls!
            } else {
                if (isSwimming) {
                    speed = swimmingSpeed;
                } else { // walking
                    speed = walkingSpeed;
                }
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
    public void pickUpObject(int i) {
        boolean removeObject = false;
        if (i != 999) {
            String objName = gp.obj[i].name;
            switch (objName) { // if we pickup a key remember that we have a key for later
                case "Key":
                    removeObject = true;
                    keysInInventory++;
                    System.out.println("You just picked up a key. You have "+keysInInventory+ " keys.");
                    break;
                case "Door": // if we interact with a door it will open only when we have a key
                    if(keysInInventory > 0) {
                        gp.obj[i] = null;
                        keysInInventory--;
                        System.out.println("You just used one of your keys to open this door. You have "+keysInInventory+ " keys left.");
                    }
                    break;
                case "Chest":
                    break;
            }
            if (removeObject) {
               gp.obj[i] = null;
            }

        }
    }
    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        if (isSwimming) {
            switch (direction) {
                case "up":
                    if (spriteNum == 1) {
                        image = swimmingUp1;
                    }
                    else {
                        image = swimmingUp2;
                    }
                    break;
                case "down":
                    if (spriteNum == 1) {
                        image = swimmingDown1;
                    }
                    else {
                        image = swimmingDown2;
                    }
                    break;
                case "left":
                    if (spriteNum == 1 || isStationary) {
                        image = swimmingLeft1;
                    }
                    else {
                        image = swimmingLeft2;
                    }
                    break;
                case "right":
                    if (spriteNum == 1 || isStationary) {
                        image = swimmingRight1;
                    }
                    else {
                        image = swimmingRight2;
                    }
                    break;
            }
        } else { //on land
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
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);
    }
}
