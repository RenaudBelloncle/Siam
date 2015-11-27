package Siam.Interface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OutilsFont {

    private Font fontMenu, police, fontTexte, fontNoel;

    public OutilsFont() {
        try {
            fontMenu = loadFont("res/font/FRAZZLE_.TTF");
            fontTexte = loadFont("res/font/Alabama.ttf");
            fontNoel = loadFont("res/font/Alabama.ttf");
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Font loadFont(String string) throws FontFormatException, IOException {
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

    public void changerFontJMenuBar(JMenuBar menuBar, int size, Color color, Font font) {
        police = font.deriveFont(Font.TRUETYPE_FONT, size);
        menuBar.setForeground(color);
        menuBar.setFont(police);
    }

    public void changerFontJMenuItem(JMenuItem menuItem, int size, Color color, Font font) {
        police = font.deriveFont(Font.TRUETYPE_FONT, size);
        menuItem.setForeground(color);
        menuItem.setFont(police);
    }

    public void changerFontJMenu(JMenu menu, int size, Color color, Font font) {
        police = font.deriveFont(Font.TRUETYPE_FONT, size);
        menu.setForeground(color);
        menu.setFont(police);
    }

    public Font getFontMenu() {
        return fontMenu;
    }

    public Font getFontTexte() {
        return fontTexte;
    }

    public Font getFont(String font) {
        if (font == "noel") {
            return fontNoel;
        }

        return null;
    }
}