package cz.martin;

public class Ratio {
    private String name;
    private Double ratio;

    public Ratio(String name, Double ratio) {
        this.name = name;
        this.ratio = ratio;
    }

    public String getName() {
        return name;
    }

    public Double getRatio() {
        return ratio;
    }
}
