package Siam;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CaseUnitTest {

    private Case aCase;

    @Before
    public void setUp() {
        aCase = new Case(0,0);
    }

    @Test
    public void testGetAbscisse() {
        Assert.assertEquals(0, aCase.getAbscisse());
    }

    @Test
    public void testSetAbscisse() {
        aCase.setAbscisse(5);
        Assert.assertEquals(5, aCase.getAbscisse());
    }

    @Test
    public void testGetOrdonnee() {
        Assert.assertEquals(0, aCase.getOrdonnee());
    }

    @Test
    public void testSetOrdonnee() {
        aCase.setOrdonnee(5);
        Assert.assertEquals(5, aCase.getOrdonnee());
    }

    @Test
    public void testEstVide() {
        Assert.assertTrue(aCase.estVide());
    }
}
