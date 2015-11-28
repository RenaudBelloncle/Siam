package Siam.Interface;

import Siam.Constantes;
import Siam.Enum.Camp;
import Siam.Enum.Theme;
import Siam.Jeu;
import Siam.Joueur;
import Siam.Sons.Musique;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ChoixCamp implements ActionListener, Constantes {

    private static final Random random = new Random();

    private Jeu jeu;
    private JFrame fenetre;
    private OutilsFont outilsFont;

    private JLabel titreCB;
    private JRadioButton JRBelephant, JRBrhinoceros, aleatoire;
    private ButtonGroup BGchoix;
    private JButton valider, annuler;

    private Theme theme;
    private Musique musique;
    private boolean son;

    public ChoixCamp(Jeu jeu, JFrame fenetre, Theme theme, Musique musique, boolean son) {
        this.jeu = jeu;
        this.fenetre = fenetre;
        this.theme = theme;
        this.musique = musique;
        this.son = son;
        outilsFont = new OutilsFont();

        initChoixCamp();
        afficheChoixCamp();
        setControlChoixCamp(this);

        fenetre.setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(false);
        fenetre.setTitle("Siam");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
    }

    public void initChoixCamp(){
        titreCB = new JLabel("Choisis un camp");
        JRBelephant = new JRadioButton("Éléphant", true);
        JRBrhinoceros = new JRadioButton("Rhinocéros");
        aleatoire = new JRadioButton("Aléatoire");
        BGchoix = new ButtonGroup();
        BGchoix.add(JRBelephant);
        BGchoix.add(JRBrhinoceros);
        BGchoix.add(aleatoire);
        valider = new JButton("Valider");
        annuler = new JButton("Annuler");
    }

    public void afficheChoixCamp(){
        JPanel panPrincipal = new JPanel();
        JPanel panTitre = new JPanel();
        JPanel panGBouton = new JPanel();
        JPanel panBouton1 = new JPanel();
        JPanel panBouton2 = new JPanel();
        JPanel panBouton3 = new JPanel();
        JPanel panValiderBouton = new JPanel();

        panPrincipal.setOpaque(false);
        panTitre.setOpaque(false);
        panGBouton.setOpaque(false);
        panBouton1.setOpaque(false);
        panBouton2.setOpaque(false);
        panBouton3.setOpaque(false);
        panValiderBouton.setOpaque(false);

        panPrincipal = new JPanel() {
            BufferedImage image = ImageLibrairie.imageLibrairie.getImage(theme,"FondCamp");

            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, LARGEUR_FENETRE, HAUTEUR_FENETRE, this);
            }
        };

        changerPolice();

        panTitre.add(titreCB);
        panBouton1.add(JRBelephant);
        panBouton2.add(JRBrhinoceros);
        panBouton3.add(aleatoire);
        panGBouton.add(panBouton1);
        panGBouton.add(panBouton2);
        panGBouton.add(panBouton3);
        panValiderBouton.add(valider);
        panValiderBouton.add(annuler);

        panGBouton.setLayout(new BoxLayout(panGBouton, BoxLayout.X_AXIS));
        panValiderBouton.setLayout(new GridLayout(1, 2));

        panPrincipal.add(panTitre);
        panPrincipal.add(panGBouton);
        panPrincipal.add(panValiderBouton);
        panPrincipal.setLayout(new BoxLayout(panPrincipal, BoxLayout.Y_AXIS));

        fenetre.setContentPane(panPrincipal);
    }

    public void changerPolice() {
        if (theme == Theme.STANDARD) {
            outilsFont.changerFontJLabel(titreCB, 95, Color.orange, outilsFont.getFontMenu());
            outilsFont.changerFontButton(valider, 80, Color.orange, outilsFont.getFontTexte());
            outilsFont.changerFontButton(annuler, 80, Color.orange, outilsFont.getFontTexte());
            outilsFont.changerFontJRadioButton(JRBelephant, 60, Color.orange, outilsFont.getFontTexte());
            outilsFont.changerFontJRadioButton(JRBrhinoceros, 60, Color.orange, outilsFont.getFontTexte());
            outilsFont.changerFontJRadioButton(aleatoire, 60, Color.orange, outilsFont.getFontTexte());
        } else if (theme == Theme.NOEL) {
            outilsFont.changerFontJLabel(titreCB, 95, Color.black, outilsFont.getFontMenu());
            outilsFont.changerFontButton(valider, 80, Color.black, outilsFont.getFontTexte());
            outilsFont.changerFontButton(annuler, 80, Color.black, outilsFont.getFontTexte());
            outilsFont.changerFontJRadioButton(JRBelephant, 60, Color.black, outilsFont.getFontTexte());
            outilsFont.changerFontJRadioButton(JRBrhinoceros, 60, Color.black, outilsFont.getFontTexte());
            outilsFont.changerFontJRadioButton(aleatoire, 60, Color.black, outilsFont.getFontTexte());
        }
    }

    public void setControlChoixCamp(ActionListener listener){
        JRBelephant.addActionListener(listener);
        JRBrhinoceros.addActionListener(listener);
        valider.addActionListener(listener);
        annuler.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == valider)
        {
            if(JRBelephant.isSelected()) jeu.setJoueurActif(jeu.getJoueurs()[0]);
            else if (JRBrhinoceros.isSelected()) jeu.setJoueurActif(jeu.getJoueurs()[1]);
            else jeu.setJoueurActif(jeu.getJoueurs()[random.nextInt(2)]);
            jeu.setMusique(musique);
            jeu.setSon(son);
            jeu.initJeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS));
            jeu.start();
        }
        else if (source == annuler){
            new Menu(jeu, jeu.getFenetre(), theme, musique, son);
        }
    }
}