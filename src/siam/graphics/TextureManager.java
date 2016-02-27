package siam.graphics;

import siam.player.Theme;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

public class TextureManager {

    public static TextureManager library = new TextureManager();

    private HashMap<Theme,HashMap<String,BufferedImage>> images;

    public TextureManager() {
        images = new HashMap<>();
        loadStandard();
        loadStarWars();
        loadChristmas();
    }

    private void loadStandard() {
        images.put(Theme.STANDARD, new HashMap<String, BufferedImage>());
        String standardPath = "/textures/images/standard/";
        images.get(Theme.STANDARD).put("Black Background", loadImage(standardPath, "BlackBackground.jpeg"));
        images.get(Theme.STANDARD).put("White Background", loadImage(standardPath, "WhiteBackground.jpeg"));
        images.get(Theme.STANDARD).put("Camp Background", loadImage(standardPath, "CampBackground.png"));
        images.get(Theme.STANDARD).put("Menu Background", loadImage(standardPath, "MenuBackground.jpg"));
        images.get(Theme.STANDARD).put("Button Background", loadImage(standardPath, "ButtonBackground.jpg"));
        images.get(Theme.STANDARD).put("Button Put", loadImage(standardPath, "Put.jpg"));
        images.get(Theme.STANDARD).put("Button Put Selected", loadImage(standardPath, "PutSelected.jpg"));
        images.get(Theme.STANDARD).put("Button Bring Out", loadImage(standardPath, "BringOut.jpg"));
        images.get(Theme.STANDARD).put("Button Move", loadImage(standardPath, "Move.jpg"));
        images.get(Theme.STANDARD).put("Button Move Selected", loadImage(standardPath, "MoveSelected.jpg"));
        images.get(Theme.STANDARD).put("Button Orient", loadImage(standardPath, "Orient.jpg"));
        images.get(Theme.STANDARD).put("Button Top", loadImage(standardPath, "Top.jpg"));
        images.get(Theme.STANDARD).put("Button Left", loadImage(standardPath, "Left.jpg"));
        images.get(Theme.STANDARD).put("Button Right", loadImage(standardPath, "Right.jpg"));
        images.get(Theme.STANDARD).put("Button Bottom", loadImage(standardPath, "Bottom.jpg"));
    }

    private void loadStarWars() {
        images.put(Theme.STARWARS, new HashMap<String, BufferedImage>());
        String starwarsPath = "/textures/images/starwars/";
        images.get(Theme.STARWARS).put("Black Background", loadImage(starwarsPath, "BlackBackground.jpeg"));
        images.get(Theme.STARWARS).put("White Background", loadImage(starwarsPath, "WhiteBackground.jpeg"));
        images.get(Theme.STARWARS).put("Camp Background", loadImage(starwarsPath, "CampBackground.png"));
        images.get(Theme.STARWARS).put("Menu Background", loadImage(starwarsPath, "MenuBackground.jpg"));
        images.get(Theme.STARWARS).put("Button Background", loadImage(starwarsPath, "ButtonBackground.jpg"));
        images.get(Theme.STARWARS).put("Button Put", loadImage(starwarsPath, "Put.jpg"));
        images.get(Theme.STARWARS).put("Button Put Selected", loadImage(starwarsPath, "PutSelected.jpg"));
        images.get(Theme.STARWARS).put("Button Bring Out", loadImage(starwarsPath, "BringOut.jpg"));
        images.get(Theme.STARWARS).put("Button Move", loadImage(starwarsPath, "Move.jpg"));
        images.get(Theme.STARWARS).put("Button Move Selected", loadImage(starwarsPath, "MoveSelected.jpg"));
        images.get(Theme.STARWARS).put("Button Orient", loadImage(starwarsPath, "Orient.jpg"));
        images.get(Theme.STARWARS).put("Button Top", loadImage(starwarsPath, "Top.jpg"));
        images.get(Theme.STARWARS).put("Button Left", loadImage(starwarsPath, "Left.jpg"));
        images.get(Theme.STARWARS).put("Button Right", loadImage(starwarsPath, "Right.jpg"));
        images.get(Theme.STARWARS).put("Button Bottom", loadImage(starwarsPath, "Bottom.jpg"));
    }

    private void loadChristmas() {
        images.put(Theme.CHRISTMAS, new HashMap<String, BufferedImage>());
        String christmasPath = "/textures/images/christmas/";
        images.get(Theme.CHRISTMAS).put("Black Background", loadImage(christmasPath, "BlackBackground.jpg"));
        images.get(Theme.CHRISTMAS).put("White Background", loadImage(christmasPath, "WhiteBackground.jpeg"));
        images.get(Theme.CHRISTMAS).put("Camp Background", loadImage(christmasPath, "CampBackground.jpg"));
        images.get(Theme.CHRISTMAS).put("Menu Background", loadImage(christmasPath, "MenuBackground.jpg"));
        images.get(Theme.CHRISTMAS).put("Button Background", loadImage(christmasPath, "ButtonBackground.jpg"));
        images.get(Theme.CHRISTMAS).put("Button Put", loadImage(christmasPath, "Put.jpg"));
        images.get(Theme.CHRISTMAS).put("Button Put Selected", loadImage(christmasPath, "PutSelected.jpg"));
        images.get(Theme.CHRISTMAS).put("Button Bring Out", loadImage(christmasPath, "BringOut.jpg"));
        images.get(Theme.CHRISTMAS).put("Button Move", loadImage(christmasPath, "Move.jpg"));
        images.get(Theme.CHRISTMAS).put("Button Move Selected", loadImage(christmasPath, "MoveSelected.jpg"));
        images.get(Theme.CHRISTMAS).put("Button Orient", loadImage(christmasPath, "Orient.jpg"));
        images.get(Theme.CHRISTMAS).put("Button Top", loadImage(christmasPath, "Top.jpg"));
        images.get(Theme.CHRISTMAS).put("Button Left", loadImage(christmasPath, "Left.jpg"));
        images.get(Theme.CHRISTMAS).put("Button Right", loadImage(christmasPath, "Right.jpg"));
        images.get(Theme.CHRISTMAS).put("Button Bottom", loadImage(christmasPath, "Bottom.jpg"));
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