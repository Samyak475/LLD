package services;

import enums.City;
import entities.Screen;
import entities.Theatre;
import entities.Movie;
import entities.Shows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class TheatreService {
    ConcurrentHashMap<City, List<Theatre>>cityTheatre = new ConcurrentHashMap<>();

    public  List<Shows> getShowDetails(Theatre theatre, Movie movie, LocalDate date){
        List<Shows>showsList = new ArrayList<>();
        for(Screen screen : theatre.getScreensInTheatre()){
            for( Shows shows : screen.getAvailableShows(date)){
                if(shows.getMovie().equals(movie)){
                    showsList.add(shows);
                }
            }
        }
        return showsList;
    }
    public void addTheatre(Theatre theatre){
        cityTheatre.computeIfAbsent(theatre.getCity(),c-> new ArrayList<>()).add(theatre);
    }
    public Set<Movie> getMovie(LocalDate date, City city){
        Set<Movie> movieSet = new HashSet<>();
        for(Theatre theatre : cityTheatre.get(city)){
            for (Screen screen: theatre.getScreensInTheatre()){
                for(Shows shows: screen.getAvailableShows(date)){
                    movieSet.add(shows.getMovie());
                }
            }
        }
        return movieSet;
    }

    public List<Theatre>getTheatre(City city, Movie movie , LocalDate date){
        List<Theatre> allTheatre = cityTheatre.get(city);
      return  allTheatre.stream()
                .filter(theatre -> theatre.getScreensInTheatre()
                        .stream().anyMatch(screen -> screen.getAvailableShows(date)
                                .stream().anyMatch(shows -> shows.getMovie()==movie)))
                .collect(Collectors.toList());
    }

}
