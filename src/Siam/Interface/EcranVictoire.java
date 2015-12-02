package Siam.Interface;

import Siam.Enum.Camp;
import Siam.Constantes;
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

public class EcranVictoire implements ActionListener, Constantes {

    private Jeu jeu;
    private JFrame fenetre;
    private OutilsFont outilsFont;
    private Camp campGagnant;

    private JButton continuer;
    private JButton retourMenu;
    private JLabel gagnant;

    private Theme theme;
    private Musique musique;
    private boolean son;
    private SoundsLibrary soundsLibrary;

    public EcranVictoire(Jeu jeu, JFrame fenetre, Camp campGagnant, Theme theme, Musique musique, boolean son, SoundsLibrary soundsLibrary){
        this.jeu = jeu;
        this.fenetre = fenetre;
        this.campGagnant = campGagnant;
        this.theme = theme;
        this.musique = musique;
        this.son = son;
        this.soundsLibrary = soundsLibrary;

        initEcranVictoire();
        afficheEcranVictoire();
        setControlEcranVictoire(this);

        fenetre.setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(false);
        fenetre.setTitle("Siam");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
    }

    public void initEcranVictoire(){
        StringBuilder str = new StringBuilder("Victoire des ");
        if (theme == Theme.STANDARD) {
            if (campGagnant == Camp.ELEPHANT) str.append("Elephants");
            else str.append("Rhinoceros");
        } else if (theme == Theme.NOEL) {
            if (campGagnant == Camp.ELEPHANT) str.append("Bonhommes");
            else str.append("Rennes");
        }
        gagnant = new JLabel(String.valueOf(str));
        outilsFont = new OutilsFont();
        continuer = new JButton("Continuer");
        retourMenu = new JButton("Retour au Menu");
    }

    public void afficheEcranVictoire() {
        JPanel panPrincipal = new JPanel();
        JPanel phraseGagnant = new JPanel();
        JPanel vide = new JPanel();
        JPanel boutonPanel = new JPanel();

        panPrincipal.setOpaque(false);
        phraseGagnant.setOpaque(false);
        vide.setOpaque(false);
        boutonPanel.setOpaque(false);

        if (campGagnant == Camp.ELEPHANT) {
            if (theme == Theme.STANDARD) {
                panPrincipal = new JPanel() {
                    BufferedImage image = ImageLibrairie.imageLibrairie.getImage(Theme.STANDARD, "FondElephant");

                    public void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.drawImage(image, 0, 0, LARGEUR_FENETRE, HAUTEUR_FENETRE, this);
                    }
                };
            } else if (theme == Theme.NOEL) {
                panPrincipal = new JPanel() {
                    BufferedImage image = ImageLibrairie.imageLibrairie.getImage(Theme.NOEL, "FondElephant");

                    public void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.drawImage(image, 0, 0, LARGEUR_FENETRE, HAUTEUR_FENETRE, this);
                    }
                };
            }
        } else {
            if (theme == Theme.STANDARD) {
                panPrincipal = new JPanel() {
                    BufferedImage image = ImageLibrairie.imageLibrairie.getImage(Theme.STANDARD, "FondRhinoceros");

                    public void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.drawImage(image, 0, 0, LARGEUR_FENETRE, HAUTEUR_FENETRE, this);
                    }
                };
            } else if (theme == Theme.NOEL) {
                panPrincipal = new JPanel() {
                    BufferedImage image = ImageLibrairie.imageLibrairie.getImage(Theme.NOEL, "FondRhinoceros");

                    public void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.drawImage(image, 0, 0, LARGEUR_FENETRE, HAUTEUR_FENETRE, this);
                    }
                };
            }
        }

        changerPolice();


        phraseGagnant.add(gagnant);
        boutonPanel.add(continuer);
        boutonPanel.add(retourMenu);
        boutonPanel.setLayout(new GridLayout(1, 2));
        panPrincipal.add(vide);
        panPrincipal.add(phraseGagnant);
        panPrincipal.add(boutonPanel);
        panPrincipal.setLayout(new GridLayout(3,1));

        fenetre.setContentPane(panPrincipal);
    }

    private void changerPolice() {
        if (theme == Theme.STANDARD) {
            outilsFont.changerFontJLabel(gagnant, 80, Color.orange, outilsFont.getStandardFontTexte());
            outilsFont.changerFontButton(continuer, 40, Color.orange, outilsFont.getStandardFontTexte());
            outilsFont.changerFontButton(retourMenu, 40, Color.orange, outilsFont.getStandardFontTexte());
        } else if (theme == Theme.NOEL) {
            outilsFont.changerFontJLabel(gagnant, 120, Color.red, outilsFont.getNoelFontTexte());
            outilsFont.changerFontButton(continuer, 60, Color.red, outilsFont.getNoelFontTexte());
            outilsFont.changerFontButton(retourMenu, 60, Color.red, outilsFont.getNoelFontTexte());
        }
    }

    private void setControlEcranVictoire(ActionListener listener) {
        continuer.addActionListener(listener);
        retourMenu.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == continuer) {
            jeu.setTheme(theme);
            jeu.setMusique(musique);
            jeu.setSon(son);
            jeu.initJeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS));
            jeu.start();
        }
        if (source == retourMenu) {
            new Menu(jeu, fenetre, theme, musique, son, soundsLibrary);
        }
    }
}