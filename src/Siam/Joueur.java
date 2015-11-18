package Siam;

import Siam.Interface.Ecran;

import java.util.ArrayList;
import java.util.List;


public class Joueur {

    private List<Animal> animals;
    private int camp;
    private int pieceSurPlateau;

    public Joueur(int camp){
        animals = new ArrayList<>();
        this.camp = camp;
        pieceSurPlateau = 0;
    }

    public int getCamp() {
        return camp;
    }

    public void setCamp(int camp) {
        this.camp = camp;
    }

    public void posePiece(int colonne, int ligne) {
        if (restePiece()) {
            pieceSurPlateau++;
            if (camp == 0) {
                animals.add(new Animal(colonne, ligne, 0, 0));

            } else {
                animals.add(new Animal(colonne, ligne, 0, 1));
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