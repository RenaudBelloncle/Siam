package siam.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

public class TextureManager {

    public static TextureManager library = new TextureManager();

    private HashMap<String,BufferedImage> images;

    public TextureManager() {
        images = new HashMap<>();
        images.put("Black Background", loadImage("BlackBackground.jpeg"));
        images.put("Button Background", loadImage("ButtonBackground.jpg"));
        images.put("Camp Background", loadImage("CampBackground.png"));
        images.put("Menu Background", loadImage("MenuBackground.jpg"));
        images.put("White Background", loadImage("WhiteBackground.jpeg"));
    }

    private BufferedImage loadImage(String name) {
        try {
            return ImageIO.read(getClass().getResource("/textures/images/standard/" + name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception ! Could not load " + name + " !");
        }
        return null;
    }

    public BufferedImage getImage(String name) {
        return images.get(name);
    }
}