package cz.martin;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CountriesService service = new CountriesService();

        Map<String, Double> map = service.get200Population();
        System.out.println("---------1--------------");
        for (String s : map.keySet()) {
            System.out.println(s+" - "+map.get(s));
        }

        System.out.println("---------2--------------");
        for (Country country : service.moreThanRussia()) {
            System.out.println(country.getName());
        }

        System.out.println("---------3--------------");
        for (Ratio population : service.getPopulations()) {
            System.out.println(population.getName()+" - "+Math.round(population.getRatio()*10000) / 100.0+"%");
        }
    }
}
