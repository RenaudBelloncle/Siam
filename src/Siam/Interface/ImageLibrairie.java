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
            // Theme Standard
            // Images
            image = ImageIO.read(getClass().getResource("/Standard/Images/StandardFondMenu.jpg"));
            imageCollection.get(Theme.STANDARD).put("FondMenu", image);
            image = ImageIO.read(getClass().getResource("/Standard/Images/StandardFondCamp.png"));
            imageCollection.get(Theme.STANDARD).put("FondCamp", image);
            image = ImageIO.read(getClass().getResource("/Standard/Images/StandardFondBouton.jpg"));
            imageCollection.get(Theme.STANDARD).put("FondBouton", image);
            image = ImageIO.read(getClass().getResource("/Standard/Images/StandardFondElephant.jpeg"));
            imageCollection.get(Theme.STANDARD).put("FondElephant", image);
            image = ImageIO.read(getClass().getResource("/Standard/Images/StandardFondRhinoceros.jpeg"));
            imageCollection.get(Theme.STANDARD).put("FondRhinoceros", image);
            image = ImageIO.read(getClass().getResource("/Standard/Images/Elephant.png"));
            imageCollection.get(Theme.STANDARD).put("ElephantExemple", image);
            image = ImageIO.read(getClass().getResource("/Standard/Images/Rhinoceros.png"));
            imageCollection.get(Theme.STANDARD).put("RhinocerosExemple", image);
            // Sprites
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
            image = ImageIO.read(getClass().getResource("/Standard/Sprites/CaillouRhino.png"));
            imageCollection.get(Theme.STANDARD).put("CaillouRhino", image);
            image = ImageIO.read(getClass().getResource("/Standard/Sprites/CaillouElephant.png"));
            imageCollection.get(Theme.STANDARD).put("CaillouElephant", image);
            image = ImageIO.read(getClass().getResource("/Standard/Sprites/Focus.png"));
            imageCollection.get(Theme.STANDARD).put("Focus", image);
            image = ImageIO.read(getClass().getResource("/Standard/Sprites/CaseBannie.png"));
            imageCollection.get(Theme.STANDARD).put("CaseBannie", image);

            // Theme Noel
            // Images
            image = ImageIO.read(getClass().getResource("/Noel/Images/NoelFondMenu.jpg"));
            imageCollection.get(Theme.NOEL).put("FondMenu", image);
            image = ImageIO.read(getClass().getResource("/Noel/Images/NoelFondCamp.jpg"));
            imageCollection.get(Theme.NOEL).put("FondCamp", image);
            image = ImageIO.read(getClass().getResource("/Noel/Images/NoelFondBouton.jpg"));
            imageCollection.get(Theme.NOEL).put("FondBouton", image);
            image = ImageIO.read(getClass().getResource("/Noel/Images/NoelFondBonhomme.jpeg"));
            imageCollection.get(Theme.NOEL).put("FondElephant", image);
            image = ImageIO.read(getClass().getResource("/Noel/Images/NoelFondRenne.jpg"));
            imageCollection.get(Theme.NOEL).put("FondRhinoceros", image);
            image = ImageIO.read(getClass().getResource("/Noel/Images/Bonhomme.png"));
            imageCollection.get(Theme.NOEL).put("ElephantExemple", image);
            image = ImageIO.read(getClass().getResource("/Noel/Images/Renne.png"));
            imageCollection.get(Theme.NOEL).put("RhinocerosExemple", image);
            // Sprites
            image = ImageIO.read(getClass().getResource("/Noel/Sprites/Case.png"));
            imageCollection.get(Theme. NOEL).put("Case", image);
            image = ImageIO.read(getClass().getResource("/Noel/Sprites/Bonhomme.png"));
            imageCollection.get(Theme.NOEL).put("Elephant", image);
            image = ImageIO.read(getClass().getResource("/Noel/Sprites/Renne.png"));
            imageCollection.get(Theme.NOEL).put("Rhinoceros", image);
            image = ImageIO.read(getClass().getResource("/Noel/Sprites/BonhommeGauche.png"));
            imageCollection.get(Theme.NOEL).put("ElephantGauche", image);
            image = ImageIO.read(getClass().getResource("/Noel/Sprites/RenneGauche.png"));
            imageCollection.get(Theme.NOEL).put("RhinocerosGauche", image);
            image = ImageIO.read(getClass().getResource("/Noel/Sprites/Cadeau.png"));
            imageCollection.get(Theme.NOEL).put("Montagne", image);
            image = ImageIO.read(getClass().getResource("/Noel/Sprites/CadeauRenne.png"));
            imageCollection.get(Theme.NOEL).put("CaillouRhino", image);
            image = ImageIO.read(getClass().getResource("/Noel/Sprites/CadeauBonhomme.png"));
            imageCollection.get(Theme.NOEL).put("CaillouElephant", image);
            image = ImageIO.read(getClass().getResource("/Noel/Sprites/Focus.png"));
            imageCollection.get(Theme.NOEL).put("Focus", image);
            image = ImageIO.read(getClass().getResource("/Noel/Sprites/CaseBannie.png"));
            imageCollection.get(Theme.NOEL).put("CaseBannie", image);
        } catch (IOException e) { System.out.println(e.getMessage()); }
    }

    public BufferedImage getImage(Theme theme, String titre) {
        return imageCollection.get(theme).get(titre);
    }
}
