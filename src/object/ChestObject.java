package object;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ChestObject extends SuperObject {
//    UtilityTool uTool = new UtilityTool();

    public ChestObject(GamePanel gp) {
        super(2);
        imageWidth = GamePanel.tileSize;
        imageHeight = GamePanel.tileSize;
        name = "Chest";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
//            image = uTool.scaleImage(image, GamePanel.tileSize, GamePanel.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error when reading resource location at ChestObject 12");
        }
        isPassable = false;
    }

}

