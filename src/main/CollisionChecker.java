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

        int curLeftCol = entityLeftWorldX/gp.tileSize;
        int curRightCol = (entityRightWorldX/gp.tileSize);
        int curTopRow = entityTopWorldY/gp.tileSize;
        int curBottomRow = entityBottomWorldY/gp.tileSize;

        Tile tile1, tile2;

        switch (entity.direction) {
            case "right":
                int nextRightCol = ((entityRightWorldX + entity.speed)/gp.tileSize);
                tile1 = gp.tileM.tile[nextRightCol][curTopRow];
                tile2 = gp.tileM.tile[nextRightCol][curBottomRow];
                if (!tile1.isPassable() || !tile2.isPassable()) {
                    entity.collisionOn = true;
                } else if(tile1.isSwimable()) {
                    entity.isSwimming = true;
                }
                break;
            case "left":
                int nextLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tile1 = gp.tileM.tile[nextLeftCol][curTopRow];
                tile2 = gp.tileM.tile[nextLeftCol][curBottomRow];
                if (!tile1.isPassable() || !tile2.isPassable()) {
                    entity.collisionOn = true;
                } else if(tile1.isSwimable()) {
                    entity.isSwimming = true;
                }
                break;

            case "up":
                int nextTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
                tile1 = gp.tileM.tile[curLeftCol][nextTopRow];
                tile2 = gp.tileM.tile[curRightCol][nextTopRow];
                if (!tile1.isPassable() || !tile2.isPassable()) {
                    entity.collisionOn = true;
                } else if(tile1.isSwimable()) {
                    entity.isSwimming = true;
                }
                break;
            case "down":
                int nextBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
                tile1 = gp.tileM.tile[curLeftCol][nextBottomRow];
                tile2 = gp.tileM.tile[curRightCol][nextBottomRow];
                if (!tile1.isPassable() || !tile2.isPassable()) {
                    entity.collisionOn = true;
                } else if(tile1.isSwimable()) {
                    entity.isSwimming = true;
                }
                break;

        }
    }
}
