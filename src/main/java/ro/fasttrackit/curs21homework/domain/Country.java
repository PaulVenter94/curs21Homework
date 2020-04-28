package ro.fasttrackit.curs21homework.domain;

import java.util.List;

public class Country {
    private final int id;
    private final String name;
    private final String capital;
    private final long population;
    private final long area;
    private final String continent;
    private final List<String> neighbours;

    public Country(int id, String name, String capital, long population, long area, String continent, List<String> neighbours) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.continent = continent;
        this.neighbours = neighbours;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public long getPopulation() {
        return population;
    }

    public long getArea() {
        return area;
    }

    public String getContinent() {
        return continent;
    }

    public List<String> getNeighbours() {
        return neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (id != country.id) return false;
        if (population != country.population) return false;
        if (area != country.area) return false;
        if (name != null ? !name.equals(country.name) : country.name != null) return false;
        if (capital != null ? !capital.equals(country.capital) : country.capital != null) return false;
        if (continent != null ? !continent.equals(country.continent) : country.continent != null) return false;
        return neighbours != null ? neighbours.equals(country.neighbours) : country.neighbours == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + (int) (population ^ (population >>> 32));
        result = 31 * result + (int) (area ^ (area >>> 32));
        result = 31 * result + (continent != null ? continent.hashCode() : 0);
        result = 31 * result + (neighbours != null ? neighbours.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", continent='" + continent + '\'' +
                ", neighbours=" + neighbours +
                '}';
    }
}
