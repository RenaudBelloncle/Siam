package Siam;

public class TokenResultatPoussee {
    private boolean pousseeEffectue;
    private Camp campGagnant;

    TokenResultatPoussee(boolean pousseeEffectue, Camp campGagnant) {
        this.pousseeEffectue = pousseeEffectue;
        this.campGagnant = campGagnant;
    }

    public boolean isPousseeEffectue() {
        return pousseeEffectue;
    }

    public Camp getCampGagnant() {
        return campGagnant;
    }
}