package main;

import object.KeyObject;


public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }


    public void setObject() {
        gp.obj[0] = new KeyObject();
        gp.obj[0].worldX = 4;
        gp.obj[0].worldY = 4;

    }
}
