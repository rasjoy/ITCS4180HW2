package com.example.joyrasmussen.hw2_group34;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

import static android.R.attr.x;

/**
 * Created by joyrasmussen on 1/24/17.
 */

public class Movie implements Parcelable{

    private String name, description, genre, imdb;
    private int year;
    private double rating;


    public Movie(String name, String description, String genre, String imdb, int year, double rating) {
        this.name = name;
        this.description = description;
        this.genre = genre;
        this.imdb = imdb;
        this.year = year;
        this.rating = rating;
    }

    protected Movie(Parcel in) {
        name = in.readString();
        description = in.readString();
        genre = in.readString();
        imdb = in.readString();
        year = in.readInt();
        rating = in.readDouble();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(genre);
        dest.writeString(imdb);
        dest.writeInt(year);
        dest.writeDouble(rating);
    }


}
