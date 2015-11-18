package Siam;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class JoueurUnitTest {

    private Joueur joueur;

    @Before
    public void setUp() {
        joueur = new Joueur(0);
    }

    @Test
    public void testGetCamp() {
        Assert.assertEquals(0, joueur.getCamp());
    }

    @Test
    public void testSetCamp() {
        joueur.setCamp(1);
        Assert.assertEquals(1, joueur.getCamp());
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
