package demo;

import org.junit.Test;

import static org.junit.Assert.*;

public class FlowerTest {

    @Test
    public void testGrow() {
        Flower rose = new Flower("red", (short)52, true, true, true);
        assertEquals("growing flower should add a petal",
                (short)53,
                rose.grow());
        assertEquals("flowers can grow many times",
                54,
                rose.grow());
    }

    @Test
    public void testGrow_manyTimes() {
        Flower tulip = new Flower("red", (short)30, false, true, true);
        for (int i = 0; i < 5; i++) {
            tulip.grow();
        }
        assertEquals("flowers growing 5 times should have 5 more petals",
                35,
                tulip.numPetals);
    }
}