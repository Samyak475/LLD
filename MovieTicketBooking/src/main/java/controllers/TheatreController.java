package controllers;

import enums.City;
import entities.Theatre;
import services.TheatreService;
import entities.Movie;
import entities.Shows;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class TheatreController {
    private  final TheatreService service;

    public TheatreController() {
        this.service = new TheatreService();
    }
    public  List<Shows> getShowDetails(Theatre theatre, Movie movie, LocalDate date) {
        return service.getShowDetails(theatre,movie,date);
    }
    public void addTheatre(Theatre theatre) {
         service.addTheatre(theatre);
    }
    public Set<Movie> getMovie(LocalDate date, City city) {
        return service.getMovie(date,city);
    }
    public List<Theatre>getTheatre(City city, Movie movie , LocalDate date) {
        return service.getTheatre(city, movie,date);
    }


    }
