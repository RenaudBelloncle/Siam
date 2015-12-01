package Siam;

import Siam.Enum.Camp;
import org.junit.Before;
import org.junit.Test;

public class TokenResultatPousseeUnitTest {

    private TokenResultatPoussee tokenResultatPoussee;

    @Before
    public void SetUp() {
        tokenResultatPoussee = new TokenResultatPoussee(true, Camp.ELEPHANT);
    }

    @Test
    public void testIsPousseeEffectue() {
        //TODO Test Manquant - JP
    }

    @Test
    public void testGetCampGagnant() {
        //TODO Test Manquant - JP
    }
}
