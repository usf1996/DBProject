package com.example.usf.dbproject1.RecyclerView;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.usf.dbproject1.R;

//Create a reference to the views for each data item
//where you hold the views of each data item
public class movieViewHolder extends RecyclerView.ViewHolder {
    private CardView cv;
    private TextView title;
    private TextView genre;
    private TextView description;
    private ImageView photoID;

    movieViewHolder(View itemView) {
        super(itemView);
        cv = (CardView)itemView.findViewById(R.id.cardView);
        title = (TextView)itemView.findViewById(R.id.cardView_title);
        genre = (TextView)itemView.findViewById(R.id.cardView_genre);
        description = (TextView)itemView.findViewById(R.id.cardView_description);
        photoID = (ImageView)itemView.findViewById(R.id.cardView_photo);
    }

    public CardView getCv() {
        return cv;
    }

    public void setCv(CardView cv) {
        this.cv = cv;
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public TextView getGenre() {
        return genre;
    }

    public void setGenre(TextView genre) {
        this.genre = genre;
    }

    public TextView getDescription() {
        return description;
    }

    public void setDescription(TextView description) {
        this.description = description;
    }

    public ImageView getPhotoID() {
        return photoID;
    }

    public void setPhotoID(ImageView photoID) {
        this.photoID = photoID;
    }
}