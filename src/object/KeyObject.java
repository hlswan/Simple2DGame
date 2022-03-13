package object;

import javax.imageio.ImageIO;
import java.io.IOException;
;
import main.GamePanel;

public class KeyObject extends SuperObject {
    GamePanel gp;
    public KeyObject(GamePanel gp) {
        name = "Key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error when reading resource location at KeyObject 12");
        }
        worldX = 5 * gp.tileSize;
        worldY = 5 * gp.tileSize;
    }

}
