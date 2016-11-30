package com.example.usf.dbproject.SearchFragments;

import android.util.Log;

import java.util.Observable;

/**
 * Created by Abed on 30/11/2016.
 */

public class BooleanObservable  extends Observable{
    private boolean flag ;
    private String searchText;

    public BooleanObservable(){
        flag = false;
        searchText = "";
    }

    public String getsearchText(){
        return searchText;
    }

    public boolean getflag(){
        return flag;
    }

    public void changeflag(boolean flag){
        this.flag = flag;
        setChanged();
        notifyObservers();

    }
    public void changeflag(boolean flag, String newText){
        this.flag = flag;
        this.searchText = newText;
        setChanged();
        notifyObservers(newText);
        Log.d("TAG50", "changeflag: Observers notified");

    }

}
