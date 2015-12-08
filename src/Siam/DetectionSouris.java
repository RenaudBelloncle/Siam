package Siam;

import Siam.Enum.Camp;
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
        clicEffectue(colonne, ligne);
    }

    private void clicEffectue(int colonne, int ligne) {
        //Si une piece est selectionnee et qu'il n'y pas de deplacement et que le bouton deplacer piece n'est pas appuye
        // et que les deux cases selectionnees ne sont pas adjacentes
        if (jeu.isPieceSelectionnee()  && !jeu.isEnCoursDeDeplacement() && !jeu.isDeplacerPiece()
                && !jeu.getPlateau().testCaseAdjacente(jeu.getAnimalSelectionnee(), plateau.getCase(colonne, ligne))) {
            jeu.deselection();
            if (jeu.isChangerOrientation()) jeu.setChangerOrientation(false);
        }
        //Si le bouton deplacer piece est appuye et si l'animal selectionne n'est pas null   && jeu.isDeplacerPiece()
        if( jeu.getAnimalSelectionnee() != null) {
            //Si les deux cases selectionnees ne sont pas cote a cote
            if(!jeu.getPlateau().testCaseAdjacente(jeu.getAnimalSelectionnee(), plateau.getCase(colonne, ligne)))
            {
                jeu.deselection();
                jeu.setDeplacerPiece(false);
                jeu.getSoundsLibrary().playErrorActionSound(jeu.getTheme());
            }
            // Les cases sont cote a cote
            // Si la case destination est vide
            else if(jeu.getJoueurActif().deplaceAnimalSurCaseVide(jeu.getAnimalSelectionnee(), plateau.getCase(colonne, ligne)))
            {
                jeu.setEnCoursDeDeplacement(true);
                jeu.setSelectionnerOrientation(true);
                jeu.setDeplacerPiece(false);
                jeu.getSoundsLibrary().playMarcheSound(jeu.getTheme(), jeu.getJoueurActif().getCamp());
            }
            // La case destination n'est pas vide
            else {
                // Evaluation des forces
                if(jeu.testOrientationEntreAnimalEtCase(jeu.getAnimalSelectionnee(), plateau.getCase(colonne, ligne))) {
                    TokenResultatPoussee ret = jeu.getJoueurActif().deplaceAnimalEnPoussant(jeu.getAnimalSelectionnee());
                    // Si poussée réussi
                    if(ret.isPousseeEffectue()){
                        jeu.getSoundsLibrary().playPousseeSound(jeu.getTheme());
                        // Si gagnant
                        if(ret.getCampGagnant() != null) {
                            new EcranVictoire(jeu, jeu.getFenetre() ,ret.getCampGagnant(), jeu.getTheme(), jeu.getMusique(), jeu.isSon(),
                                    jeu.getSoundsLibrary());
                            jeu.getVueJeu().getMenuBar().removeAll();
                            new EcranVictoire(jeu, jeu.getFenetre() ,ret.getCampGagnant(), jeu.getTheme(), jeu.getMusique(), jeu.isSon(), jeu.getSoundsLibrary());
                            return;
                        }
                        jeu.changerJoueurActif();
                    }
                    // Si poussée échouée
                    else
                    {
                        jeu.getSoundsLibrary().playErrorActionSound(jeu.getTheme());
                    }
                }
                jeu.deselection();
            }
            jeu.setDeplacerPiece(false);
        }

        if (jeu.isPlacerPiece()) {
            if (!jeu.getJoueurActif().restePiece()) {
                jeu.getSoundsLibrary().playPoserPieceSound(jeu.getTheme());
                jeu.deselection();
                return;
            }
            if (colonne == 0 || colonne == 4 || ligne == 0 || ligne == 4) {
                Animal animal = jeu.getJoueurActif().posePiece(colonne, ligne,jeu.varianteNombreDePieceMaxActive(),
                        jeu.varianteCaseBannieActive());
                if (animal == null) {
                    jeu.setPlacerPiece(false);
                    jeu.getSoundsLibrary().playErrorActionSound(jeu.getTheme());
                    return;
                }
                jeu.getSoundsLibrary().playPoserPieceSound(jeu.getTheme());
                animal.setSelectionnee(true);
                jeu.setAnimalSelectionnee(animal);
                jeu.setPlacerPiece(false);
                jeu.setSelectionnerOrientation(true);
            }
        } else if(!jeu.isSelectionnerOrientation() && !jeu.isEnCoursDeDeplacement() && !jeu.isDeplacerPiece()) {
            if (plateau.getCase(colonne, ligne) instanceof Animal) {
                if (((Animal) plateau.getCase(colonne, ligne)).getCamp() == jeu.getJoueurActif().getCamp()) {
                    Animal animal = (Animal)plateau.getCase(colonne, ligne);
                    if(animal.getCamp() == Camp.ELEPHANT){
                        jeu.getSoundsLibrary().playElephantSound(jeu.getTheme());
                    }
                    else{
                        jeu.getSoundsLibrary().playRinhocerosSound(jeu.getTheme());
                    }
                    animal.setSelectionnee(true);
                    jeu.setPieceSelectionnee(true);
                    jeu.setAnimalSelectionnee(animal);
                }
            }
        }
    }
}