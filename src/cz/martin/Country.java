package cz.martin;

public class Country {
    private String name;
    private long population;
    private long gdp;

    private String continent;

    public Country(String name, long population, long gdp, String continent) {
        this.name = name;
        this.population = population;
        this.gdp = gdp;
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public long getPopulation() {
        return population;
    }

    public long getGdp() {
        return gdp;
    }

    public String getContinent() {
        return continent;
    }
}
