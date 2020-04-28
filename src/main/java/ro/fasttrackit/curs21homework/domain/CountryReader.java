package ro.fasttrackit.curs21homework.domain;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.*;

public class CountryReader {
    public static List<Country> readCountries(String fileName) throws FileNotFoundException {
        List<Country> result = new ArrayList<>();
        Scanner scanner = new Scanner(new FileReader(fileName));
        int id = 1;
        while (scanner.hasNext()) {
            String[] country = scanner.nextLine().split("\\|");
            result.add(lineReader(id, country));
            id++;
        }
        return result;
    }

    private static Country lineReader(int id, String[] country) {
        return new Country(id,
                country[0],
                country[1],
                Long.parseLong(country[2]),
                Long.parseLong(country[3]),
                country[4],
                country.length > 5 ? getNeighbours(country[5]) : new ArrayList<>());
    }

    private static List<String> getNeighbours(String string) {
        return Arrays.asList(string.split("~"));
    }


}
