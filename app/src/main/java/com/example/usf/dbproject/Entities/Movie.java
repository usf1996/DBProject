package com.example.usf.dbproject.Entities;


import java.util.ArrayList;

public class Movie {
    private int movieID,companyID,duration;
    private String title,releaseDate,storyline,contentRating;
    private ArrayList<String> genres;

    /*public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }*/

    public Movie(int movieID, int companyID, String title,
                 int duration, String releaseDate, String storyline, String contentRating) {
        this.movieID = movieID;
        this.companyID = companyID;
        this.title = title;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.storyline = storyline;
        this.contentRating = contentRating;
    }

    public Movie (){

    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
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