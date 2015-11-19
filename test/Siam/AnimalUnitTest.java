package Siam;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalUnitTest {

    private Animal animal;

    @Before
    public void setUp() {
        animal = new Animal(0, 0, 0, 0);
    }

    @Test
    public void testGetOrientation() {
        Assert.assertEquals(0, animal.getOrientation());
    }

    @Test
    public void testSetOrientation() {
        animal.setOrientation(3);
        Assert.assertEquals(3, animal.getOrientation());
    }
}
