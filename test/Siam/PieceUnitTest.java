package Siam;

import Siam.Interface.Ecran;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class PieceUnitTest {

    private Piece piece;

    @Before
    public void setUp() {
        piece = new Piece() {
            @Override
            public void render(Ecran ecran) {}
        };
    }

    @Test
    public void testGetPosition() {
        Case aCase = Mockito.mock(Case.class);
        piece = new Piece(aCase, 0) {
            @Override
            public void render(Ecran ecran) {}
        };
        Assert.assertSame(aCase, piece.getPosition());
    }

    @Test
    public void testSetPosition() {
        Case aCase = Mockito.mock(Case.class);
        piece.setPosition(aCase);
        Assert.assertSame(aCase, piece.getPosition());
    }

    @Test
    public void testGetOrientation() {
        Assert.assertEquals(0, piece.getOrientation());
    }

    @Test
    public void testSetOrientation() {
        piece.setOrientation(3);
        Assert.assertEquals(3, piece.getOrientation());
    }
}