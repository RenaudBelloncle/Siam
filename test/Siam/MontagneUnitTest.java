package Siam;

import org.junit.Assert;
import org.junit.Test;

public class MontagneUnitTest {

    @Test
    public void testEstVide() {
        Montagne montagne = new Montagne(0,0);
        Assert.assertFalse(montagne.estVide());
    }
}
