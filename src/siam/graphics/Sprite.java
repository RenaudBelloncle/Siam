package siam.graphics;

public class Sprite {

    public static Sprite tile = new Sprite(128, 0, 0, SpriteSheet.standard);
    public static Sprite bannedTile = new Sprite(128, 1, 0, SpriteSheet.standard);

    public static Sprite focus = new Sprite(128, 2, 0, SpriteSheet.standard);

    public static Sprite mountain = new Sprite(128, 0, 1, SpriteSheet.standard);
    public static Sprite whiteMountain = new Sprite(128, 1, 1, SpriteSheet.standard);
    public static Sprite blackMountain = new Sprite(128, 2, 1, SpriteSheet.standard);

    public static Sprite whitePiece = new Sprite(128, 0, 2, SpriteSheet.standard);
    public static Sprite blackPiece = new Sprite(128, 1, 2, SpriteSheet.standard);

    private final int SIZE;
    private int x, y;
    private int width, heigth;
    private int[] pixels;
    private SpriteSheet sheet;

    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        SIZE = size;
        this.width = size;
        this.heigth = size;
        pixels = new int[SIZE * SIZE];
        this.x = x * SIZE;
        this.y = y * SIZE;
        this.sheet = sheet;
        load();
    }

    public Sprite(int[] pixels, int width, int heigth) {
        SIZE = (width == heigth) ? width : -1;
        this.width = width;
        this.heigth = heigth;
        this.pixels = new int[pixels.length];
        System.arraycopy(pixels, 0, this.pixels, 0, pixels.length);
    }

    public void changeToChristmas(){

        tile = new Sprite(128, 0, 0, SpriteSheet.christmas);
        bannedTile = new Sprite(128, 1, 0, SpriteSheet.christmas);

        focus = new Sprite(128, 2, 0, SpriteSheet.christmas);

        mountain = new Sprite(128, 0, 1, SpriteSheet.christmas);
        whiteMountain = new Sprite(128, 1, 1, SpriteSheet.christmas);
        blackMountain = new Sprite(128, 2, 1, SpriteSheet.christmas);

        whitePiece = new Sprite(128, 0, 2, SpriteSheet.christmas);
        blackPiece = new Sprite(128, 1, 2, SpriteSheet.christmas);
    }

    public void changeToStarWars(){

        tile = new Sprite(128, 0, 0, SpriteSheet.starwars);
        bannedTile = new Sprite(128, 1, 0, SpriteSheet.starwars);

        focus = new Sprite(128, 2, 0, SpriteSheet.starwars);

        mountain = new Sprite(128, 0, 1, SpriteSheet.starwars);
        whiteMountain = new Sprite(128, 1, 1, SpriteSheet.starwars);
        blackMountain = new Sprite(128, 2, 1, SpriteSheet.starwars);

        whitePiece = new Sprite(128, 0, 2, SpriteSheet.starwars);
        blackPiece = new Sprite(128, 1, 2, SpriteSheet.starwars);
    }

    public void changeToStandard(){

        tile = new Sprite(128, 0, 0, SpriteSheet.standard);
        bannedTile = new Sprite(128, 1, 0, SpriteSheet.standard);

        focus = new Sprite(128, 2, 0, SpriteSheet.standard);

        mountain = new Sprite(128, 0, 1, SpriteSheet.standard);
        whiteMountain = new Sprite(128, 1, 1, SpriteSheet.standard);
        blackMountain = new Sprite(128, 2, 1, SpriteSheet.standard);

        whitePiece = new Sprite(128, 0, 2, SpriteSheet.standard);
        blackPiece = new Sprite(128, 1, 2, SpriteSheet.standard);
    }

    public static Sprite rotate(Sprite sprite, double angle) {
        return new Sprite(rotate(sprite.pixels, sprite.width, sprite.heigth, angle), sprite.width, sprite.heigth);
    }

    private static int[] rotate(int[] pixels, int width, int heigth, double angle) {
        int[] result = new int[width * heigth];

        double nx_x = rot_x(-angle, 1.0, 0.0);
        double nx_y = rot_y(-angle, 1.0, 0.0);
        double ny_x = rot_x(-angle, 0.0, 1.0);
        double ny_y = rot_y(-angle, 0.0, 1.0);

        double x0 = rot_x(-angle, -width / 2.0, -heigth / 2.0) + width / 2.0;
        double y0 = rot_y(-angle, -width / 2.0, -heigth / 2.0) + heigth / 2.0;

        for (int y = 0; y < heigth; y++) {
            double x1 = x0;
            double y1 = y0;
            for (int x = 0; x < width; x++) {
                int xx = (int) x1;
                int yy = (int) y1;
                int col;
                if (xx < 0 || xx >= width || yy < 0 || yy >= heigth) col = 0xFFFF00FF;
                else col = pixels[xx + yy * width];
                result[x + y * width] = col;
                x1 += nx_x;
                y1 += nx_y;
            }
            x0 += ny_x;
            y0 += ny_y;
        }

        return result;
    }

    private static double rot_x(double angle, double x, double y) {
        double cos = Math.cos(angle - Math.PI / 2);
        double sin = Math.sin(angle - Math.PI / 2);
        return x * cos + y * -sin;
    }

    private static double rot_y(double angle, double x, double y) {
        double cos = Math.cos(angle - Math.PI / 2);
        double sin = Math.sin(angle - Math.PI / 2);
        return x * sin + y * cos;
    }

    private void load() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                pixels[x + y * SIZE] = sheet.getPixel((x + this.x) + (y + this.y) * sheet.getSize());
            }
        }
    }

    public int getSize() {
        return SIZE;
    }

    public int getPixel(int i) {
        return pixels[i];
    }
}
