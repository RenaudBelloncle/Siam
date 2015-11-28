package Siam;

import Siam.Enum.Camp;
import Siam.Enum.Orientation;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class Joueur {

    private List<Animal> animals;
    private Plateau plateau;
    private Camp camp;
    private int pieceSurPlateau;

    public Joueur(Camp camp){
        animals = new ArrayList<>();
        this.camp = camp;
        pieceSurPlateau = 0;
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

    public Animal posePiece(int colonne, int ligne) {
        if (restePiece()) {
            if (!(plateau.getCase(colonne,ligne) instanceof Piece)) {
                pieceSurPlateau++;
                if (camp == Camp.ELEPHANT) {
                    animals.add(new Animal(colonne, ligne, Orientation.HAUT, Camp.ELEPHANT, false));
                    plateau.posePiece(animals.get(pieceSurPlateau - 1));
                } else {
                    animals.add(new Animal(colonne, ligne, Orientation.HAUT, Camp.RHINOCEROS, false));
                    plateau.posePiece(animals.get(pieceSurPlateau - 1));
                }
                return animals.get(pieceSurPlateau - 1);
            }
        }
        return null;
    }

    public boolean restePiece() {
        return pieceSurPlateau < 5;
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
            getPlateau().deplacerPiece(animal, caseCible.getAbscisse(), caseCible.getOrdonnee());
            return true;
        }
        return false;
    }

    public TokenResultatPoussee deplaceAnimalEnPoussant(Animal pousseur){
        ArrayList<Piece> ligne = plateau.getLignePoussee(pousseur);
        TokenSommePoussee resultat = plateau.calculResultatPoussee(ligne);
        boolean pousseeReussie = false;
        Camp campGagnant = null;
        if(plateau.analyseTokenPoussee(resultat)){
            Piece pieceSortie = plateau.decalageLigne(ligne);
            pousseeReussie = true;
            if(pieceSortie != null && pieceSortie instanceof Montagne){
                campGagnant = plateau.trouveCampGagnant(ligne);
            }
        }
        return new TokenResultatPoussee(pousseeReussie, campGagnant);
    }
}