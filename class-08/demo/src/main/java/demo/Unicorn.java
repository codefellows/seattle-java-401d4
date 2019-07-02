package demo;

public class Unicorn {
    private String name;
    private String hornColor;
    private Land homeland;

    public Unicorn(String name, String hornColor) {
        this.name = name;
        this.hornColor = hornColor;
        this.homeland = new Land("Disneyland", "sunny");
    }

    @Override
    public String toString() {
        return String.format("%s, a unicorn with a %s horn who lives in %s", this.name, this.hornColor, this.homeland.landName);
    }
}
