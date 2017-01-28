package com.example.joyrasmussen.hw2_group34;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Movie> movieList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        movieList = new ArrayList<Movie>();
        movieList.add(new Movie("Space Jam", "So 90s", "Comedy","www.imbd.com", 5, 1996));
        movieList.add(new Movie("Toy Story", "There are toys","Other", "www.imdb.com", 4, 1995));
        movieList.add(new Movie("Finding Nemo","Just keep swimming", "Comedy", "www.imdb.com", 3, 2003));
        movieList.add(new Movie("Star Wars: Episode 1 - the Phantom Menace", "This movie should have never been made", "Action", "www.imdb.com", 1, 1999));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAddClickListener(View v){
        Intent addIntent = new Intent(MainActivity.this, AddMovie.class);
        startActivity(addIntent);


    }
}
