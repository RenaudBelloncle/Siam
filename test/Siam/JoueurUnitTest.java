package Siam;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class JoueurUnitTest {

    private Joueur joueur;

    @Before
    public void setUp() {
        joueur = new Joueur(Camp.ELEPHANT);
    }

    @Test
    public void testGetCamp() {
        Assert.assertEquals(Camp.ELEPHANT, joueur.getCamp());
    }

    @Test
    public void testSetCamp() {
        joueur.setCamp(Camp.RHINOCEROS);
        Assert.assertEquals(Camp.RHINOCEROS, joueur.getCamp());
    }

    @Test
    public void testGetPlateau() {
        //TODO
    }

    @Test
    public void setPlateau() {
        Plateau plateau = Mockito.mock(Plateau.class);
        joueur.setPlateau(plateau);
        Assert.assertSame(plateau, joueur.getPlateau());
    }

    @Test
    public void testRestePiece() {
        Assert.assertTrue(joueur.restePiece());
        //TODO
    }

    @Test
    public void testPosePiece() {
        //TODO
    }
}
