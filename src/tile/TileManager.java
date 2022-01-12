package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    public String mapTile[][];


    public TileManager(GamePanel gp) {
        this.gp = gp;

        mapTile = new String[gp.maxWorldCol][gp.maxWorldRow];


        loadMap();
    }

    public void loadMap() {

        try {
            InputStream is = getClass().getResourceAsStream("/maps/map.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (row < gp.maxWorldRow) {
                String line = br.readLine();

                String[] strs = line.split(" ");
                while (col < gp.maxWorldCol) {
                    mapTile[col][row] = strs[col];
                    col++;
                }
                col = 0;
                row++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2) {

        int worldCol = 0;
        int worldRow = 0;


        while(worldRow < gp.maxWorldRow) {
            while (worldCol < gp.maxWorldCol) {
                String tileType = mapTile[worldCol][worldRow];
                Tile tile;
                switch (tileType) {
                    case "wa":
                        tile = Tile.WATER;
                        break;
                    case "gr":
                        tile = Tile.GRASS;
                        break;
                    case "fn":
                        tile = Tile.FENCE;

                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + tileType);
                }
                int worldX = worldCol * gp.tileSize;
                int worldY = worldRow * gp.tileSize;

                int screenX = worldX - gp.player.worldX + gp.player.screenX;
                int screenY = worldY - gp.player.worldY + gp.player.screenY;
                g2.drawImage(tile.getImage(), screenX, screenY, gp.tileSize, gp.tileSize, null);
                worldCol++;
            }
                worldCol = 0;
                worldRow++;
        }
    }
}
