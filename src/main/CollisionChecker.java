package main;

import entity.Entity;
import tile.Tile;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }
    public void checkTile(Entity entity) {

        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        Tile tile1, tile2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
                tile1 = gp.tileM.tile[entityLeftCol][entityTopRow];
                tile2 = gp.tileM.tile[entityRightCol][entityTopRow];
                if (!tile1.isPassable() || !tile2.isPassable()) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY - entity.speed)/gp.tileSize;
                tile1 = gp.tileM.tile[entityLeftCol][entityBottomRow];
                tile2 = gp.tileM.tile[entityRightCol][entityBottomRow];
                if (!tile1.isPassable() || !tile2.isPassable()) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
                tile1 = gp.tileM.tile[entityLeftCol][entityLeftCol];
                tile2 = gp.tileM.tile[entityRightCol][entityLeftCol];
                if (!tile1.isPassable() || !tile2.isPassable()) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX - entity.speed)/gp.tileSize;
                tile1 = gp.tileM.tile[entityRightCol][entityRightCol];
                tile2 = gp.tileM.tile[entityLeftCol][entityRightCol];
                if (!tile1.isPassable() || !tile2.isPassable()) {
                    entity.collisionOn = true;
                }
                break;
        }
    }
}
