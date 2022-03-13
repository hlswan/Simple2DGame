package main;

import object.ChestObject;
import object.DoorObject;
import object.KeyObject;


public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }


    public void setObject() {
        gp.obj[0] = new KeyObject(gp);
        gp.obj[0].worldX = 6 * gp.tileSize;
        gp.obj[0].worldY = 5 * gp.tileSize;

        gp.obj[1] = new KeyObject(gp);
        gp.obj[1].worldX = 6 * gp.tileSize;
        gp.obj[1].worldY = 13 * gp.tileSize;

        gp.obj[2] = new KeyObject(gp);
        gp.obj[2].worldX = 16 * gp.tileSize;
        gp.obj[2].worldY = 8 * gp.tileSize;

        gp.obj[3] = new DoorObject(gp);
        gp.obj[3].worldX = 1 * gp.tileSize;
        gp.obj[3].worldY = 10 * gp.tileSize;

        gp.obj[4] = new DoorObject(gp);
        gp.obj[4].worldX = 6 * gp.tileSize;
        gp.obj[4].worldY = 16 * gp.tileSize;

        gp.obj[5] = new DoorObject(gp);
        gp.obj[5].worldX = 22 * gp.tileSize;
        gp.obj[5].worldY = 10 * gp.tileSize;

        gp.obj[6] = new ChestObject(gp);
        gp.obj[6].worldX = 22 * gp.tileSize;
        gp.obj[6].worldY = 22 * gp.tileSize;

        gp.obj[7] = new DoorObject(gp);
        gp.obj[7].worldX = 22 * gp.tileSize;
        gp.obj[7].worldY = 20 * gp.tileSize;

        gp.obj[8] = new DoorObject(gp);
        gp.obj[8].worldX = 20 * gp.tileSize;
        gp.obj[8].worldY = 22 * gp.tileSize;

        gp.obj[9] = new DoorObject(gp);
        gp.obj[9].worldX = 16 * gp.tileSize;
        gp.obj[9].worldY = 5 * gp.tileSize;
    }
}
