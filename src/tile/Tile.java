package tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

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
    public boolean isSwimable() { return swimable;}

    public static Tile GRASS = new Tile(true, true, false, "/tiles/grass/grass_tile_blank.png");
    public static Tile GRASS_ONE = new Tile(true, true, false, "/tiles/grass/grass_tile_1.png");
    public static Tile GRASS_TWO = new Tile(true, true, false, "/tiles/grass/grass_tile_2.png");
    public static Tile GRASS_THREE = new Tile(true, true, false, "/tiles/grass/grass_tile_3.png");
    public static Tile GRASS_FOUR = new Tile(true, true, false, "/tiles/grass/grass_tile_4.png");
    public static Tile GRASS_FIVE = new Tile(true, true, false, "/tiles/grass/grass_tile_5.png");
    public static Tile GRASS_SIX = new Tile(true, true, false, "/tiles/grass/grass_tile_6.png");
    public static Tile GRASS_SEVEN = new Tile(true, true, false, "/tiles/grass/grass_tile_7.png");
    public static Tile WATER = new Tile(true, false, true, "/tiles/water/water_tile_blank.png");
    public static Tile FENCE = new Tile(false, false, false, "/tiles/fence/basic_fence.png");
    public static Tile convertTileFromStr(String tileType) {
        Tile tile;
        switch (tileType) {
            case "wtr":
                tile = Tile.WATER;
                break;
            case "grs":
                tile = Tile.GRASS;
                break;
            case "fnc":
                tile = Tile.FENCE;
                break;
            case "gr1":
                tile = Tile.GRASS_ONE;
                break;
            case "gr2":
                tile = Tile.GRASS_TWO;
            case "gr3":
                tile = Tile.GRASS_THREE;
                break;
            case "gr4":
                tile = Tile.GRASS_FOUR;
                break;
            case "gr5":
                tile = Tile.GRASS_FIVE;
                break;
            case "gr6":
                tile = Tile.GRASS_SIX;
                break;
            case "gr7":
                tile = Tile.GRASS_SEVEN;
                break;


            default:
                throw new IllegalStateException("Unexpected value: " + tileType);
        }
        return tile;
    }

}
