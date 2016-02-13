package siam.graphics;

import siam.player.Theme;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

public class TextureManager {

    public static TextureManager library = new TextureManager();

    private HashMap<Theme,HashMap<String,BufferedImage>> images;
    private String standardPath = "/textures/images/standard/";
    private String starwarsPath = "/textures/images/starwars/";
    private String christmasPath = "/textures/images/christmas/";

    public TextureManager() {
        images = new HashMap<>();
        loadStandard();
        loadStarWars();
        loadChristmas();
    }

    private void loadStandard() {
        images.put(Theme.STANDARD, new HashMap<String, BufferedImage>());
        images.get(Theme.STANDARD).put("Black Background", loadImage( standardPath, "BlackBackground.jpeg"));
        images.get(Theme.STANDARD).put("White Background", loadImage(standardPath, "WhiteBackground.jpeg"));
        images.get(Theme.STANDARD).put("Camp Background", loadImage(standardPath, "CampBackground.png"));
        images.get(Theme.STANDARD).put("Menu Background", loadImage(standardPath, "MenuBackground.jpg"));
        images.get(Theme.STANDARD).put("Button Background", loadImage(standardPath, "ButtonBackground.jpg"));
    }
    private void loadStarWars() {
        images.put(Theme.STARWARS, new HashMap<String, BufferedImage>());
        images.get(Theme.STARWARS).put("Black Background", loadImage(starwarsPath, "BlackBackground.jpeg"));
        images.get(Theme.STARWARS).put("White Background", loadImage(starwarsPath, "WhiteBackground.jpeg"));
        images.get(Theme.STARWARS).put("Camp Background", loadImage(starwarsPath, "CampBackground.png"));
        images.get(Theme.STARWARS).put("Menu Background", loadImage(starwarsPath, "MenuBackground.jpg"));
        images.get(Theme.STARWARS).put("Button Background", loadImage(starwarsPath, "ButtonBackground.jpg"));
    }
    private void loadChristmas() {
        images.put(Theme.CHRISTMAS, new HashMap<String, BufferedImage>());
        images.get(Theme.CHRISTMAS).put("Black Background", loadImage(christmasPath, "BlackBackground.jpg"));
        images.get(Theme.CHRISTMAS).put("White Background", loadImage(christmasPath, "WhiteBackground.jpeg"));
        images.get(Theme.CHRISTMAS).put("Camp Background", loadImage(christmasPath, "CampBackground.jpg"));
        images.get(Theme.CHRISTMAS).put("Menu Background", loadImage(christmasPath, "MenuBackground.jpg"));
        images.get(Theme.CHRISTMAS).put("Button Background", loadImage(christmasPath, "ButtonBackground.jpg"));
    }

    private BufferedImage loadImage(String path, String name) {
        try {
            return ImageIO.read(getClass().getResource(path + name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception ! Could not load " + name + " !");
        }
        return null;
    }

    public BufferedImage getImage(Theme theme, String name) {
        return images.get(theme).get(name);
    }
}