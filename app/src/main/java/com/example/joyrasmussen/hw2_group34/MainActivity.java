package com.example.joyrasmussen.hw2_group34;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Movie> movieList; //Declare as ArrayList
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        movieList = new ArrayList<Movie>();
        movieList.add(new Movie("Space Jam", "So 90s", "Comedy","www.imbd.com", 1996, 5));
        movieList.add(new Movie("Toy Story", "There are toys","Other", "www.imdb.com", 1995, 4));
        movieList.add(new Movie("Finding Nemo","Just keep swimming", "Comedy", "www.imdb.com", 2003, 3));
        movieList.add(new Movie("Star Wars: Episode 1 - the Phantom Menace", "This movie should have never been made", "Action", "www.imdb.com", 1999, 1));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAddClickListener(View v){
        Intent addIntent = new Intent(MainActivity.this, AddMovie.class);
        startActivity(addIntent);


    }

    public void showListByYear(View view){

        //Implicit intent creation
        Intent i = new Intent("com.example.joyrasmussen.hw2_group34.intent.action.VIEWBYYEAR");
        i.putExtra("movieList", movieList);
        startActivity(i);

    }

    public void showListByRating(View view){
        //Implicit intent creation
        Intent i = new Intent("com.example.joyrasmussen.hw2_group34.intent.action.VIEWBYRATING");
        i.putExtra("movieList", movieList);
        startActivity(i);
    }
}
