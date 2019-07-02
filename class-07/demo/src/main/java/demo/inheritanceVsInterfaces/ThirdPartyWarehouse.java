package demo.inheritanceVsInterfaces;

public class ThirdPartyWarehouse implements Warehouse {

    private long cubicFootage;

    private String address;

    public ThirdPartyWarehouse(long cubicFootage, String address) {
        this.cubicFootage = cubicFootage;
        this.address = address;
    }
    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public long getCubicFootage() {
        return this.cubicFootage;
    }
}
