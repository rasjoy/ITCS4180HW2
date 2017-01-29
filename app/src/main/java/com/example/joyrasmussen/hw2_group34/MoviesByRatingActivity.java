package com.example.joyrasmussen.hw2_group34;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MoviesByRatingActivity extends AppCompatActivity {

    ArrayList<Movie> movieList;

    int index;

    TextView currentTitle, currentYear, currentGenre, currentRating, currentIMDB, currentDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_by_rating);

        currentDesc = (TextView) findViewById(R.id.textViewCurrentDesc);
        currentTitle = (TextView) findViewById(R.id.textViewCurrentTitle);
        currentYear = (TextView) findViewById(R.id.textViewCurrentYear);
        currentGenre = (TextView) findViewById(R.id.textViewCurrentGenre);
        currentRating = (TextView) findViewById(R.id.textViewCurrentRating);
        currentIMDB = (TextView) findViewById(R.id.textViewCurrentIMDB);

        index = 0;

        movieList = (ArrayList<Movie>) getIntent().getSerializableExtra(MainActivity.MOVIE_LIST);

        Collections.sort(movieList, new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                return (((int) m2.getRating())-((int) m1.getRating()));
            }
        });

        displayMovie(index);

    }

    public void displayMovie(int index){

        Movie m = movieList.get(index);

        currentTitle.setText(m.getName());
        currentIMDB.setText(m.getImdb());
        currentDesc.setText(m.getDescription());
        currentRating.setText(Double.toString(m.getRating()));
        currentGenre.setText(m.getGenre());
        currentYear.setText(m.getYear() + "");
    }

    public void goToPrevious(View view){

        if(index == 0) {
            Toast.makeText(this, "This is the highest rated movie.", Toast.LENGTH_LONG).show();
            return;
        } else {
            index--;
        }

        displayMovie(index);

    }

    public void goToNext(View view){

        if(index == movieList.size() -1){
            Toast.makeText(this, "This is the lowest rated movie.", Toast.LENGTH_LONG).show();
           return;
        } else {
            index++;
        }

        displayMovie(index);
    }

    public void goToFirst(View view){
        index = 0;
        displayMovie(index);
    }

    public void goToLast(View view){
        index = movieList.size() - 1;

        if(index < 0) index = 0;

        displayMovie(index);
    }

    public void finish(View view){
        finish();
    }
}
