package Siam;

import Siam.Enum.Camp;
import Siam.Enum.Orientation;
import Siam.Enum.TraceType;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class Joueur implements Constantes{

    private List<Animal> animals;
    private Plateau plateau;
    private Camp camp;
    private int pieceSurPlateau;
    private int pieceRestantAPlacer;
    private int nombreTour;
    private String pseudo;


    public Joueur(Camp camp, String pseudo){
        pieceRestantAPlacer = NOMBRE_DE_PIECE_POSEE_MAX_VARIANTE;
        animals = new ArrayList<>();
        this.camp = camp;
        this.pseudo = pseudo;
        pieceSurPlateau = 0;
        nombreTour = 0;
    }

    public Joueur(Plateau plateau) {
        this(Camp.ELEPHANT, "");
        this.plateau = plateau;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public Camp getCamp() {
        return camp;
    }

    public void setCamp(Camp camp) {
        this.camp = camp;
    }

    public String getPseudo() {
        return pseudo;
    }

    public Animal posePiece(int colonne, int ligne, boolean varianteNombrePieceActive,
                            boolean varianteCaseBannieActive, boolean varianteMontagneActive) {
        if(varianteMontagneActive) {
            plateau.posePiece(new Montagne(colonne, ligne, Camp.NEUTRE));
            return null;
        }
        else {
            if(varianteNombrePieceActive && !restePieceDispo())
                return null;
            if(varianteCaseBannieActive && nombreTour < 2) {
                if (colonne == 2 && (ligne == 0 || ligne == 4))
                    return null;
            }
            if (restePiece()) {
                if (!(plateau.getCase(colonne, ligne) instanceof Piece)) {
                    pieceSurPlateau++;
                    if (camp == Camp.ELEPHANT) {
                        animals.add(new Animal(colonne, ligne, Orientation.HAUT, Camp.ELEPHANT, false));
                        plateau.posePiece(animals.get(pieceSurPlateau - 1));
                    } else {
                        animals.add(new Animal(colonne, ligne, Orientation.HAUT, Camp.RHINOCEROS, false));
                        plateau.posePiece(animals.get(pieceSurPlateau - 1));
                    }
                    if(varianteNombrePieceActive && restePieceDispo()) piecePose();
                    return animals.get(pieceSurPlateau - 1);
                }
            }
            return null;
        }
    }

    public boolean restePiece() {
        return pieceSurPlateau < 5;
    }

    public boolean restePieceDispo(){
        return pieceRestantAPlacer > 0;
    }

    public void piecePose() {
        pieceRestantAPlacer --;
    }

    public int getPieceRestantAPlacer(){
        return pieceRestantAPlacer;
    }

    public void sortirPiece(int colonne, int ligne) {
        pieceSurPlateau--;
        ListIterator<Animal> listIterator = animals.listIterator();
        while(listIterator.hasNext()) {
            Animal animal = listIterator.next();
            if (animal.getAbscisse() == colonne && animal.getOrdonnee() == ligne) listIterator.remove();
        }
        plateau.sortirPiece(colonne, ligne);
    }

    public boolean deplaceAnimalSurCaseVide(Animal animal, Case caseCible){
        if(caseCible.estVide()){
            getPlateau().deplacerPiece(animal, caseCible.getAbscisse(), caseCible.getOrdonnee(), TraceType.MARCHE);
            return true;
        }
        return false;
    }

    public TokenResultatPoussee deplaceAnimalEnPoussant(Animal pousseur){
        ArrayList<Piece> ligne = plateau.getLignePoussee(pousseur);
        TokenSommePoussee resultat = plateau.calculResultatPoussee(ligne);
        boolean pousserReussie = false;
        Piece pieceSortie = null;
        Camp campGagnant = null;
        if(plateau.analyseTokenPoussee(resultat)){
            pieceSortie = plateau.decalageLigne(ligne);
            pousserReussie = true;
            if(pieceSortie != null && pieceSortie instanceof Montagne){
                if (pieceSortie.getCamp() == null){
                    return new TokenResultatPoussee(true, null, pieceSortie);
                }
                else campGagnant = plateau.trouveCampGagnant(ligne, pieceSortie);
            }
        }
        return new TokenResultatPoussee(pousserReussie, campGagnant, pieceSortie);
    }

    public int getNombreTour(){
        return nombreTour;
    }

    public void finDeTour(){
        nombreTour ++;
    }
}