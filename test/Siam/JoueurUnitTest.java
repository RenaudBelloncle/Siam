package Siam;

import Siam.Enum.Camp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class JoueurUnitTest {

    private Joueur joueur;

    @Before
    public void setUp() {
        joueur = new Joueur(Camp.ELEPHANT, "");
    }

    @Test
    public void testGetPlateau() {
        Plateau plateau = Mockito.mock(Plateau.class);
        joueur = new Joueur(plateau);
        Assert.assertSame(plateau, joueur.getPlateau());
    }

    @Test
    public void testSetPlateau() {
        Plateau plateau = Mockito.mock(Plateau.class);
        joueur.setPlateau(plateau);
        Assert.assertSame(plateau, joueur.getPlateau());
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
    public void testPosePiece() {
        joueur.setPlateau(new Plateau(5));
        joueur.posePiece(0, 0,false,false);
        Assert.assertNotSame(joueur.getPlateau().getCase(1, 1), joueur.getPlateau().getCase(0, 0));
        Assert.assertNull(joueur.posePiece(0, 0, false, false));
    }

    @Test
    public void testRestePiece() {
        Plateau plateau = Mockito.mock(Plateau.class);
        Case aCase = Mockito.mock(Case.class);
        Mockito.when(plateau.getCase(0, 0)).thenReturn(aCase);
        Mockito.when(plateau.getCase(0, 1)).thenReturn(aCase);
        Mockito.when(plateau.getCase(0, 2)).thenReturn(aCase);
        Mockito.when(plateau.getCase(0, 3)).thenReturn(aCase);
        Mockito.when(plateau.getCase(0, 4)).thenReturn(aCase);

        joueur.setPlateau(plateau);
        Assert.assertTrue(joueur.restePiece());
        joueur.posePiece(0, 0,false,false);
        Assert.assertTrue(joueur.restePiece());
        joueur.posePiece(0, 1,false,false);
        Assert.assertTrue(joueur.restePiece());
        joueur.posePiece(0, 2,false,false);
        Assert.assertTrue(joueur.restePiece());
        joueur.posePiece(0, 3,false,false);
        Assert.assertTrue(joueur.restePiece());
        joueur.posePiece(0, 4,false,false);
        Assert.assertFalse(joueur.restePiece());
    }

    @Test
    public void testSortirPiece() {
        joueur.setPlateau(new Plateau(5));
        joueur.posePiece(0, 0,false,false);
        Animal animal = (Animal)joueur.getPlateau().getCase(0, 0);
        joueur.sortirPiece(0, 0);
        Assert.assertNotSame(animal, joueur.getPlateau().getCase(0, 0));
    }

    @Test
    public void testDeplaceAnimalSurCaseVide(){
        Animal animal = Mockito.mock(Animal.class);
        Plateau plateau = Mockito.mock(Plateau.class);
        Case targetCase = Mockito.mock(Case.class);
        joueur.setPlateau(plateau);

        Mockito.when(plateau.getCase(0, 1)).thenReturn(targetCase);
        Mockito.when(targetCase.estVide()).thenReturn(false, true);
        Mockito.when(targetCase.getAbscisse()).thenReturn(0);
        Mockito.when(targetCase.getOrdonnee()).thenReturn(0);

        //test case adjacente et non vide
        boolean ret = joueur.deplaceAnimalSurCaseVide(animal, targetCase);
        Assert.assertEquals(ret, false);

        //test case adjacente et vide
        ret = joueur.deplaceAnimalSurCaseVide(animal, targetCase);
        Assert.assertEquals(ret, true);
    }

    @Test
    public void testDeplaceAnimalEnPoussant(){
        //TODO Test Manquant - JP
        Animal animal = Mockito.mock(Animal.class);
        Plateau plateau = Mockito.mock(Plateau.class);
        //creer situation qui pousse


        //creer situation ou la charge est trop importante pour la poussee
    }

    // Tests pour variante du nombre de pi�ce
    @Test
    public void testPiecePose(){
        Assert.assertEquals(joueur.getPieceRestantAPlacer(), 6);
        joueur.piecePose();
        Assert.assertEquals(joueur.getPieceRestantAPlacer(), 5);
    }

    @Test
    public void testRestePieceDispo(){
        Assert.assertTrue(joueur.restePieceDispo());
        joueur.piecePose();
        joueur.piecePose();
        joueur.piecePose();
        joueur.piecePose();
        joueur.piecePose();
        joueur.piecePose();
        Assert.assertFalse(joueur.restePieceDispo());
    }

    @Test
    public void testFinDeTour(){
        Assert.assertEquals(joueur.getNombreTour(),0);
        joueur.finDeTour();
        Assert.assertEquals(joueur.getNombreTour(), 1);
    }
}
