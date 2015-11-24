package Siam.Interface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Instructions extends JFrame implements ActionListener {

    private OutilsFont outil;

    private JLabel commentjouer;
    private JLabel intro;
    private JLabel titrebut;
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
    private JLabel titre;

    public Instructions(){
        outil = new OutilsFont();
        initInstructions();
        afficherInstructions();
        setControlInstructions(this);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Siam");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
    }

    public void initInstructions(){
        commentjouer = new JLabel("Comment jouer :");
        but = new JLabel("<html><br>Après avoir choisi votre animal vous devez être " +
                "le premier à sortir une région montagneuse (bloc de rochers)" +
                " à l'extérieur du plateau.<br><br></html>");
        titrebut = new JLabel("But du jeu :");
        intro = new JLabel("<html><br>Chaque joueur choisit son animal." +
                " Les joueurs joueront à tour de rôle. " +
                "Au début du jeu les animaux sont disposés à l'extérieur du plateau " +
                "et les blocs de rochers au centre du plateau." +
                " Les éléphants blancs commenceront à jouer. " +
                "Les joueurs ne pourront jouer à chaque tour de jeu qu'un seul de " +
                "leur animal et ne faire qu'une des 5 actions suivantes : " +
                "<br>-     Entrer un de ses animaux sur le plateau " +
                "<br>-     Se déplacer sur une case libre " +
                "<br>-     Changer l'orientation de son animal sans changer de case " +
                "<br>-     Sortir un de ses animaux disposés sur une case extérieure " +
                "<br>-     Se déplacer en poussant d'autres pièces disposées sur le plateau.<br><br></html> ");


        tpart1 = new JLabel("Poser une pièce :");
        tpart2 = new JLabel("Se déplacer sans pousser :");
        tpart3 = new JLabel("Changer l'orientation :");
        tpart4 = new JLabel("Sortir une pièce :");
        tpart5 = new JLabel("Se déplacer en poussant :");

        part1 = new JLabel("<html><br>Vous devez entrer un de vos animaux par l'une des cases " +
                "extérieures. " +
                "Deux cas peuvent se présenter : " +
                "-     la case est libre et dans ce cas vous pouvez placer votre animal " +
                "en l'orientant dans la direction de votre choix " +
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
                "effectuer une poussée :"+
                "   Vous ne pouvez pousser que dans une seule direction : " +
                "vers l'avant de votre animal. " +
                "    Un animal peut pousser un rocher, deux animaux orientés" +
                " dans la bonne direction peuvent pousser deux rochers," +
                " et trois animaux orientés dans la bonne direction " +
                "peuvent pousser trois rochers. " +
                "   Un animal ne peut pousser un autre animal qui lui fait face."+
                "Précision : un de vos animaux peut empêcher votre poussée," +
                " un animal adverse peut aider votre poussée . " +
                "    Un animal peut pousser autant d'animaux que possible si " +
                "ceux-ci ne sont pas orientés dans la direction opposée." +
                " Vous pouvez pousser en entrant une pièce sur le plateau " +
                "    Pour résoudre des situations de poussée plus compliquées," +
                " il suffit de regarder les animaux qui se neutralisent " +
                "et de voir si ceux qui restent sont en nombre suffisant" +
                " pour pousser des rochers. " +
                "    Lorsqu'un rocher est expulsé la partie est terminée " +
                "mais attention le gagnant est le joueur qui est " +
                "le plus proche du rocher et dans le même sens de poussée." +
                "  Un animal expulsé hors du plateau n'est pas éliminé ; " +
                "il est récupéré et peut être joué à tout moment. " +
                "    Pendant une poussée, aucun animal ne peut changer d'orientation.<br><br></html>");
        titre = new JLabel("Instructions");
    }

    public void afficherInstructions(){
        JPanel panPrincipal =new JPanel();
        JPanel panTitre =new JPanel();

        JTextArea panRegle = new JTextArea(155, 1);
        panRegle.setEditable(false);

        JScrollPane panTest = new JScrollPane(panRegle);

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
        panTitre.add(titre);

        panRegle.setOpaque(false);
        panTitre.setOpaque(false);
        panPrincipal.setOpaque(false);
        panTest.setOpaque(false);


        try {
            panPrincipal = new JPanel() {
                BufferedImage image = ImageIO.read(new File("res/images/menu.png"));

                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(image, 0, 0, 500, 500, this);
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }

        panPrincipal.setLayout(new BorderLayout());
        panRegle.setLayout(new BoxLayout(panRegle, BoxLayout.Y_AXIS));

        outil.changerFontJLabel(titre, 50, Color.black, outil.getFontMenu());
        outil.changerFontJLabel(titrebut, 40, Color.black, outil.getFontTexte());
        outil.changerFontJLabel(but, 20, Color.black, outil.getFontTexte());
        outil.changerFontJLabel(commentjouer, 40, Color.black, outil.getFontTexte());
        outil.changerFontJLabel(intro, 20, Color.black, outil.getFontTexte());
        outil.changerFontJLabel(tpart1, 30, Color.black, outil.getFontTexte());
        outil.changerFontJLabel(tpart2, 30, Color.black, outil.getFontTexte());
        outil.changerFontJLabel(tpart3, 30, Color.black, outil.getFontTexte());
        outil.changerFontJLabel(tpart4, 30, Color.black, outil.getFontTexte());
        outil.changerFontJLabel(tpart5, 30, Color.black, outil.getFontTexte());
        outil.changerFontJLabel(part1, 20, Color.black, outil.getFontTexte());
        outil.changerFontJLabel(part2, 20, Color.black, outil.getFontTexte());
        outil.changerFontJLabel(part3, 20, Color.black, outil.getFontTexte());
        outil.changerFontJLabel(part4, 20, Color.black, outil.getFontTexte());
        outil.changerFontJLabel(part5, 20, Color.black, outil.getFontTexte());

        panPrincipal.add(panTitre, BorderLayout.NORTH);
        panPrincipal.add(panTest, BorderLayout.CENTER);

        setContentPane(panPrincipal);
    }

    public void setControlInstructions(ActionListener listener){

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
