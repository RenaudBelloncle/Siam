package Siam;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.ArrayEquals;

import java.util.ArrayList;

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
    public void testTestCaseAdjacente(){
        boolean ret = plateau.testCaseAdjacente(plateau.getCase(1, 1), plateau.getCase(0, 1));
        Assert.assertEquals(ret, true);
        ret = plateau.testCaseAdjacente(plateau.getCase(1, 1), plateau.getCase(1, 0));
        Assert.assertEquals(ret, true);
        ret = plateau.testCaseAdjacente(plateau.getCase(1, 1), plateau.getCase(2, 1));
        Assert.assertEquals(ret, true);
        ret = plateau.testCaseAdjacente(plateau.getCase(1, 1), plateau.getCase(1, 2));
        Assert.assertEquals(ret, true);
        ret = plateau.testCaseAdjacente(plateau.getCase(0, 0), plateau.getCase(0, 2));
        Assert.assertEquals(ret, false);
    }

    @Test
    public void testDeplacerPiece(){
        Piece piece = Mockito.mock(Piece.class);
        Mockito.when(piece.getAbscisse()).thenReturn(0, 0);
        Mockito.when(piece.getOrdonnee()).thenReturn(0, 0);
        plateau.posePiece(piece);
        plateau.deplacerPiece(piece, 1, 1);
        Case acase = plateau.getCase(1, 1);
        boolean ret = acase instanceof Piece;
        Assert.assertEquals(ret, true);
    }

    @Test
    public void testSortirPiece() {
        //TODO
    }

    @Test
    public void testGetLinePushed(){
        //test d'une ligne ne contenant qu'une piece
        Animal piece1 = Mockito.mock(Animal.class);
        Mockito.when(piece1.getAbscisse()).thenReturn(0);
        Mockito.when(piece1.getOrdonnee()).thenReturn(0);
        Mockito.when(piece1.getOrientation()).thenReturn(Orientation.DROITE,
                Orientation.DROITE, Orientation.GAUCHE);
        plateau.posePiece(piece1);

        Piece piece3 = Mockito.mock(Piece.class);
        Mockito.when(piece3.getAbscisse()).thenReturn(3);
        Mockito.when(piece3.getOrdonnee()).thenReturn(0);
        plateau.posePiece(piece3);

        ArrayList<Piece> ligne = plateau.getLinePushed(piece1);
        Assert.assertEquals(ligne.size(), 1);

        Animal piece2 = Mockito.mock(Animal.class);
        Mockito.when(piece2.getAbscisse()).thenReturn(1);
        Mockito.when(piece2.getOrdonnee()).thenReturn(0);
        Mockito.when(piece2.getOrientation()).thenReturn(Orientation.GAUCHE);
        plateau.posePiece(piece2);

        //test d'une ligne contenant plusieurs pieces
        ligne = plateau.getLinePushed(piece1);
        Assert.assertEquals(ligne.size(), 2);

        //test d'une ligne qui est sur le bord
        ligne = plateau.getLinePushed(piece2);
        Assert.assertEquals(ligne.size(), 2);
    }

    @Test
    public void testCalculResultatPoussee(){
        ArrayList <Piece> ligne = new ArrayList<Piece>();
        Animal animal1 = Mockito.mock(Animal.class);
        Animal animal2 = Mockito.mock(Animal.class);
        Animal animal3 = Mockito.mock(Animal.class);
        Montagne montagne1 = Mockito.mock(Montagne.class);
        Mockito.when(animal1.getOrientation()).thenReturn(Orientation.DROITE,
                Orientation.DROITE, Orientation.DROITE);
        Mockito.when(animal2.getOrientation()).thenReturn(Orientation.BAS,
                Orientation.BAS, Orientation.BAS);
        Mockito.when(animal3.getOrientation()).thenReturn(Orientation.GAUCHE,
                Orientation.GAUCHE, Orientation.GAUCHE);

        //calcul d'une ligne avec des animaux qui ne genent pas la poussée
        ligne.add(animal1);
        ligne.add(animal2);
        TokenSommePoussee resultatPoussee = plateau.calculResultatPoussee(ligne);
        boolean compare = resultatPoussee.getSomme() > 0;
        Assert.assertEquals(compare, true);
        Assert.assertEquals(resultatPoussee.isPeutEtreNull(), false);

        //calcul d'une ligne avec des montagnes
        ligne.add(montagne1);
        resultatPoussee = plateau.calculResultatPoussee(ligne);
        compare = resultatPoussee.getSomme() == 0;
        Assert.assertEquals(compare, true);
        Assert.assertEquals(resultatPoussee.isPeutEtreNull(), true);

        //calcul d'une ligne avec des animaux a contre sens
        ligne.add(animal3);
        resultatPoussee = plateau.calculResultatPoussee(ligne);
        compare = resultatPoussee.getSomme() < 0;
        Assert.assertEquals(compare, true);
        Assert.assertEquals(resultatPoussee.isPeutEtreNull(), true);
    }

    @Test
    public void testAnalyseTokenPoussee(){
        //si > 0
        TokenSommePoussee token = new TokenSommePoussee(2, false);
        boolean ret = plateau.analyseTokenPoussee(token);
        Assert.assertEquals(ret, true);

        //si == 0 et montagne
        token = new TokenSommePoussee(0, true);
        ret =  plateau.analyseTokenPoussee(token);
        Assert.assertEquals(ret, true);

        //si == 0 et pas montagne
        token = new TokenSommePoussee(0, false);
        ret =  plateau.analyseTokenPoussee(token);
        Assert.assertEquals(ret, false);

        //si < 0
        token = new TokenSommePoussee(-1, true);
        ret =  plateau.analyseTokenPoussee(token);
        Assert.assertEquals(ret, false);

    }

    @Test
    public void testDecalageLigne(){
        //recupere une ligne et la decale
        //gere la sortie des pieces et retourne les pieces sorties
    }
}

