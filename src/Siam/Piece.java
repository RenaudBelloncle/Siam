package Siam;

import Siam.Enum.Camp;

import java.io.PrintStream;

public abstract class Piece extends Case {

    protected Camp camp;
    private Case lastPosition;

    public Piece(int abscisse, int ordonnee, Camp camp) {
        super(abscisse, ordonnee);
        this.camp = camp;
        lastPosition = null;
    }

    public boolean estVide(){
        return false;
    }

    public Camp getCamp() {
        return camp;
    }

    public void setCamp(Camp camp) {
        this.camp = camp;
    }

    public void setLastPosition(Case lastPosition) {
        this.lastPosition = lastPosition;
    }

    public Case getLastPosition() {
        return lastPosition;
    }

    public void sauvegarder(PrintStream ps){
        super.sauvegarder(ps);
        ps.println(camp);
    }
}