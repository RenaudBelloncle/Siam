package Siam;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class PlateauUnitTest {

    private Plateau plateau;

    @Before
    public void setUp() {
        plateau = new Plateau(5);
    }

    @Test
    public void testGetCase(){
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                Assert.assertEquals(plateau.getCase(j,i).getAbscisse(),j);
                Assert.assertEquals(plateau.getCase(j,i).getOrdonnee(),i);
            }
        }
    }

    @Test
    public void testGetTailleCote(){
        Assert.assertEquals(plateau.getTailleCote(),5);
    }

    @Test
    public void testPosePiece() {
        Piece piece = Mockito.mock(Piece.class);
        Mockito.when(piece.getAbscisse()).thenReturn(0);
        Mockito.when(piece.getOrdonnee()).thenReturn(0);
        plateau.posePiece(piece);
        Assert.assertSame(piece, plateau.getCase(0, 0));
    }

    @Test
    public void testSortirPiece() {
        //TODO
    }
}

