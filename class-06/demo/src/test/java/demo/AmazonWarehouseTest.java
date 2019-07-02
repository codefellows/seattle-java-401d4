package demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AmazonWarehouseTest {
    @Test
    public void testConstructor() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Michelle"));
        AmazonWarehouse aw = new AmazonWarehouse("456 Second Street, Seattle, WA", 2345, 23450, employees);
        assertEquals("address should match",
                "456 Second Street, Seattle, WA",
                aw.getAddress());
        assertEquals("employee list should match",
                employees,
                aw.getEmployees());
    }

    @Test
    public void testStuff() {
        AmazonWarehouse w = new AmazonWarehouse("456 Second Street, Seattle, WA", 2345, 23450, null);
        // cannot find symbol
        // method getEmployees
        // variable w of type demo.Warehouse

        List<Warehouse> warehouses = new ArrayList<>();
        warehouses.add(w);
        ThirdPartyWarehouse thirdPartyWarehouse = new ThirdPartyWarehouse("456 Second Street, Seattle, WA", 2345, 23450);
        warehouses.add(thirdPartyWarehouse);
        for (Warehouse warehouse : warehouses) {
            System.out.println(warehouse.toString());
            // does not work
//            System.out.println(warehouse.getEmployees());
        }
    }

}