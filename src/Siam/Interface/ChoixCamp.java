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

public class ChoixCamp implements ActionListener, Constantes {

    private Jeu jeu;
    private JFrame fenetre;
    private OutilsFont outilsFont;

    private JLabel titreCB;
    private JLabel elephant;
    private JLabel rhinoceros;
    private JButton spriteElephant;
    private JButton spriteRhinoceros;
    private JCheckBox JCBvarianteCase;
    private JCheckBox JCBvariantePiece;
    private JButton valider;
    private JButton annuler;

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
        if (theme == Theme.STANDARD) {
            elephant = new JLabel("Elephants");
            rhinoceros = new JLabel("Rhinoceros");
        } else if (theme == Theme.NOEL) {
            elephant = new JLabel("Bonhommes");
            rhinoceros = new JLabel("Rennes");
        }
        spriteElephant = new JButton(new ImageIcon(ImageLibrairie.imageLibrairie.getImage(theme,"ElephantExemple")));
        spriteRhinoceros = new JButton(new ImageIcon(ImageLibrairie.imageLibrairie.getImage(theme,"RhinocerosExemple")));
        valider = new JButton("Valider");
        annuler = new JButton("Annuler");
        JCBvarianteCase = new JCheckBox("Variante case bannie");
        JCBvariantePiece = new JCheckBox("Variante nombre de piece limite");
    }

    public void afficheChoixCamp(){
        JPanel panPrincipal = new JPanel();
        JPanel panTitre = new JPanel();
        JPanel panElephant = new JPanel();
        JPanel panRhinoceros = new JPanel();
        JPanel panValiderBouton = new JPanel();
        JPanel panVariante = new JPanel();
        JPanel panVariante1 = new JPanel();
        JPanel panVariante2 = new JPanel();

        panPrincipal.setOpaque(false);
        panTitre.setOpaque(false);
        panElephant.setOpaque(false);
        panRhinoceros.setOpaque(false);
        panValiderBouton.setOpaque(false);
        panVariante.setOpaque(false);
        panVariante1.setOpaque(false);
        panVariante2.setOpaque(false);

        panPrincipal = new JPanel() {
            BufferedImage image = ImageLibrairie.imageLibrairie.getImage(theme,"FondCamp");

            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, LARGEUR_FENETRE, HAUTEUR_FENETRE, this);
            }
        };

        changerPolice();

        panTitre.add(titreCB);
        panElephant.add(elephant);
        panElephant.add(spriteElephant);
        panRhinoceros.add(rhinoceros);
        panRhinoceros.add(spriteRhinoceros);
        panVariante1.add(JCBvariantePiece);
        panVariante2.add(JCBvarianteCase);
        panVariante.add(panVariante1);
        panVariante.add(panVariante2);
        panValiderBouton.add(valider);
        panValiderBouton.add(annuler);

        panVariante.setLayout(new GridLayout(2,1));
        panValiderBouton.setLayout(new GridLayout(1, 2));

        panPrincipal.add(panTitre);
        panPrincipal.add(panElephant);
        panPrincipal.add(panRhinoceros);
        panPrincipal.add(panVariante);
        panPrincipal.add(panValiderBouton);

        panPrincipal.setLayout(new GridLayout(5,1));

        fenetre.setContentPane(panPrincipal);
    }

    public void changerPolice() {
        if (theme == Theme.STANDARD) {
            outilsFont.changerFontJLabel(titreCB, 95, Color.orange, outilsFont.getStandardFontMenu());
            outilsFont.changerFontButton(valider, 60, Color.orange, outilsFont.getStandardFontTexte());
            outilsFont.changerFontButton(annuler, 60, Color.orange, outilsFont.getStandardFontTexte());
            outilsFont.changerFontJLabel(elephant, 60, Color.orange, outilsFont.getStandardFontTexte());
            outilsFont.changerFontJLabel(rhinoceros, 60, Color.orange, outilsFont.getStandardFontTexte());
            outilsFont.changerFontJCheckBox(JCBvarianteCase, 40, Color.orange, outilsFont.getStandardFontTexte());
            outilsFont.changerFontJCheckBox(JCBvariantePiece, 40,Color.orange,outilsFont.getStandardFontTexte());
        } else if (theme == Theme.NOEL) {
            outilsFont.changerFontJLabel(titreCB, 95, Color.red, outilsFont.getNoelFontMenu());
            outilsFont.changerFontButton(valider, 80, Color.red, outilsFont.getNoelFontTexte());
            outilsFont.changerFontButton(annuler, 80, Color.red, outilsFont.getNoelFontTexte());
            outilsFont.changerFontJLabel(elephant, 80, Color.red, outilsFont.getNoelFontTexte());
            outilsFont.changerFontJLabel(rhinoceros, 80, Color.red, outilsFont.getNoelFontTexte());
            outilsFont.changerFontJCheckBox(JCBvarianteCase, 80, Color.red, outilsFont.getNoelFontTexte());
            outilsFont.changerFontJCheckBox(JCBvariantePiece,80,Color.red, outilsFont.getNoelFontTexte());
        }
        outilsFont.changerFontButton(spriteElephant, 0, Color.black, outilsFont.getStandardFontTexte());
        outilsFont.changerFontButton(spriteRhinoceros, 0, Color.black, outilsFont.getStandardFontTexte());
    }

    public void setControlChoixCamp(ActionListener listener){
        valider.addActionListener(listener);
        annuler.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        soundsLibrary.playBouttonSound(theme);

        if (source == valider)
        {
            jeu.setMusique(musique);
            jeu.setSon(son);
            jeu.activerVariante(JCBvarianteCase.isSelected(),JCBvariantePiece.isSelected());
            jeu.initJeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS));
            jeu.start();
        }
        else if (source == annuler){
            new Menu(jeu, jeu.getFenetre(), theme, musique, son, soundsLibrary);
        }
    }
}