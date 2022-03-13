package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ChestObject extends SuperObject {
    GamePanel gp;
    public ChestObject(GamePanel gp) {
        name = "Chest";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error when reading resource location at ChestObject 12");
        }
        worldX = 8 * gp.tileSize;
        worldY = 12 * gp.tileSize;
    }

}

