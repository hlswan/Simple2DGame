package tile;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Tile {

    private BufferedImage image;
    private boolean passable = true;
    private boolean walkable = true;
    private boolean swimable = false;
    UtilityTool uTool = new UtilityTool();

    private Tile(boolean passable, boolean walkable, boolean swimable, String imagePath) {
        this.passable =  passable;
        this.walkable = walkable;
        this.swimable = swimable;
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream("/tiles/"+imagePath+".png"));
            this.image = uTool.scaleImage(image, GamePanel.tileSize, GamePanel.tileSize);
        } catch (Exception e) {
            System.out.println("Tile Image Error. Image Path: "+imagePath);
            e.printStackTrace();
            System.exit(1);
        }

    }

    public BufferedImage getImage() { return image;}
    public boolean isPassable() { return passable;}
    public boolean isSwimable() { return swimable;}

    public static Tile GRASS = new Tile(true, true, false, "grass/grass_tile_blank");
    public static Tile GRASS_ONE = new Tile(true, true, false, "grass/grass_tile_1");
    public static Tile GRASS_TWO = new Tile(true, true, false, "grass/grass_tile_2");
    public static Tile GRASS_THREE = new Tile(true, true, false, "grass/grass_tile_3");
    public static Tile GRASS_FOUR = new Tile(true, true, false, "grass/grass_tile_4");
    public static Tile GRASS_FIVE = new Tile(true, true, false, "grass/grass_tile_5");
    public static Tile GRASS_SIX = new Tile(true, true, false, "grass/grass_tile_6");
    public static Tile GRASS_SEVEN = new Tile(true, true, false, "/grass/grass_tile_7");

    public static Tile WATER = new Tile(true, false, true, "water/water_tile_blank");
    public static Tile SHORE_TOP = new Tile(true, false, true, "water/shore_top");
    public static Tile SHORE_BOTTOM = new Tile(true, false, true, "water/shore_bottom");
    public static Tile SHORE_LEFT = new Tile(true, false, true, "water/shore_left");
    public static Tile SHORE_RIGHT = new Tile(true, false, true, "water/shore_right");
    public static Tile SHORE_TOP_LEFT = new Tile(true, false, true, "water/shore_top_left");
    public static Tile SHORE_TOP_RIGHT = new Tile(true, false, true, "water/shore_top_right");
    public static Tile SHORE_BOTTOM_LEFT = new Tile(true, false, true, "water/shore_bottom_left");
    public static Tile SHORE_BOTTOM_RIGHT = new Tile(true, false, true, "water/shore_bottom_right");
    public static Tile SHORE_WATER_TOP_LEFT = new Tile(true, false, true, "water/shore_water_top_left");
    public static Tile SHORE_WATER_TOP_RIGHT = new Tile(true, false, true, "water/shore_water_top_right");
    public static Tile SHORE_WATER_BOTTOM_LEFT = new Tile(true, false, true, "water/shore_water_bottom_left");
    public static Tile SHORE_WATER_BOTTOM_RIGHT = new Tile(true, false, true, "water/shore_water_bottom_right");

    public static Tile TREE = new Tile(false, false, false, "nature/tree");
    public static Tile convertTileFromStr(String tileType) {
        Tile tile;
        switch (tileType) {
            case "wtr":
                tile = Tile.WATER;
                break;
            case "sht":
                tile = Tile.SHORE_TOP;
                break;
            case "shb":
                tile = Tile.SHORE_BOTTOM;
                break;
            case "shr":
                tile = Tile.SHORE_RIGHT;
                break;
            case "shl":
                tile = Tile.SHORE_LEFT;
                break;
            case "str":
                tile = Tile.SHORE_TOP_RIGHT;
                break;
            case "stl":
                tile = Tile.SHORE_TOP_LEFT;
                break;
            case "sbr":
                tile = Tile.SHORE_BOTTOM_RIGHT;
                break;
            case "sbl":
                tile = Tile.SHORE_BOTTOM_LEFT;
                break;
            case "s11":
                tile = Tile.SHORE_WATER_TOP_RIGHT;
                break;
            case "s12":
                tile = Tile.SHORE_WATER_TOP_LEFT;
                break;
            case "s13":
                tile = Tile.SHORE_WATER_BOTTOM_RIGHT;
                break;
            case "s14":
                tile = Tile.SHORE_WATER_BOTTOM_LEFT;
                break;
            case "grs":
                tile = Tile.GRASS;
                break;
            case "tre":
                tile = Tile.TREE;
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
