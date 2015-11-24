package Siam;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public class DetectionSouris extends MouseInputAdapter implements Constantes {

    private Game game;
    private Plateau plateau;

    public DetectionSouris(Game game, Plateau plateau) {
        this.game = game;
        this.plateau = plateau;
    }

    public void mouseClicked(MouseEvent event) {
        if (event.getX() < BORDURE_FENETRE/2 || event.getX() > (1+NOMBRE_CASE_INI)*TAILLE_SPRITE) return;
        if (event.getY() < BORDURE_FENETRE/2 || event.getY() > (1+NOMBRE_CASE_INI)*TAILLE_SPRITE) return;
        int colonne = (event.getX() - BORDURE_FENETRE/2) / TAILLE_SPRITE;
        int ligne = (event.getY() - BORDURE_FENETRE/2) / TAILLE_SPRITE;
        clickPerformed(colonne,ligne);
    }

    private void clickPerformed(int colonne, int ligne) {
        if (game.isPieceSelectionnee()) {
            game.getAnimalSelectionnee().setSelected(false);
            game.setAnimalSelectionnee(null);
            game.setSelectionnerOrientation(false);
            game.setPieceSelectionnee(false);
            if (game.isChangerOrientation()) game.setChangerOrientation(false);
        }
        if(game.isPlacerPiece()) {
            if (!game.getJoueurActif().restePiece()) {
                game.setPlacerPiece(false);
                return;
            }
            if (colonne == 0 || colonne == 4 || ligne == 0 || ligne == 4) {
                Animal animal = game.getJoueurActif().posePiece(colonne, ligne);
                if (animal == null) {
                    game.setPlacerPiece(false);
                    return;
                }
                animal.setSelected(true);
                game.setAnimalSelectionnee(animal);
                game.setPlacerPiece(false);
                game.setSelectionnerOrientation(true);
            }
        } else {
            if (plateau.getCase(colonne, ligne) instanceof Animal) {
                if (((Animal) plateau.getCase(colonne, ligne)).getCamp() == game.getJoueurActif().getCamp()) {
                    Animal animal = (Animal)plateau.getCase(colonne, ligne);
                    animal.setSelected(true);
                    game.setPieceSelectionnee(true);
                    game.setAnimalSelectionnee(animal);
                }
            }
        }
    }
}