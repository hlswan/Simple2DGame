package object;

import javax.imageio.ImageIO;
import java.io.IOException;
;
import main.GamePanel;

public class KeyObject extends SuperObject {
    GamePanel gp;
    public KeyObject(GamePanel gp) {
        name = "Key";
        isPassable = false;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error when reading resource location at KeyObject 12");
        }
    }

}
