package main;

import entity.DuckNPC;
import object.*;


public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }


    public void setObject() {
        gp.obj[0] = new ChestObject(gp);
        gp.obj[0].worldX = 10 * GamePanel.tileSize;
        gp.obj[0].worldY = 10 * GamePanel.tileSize;

        gp.obj[1] = new DuckObject(gp);
        gp.obj[1].worldX = DuckObject.tileLocationX;
        gp.obj[1].worldY = DuckObject.tileLocationY;
    }
    public void setNPC() {
        gp.NPC[0] = new DuckNPC(gp);
        gp.NPC[0].worldX = DuckObject.tileLocationX;
        gp.NPC[0].worldY = DuckObject.tileLocationY;
    }
}
