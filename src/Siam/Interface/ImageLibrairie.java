package Siam.Interface;

import Siam.Enum.Theme;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

public class ImageLibrairie {

    public static ImageLibrairie imageLibrairie = new ImageLibrairie();

    private HashMap<Theme,HashMap<String,BufferedImage>> imageCollection;

    public ImageLibrairie() {
        imageCollection = new HashMap<>();
        imageCollection.put(Theme.STANDARD, new HashMap<String, BufferedImage>());
        imageCollection.put(Theme.NOEL, new HashMap<String, BufferedImage>());
        BufferedImage image;
        try {
            image = ImageIO.read(getClass().getResource("/Standard/Images/StandardFondMenu.jpg"));
            imageCollection.get(Theme.STANDARD).put("FondMenu", image);
            image = ImageIO.read(getClass().getResource("/Standard/Images/StandardFondCamp.png"));
            imageCollection.get(Theme.STANDARD).put("FondCamp", image);
            image = ImageIO.read(getClass().getResource("/Standard/Sprites/Case.png"));
            imageCollection.get(Theme.STANDARD).put("Case", image);
            image = ImageIO.read(getClass().getResource("/Standard/Sprites/Elephant.png"));
            imageCollection.get(Theme.STANDARD).put("Elephant", image);
            image = ImageIO.read(getClass().getResource("/Standard/Sprites/Rhinoceros.png"));
            imageCollection.get(Theme.STANDARD).put("Rhinoceros", image);
            image = ImageIO.read(getClass().getResource("/Standard/Sprites/ElephantGauche.png"));
            imageCollection.get(Theme.STANDARD).put("ElephantGauche", image);
            image = ImageIO.read(getClass().getResource("/Standard/Sprites/RhinocerosGauche.png"));
            imageCollection.get(Theme.STANDARD).put("RhinocerosGauche", image);
            image = ImageIO.read(getClass().getResource("/Standard/Sprites/Montagne.png"));
            imageCollection.get(Theme.STANDARD).put("Montagne", image);
            image = ImageIO.read(getClass().getResource("/Standard/Sprites/Focus.png"));
            imageCollection.get(Theme.STANDARD).put("Focus", image);
            image = ImageIO.read(getClass().getResource("/Noel/Images/NoelFondMenu.jpg"));
            imageCollection.get(Theme.NOEL).put("FondMenu", image);
        } catch (IOException e) { System.out.println(e.getMessage()); }
    }

    public BufferedImage getImage(Theme theme, String titre) {
        return imageCollection.get(theme).get(titre);
    }
}
