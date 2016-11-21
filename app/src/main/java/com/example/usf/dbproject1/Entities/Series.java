package com.example.usf.dbproject1.Entities;


public class Series {
    private String series_title, series_genre, series_description;
    private int series_photoID;

    public Series(String series_title, String series_genre, String series_description, int series_photoID) {
        this.series_title = series_title;
        this.series_genre = series_genre;
        this.series_description = series_description;
        this.series_photoID = series_photoID;
    }

    public String getSeries_title() {
        return series_title;
    }

    public void setSeries_title(String series_title) {
        this.series_title = series_title;
    }

    public String getSeries_genre() {
        return series_genre;
    }

    public void setSeries_genre(String series_genre) {
        this.series_genre = series_genre;
    }

    public String getSeries_description() {
        return series_description;
    }

    public void setSeries_description(String series_description) {
        this.series_description = series_description;
    }

    public int getSeries_photoID() {
        return series_photoID;
    }

    public void setSeries_photoID(int series_photoID) {
        this.series_photoID = series_photoID;
    }
}
