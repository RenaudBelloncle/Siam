package Siam;

import Siam.Enum.Camp;

public class TokenResultatPoussee {

    private boolean pousseeEffectue;
    private Camp campGagnant;

    public TokenResultatPoussee(boolean pousseeEffectue, Camp campGagnant) {
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