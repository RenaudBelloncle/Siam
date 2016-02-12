package siam.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {

    public static SpriteSheet standard = new SpriteSheet("/textures/sheets/standardsheet.png", 384);
    public static SpriteSheet christmas = new SpriteSheet("/textures/sheets/christmassheet.png", 384);
    public static SpriteSheet starwars = new SpriteSheet("/textures/sheets/starwarssheet.png", 384);

    private String path;
    private final int SIZE;
    private int[] pixels;

    public SpriteSheet(String path, int size) {
        this.path = path;
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        load();
    }

    private void load() {
        try {
            BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
            int width = image.getWidth();
            int heigth = image.getHeight();
            image.getRGB(0, 0, width, heigth, pixels, 0, width);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception ! Could not load sprite sheet !");
        }
    }

    public int getSize() {
        return SIZE;
    }

    public int getPixel(int i) {
        return pixels[i];
    }

}
