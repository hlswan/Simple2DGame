package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public int worldX, worldY;
    public int speed;

    public BufferedImage walkingUp1, walkingUp2, walkingDown1, walkingDown2, walkingLeft1, walkingLeft2, walkingRight1, walkingRight2, walkingUpStationary, walkingDownStationary;
    public BufferedImage swimmingUp1, swimmingUp2, swimmingDown1, swimmingDown2, swimmingLeft1, swimmingLeft2, swimmingRight1, swimmingRight2;

    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
    public boolean isStationary = true;
    public Rectangle solidArea;
    public boolean collisionOn = false;
    public boolean isSwimming = false;
    public int solidAreaDefaultX, solidAreaDefaultY;
}
