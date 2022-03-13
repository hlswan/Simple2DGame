package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class DoorObject extends SuperObject {
    GamePanel gp;
    public DoorObject(GamePanel gp) {
        name = "Door";
        isPassable = false;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error when reading resource location at DoorObject 12");
        }
    }

}
