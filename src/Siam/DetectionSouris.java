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
        if(jeu.getPlacerMontagne()){
            if (plateau.getCase(colonne, ligne) instanceof Montagne) return;
            if (plateau.getCase(colonne, ligne) instanceof Animal) {
                if (((Animal)plateau.getCase(colonne, ligne)).getCamp() == jeu.getJoueurActif().getCamp()) {
                    jeu.getJoueurActif().sortirPiece(colonne, ligne);
                } else {
                    if (jeu.getJoueurActif() == jeu.getJoueurs()[0]) jeu.getJoueurs()[1].sortirPiece(colonne, ligne);
                    else jeu.getJoueurs()[0].sortirPiece(colonne, ligne);
                }
            }
            jeu.getJoueurActif().posePiece(colonne, ligne,jeu.varianteNombreDePieceMaxActive(),
                    jeu.varianteCaseBannieActive(), true);
            jeu.setPlacerMontagne(false);
            jeu.changerJoueurActif();
            return;
        }
        if (jeu.isPieceSelectionnee() && !jeu.isDeplacerPiece() && !jeu.isEnCoursDeDeplacement()) {
        //Si une piece est selectionnee et qu'il n'y pas de deplacement et que le bouton deplacer piece n'est pas appuye
        // et que les deux cases selectionnees ne sont pas adjacentes
            jeu.deselection();
            if (jeu.isChangerOrientation()) jeu.setChangerOrientation(false);
        }
        //Si le bouton deplacer piece est appuye et si l'animal selectionne n'est pas null
        if( jeu.getAnimalSelectionnee() != null && jeu.isDeplacerPiece()) {
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
                    // Si poussee reussi
                    if(ret.isPousseeEffectue()){
                        jeu.getSoundsLibrary().playPousseeSound(jeu.getTheme());
                        if(ret.getCampGagnant() == Camp.NEUTRE) {
                            jeu.setPlacerMontagne(true);
                            jeu.deselection();
                            jeu.setDeplacerPiece(false);
                            return;
                        }
                        else if(ret.getCampGagnant() != null && ret.getCampGagnant() != Camp.NEUTRE) {
                        // Si gagnant
                            new EcranVictoire(jeu, jeu.getFenetre() ,ret.getCampGagnant(), jeu.getTheme(), jeu.getMusique(), jeu.isSon(),
                                    jeu.getSoundsLibrary());
                            jeu.getVueJeu().getMenuBar().removeAll();
                            new EcranVictoire(jeu, jeu.getFenetre() ,ret.getCampGagnant(), jeu.getTheme(), jeu.getMusique(), jeu.isSon(), jeu.getSoundsLibrary());
                            return;
                        }
                        if (ret.getPieceSortie() != null) {
                            Animal animalSortie = (Animal)ret.getPieceSortie();
                            if (animalSortie.getCamp() == jeu.getJoueurActif().getCamp()) {
                                jeu.getJoueurActif().enleverPiece();
                            } else {
                                jeu.getJoueurPassif().enleverPiece();
                            }
                        }
                        jeu.changerJoueurActif();
                    }
                    // Si poussee echouee
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
                jeu.getSoundsLibrary().playErrorActionSound(jeu.getTheme());
                jeu.deselection();
                return;
            }
            if (colonne == 0 || colonne == 4 || ligne == 0 || ligne == 4) {
                Animal animal = jeu.getJoueurActif().posePiece(colonne, ligne,jeu.varianteNombreDePieceMaxActive(),
                        jeu.varianteCaseBannieActive(), false);
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
            if (colonne >= 0 && colonne < 5 && ligne >= 0 && ligne < 5) {
                if (plateau.getCase(colonne, ligne) instanceof Animal) {
                    if (((Animal) plateau.getCase(colonne, ligne)).getCamp() == jeu.getJoueurActif().getCamp()) {
                        Animal animal = (Animal) plateau.getCase(colonne, ligne);
                        if (animal.getCamp() == Camp.ELEPHANT) {
                            jeu.getSoundsLibrary().playElephantSound(jeu.getTheme());
                        } else {
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
}