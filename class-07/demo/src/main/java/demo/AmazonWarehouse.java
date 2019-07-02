package demo;

import java.util.List;

public class AmazonWarehouse extends Warehouse {

    private List<Employee> employees;

    public AmazonWarehouse(String address, long squareFootage, long cubicFootage, List<Employee> employees) {
        super(address, squareFootage, cubicFootage);
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String toString() {
        return String.format("An Amazon warehouse at %s with %d cubic feet.", this.getAddress(), this.getCubicFootage());
    }
}
