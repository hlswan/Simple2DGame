package entity;


import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;
import sound.Sound;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {


    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    private final int walkingSpeed = 3;
    private final int swimmingSpeed = 4;




    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);

        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();

        screenX = GamePanel.screenWidth /2 -(GamePanel.tileSize /2);
        screenY = GamePanel.screenHeight /2 -(GamePanel.tileSize /2);

        solidArea = new Rectangle(12, 18, 30,29); //HITBOX!!

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

    }
    public void setDefaultValues() {
        worldX = GamePanel.worldWidth/2;
        worldY = GamePanel.worldHeight/2;
        speed = 3;
        direction = "down";
        isSwimming = false;
    }
    public void getPlayerImage() {

        walkingUp1 = setup("walking_up_1");
        walkingUp2 = setup("walking_up_2");
        walkingDown1 = setup("walking_down_1");
        walkingDown2 = setup("walking_down_2");
        walkingRight1 = setup("walking_right_1");
        walkingRight2 = setup("walking_right_2");
        walkingLeft1 = setup("walking_left_1");
        walkingLeft2 = setup("walking_left_2");
        swimmingUp1 = setup("swimming_up_1");
        swimmingUp2 = setup("swimming_up_2");
        swimmingDown1 = setup("swimming_down_1");
        swimmingDown2 = setup("swimming_down_2");
        swimmingRight1 = setup("swimming_right_1");
        swimmingRight2 = setup("swimming_right_2");
        swimmingLeft1 = setup("swimming_left_1");
        swimmingLeft2 = setup("swimming_left_2");
        walkingUpStationary = setup("stationary_up");
        walkingDownStationary= setup("stationary_down");

//        try {
//
//     //       walkingUp1 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_up_1.png"));
//            walkingUp1 = uTool.scaleImage(walkingUp1, GamePanel.tileSize, GamePanel.tileSize);
//
//     //       walkingUp2 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_up_2.png"));
//            walkingUp2 = uTool.scaleImage(walkingUp2, GamePanel.tileSize, GamePanel.tileSize);
//
//     //       walkingDown1 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_down_1.png"));
//            walkingDown1 = uTool.scaleImage(walkingDown1, GamePanel.tileSize, GamePanel.tileSize);
//
//    //        walkingDown2 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_down_2.png"));
//            walkingDown2 = uTool.scaleImage(walkingDown2, GamePanel.tileSize, GamePanel.tileSize);
//
//     //       walkingRight1 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_right_1.png"));
//            walkingRight1 = uTool.scaleImage(walkingRight1, GamePanel.tileSize, GamePanel.tileSize);
//
//    //        walkingRight2 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_right_2.png"));
//            walkingRight2 = uTool.scaleImage(walkingRight2, GamePanel.tileSize, GamePanel.tileSize);
//
//     //       walkingLeft1 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_left_1.png"));
//            walkingLeft1 = uTool.scaleImage(walkingLeft1, GamePanel.tileSize, GamePanel.tileSize);
//
//    //        walkingLeft2 = ImageIO.read(getClass().getResourceAsStream("/player/duck_walking_left_2.png"));
//            walkingLeft2 = uTool.scaleImage(walkingLeft2, GamePanel.tileSize, GamePanel.tileSize);
//
//     //       swimmingUp1 = ImageIO.read(getClass().getResourceAsStream("/player/duck_swimming_up_1.png"));
//            int type = swimmingUp1.getType();
//            System.out.println(type);
//            swimmingUp1 = uTool.scaleImage(swimmingUp1, GamePanel.tileSize, GamePanel.tileSize);
//
//
//    //        swimmingUp2 = ImageIO.read(getClass().getResourceAsStream("/player/duck_swimming_up_2.png"));
//            swimmingUp2 = uTool.scaleImage(swimmingUp2, GamePanel.tileSize, GamePanel.tileSize);
//
//    //        swimmingDown1 = ImageIO.read(getClass().getResourceAsStream("/player/duck_swimming_down_1.png"));
//            swimmingDown1 = uTool.scaleImage(swimmingDown1, GamePanel.tileSize, GamePanel.tileSize);
//
//    //        swimmingDown2 = ImageIO.read(getClass().getResourceAsStream("/player/duck_swimming_down_2.png"));
//            swimmingDown2 = uTool.scaleImage(swimmingDown2, GamePanel.tileSize, GamePanel.tileSize);
//
//     //       swimmingRight1 = ImageIO.read(getClass().getResourceAsStream("/player/duck_swimming_right_1.png"));
//            swimmingRight1 = uTool.scaleImage(swimmingRight1, GamePanel.tileSize, GamePanel.tileSize);
//
//          //  swimmingRight2 = ImageIO.read(getClass().getResourceAsStream("/player/duck_swimming_right_2.png"));
//            swimmingRight2 = uTool.scaleImage(swimmingRight2, GamePanel.tileSize, GamePanel.tileSize);
//
//        //    swimmingLeft1 = ImageIO.read(getClass().getResourceAsStream("/player/duck_swimming_left_1.png"));
//            swimmingLeft1 = uTool.scaleImage(swimmingLeft1, GamePanel.tileSize, GamePanel.tileSize);
//
//     //       swimmingLeft2 = ImageIO.read(getClass().getResourceAsStream("/player/duck_swimming_left_2.png"));
//            swimmingLeft2 = uTool.scaleImage(swimmingLeft2, GamePanel.tileSize, GamePanel.tileSize);
//
//      //      walkingUpStationary = ImageIO.read(getClass().getResourceAsStream("/player/duck_stationary_up.png"));
//            walkingUpStationary = uTool.scaleImage(walkingUpStationary, GamePanel.tileSize, GamePanel.tileSize);
//
////            walkingDownStationary = ImageIO.read(getClass().getResourceAsStream("/player/duck_stationary_down.png"));
//            walkingDownStationary = uTool.scaleImage(walkingDownStationary, GamePanel.tileSize, GamePanel.tileSize);

//        } catch (IOException e){
//            e.printStackTrace();
//            System.out.println("Error loading player sprites:");
//            System.exit(1);
        }

    public BufferedImage setup(String imagePath) {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/player/duck_"+imagePath+ ".png"));
            int type = image.getType();
            System.out.println("Image Path:"+imagePath);
            System.out.println(type);
            image = uTool.scaleImage(image, GamePanel.tileSize, GamePanel.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
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
            if (keyH.downPressed) {
                direction = "down";
            }
            if (keyH.leftPressed) {
                direction = "left";
            }
            if (keyH.rightPressed) {
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
                // can't walk through walls!
            } else {
                if (isSwimming) {  //swimming
                    speed = swimmingSpeed;
                } else { // walking
                    speed = walkingSpeed;
                }
                switch (direction) {
                    case "up" -> worldY -= speed;
                    case "down" -> worldY += speed;
                    case "left" -> worldX -= speed;
                    case "right" -> worldX += speed;
                }
            }
        } else {
            isStationary = true;
        }
    }
    public void pickUpObject(int i) {
        if (i != 999) {
            String objName = gp.obj[i].name;
            switch (objName) {
                case "Chest": // opening the chest means you beat the level.
                    Sound.FANFARE.play();
                    gp.obj[i] = null;
                    break;
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
        g2.drawImage(image, screenX, screenY, null);
        //g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);
    }
}
