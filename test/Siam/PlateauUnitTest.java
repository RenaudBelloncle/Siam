package Siam;

import org.junit.Assert;
import org.junit.Test;

public class PlateauUnitTest {

    @Test
    public void testGetCase(){
        Plateau plateau = new Plateau(2);
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                Assert.assertEquals(plateau.getCase(j,i).getAbscisse(),j);
                Assert.assertEquals(plateau.getCase(j,i).getOrdonnee(),i);
            }
        }

    }

    @Test
    public void testGetTailleCote(){
        Plateau plateau = new Plateau(5);
        Assert.assertEquals(plateau.getTailleCote(),5);
    }
}

