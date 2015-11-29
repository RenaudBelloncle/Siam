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

    public OutilsFont() {
        try {
            StandardFontMenu = chargerFont("res/Standard/Fonts/FRAZZLE_.TTF");
            StandardFontTexte = chargerFont("res/Standard/Fonts/Alabama.ttf");
            NoelFontTexte = chargerFont("res/Noel/Fonts/kr.ttf");
            NoelFontMenu = chargerFont("res/Noel/Fonts/Candcu__.ttf");
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

    public void changerFontJRadioButton(JRadioButton bouton, int size, Color color, Font font) {
        police = font.deriveFont(Font.TRUETYPE_FONT, size);
        bouton.setForeground(color);
        bouton.setOpaque(false);
        bouton.setBorderPainted(false);
        bouton.setContentAreaFilled(false);
        bouton.setFont(police);
    }

    public void changerFontJTextField(JTextField textField, int size, Color color, Font font) {
        police = font.deriveFont(Font.TRUETYPE_FONT, size);
        textField.setForeground(color);
        textField.setOpaque(false);
        textField.setBorder(BorderFactory.createLineBorder(color));
        textField.setFont(police);
    }

    public void changerFontJTextArea(JTextArea textArea, int size, Color color, Font font) {
        police = font.deriveFont(Font.TRUETYPE_FONT, size);
        textArea.setForeground(color);
        textArea.setFont(police);
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
}