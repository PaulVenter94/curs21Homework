package ro.fasttrackit.curs21homework.domain;

import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

@Service
public class CountryService {
    private final List<Country> countries;

    public CountryService() {
        List<Country> countries1;
        try {
            countries1 = CountryReader.readCountries("src/main/resources/Countries2.txt");
        } catch (FileNotFoundException e) {
            countries1 = new ArrayList<>();
            e.printStackTrace();
        }
        this.countries = countries1;
    }

    public List<Country> getCountries(String includedNeighbour, String excludedNeighbour) {
        if (includedNeighbour == null && excludedNeighbour == null) {
            return Collections.unmodifiableList(countries);
        } else {
            return countries.stream()
                    .filter(country -> country.getNeighbours().contains(includedNeighbour))
                    .filter(country -> !country.getNeighbours().contains(excludedNeighbour))
                    .collect(toList());
        }
    }

    public List<String> getNames() {
        return countries.stream()
                .map(Country::getName)
                .collect(toList());
    }

    public Optional<String> getCapital(int id) {
        return countries.stream()
                .filter(country -> country.getId() == id)
                .map(Country::getCapital)
                .findFirst();
    }

    public Optional<Long> getPopulation(int id) {
        return countries.stream()
                .filter(country -> country.getId() == id)
                .map(Country::getPopulation)
                .findFirst();
    }

    public List<String> getNeighbours(int id) {
        return countries.stream()
                .filter(country -> country.getId() == id)
                .map(Country::getNeighbours)
                .findFirst().orElse(new ArrayList<>());
    }


    public List<Country> getCountriesContinent(String continentName, Integer minPopulation) {
        if (minPopulation == null) {
            minPopulation = 0;
        }
        Integer finalMinPopulation = minPopulation;
        return countries.stream()
                .filter(country -> country.getContinent().equalsIgnoreCase(continentName))
                .filter(country -> country.getPopulation() > finalMinPopulation)
                .collect(toList());
    }

    public Map<String, Long> mapPopToName() {
        return countries.stream()
                .collect(toMap(Country::getName, Country::getPopulation));
    }

    public Map<String, List<String>> mapContinentsCountry() {
        return countries.stream()
                .collect(toMap(Country::getContinent,
                        country -> List.of(country.getName()),
                        (c1, c2) -> Stream.concat(c1.stream(), c2.stream()).collect(toList())));
    }
}
