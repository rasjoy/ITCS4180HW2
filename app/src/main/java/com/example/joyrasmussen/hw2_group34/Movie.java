package com.example.joyrasmussen.hw2_group34;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by joyrasmussen on 1/24/17.
 */

public class Movie implements  Serializable, Parcelable{

    private String name, description, genre, imdb;
    private int year;
    private int rating;

    public Movie(String name, String description, String genre, String imdb, int year, int rating) {
        this.name = name;
        this.description = description;
        this.genre = genre;
        this.imdb = imdb;
        this.year = year;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", imdb='" + imdb + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (year != movie.year) return false;
        if (rating != movie.rating) return false;
        if (name != null ? !name.equals(movie.name) : movie.name != null) return false;
        if (description != null ? !description.equals(movie.description) : movie.description != null)
            return false;
        if (genre != null ? !genre.equals(movie.genre) : movie.genre != null) return false;
        return imdb != null ? imdb.equals(movie.imdb) : movie.imdb == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (imdb != null ? imdb.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + rating;
        return result;
    }

    public int getRating() {

        return rating;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public String getImdb() {
        return imdb;
    }

    public int getYear() {
        return year;
    }


    public void updateMovie(String name, String description, String genre, String imdb, int year, int rating){
        this.name = name;
        this.description = description;
        this.genre = genre;
        this.imdb = imdb;
        this.year = year;
        this.rating = rating;

    }
    public void updateMovie(Movie movie){
        this.name = movie.name;
        this.description = movie.description;
        this.genre = movie.genre;
        this.imdb = movie.imdb;
        this.year = movie.year;
        this.rating = movie.rating;


    }
    protected Movie(Parcel in) {
        name = in.readString();
        description = in.readString();
        genre = in.readString();
        imdb = in.readString();
        year = in.readInt();
        rating = in.readInt();
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
        dest.writeInt(rating);
    }



}
