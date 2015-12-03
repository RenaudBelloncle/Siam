package Siam;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TokenSommePousseeUnitTest {

    private TokenSommePoussee tokenSommePoussee;

    @Before
    public void setUp() {
        tokenSommePoussee = new TokenSommePoussee();
    }

    @Test
    public void testIsPeutEtreNull() {
        Assert.assertEquals(false, tokenSommePoussee.isPeutEtreNull());
    }

    @Test
    public void testGetSomme() {
        Assert.assertEquals(0, tokenSommePoussee.getSomme());
    }

    @Test
    public void testAddSomme() {
        tokenSommePoussee.addSomme(10);
        Assert.assertEquals(10 , tokenSommePoussee.getSomme());
    }

    @Test
    public void testSetPeutEtreNull() {
        tokenSommePoussee.setPeutEtreNull(true);
        Assert.assertEquals(true, tokenSommePoussee.isPeutEtreNull());
    }
}
