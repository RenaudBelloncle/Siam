package Siam;

import Siam.Interface.EcranVictoire;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public class DetectionSouris extends MouseInputAdapter implements Constantes {

    private Jeu jeu;
    private Plateau plateau;

    public DetectionSouris(Jeu jeu, Plateau plateau) {
        this.jeu = jeu;
        this.plateau = plateau;
    }

    public void mouseClicked(MouseEvent event) {
        if (event.getX() < BORDURE_FENETRE/2 || event.getX() > (1+NOMBRE_CASE_INI)*TAILLE_SPRITE) return;
        if (event.getY() < BORDURE_FENETRE/2 || event.getY() > (1+NOMBRE_CASE_INI)*TAILLE_SPRITE) return;
        int colonne = (event.getX() - BORDURE_FENETRE/2) / TAILLE_SPRITE;
        int ligne = (event.getY() - BORDURE_FENETRE/2) / TAILLE_SPRITE;
        clicEffectue(colonne,ligne);
    }

    private void clicEffectue(int colonne, int ligne) {
        if (jeu.isPieceSelectionnee() && !jeu.isDeplacerPiece() && !jeu.isEnCoursDeDeplacement()) {
            jeu.deselection();
            if (jeu.isChangerOrientation()) jeu.setChangerOrientation(false);
        }
        if(jeu.isDeplacerPiece() && jeu.getAnimalSelectionnee() != null) {
            if(!jeu.getPlateau().testCaseAdjacente(jeu.getAnimalSelectionnee(),
                    plateau.getCase(colonne, ligne)))
            {
                jeu.deselection();
                jeu.setDeplacerPiece(false);
            }
            else if(jeu.getJoueurActif().deplaceAnimalSurCaseVide(jeu.getAnimalSelectionnee(),
                    plateau.getCase(colonne, ligne)))
            {
                jeu.setEnCoursDeDeplacement(true);
                jeu.setSelectionnerOrientation(true);
                jeu.setDeplacerPiece(false);
            }
            else {
                if(jeu.testOrientationEntreAnimalEtCase(jeu.getAnimalSelectionnee(),
                        plateau.getCase(colonne, ligne))) {
                    TokenResultatPoussee ret = jeu.getJoueurActif().deplaceAnimalEnPoussant(jeu.getAnimalSelectionnee());
                    if(ret.isPousseeEffectue()){
                        if(ret.getCampGagnant() != null) {
                            jeu.getVueJeu().getMenuBar().removeAll();
                            new EcranVictoire(jeu, jeu.getFenetre() ,ret.getCampGagnant(), jeu.getTheme(), jeu.getMusique(), jeu.isSon());
                            return;
                        }
                        jeu.changerJoueurActif();
                    }
                }
                jeu.deselection();
            }
            jeu.setDeplacerPiece(false);
        }
        if (jeu.isPlacerPiece()) {
            if (!jeu.getJoueurActif().restePiece()) {
                jeu.deselection();
                return;
            }
            if (colonne == 0 || colonne == 4 || ligne == 0 || ligne == 4) {
                Animal animal = jeu.getJoueurActif().posePiece(colonne, ligne);
                if (animal == null) {
                    jeu.setPlacerPiece(false);
                    return;
                }
                animal.setSelectionnee(true);
                jeu.setAnimalSelectionnee(animal);
                jeu.setPlacerPiece(false);
                jeu.setSelectionnerOrientation(true);
            }
        } else if(!jeu.isSelectionnerOrientation() && !jeu.isEnCoursDeDeplacement() && !jeu.isDeplacerPiece()) {
            if (plateau.getCase(colonne, ligne) instanceof Animal) {
                if (((Animal) plateau.getCase(colonne, ligne)).getCamp() == jeu.getJoueurActif().getCamp()) {
                    Animal animal = (Animal)plateau.getCase(colonne, ligne);
                    animal.setSelectionnee(true);
                    jeu.setPieceSelectionnee(true);
                    jeu.setAnimalSelectionnee(animal);
                }
            }
        }
    }
}