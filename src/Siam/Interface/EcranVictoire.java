package Siam.Interface;

import Siam.Camp;
import Siam.Constantes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EcranVictoire implements ActionListener, Constantes {

    private JFrame fenetre;
    private OutilsFont outils;
    private JButton retour;
    private JLabel gagnant;

    public EcranVictoire(JFrame fenetre, Camp campGagnant){
        this.fenetre = fenetre;
        initEcranVictoire(campGagnant);
        afficheEcranVictoire();
        retour.addActionListener(this);

        fenetre.setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(false);
        fenetre.setTitle("Siam");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
    }

    public void initEcranVictoire(Camp campGagnant){
        StringBuilder str = new StringBuilder("La victoire est pour les ");
        if(campGagnant == Camp.ELEPHANT) {
            str.append("Eléphants");
        }
        else{
            str.append("Rhinocéros");
        }
        gagnant = new JLabel(String.valueOf(str));
        outils = new OutilsFont();
        retour = new JButton("retour");
    }

    public void afficheEcranVictoire() {
        JPanel panPrincipal = new JPanel();
        JPanel phraseGagnant = new JPanel();
        JPanel vide = new JPanel();
        JPanel retourPanel = new JPanel();

        panPrincipal.setOpaque(false);
        phraseGagnant.setOpaque(false);
        vide.setOpaque(false);
        retourPanel.setOpaque(false);

        try {
            panPrincipal = new JPanel() {
                BufferedImage image = ImageIO.read(new File("res/images/menu.png"));

                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(image, 0, 0, LARGEUR_FENETRE, HAUTEUR_FENETRE, this);
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }

        //changement de la police
        outils.changerFontJLabel(gagnant, 40, Color.orange, outils.getFontTexte());
        outils.changerFontButton(retour, 80, Color.orange, outils.getFontMenu());

        phraseGagnant.add(gagnant);
        retourPanel.add(retour);
        panPrincipal.add(phraseGagnant);
        panPrincipal.add(vide);
        panPrincipal.add(retourPanel);
        panPrincipal.setLayout(new BoxLayout(panPrincipal, BoxLayout.Y_AXIS));

        fenetre.setContentPane(panPrincipal);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Menu menu = new Menu(fenetre);
    }
}