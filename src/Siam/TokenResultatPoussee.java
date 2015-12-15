package Siam;

import Siam.Enum.Camp;

public class TokenResultatPoussee {

    private boolean pousseeEffectue;
    private Camp campGagnant;
    private Piece pieceSortie;

    public TokenResultatPoussee(boolean pousseeEffectue, Camp campGagnant, Piece pieceSortie) {
        this.pousseeEffectue = pousseeEffectue;
        this.campGagnant = campGagnant;
        this.pieceSortie = pieceSortie;
    }

    public boolean isPousseeEffectue() {
        return pousseeEffectue;
    }

    public Camp getCampGagnant() {
        return campGagnant;
    }

    public Piece getPieceSortie() {
        return pieceSortie;
    }
}