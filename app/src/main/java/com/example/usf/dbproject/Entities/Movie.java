package com.example.usf.dbproject.Entities;


public class Movie {
    private String movie_title, movie_genre, movie_description;
    private int movie_photoID;

    public Movie(String movie_title, String movie_genre, String movie_description, int movie_photoID) {
        this.movie_title = movie_title;
        this.movie_genre = movie_genre;
        this.movie_description = movie_description;
        this.movie_photoID = movie_photoID;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getMovie_genre() {
        return movie_genre;
    }

    public void setMovie_genre(String movie_genre) {
        this.movie_genre = movie_genre;
    }

    public String getMovie_description() {
        return movie_description;
    }

    public void setMovie_description(String movie_description) {
        this.movie_description = movie_description;
    }

    public int getMovie_photoID() {
        return movie_photoID;
    }

    public void setMovie_photoID(int movie_photoID) {
        this.movie_photoID = movie_photoID;
    }
}
