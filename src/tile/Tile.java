package tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;

public class Tile {

    private BufferedImage image;
    private boolean passable = true;
    private boolean walkable = true;
    private boolean swimable = false;

    private Tile(boolean passable, boolean walkable, boolean swimable, String imagePath) {
        this.passable =  passable;
        this.walkable = walkable;
        this.swimable = swimable;
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream(imagePath));
        } catch (Exception e) {
            System.out.println("Tile Image Error. Image Path: "+imagePath);
            e.printStackTrace();
            System.exit(1);
        }

    }

    public BufferedImage getImage() { return image;}
    public boolean isPassable() { return passable;}
    public boolean isWalkable() { return walkable;}
    public boolean isSwimable() { return swimable;}

    public static Tile GRASS = new Tile(true, true, false, "/tiles/grass/grass_tile_blank.png");
    public static Tile DETAILED_GRASS_ONE = new Tile(true, true, false, "/tiles/grass/grass_tile_blank.png");
    public static Tile WATER = new Tile(true, false, true, "/tiles/water/water_tile_blank.png");
    public static Tile FENCE = new Tile(false, false, false, "/tiles/fence/basic_fence.png");
    public static Tile convertTileFromStr(String tileType) {
        Tile tile;
        switch (tileType) {
            case "wa":
                tile = Tile.WATER;
                break;
            case "gr":
                tile = Tile.GRASS;
                break;
            case "fe":
                tile = Tile.FENCE;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + tileType);
        }
        return tile;
    }

}
