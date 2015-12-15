package Siam;


import Siam.Enum.Theme;
import Siam.Interface.Ecran;
import org.junit.Assert;
import org.junit.Test;

public class PieceUnitTest {

    @Test
    public void testEstVide() {
        Piece piece = new Piece(0,0, null) {
            @Override
            public void affichage(Ecran ecran, Theme theme) {}
        };
        Assert.assertFalse(piece.estVide());
    }

}