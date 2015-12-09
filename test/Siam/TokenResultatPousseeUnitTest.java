package Siam;

import Siam.Enum.Camp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TokenResultatPousseeUnitTest {

    private TokenResultatPoussee tokenResultatPoussee;

    @Before
    public void SetUp() {
        tokenResultatPoussee = new TokenResultatPoussee(true, Camp.ELEPHANT, null);
    }

    @Test
    public void testIsPousseeEffectue() {
        Assert.assertEquals(true, tokenResultatPoussee.isPousseeEffectue());
    }

    @Test
    public void testGetCampGagnant() {
        Assert.assertEquals(Camp.ELEPHANT, tokenResultatPoussee.getCampGagnant());
    }
}
