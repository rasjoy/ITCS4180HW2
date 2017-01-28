package com.example.joyrasmussen.hw2_group34;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

import static android.R.attr.x;

/**
 * Created by joyrasmussen on 1/24/17.
 */

public class Movie implements Parcelable, Serializable{

    private String name, description, genre, imdb;
    private int year;
    private double rating;


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
        if (Double.compare(movie.rating, rating) != 0) return false;
        if (!name.equals(movie.name)) return false;
        if (description != null ? !description.equals(movie.description) : movie.description != null)
            return false;
        if (!genre.equals(movie.genre)) return false;
        return imdb != null ? imdb.equals(movie.imdb) : movie.imdb == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + genre.hashCode();
        result = 31 * result + (imdb != null ? imdb.hashCode() : 0);
        result = 31 * result + year;
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public double getRating() {

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

    public Movie(String name, String description, String genre, String imdb, int year, double rating) {
        this.name = name;
        this.description = description;
        this.genre = genre;
        this.imdb = imdb;
        this.year = year;
        this.rating = rating;
    }
    public void updateMovie(String name, String description, String genre, String imdb, int year, double rating){
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
