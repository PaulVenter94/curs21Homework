package ro.fasttrackit.curs21homework.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs21homework.domain.Country;
import ro.fasttrackit.curs21homework.domain.CountryService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("countries")
    public List<Country> getAllCountries(@RequestParam(required = false) String includedNeighbour, @RequestParam(required = false) String excludedNeighbour) {
        return countryService.getCountries(includedNeighbour, excludedNeighbour);
    }

    @GetMapping("countries/names")
    public List<String> getNames() {
        return countryService.getNames();
    }

    @GetMapping("countries/{id}/capital")
    public String getCapital(@PathVariable int id) {
        return countryService.getCapital(id)
                .orElse("Country does not exists");
    }

    @GetMapping("countries/{id}/population")
    public Long getPopulation(@PathVariable int id) {
        return countryService.getPopulation(id)
                .orElseThrow(() -> new RuntimeException("Id does not exits"));
    }

    @GetMapping("continents/{continentName}/countries")
    public List<Country> getCountryContinent(@PathVariable String continentName, @RequestParam(required = false) Integer minPopulation) {
        return countryService.getCountriesContinent(continentName, minPopulation);
    }

    @GetMapping("/countries/{id}/neighbours")
    public List<String> getCountryNeighbours(@PathVariable int id) {
        return countryService.getNeighbours(id);
    }

    @GetMapping("countries/population")
    public Map<String,Long> mapPopToName(){
        return countryService.mapPopToName();
    }

    @GetMapping("continents/countries")
    public Map<String,List<String>> mapContinentsCountry(){
        return countryService.mapContinentsCountry();
    }
}
