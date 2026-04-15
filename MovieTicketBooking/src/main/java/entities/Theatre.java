package entities;

import enums.City;

import java.util.List;

public class Theatre {
    private final City city;
    private final  List<Screen>screensInTheatre;
    private final String Name;

    public Theatre(City city, List<Screen> screensInTheatre, String name) {
        this.city = city;
        this.screensInTheatre = screensInTheatre;
        Name = name;
    }

    public City getCity() {
        return city;
    }

    public List<Screen> getScreensInTheatre() {
        return screensInTheatre;
    }

    public String getName() {
        return Name;
    }
}
