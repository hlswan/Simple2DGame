package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class DuckNPC extends Entity {
    public DuckNPC(GamePanel gp) {
        super(gp);
        direction = "down";
        speed = 2;
        getImage();
    }
    public void setAction() {

    }
    public void getImage() {
        try {

            walkingUp1 = ImageIO.read(getClass().getResourceAsStream("/npc/duck_walking_up_1.png"));

            walkingUp2 = ImageIO.read(getClass().getResourceAsStream("/npc/duck_walking_up_2.png"));

            walkingDown1 = ImageIO.read(getClass().getResourceAsStream("/npc/duck_walking_down_1.png"));

            walkingDown2 = ImageIO.read(getClass().getResourceAsStream("/npc/duck_walking_down_2.png"));

            walkingRight1 = ImageIO.read(getClass().getResourceAsStream("/npc/duck_walking_right_1.png"));

            walkingRight2 = ImageIO.read(getClass().getResourceAsStream("/npc/duck_walking_right_2.png"));

            walkingLeft1 = ImageIO.read(getClass().getResourceAsStream("/npc/duck_walking_left_1.png"));

            walkingLeft2 = ImageIO.read(getClass().getResourceAsStream("/npc/duck_walking_left_2.png"));

            swimmingUp1 = ImageIO.read(getClass().getResourceAsStream("/npc/duck_swimming_up_1.png"));

            swimmingUp2 = ImageIO.read(getClass().getResourceAsStream("/npc/duck_swimming_up_2.png"));

            swimmingDown1 = ImageIO.read(getClass().getResourceAsStream("/npc/duck_swimming_down_1.png"));

            swimmingDown2 = ImageIO.read(getClass().getResourceAsStream("/npc/duck_swimming_down_2.png"));

            swimmingRight1 = ImageIO.read(getClass().getResourceAsStream("/npc/duck_swimming_right_1.png"));

            swimmingRight2 = ImageIO.read(getClass().getResourceAsStream("/npc/duck_swimming_right_2.png"));

            swimmingLeft1 = ImageIO.read(getClass().getResourceAsStream("/npc/duck_swimming_left_1.png"));

            swimmingLeft2 = ImageIO.read(getClass().getResourceAsStream("/npc/duck_swimming_left_2.png"));

            walkingUpStationary = ImageIO.read(getClass().getResourceAsStream("/npc/duck_stationary_up.png"));

            walkingDownStationary = ImageIO.read(getClass().getResourceAsStream("/npc/duck_stationary_down.png"));

        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error loading player sprites:");
            System.exit(1);
        }
    }
}
