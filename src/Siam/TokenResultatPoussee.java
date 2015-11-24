package Siam;

/**
 * Created by jipay on 24/11/2015.
 */
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
