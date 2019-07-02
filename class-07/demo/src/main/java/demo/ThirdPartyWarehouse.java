package demo;

import java.util.Date;

public class ThirdPartyWarehouse extends Warehouse {
    String owner;
    Date expirationDate;

    public ThirdPartyWarehouse(String address, long squareFootage, long cubicFootage, String owner, Date expirationDate) {
        super(address, squareFootage, cubicFootage);
        this.owner = owner;
        this.expirationDate = expirationDate;
    }

    public ThirdPartyWarehouse(String address, long squareFootage, long cubicFootage) {
//        super(address, squareFootage, cubicFootage);
//        this.owner = null;
//        this.expirationDate = new Date();
        this(address, squareFootage, cubicFootage, null, new Date());
    }
}
