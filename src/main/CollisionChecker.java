package main;

import entity.Entity;
import tile.Tile;

public class CollisionChecker {
    GamePanel gp;
    private final int dialogueObject = 1;
    private final int itemObject = 2;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }
    public void checkTile(Entity entity) {

        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int curLeftCol = entityLeftWorldX/gp.tileSize;
        int curRightCol = (entityRightWorldX/gp.tileSize);
        int curTopRow = entityTopWorldY/gp.tileSize;
        int curBottomRow = entityBottomWorldY/gp.tileSize;

        Tile tile1, tile2;

        switch (entity.direction) {
            case "right" -> {
                int nextRightCol = ((entityRightWorldX + entity.speed) / gp.tileSize);
                tile1 = gp.tileM.tile[nextRightCol][curTopRow];
                tile2 = gp.tileM.tile[nextRightCol][curBottomRow];
            }
            case "left" -> {
                int nextLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tile1 = gp.tileM.tile[nextLeftCol][curTopRow];
                tile2 = gp.tileM.tile[nextLeftCol][curBottomRow];
            }
            case "up" -> {
                int nextTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tile1 = gp.tileM.tile[curLeftCol][nextTopRow];
                tile2 = gp.tileM.tile[curRightCol][nextTopRow];
            }
            case "down" -> {
                int nextBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tile1 = gp.tileM.tile[curLeftCol][nextBottomRow];
                tile2 = gp.tileM.tile[curRightCol][nextBottomRow];
            }
            default -> throw new IllegalStateException("Error: Unknown Direction");
        }
        if (!tile1.isPassable() || !tile2.isPassable()) {
            entity.collisionOn = true;
        } else if(tile1.isSwimable() || tile2.isSwimable()) {
            entity.isSwimming = true;
        } else {
            entity.isSwimming = false;
            entity.collisionOn = false;
        }
    }
    public int checkObject(Entity entity, boolean player) {
        int index = 999;

        for(int i = 0; i < gp.obj.length; i++) {

            if(gp.obj[i] != null) {
                //Get pos entity's solid area
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;
                //Get pos object's solid area
                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

                switch (entity.direction) { //checks where the player will be when they move next.
                    case "up" -> entity.solidArea.y -= entity.speed;
                    case "down" -> entity.solidArea.y += entity.speed;
                    case "left" -> entity.solidArea.x -= entity.speed;
                    case "right" -> entity.solidArea.x += entity.speed;
                }
                if(entity.solidArea.intersects(gp.obj[i].solidArea)) { //does the players hitbox intersect with the objects hitbox?
                    if (!gp.obj[i].isPassable) { //if the hitboxes do intersect, then is the object passable?
                        entity.collisionOn = true; // if it's not passable then turn on collision, which stops movement
                    } else if (gp.obj[i].objectType == dialogueObject) {
                        System.out.println("something");
                        gp.setGameState(gp.dialogueState);
                    }
                    if (player) {
                        index = i;
                    }
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;


            }
        }
        return index;
    }
}
