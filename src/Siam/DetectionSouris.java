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
            if (event.getX() >= BORDURE_FENETRE + TAILLE_SPRITE*NOMBRE_CASE_INI + 75 && event.getX() <= BORDURE_FENETRE + TAILLE_SPRITE*NOMBRE_CASE_INI + 75 + TAILLE_SPRITE_FLECHE) {
                if (event.getY() >= 500 + BORDURE_FENETRE / 2 && event.getY() <= TAILLE_SPRITE_FLECHE + 500 + BORDURE_FENETRE / 2) clickFleche(Orientation.HAUT);
                if (event.getY() >= TAILLE_SPRITE_FLECHE * 2 + 500 + BORDURE_FENETRE / 2 && event.getY() <= TAILLE_SPRITE_FLECHE * 3 + 500 + BORDURE_FENETRE / 2) clickFleche(Orientation.BAS);
            }
            if (event.getY() >= TAILLE_SPRITE_FLECHE + 500 + BORDURE_FENETRE / 2 && event.getY() <= TAILLE_SPRITE_FLECHE * 2 + 500 + BORDURE_FENETRE / 2) {
                if (event.getX() >= BORDURE_FENETRE + TAILLE_SPRITE*NOMBRE_CASE_INI + 25 && event.getX() <= BORDURE_FENETRE + TAILLE_SPRITE*NOMBRE_CASE_INI + 25 + TAILLE_SPRITE_FLECHE) clickFleche(Orientation.GAUCHE);
                if (event.getX() >= BORDURE_FENETRE + TAILLE_SPRITE*NOMBRE_CASE_INI + 25 + TAILLE_SPRITE_FLECHE * 2 && event.getX() <= BORDURE_FENETRE + TAILLE_SPRITE*NOMBRE_CASE_INI + 25 + TAILLE_SPRITE_FLECHE * 3) clickFleche(Orientation.DROITE);
            }
            int ligne = 0;
            if (event.getY() >= BORDURE_FENETRE / 2 && event.getY() <= BORDURE_FENETRE / 2 + HAUTEUR_BOUTON) ligne = 1;
            else if (event.getY() >= BORDURE_FENETRE / 2 + HAUTEUR_BOUTON + 25 && event.getY() <= BORDURE_FENETRE / 2 + HAUTEUR_BOUTON * 2 + 25) ligne = 2;
            else if (event.getY() >= BORDURE_FENETRE / 2 + HAUTEUR_BOUTON * 2 + 25 * 2 && event.getY() <= BORDURE_FENETRE / 2 + HAUTEUR_BOUTON * 3 + 25 * 2) ligne = 3;
            else if (event.getY() >= BORDURE_FENETRE / 2 + HAUTEUR_BOUTON * 3 + 25 * 3 && event.getY() <= BORDURE_FENETRE / 2 + HAUTEUR_BOUTON * 4 + 25 * 3) ligne = 4;
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
            if (!game.getJoueurActif().restePiece()) {
                game.setPlacerPiece(false);
                return;
            }
            if (colonne == 0 || colonne == 4 || ligne == 0 || ligne == 4) {
                Animal animal = game.getJoueurActif().posePiece(colonne, ligne);
                animal.setSelected(true);
                game.setAnimalSelectionnee(animal);
                game.setPlacerPiece(false);
                game.setSelectionnerOrientation(true);
                game.changerJoueurActif();
            }
        }
    }

    private void clickBouton(int ligne) {
        if (ligne == 1 && !game.isPieceSelectionnee() && !game.isSelectionnerOrientation()) game.setPlacerPiece(true);
        if (ligne == 2 && game.isPieceSelectionnee()) game.setSortirPiece(true);
        if (ligne == 3 && game.isPieceSelectionnee()) game.setDeplacerPiece(true);
        if (ligne == 4 && game.isPieceSelectionnee()) game.setChangerOrientation(true);
    }

    private void clickFleche(Orientation orientation) {
        if (game.isSelectionnerOrientation()) {
            if (orientation == Orientation.HAUT) {
                game.getAnimalSelectionnee().setOrientation(Orientation.HAUT);
            }
            if (orientation == Orientation.DROITE) {
                game.getAnimalSelectionnee().setOrientation(Orientation.DROITE);
            }
            if (orientation == Orientation.BAS) {
                game.getAnimalSelectionnee().setOrientation(Orientation.BAS);
            }
            if (orientation == Orientation.GAUCHE) {
                game.getAnimalSelectionnee().setOrientation(Orientation.GAUCHE);
            }
            game.getAnimalSelectionnee().setSelected(false);
            game.setAnimalSelectionnee(null);
            game.setSelectionnerOrientation(false);
        }
    }
}