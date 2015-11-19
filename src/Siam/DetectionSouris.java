package Siam;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public class DetectionSouris extends MouseInputAdapter implements Constantes {

    private Game game;

    public DetectionSouris(Game game) {
        this.game = game;
    }

    public void mouseClicked(MouseEvent event) {
        if (event.getX() >= BORDURE_FENETRE + TAILLE_SPRITE*NOMBRE_CASE_INI && event.getX() <= BORDURE_FENETRE + TAILLE_SPRITE*NOMBRE_CASE_INI + LARGEUR_BOUTON) {
            int ligne = 0;
            if (event.getY() >= BORDURE_FENETRE/2 && event.getY() <= BORDURE_FENETRE/2 + HAUTEUR_BOUTON) ligne = 1;
            else if (event.getY() >= BORDURE_FENETRE/2 + HAUTEUR_BOUTON + 25 && event.getY() <= BORDURE_FENETRE/2 + HAUTEUR_BOUTON * 2 + 25) ligne = 2;
            else if (event.getY() >= BORDURE_FENETRE/2 + HAUTEUR_BOUTON * 2 + 25 * 2 && event.getY() <= BORDURE_FENETRE/2 + HAUTEUR_BOUTON * 3 + 25 * 2) ligne = 3;
            else if (event.getY() >= BORDURE_FENETRE/2 + HAUTEUR_BOUTON * 3 + 25 * 3 && event.getY() <= BORDURE_FENETRE/2 + HAUTEUR_BOUTON * 4 + 25 * 3) ligne = 4;
            clickBouton(ligne);
        }
        if (event.getX() < BORDURE_FENETRE/2 || event.getX() > (1+NOMBRE_CASE_INI)*TAILLE_SPRITE) return;
        if (event.getY() < BORDURE_FENETRE/2 || event.getY() > (1+NOMBRE_CASE_INI)*TAILLE_SPRITE) return;
        int colonne = (event.getX() - BORDURE_FENETRE/2) / TAILLE_SPRITE;
        int ligne = (event.getY() - BORDURE_FENETRE/2) / TAILLE_SPRITE;
        clickPerformed(colonne,ligne);
    }

    private void clickPerformed(int colonne, int ligne) {
        if(game.isPlacerPiece()) {
            if (colonne == 0 || colonne == 4 || ligne == 0 || ligne == 4) {
                game.getJoueurActif().posePiece(colonne, ligne);
                game.setPlacerPiece(false);
                if (game.getJoueurActif() == game.getJoueurs()[0]) game.setJoueurActif(game.getJoueurs()[1]);
                else game.setJoueurActif(game.getJoueurs()[0]);
            }
        }
    }

    private void clickBouton(int ligne) {
        if (ligne == 1) game.setPlacerPiece(true);
        if (ligne == 2 && game.isPieceSelectionnee()) game.setSortirPiece(true);
        if (ligne == 3 && game.isPieceSelectionnee()) game.setDeplacerPiece(true);
        if (ligne == 4 && game.isPieceSelectionnee()) game.setChangerOrientation(true);
    }
}