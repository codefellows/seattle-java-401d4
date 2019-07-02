package demo;

import org.junit.Test;

import static org.junit.Assert.*;

public class WarehouseTest {
    @Test
    public void testConstructor() {
        Warehouse w = new Warehouse("123 Main St, Seattle, WA", 35*35, 35*35*35);
        assertEquals(
                "address should be saved correctly",
                "123 Main St, Seattle, WA",
                w.getAddress()
        );
    }

    @Test
    public void testToString() {
        Warehouse w = new Warehouse("123 Main St, Seattle, WA", 35*35, 35*35*35);
        assertEquals(
                "should give a nice string",
                "A warehouse at 123 Main St, Seattle, WA with " + (35*35*35) + " cubic feet of space",
                w.toString()
        );
    }

}