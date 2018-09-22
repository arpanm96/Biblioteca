package model;

import java.util.Objects;

public class Movies implements Item {
    private String name;
    private String director;
    private int movieRating;
    private int year;

    public Movies(String name, String director, int movieRating, int year) {
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
        Movies movies = (Movies) o;
        return movieRating == movies.movieRating &&
                year == movies.year &&
                Objects.equals(name, movies.name) &&
                Objects.equals(director, movies.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, director, movieRating, year);
    }
}
