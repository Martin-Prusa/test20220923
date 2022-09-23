package cz.martin;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountriesService {
    private CountriesRepository repository = new CountriesRepository();
    private List<Country> countries = repository.loadCountries();

    public Map<String, Double>  get200Population() {
        List<Country> c = countries.stream().filter(i -> i.getPopulation() >= 200000000).toList();
        HashMap<String, Double> map = new HashMap<>();
        for (Country country : c) {
            map.put(country.getName(), country.getGdp()*1.0 / country.getPopulation());
        }
        return map;
    }

    public List<Country> moreThanRussia() {
        Country russia = countries.stream().filter(i -> i.getName().equalsIgnoreCase("Russia")).findFirst().get();
        return countries.stream().filter(i -> i.getPopulation() > russia.getPopulation()).toList();
    }

    public List<Ratio> getPopulations() {
        List<Country> europeanCountries = countries.stream()
                .filter(i -> i.getContinent().equalsIgnoreCase("Europe"))
                .toList();
        Country biggest = europeanCountries.stream().max((i, j) -> (int) (i.getPopulation() - j.getPopulation())).get();

        return europeanCountries.stream()
                .sorted((i, j) -> (int) (j.getName().length() - i.getName().length()))
                .map(i -> new Ratio(i.getName(), Math.round(i.getPopulation()*1.0/biggest.getPopulation() * 10000) / 10000.0)).toList();
    }
}
