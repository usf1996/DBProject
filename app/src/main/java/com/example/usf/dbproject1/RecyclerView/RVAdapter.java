package com.example.usf.dbproject1.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usf.dbproject1.Entities.Movie;
import com.example.usf.dbproject1.Entities.Series;
import com.example.usf.dbproject1.R;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Object> obj;
    private final int MOVIE = 1, SERIES = 2;

    public RVAdapter(List<Object> obj){
        this.obj = obj;
    }

    @Override
    public int getItemCount() {
        return obj.size();
    }

    @Override
    //This method is invoked by the layout manager
    //Create the appropriate viewholder that will
    // bind the data to the views from the dataset
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch (viewType) {
            case MOVIE:
                View movieView = inflater.inflate(R.layout.cardview, viewGroup, false);
                viewHolder = new movieViewHolder(movieView);
                break;
            case SERIES:
                View seriesView = inflater.inflate(R.layout.cardview, viewGroup, false);
                viewHolder = new seriesViewHolder(seriesView);
                break;
            default:
                viewHolder = null;
                break;
        }
        return viewHolder;
    }

    @Override
    //This method is invoked by the layout manager
    //Gets element from your dataset at a position i
    //and choose the appropriate viewholder to replace
    //the contents of the view with that element
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case MOVIE:
                movieViewHolder mvh = (movieViewHolder) viewHolder;
                configureMovieViewHolder(mvh, position);
                break;
            case SERIES:
                seriesViewHolder svh = (seriesViewHolder) viewHolder;
                configureSeriesViewHolder(svh, position);
                break;
        }
    }

    //set the data of the different views in the viewholder to the data of the dataset
    private void configureSeriesViewHolder(seriesViewHolder svh, int position) {
        Series series = (Series) obj.get(position);
        svh.getTitle().setText(series.getSeries_title());
        svh.getGenre().setText(series.getSeries_genre());
        svh.getDescription().setText(series.getSeries_description());
        svh.getPhotoID().setImageResource(series.getSeries_photoID());
    }

    //set the data of the different views in the viewholder to the data of the dataset
    private void configureMovieViewHolder(movieViewHolder mvh, int position) {
        Movie movie = (Movie) obj.get(position);
        mvh.getTitle().setText(movie.getMovie_title());
        mvh.getGenre().setText(movie.getMovie_genre());
        mvh.getDescription().setText(movie.getMovie_description());
        mvh.getPhotoID().setImageResource(movie.getMovie_photoID());
    }

    @Override
    //Returns the view type of the item at position for the purposes of view recycling.
    public int getItemViewType(int position) {
        if (obj.get(position) instanceof Movie) {
            return MOVIE;
        } else if (obj.get(position) instanceof Series) {
            return SERIES;
        }
        return -1;
    }

}
