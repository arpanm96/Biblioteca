package model;

import java.util.Objects;

public class Movie implements Item {
    private String name;
    private String director;
    private int movieRating;
    private int year;

    public Movie(String name, String director, int movieRating, int year) {
        this.name = name;
        this.director = director;
        this.movieRating = movieRating;
        this.year = year;
    }

    @Override
    public ItemType getItemType() {
        return ItemType.MOVIE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return movieRating == movie.movieRating &&
                year == movie.year &&
                Objects.equals(name, movie.name) &&
                Objects.equals(director, movie.director);
    }

    @Override
    public String toString() {
        return name +
                "," + director +
                "," + movieRating +
                "," + year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, director, movieRating, year);
    }
}
