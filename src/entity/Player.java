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
    public boolean interacting = false;
    private final double interactTimer = 3;




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
        if (keyH.interactPressed) {
            interacting = true;
            System.out.println("Pressing the Interact Key");
            int objI = gp.collisionChecker.checkObject(this, true);
            interact(objI);
        }
        if (keyH.upPressed || keyH.downPressed || keyH.rightPressed || keyH.leftPressed) {
            isStationary = false;

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

            //checks if the tile you want to move into is passable or water etc...
            gp.collisionChecker.checkTile(this); //checks if the tile you want to move into is passable or water etc...
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
            interacting = false;
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
    public void interact(int i) {

        if (i != 999) {
            System.out.println("Interact is Running");
            String objName = gp.obj[i].name;
            switch (objName) {
                case "duckNPC": // opening the chest means you beat the level.
                    Sound.FANFARE.play();
                    GamePanel.gameState = 3;
                    System.out.println("Game State is dialogue");// dialogue state
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
