package Siam.Interface;

import Siam.Constantes;
import Siam.Enum.Camp;
import Siam.Enum.Theme;
import Siam.Jeu;
import Siam.Joueur;
import Siam.Sons.Musique;
import Siam.Sons.SoundsLibrary;

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
    private JCheckBox JCBvarianteCase, JCBvariantePiece;
    private ButtonGroup BGchoix;
    private JButton valider, annuler;

    private Theme theme;
    private Musique musique;
    private boolean son;
    private SoundsLibrary soundsLibrary;

    public ChoixCamp(Jeu jeu, JFrame fenetre, Theme theme, Musique musique, boolean son, SoundsLibrary soundsLibrary) {
        this.jeu = jeu;
        this.fenetre = fenetre;
        this.theme = theme;
        this.musique = musique;
        this.son = son;
        outilsFont = new OutilsFont();
        this.soundsLibrary = soundsLibrary;
        
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
        JRBelephant = new JRadioButton("Elephant", true);
        JRBrhinoceros = new JRadioButton("Rhinoceros");
        aleatoire = new JRadioButton("Aleatoire");
        BGchoix = new ButtonGroup();
        BGchoix.add(JRBelephant);
        BGchoix.add(JRBrhinoceros);
        BGchoix.add(aleatoire);
        valider = new JButton("Valider");
        annuler = new JButton("Annuler");
        JCBvarianteCase = new JCheckBox("Variante case bannie");
        JCBvariantePiece = new JCheckBox("Variante nombre de piece limite");
    }

    public void afficheChoixCamp(){
        JPanel panPrincipal = new JPanel();
        JPanel panTitre = new JPanel();
        JPanel panGBouton = new JPanel();
        JPanel panBouton1 = new JPanel();
        JPanel panBouton2 = new JPanel();
        JPanel panBouton3 = new JPanel();
        JPanel panValiderBouton = new JPanel();
        JPanel panVariante = new JPanel();

        panPrincipal.setOpaque(false);
        panTitre.setOpaque(false);
        panGBouton.setOpaque(false);
        panBouton1.setOpaque(false);
        panBouton2.setOpaque(false);
        panBouton3.setOpaque(false);
        panValiderBouton.setOpaque(false);
        panVariante.setOpaque(false);

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
        panVariante.add(JCBvariantePiece);
        panVariante.add(JCBvarianteCase);
        panValiderBouton.add(valider);
        panValiderBouton.add(annuler);

        panGBouton.setLayout(new BoxLayout(panGBouton, BoxLayout.X_AXIS));
        panValiderBouton.setLayout(new GridLayout(1, 2));

        panPrincipal.add(panTitre);
        panPrincipal.add(panGBouton);
        panPrincipal.add(panVariante);
        panPrincipal.add(panValiderBouton);
        panPrincipal.setLayout(new BoxLayout(panPrincipal, BoxLayout.Y_AXIS));

        fenetre.setContentPane(panPrincipal);
    }

    public void changerPolice() {
        if (theme == Theme.STANDARD) {
            outilsFont.changerFontJLabel(titreCB, 95, Color.orange, outilsFont.getStandardFontMenu());
            outilsFont.changerFontButton(valider, 80, Color.orange, outilsFont.getStandardFontTexte());
            outilsFont.changerFontButton(annuler, 80, Color.orange, outilsFont.getStandardFontTexte());
            outilsFont.changerFontJRadioButton(JRBelephant, 60, Color.orange, outilsFont.getStandardFontTexte());
            outilsFont.changerFontJRadioButton(JRBrhinoceros, 60, Color.orange, outilsFont.getStandardFontTexte());
            outilsFont.changerFontJCheckBox(JCBvarianteCase, 30, Color.orange, outilsFont.getStandardFontTexte());
            outilsFont.changerFontJCheckBox(JCBvariantePiece,30,Color.orange,outilsFont.getStandardFontTexte());
            outilsFont.changerFontJRadioButton(aleatoire, 60, Color.orange, outilsFont.getStandardFontTexte());
        } else if (theme == Theme.NOEL) {
            outilsFont.changerFontJLabel(titreCB, 95, Color.red, outilsFont.getNoelFontMenu());
            outilsFont.changerFontButton(valider, 100, Color.red, outilsFont.getNoelFontTexte());
            outilsFont.changerFontButton(annuler, 100, Color.red, outilsFont.getNoelFontTexte());
            outilsFont.changerFontJRadioButton(JRBelephant, 80, Color.red, outilsFont.getNoelFontTexte());
            outilsFont.changerFontJRadioButton(JRBrhinoceros, 80, Color.red, outilsFont.getNoelFontTexte());
            outilsFont.changerFontJRadioButton(aleatoire, 80, Color.red, outilsFont.getNoelFontTexte());
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
        soundsLibrary.playBouttonSound(theme);

        if (source == valider)
        {
            if(JRBelephant.isSelected()) jeu.setJoueurActif(jeu.getJoueurs()[0]);
            else if (JRBrhinoceros.isSelected()) jeu.setJoueurActif(jeu.getJoueurs()[1]);
            else jeu.setJoueurActif(jeu.getJoueurs()[random.nextInt(2)]);
            jeu.setMusique(musique);
            jeu.setSon(son);
            jeu.activerVariante(JCBvarianteCase.isSelected(),JCBvariantePiece.isSelected());
            jeu.initJeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS));
            jeu.start();
        }
        else if (source == annuler){
            new Menu(jeu, jeu.getFenetre(), theme, musique, son);
        }
    }
}