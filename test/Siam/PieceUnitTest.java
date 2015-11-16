package Siam;

import Siam.Interface.Ecran;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PieceUnitTest {

    private Piece piece;

    @Before
    public void setUp() {
        piece = new Piece(new Case(0,0), 0) {
            @Override
            public void render(Ecran ecran) {

            }
        };
    }

    @Test
    public void testGetPosition() {
        Assert.assertEquals(0, piece.getPosition()[0]);
        Assert.assertEquals(0, piece.getPosition()[1]);
    }

    @Test
    public void testSetPosition() {
        piece.setPosition(5,5);
        Assert.assertEquals(5, piece.getPosition()[0]);
        Assert.assertEquals(5, piece.getPosition()[1]);
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