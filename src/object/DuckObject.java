package object;

import main.GamePanel;

import javax.imageio.ImageIO;

import java.io.IOException;

public class DuckObject extends SuperObject {
    public static int tileLocationX = GamePanel.tileSize * 12;
    public static int tileLocationY = GamePanel.tileSize * 12;
    public DuckObject(GamePanel gp) {
        imageWidth = GamePanel.tileSize;
        imageHeight = GamePanel.tileSize;


        name = "DuckNPC";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/duckNPCCollisionBox.png"));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error when reading resource location at DuckObject 16");
        }
        isPassable = false;
    }

}
