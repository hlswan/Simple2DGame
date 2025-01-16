package tile;

import main.GamePanel;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    public Tile[][] tile;


    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[GamePanel.maxWorldCol][GamePanel.maxWorldRow];

        loadMap();
    }

    public void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream("/maps/forest.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (row < GamePanel.maxWorldRow) {
                String line = br.readLine();

                String[] strs = line.split(" ");
                while (col < GamePanel.maxWorldCol) {
                    tile[col][row] = Tile.convertTileFromStr(strs[col]);
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


        while(worldRow < GamePanel.maxWorldRow) {
            while (worldCol < GamePanel.maxWorldCol) {
                Tile tile = this.tile[worldCol][worldRow];
                int worldX = worldCol * GamePanel.tileSize;
                int worldY = worldRow * GamePanel.tileSize;

                int screenX = worldX - gp.player.worldX + gp.player.screenX;
                int screenY = worldY - gp.player.worldY + gp.player.screenY;



                g2.drawImage(tile.getImage(), screenX, screenY, null);
                worldCol++;
            }
                worldCol = 0;
                worldRow++;
        }
    }
}
