package Siam;

import org.junit.Assert;
import org.junit.Test;

public class JoueurUnitTest {

    @Test
    public void testGetCamp(){
        Joueur j = new Joueur(0);
        Assert.assertEquals(0, j.getCamp());
    }

    @Test
    public void testSetCamp(){
        Joueur j = new Joueur(0);
        j.setCamp(1);
        Assert.assertEquals(1, j.getCamp());
    }
}
