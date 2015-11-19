package Siam;

import Siam.Interface.Ecran;

import java.util.ArrayList;
import java.util.List;


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

    public void posePiece(int colonne, int ligne) {
        if (restePiece()) {
            if (!(plateau.getCase(colonne,ligne) instanceof Piece)) {
                pieceSurPlateau++;
                System.out.println(pieceSurPlateau);
                if (camp == Camp.ELEPHANT) {
                    animals.add(new Animal(colonne, ligne, Orientation.HAUT, Camp.ELEPHANT));
                    plateau.posePiece(animals.get(pieceSurPlateau - 1));
                } else {
                    animals.add(new Animal(colonne, ligne, Orientation.HAUT, Camp.RHINOCEROS));
                    plateau.posePiece(animals.get(pieceSurPlateau - 1));
                }
            }
        }
    }

    public boolean restePiece() {
        return pieceSurPlateau < 5;
    }

    public void render(Ecran ecran){
        for(Piece piece : animals) piece.render(ecran);
    }
}