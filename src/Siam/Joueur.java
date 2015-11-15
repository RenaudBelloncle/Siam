package Siam;

import java.util.List;

public class Joueur {

    private List<Piece> pieces;
    private final int elephant = 0;
    private final int rhinoceros = 1;
    private int camp;

    public Joueur(){
        this.camp=0;
    }

    public Joueur(int camp){
        this.camp = camp;
    }

    public void setCamp(int camp){
        this.camp=camp;
    }

    public int getCamp(){
        return this.camp;
    }

    public int getElephant(){
        return this.elephant;
    }

    public int getRhinoceros(){
        return this.rhinoceros;
    }
}
