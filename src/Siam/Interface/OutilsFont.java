package Siam.Interface;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class OutilsFont {

    private Font police;
    private Font StandardFontMenu;
    private Font StandardFontTexte;
    private Font NoelFontMenu;
    private Font NoelFontTexte;
    private Font StarWarsTexte;

    public OutilsFont() {
        try {
            StandardFontMenu = chargerFont("res/Standard/Fonts/FRAZZLE_.TTF");
            StandardFontTexte = chargerFont("res/Standard/Fonts/Alabama.ttf");
            NoelFontTexte = chargerFont("res/Noel/Fonts/kr.ttf");
            NoelFontMenu = chargerFont("res/Noel/Fonts/Candcu__.ttf");
            StarWarsTexte = chargerFont("res/StarWars/Fonts/SFDistantGalaxy.ttf");
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Font chargerFont(String string) throws FontFormatException, IOException {
        File fileFont = new File(string);
        return Font.createFont(Font.TRUETYPE_FONT, fileFont);
    }

    public void changerFontButton(JButton bouton, int size, Color color, Font font) {
        police = font.deriveFont(Font.TRUETYPE_FONT, size);
        bouton.setOpaque(false);
        bouton.setBorderPainted(false);
        bouton.setContentAreaFilled(false);
        bouton.setForeground(color);
        bouton.setFont(police);
        bouton.setFocusPainted(false);
    }

    public void changerFontJLabel(JLabel label, int size, Color color, Font font) {
        police = font.deriveFont(Font.TRUETYPE_FONT, size);
        label.setForeground(color);
        label.setOpaque(false);
        label.setFont(police);
    }

    public void changerFontJCheckBox(JCheckBox jcb, int size, Color color, Font font){
        police = font.deriveFont(Font.TRUETYPE_FONT, size);
        jcb.setForeground(color);
        jcb.setOpaque(false);
        jcb.setBorderPainted(false);
        jcb.setContentAreaFilled(false);
        jcb.setFont(police);
    }

    public Font getStandardFontMenu() {
        return StandardFontMenu;
    }

    public Font getStandardFontTexte() {
        return StandardFontTexte;
    }

    public Font getNoelFontMenu() {
        return NoelFontMenu;
    }

    public Font getNoelFontTexte() {
        return NoelFontTexte;
    }

    public Font getStarWarsTexte() {
        return StarWarsTexte;
    }
}