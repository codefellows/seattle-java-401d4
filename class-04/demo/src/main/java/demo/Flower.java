package demo;

public class Flower {
    // class variables
    public final static String[] flowerTypes = new String[]{"rose", "tulip", "sunflower"};
    static String[] flowerHabitats = new String[]{"greenhouse", "garden", "wilderness", "vase"};
    // Flower.flowerTypes

    // instance variables
    // properties
    String color;
    short numPetals;
    boolean hasThorns;
    boolean isEdible;
    boolean isInGround;
    // Flower rose = new Flower("red", (short)52, true, true, true);
    // rose.isInGround;
    // Flower sunflower = new Flower("red", (short)52, true, true, false);
    // sunflower.isInGround;
    // BAD CODE: Flower.isInGround THIS BREAKS

    // constructor
    // create new instances
    public Flower(String color, short numPetals, boolean hasThorns, boolean isEdible, boolean isInGround) {
        this.color = color;
        this.numPetals = numPetals;
        this.hasThorns = hasThorns;
        this.isEdible = isEdible;
        this.isInGround = isInGround;
    }

    public Flower() {

    }

    // instance methods

    // grow the flower: it has more petals now!
    // returns the new number of petals
    public short grow() {
        this.numPetals++;
        return this.numPetals;
    }

    // class methods?
}
