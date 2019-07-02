package demo.inheritanceVsInterfaces;

public class AmazonWarehouse extends demo.Warehouse {

    private long squareFootage;
    private long height;


    @Override
    public String getAddress() {
        return "123 Main St.";
    }

    @Override
    public long getCubicFootage() {
        return this.squareFootage * this.height;
    }
}
