package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class BootsObject  extends SuperObject {
    GamePanel gp;
    public BootsObject(GamePanel gp) {
        name = "Boots";
        isPassable = false;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/boots.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error when reading resource location at BootsObject 13");
        }
    }

}
