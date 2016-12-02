package com.example.usf.dbproject.Entities;


import java.util.ArrayList;
import java.util.List;

public class Movie {
    private int movieID,duration;
    private String title,releaseDate,storyline,contentRating;
    private List<String> genres;

    public Movie(int movieID, String title,
                 int duration, String releaseDate, String storyline, String contentRating) {
        this.movieID = movieID;
        this.title = title;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.storyline = storyline;
        this.contentRating = contentRating;
    }

    public Movie (){

    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getStoryline() {
        return storyline;
    }

    public void setStoryline(String storyline) {
        this.storyline = storyline;
    }

    public String getContentRating() {
        return contentRating;
    }

    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }
}