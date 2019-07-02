package demo;

public class Warehouse {
    private String address;
    private long squareFootage;
    private long cubicFootage;

    public Warehouse(){}
    public Warehouse(String address, long squareFootage, long cubicFootage) {
        this.address = address;
        this.squareFootage = squareFootage;
        this.cubicFootage = cubicFootage;
    }

    public String getAddress() {
        return address;
    }

    public long getSquareFootage() {
        return squareFootage;
    }

    public long getCubicFootage() {
        return cubicFootage;
    }

    public String toString() {
        return String.format("A warehouse at %s with %d cubic feet of space", this.address, this.cubicFootage);
    }
}
