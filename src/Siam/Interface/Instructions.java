package Siam.Interface;

import Siam.Enum.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Instructions extends JFrame {

    private Theme theme;
    private OutilsFont outilsFont;

    private JLabel commentjouer;
    private JLabel intro;
    private JLabel titrebut;
    private JLabel variante;
    private JLabel but;
    private JLabel tpart1;
    private JLabel part1;
    private JLabel tpart2;
    private JLabel part2;
    private JLabel tpart3;
    private JLabel part3;
    private JLabel tpart4;
    private JLabel part4;
    private JLabel tpart5;
    private JLabel part5;
    private JLabel tpart6;
    private JLabel part6;
    private JLabel tpart7;
    private JLabel part7;
    private JLabel tpart8;
    private JLabel part8;
    private JLabel titre;

    public Instructions(Theme theme){
        this.theme = theme;
        outilsFont = new OutilsFont();
        initInstructions();
        afficherInstructions();

        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Siam");
        setVisible(true);
    }

    public void initInstructions() {
        titre = new JLabel("Instructions");
        titrebut = new JLabel("<html><h1>But du jeu</h1></html>", SwingConstants.CENTER);
        but = new JLabel("<html><br>Après avoir choisi votre animal vous devez être " +
                "le premier à sortir une région montagneuse (bloc de rochers)" +
                " à l'extérieur du plateau.<br><br></html>");
        commentjouer = new JLabel("<html><h1>Comment jouer</h1></html>", SwingConstants.CENTER);
        variante = new JLabel("<html><h1>Variantes de jeu</h1></html>", SwingConstants.CENTER);
        intro = new JLabel("<html><br>Chaque joueur choisit son animal." +
                " Les joueurs joueront à tour de rôle. " +
                "Au début du jeu les animaux sont disposés à l'extérieur du plateau " +
                "et les blocs de rochers au centre du plateau." +
                " Les éléphants commenceront à jouer. " +
                "Les joueurs ne pourront jouer à chaque tour de jeu qu'un seul de " +
                "leur animal et ne faire qu'une des 5 actions suivantes : " +
                "<br>-     Entrer un de ses animaux sur le plateau " +
                "<br>-     Se déplacer sur une case libre " +
                "<br>-     Changer l'orientation de son animal sans changer de case " +
                "<br>-     Sortir un de ses animaux disposés sur une case extérieure " +
                "<br>-     Se déplacer en poussant d'autres pièces disposées sur le plateau.<br><br></html>");
        tpart1 = new JLabel("<html><h3>Poser une pièce</h3></html>", SwingConstants.CENTER);
        tpart2 = new JLabel("<html><h3>Se déplacer sans pousser</h3></html>", SwingConstants.CENTER);
        tpart3 = new JLabel("<html><h3>Changer l'orientation</h3></html>", SwingConstants.CENTER);
        tpart4 = new JLabel("<html><h3>Sortir une pièce</h3></html>", SwingConstants.CENTER);
        tpart5 = new JLabel("<html><h3>Se déplacer en poussant</h3></html>", SwingConstants.CENTER);
        tpart6 = new JLabel("<html><h3>Cases bannies</h3></html>", SwingConstants.CENTER);
        tpart7 = new JLabel("<html><h3>Nombre de pièces limité</h3></html>", SwingConstants.CENTER);
        tpart8 = new JLabel("<html><h3>Montagnes de camp</h3></html>", SwingConstants.CENTER);


        part1 = new JLabel("<html><br> Vous devez entrer un de vos animaux par l'une des cases " +
                "extérieures. " +
                " Deux cas peuvent se présenter : <br>" +
                "-     la case est libre et dans ce cas vous pouvez placer votre animal " +
                "en l'orientant dans la direction de votre choix <br>" +
                "-    la case est occupée et vous pouvez sous certaines conditions " +
                "rentrer en effectuant un poussée. <br><br></html>");
        part2 = new JLabel("<html><br>Vous ne pouvez vous déplacer que d'une seule case" +
                " et de façon orthogonale (déplacement en diagonale interdit)." +
                " L'orientation de votre animal n'importe pas sur la direction de votre " +
                "déplacement. " +
                "Tout en vous déplaçant, vous pouvez à votre guise" +
                " changer l'orientation de votre animal.<br><br></html> ");
        part3 = new JLabel("<html><br>Vous pouvez changer l'orientation de votre animal" +
                " sur sa case, ce coup compte comme un tour de jeu. <br><br></html>");
        part4 = new JLabel("<html><br>Vous pouvez sortir du plateau et à tout moment" +
                " un de vos animaux disposé sur une case extérieure " +
                ", ce coup compte comme un tour de jeu. " +
                "L'animal sorti pourra être réutilisé et revenir sur le plateau à tout moment.<br><br></html> ");
        part5 = new JLabel("<html><br>Lorsque la case ou vous voulez vous rendre est occupée " +
                "par une pièce  vous pouvez sous certaines conditions " +
                "effectuer une poussée :<br>"+
                "   Vous ne pouvez pousser que dans une seule direction : " +
                "vers l'avant de votre animal. <br>" +
                "    Un animal peut pousser un rocher, deux animaux orientés" +
                " dans la bonne direction peuvent pousser deux rochers," +
                " et trois animaux orientés dans la bonne direction " +
                "peuvent pousser trois rochers.<br> " +
                "   Un animal ne peut pousser un autre animal qui lui fait face."+
                "Précision : un de vos animaux peut empêcher votre poussée," +
                " un animal adverse peut aider votre poussée .<br> " +
                "    Un animal peut pousser autant d'animaux que possible si " +
                "ceux-ci ne sont pas orientés dans la direction opposée." +
                " Vous pouvez pousser en entrant une pièce sur le plateau " +
                "    Pour résoudre des situations de poussée plus compliquées," +
                " il suffit de regarder les animaux qui se neutralisent " +
                "et de voir si ceux qui restent sont en nombre suffisant" +
                " pour pousser des rochers. <br>" +
                "    Lorsqu'un rocher est expulsé la partie est terminée " +
                "mais attention le gagnant est le joueur qui est " +
                "le plus proche du rocher et dans le même sens de poussée." +
                "  Un animal expulsé hors du plateau n'est pas éliminé ; " +
                "il est récupéré et peut être joué à tout moment.<br> " +
                "    Pendant une poussée, aucun animal ne peut changer d'orientation.<br><br></html>");
        part6 = new JLabel("<html><br>Lors des deux premiers tours de jeu" +
                " les deux joueurs n'auront pas le droit de poser de pièce" +
                " sur les cases du milieu de la ligne du haut et du bas.<br><br></html> ");
        part7 = new JLabel("<html><br>Les joueurs ne pourront poser que six pièces" +
                " lors de la partie.<br><br></html> ");
        part8 = new JLabel("<html><br>Chaque camp a sa propre montagne (reconnaissable par son apparence). " +
                "La montagne au centre est neutre et ne permet pas la victoire. La victoire est déterminée" +
                "en fonction de la montagne sortie : si les éléphants sortent la montagne des éléphants, les " +
                "rhinocéros gagnent. Quand un animal pousse la montagne neutre hors de la grille le joueur peut" +
                "la poser de suite dans la case qu'il veut (excepté une case occupée par une montagne), si un " +
                "animal se trouve sur cette case il est alors sorti du plateau, il pouura tout de même être reposé" +
                "plus tard.<br><br></html> ");
    }

    public void afficherInstructions(){
        JPanel panPrincipal = new JPanel();
        JPanel panTitre = new JPanel();

        JTextArea panRegle = new JTextArea(117, 1);
        panRegle.setColumns(1);
        panRegle.setLineWrap(true);
        panRegle.setWrapStyleWord(true);
        panRegle.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(panRegle);

        panRegle.add(titrebut);
        panRegle.add(but);
        panRegle.add(commentjouer);
        panRegle.add(intro);
        panRegle.add(tpart1);
        panRegle.add(part1);
        panRegle.add(tpart2);
        panRegle.add(part2);
        panRegle.add(tpart3);
        panRegle.add(part3);
        panRegle.add(tpart4);
        panRegle.add(part4);
        panRegle.add(tpart5);
        panRegle.add(part5);
        panRegle.add(variante);
        panRegle.add(tpart6);
        panRegle.add(part6);
        panRegle.add(tpart7);
        panRegle.add(part7);
        panRegle.add(tpart8);
        panRegle.add(part8);
        panTitre.add(titre);

        panRegle.setOpaque(false);
        panTitre.setOpaque(false);
        panPrincipal.setOpaque(false);
        scrollPane.setOpaque(false);


        panPrincipal = new JPanel() {
            BufferedImage image = ImageLibrairie.imageLibrairie.getImage(theme, "FondMenu");

            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, 500, 500, this);
            }
        };

        changerPolice();

        panPrincipal.setLayout(new BorderLayout());
        panRegle.setLayout(new BoxLayout(panRegle, BoxLayout.Y_AXIS));


        panPrincipal.add(panTitre, BorderLayout.NORTH);
        panPrincipal.add(scrollPane, BorderLayout.CENTER);

        setContentPane(panPrincipal);
    }

    public void changerPolice(){
        if (theme == Theme.STANDARD) outilsFont.changerFontJLabel(titre, 50, Color.orange, outilsFont.getStandardFontMenu());
        else if (theme == Theme.NOEL) outilsFont.changerFontJLabel(titre, 70, Color.red, outilsFont.getNoelFontTexte());
    }
}