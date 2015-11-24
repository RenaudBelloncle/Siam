package Siam;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AnimalUnitTest {

    private Animal animal;

    @Before
    public void setUp() {
        animal = new Animal(0, 0, Orientation.HAUT, Camp.ELEPHANT, false);
    }

    @Test
    public void testGetOrientation() {
        Assert.assertEquals(Orientation.HAUT, animal.getOrientation());
    }

    @Test
    public void testSetOrientation() {
        animal.setOrientation(Orientation.BAS);
        Assert.assertEquals(Orientation.BAS, animal.getOrientation());
    }

    @Test
    public void testIsSelected() {
        Assert.assertFalse(animal.isSelected());
    }

    @Test
    public void testSetSelected() {
        animal.setSelected(true);
        Assert.assertTrue(animal.isSelected());
    }

    @Test
    public void testGetCamp() {
        Assert.assertEquals(Camp.ELEPHANT, animal.getCamp());
    }

    @Test
    public void testSetCamp() {
        animal.setCamp(Camp.RHINOCEROS);
        Assert.assertEquals(Camp.RHINOCEROS, animal.getCamp());

    }
}
