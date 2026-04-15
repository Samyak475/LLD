package entities;

import enums.MovieType;

public class Movie {
    private final MovieType movieType;
    private final int movieLength;

    public Movie(MovieType movieType, int movieLength) {
        this.movieType = movieType;
        this.movieLength = movieLength;
    }

    public int getMovieLength() {
        return movieLength;
    }

    public MovieType getMovieType() {
        return movieType;
    }
}
