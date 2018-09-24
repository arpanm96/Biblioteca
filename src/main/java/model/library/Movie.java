package model.library;

import java.util.Objects;

/*
A class containing the movie details
*/

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

    public Movie(String name) {
        this.name = name;
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
        return name.trim().equalsIgnoreCase(movie.name.trim());
    }

    @Override
    public String toString() {
        return name + "," + director + "," + movieRating + "," + year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, director, movieRating, year);
    }
}
