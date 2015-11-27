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
            image = ImageIO.read(getClass().getResource("/images/Standard/StandardFondMenu.jpg"));
            imageCollection.get(Theme.STANDARD).put("FondMenu", image);
            image = ImageIO.read(getClass().getResource("/images/Standard/StandardFondCamp.png"));
            imageCollection.get(Theme.STANDARD).put("FondCamp", image);
            image = ImageIO.read(getClass().getResource("/images/Noel/NoelFondMenu.jpg"));
            imageCollection.get(Theme.NOEL).put("FondMenu", image);
        } catch (IOException e) { System.out.println(e.getMessage()); }
    }

    public BufferedImage getImage(Theme theme, String titre) {
        return imageCollection.get(theme).get(titre);
    }
}
