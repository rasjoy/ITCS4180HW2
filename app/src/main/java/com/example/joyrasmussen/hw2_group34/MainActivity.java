package com.example.joyrasmussen.hw2_group34;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import android.app.AlertDialog.Builder;


public class MainActivity extends AppCompatActivity {
    ArrayList<Movie> movieList; //Declare as ArrayList
    public final static int REQ_CODE_ADD = 100;
    public final static String MOVIE_LIST = "movieList";
    public final static String MOVIE = "Movie";
    public final static int REQ_CODE_EDIT = 200;
    public final static String EDIT_INDEX = "Index";
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
        addIntent.putExtra(MOVIE_LIST, movieList);
        startActivityForResult(addIntent,REQ_CODE_ADD);


    }

    public void showListByYear(View view){
        if(!movieList.isEmpty()) {
            //Implicit intent creation
            Intent i = new Intent("com.example.joyrasmussen.hw2_group34.intent.action.VIEWBYYEAR");
            i.putExtra("movieList", movieList);
            startActivity(i);
        }else{
            Toast.makeText(this, "There are no favorite movies to show", Toast.LENGTH_LONG).show();
        }
    }

    public void showListByRating(View view){
        //Implicit intent creation
        if(!movieList.isEmpty()) {
            Intent i = new Intent("com.example.joyrasmussen.hw2_group34.intent.action.VIEWBYRATING");
            i.putExtra("movieList", movieList);
            startActivity(i);
        }else{
            Toast.makeText(this, "There are no favorite movies to show", Toast.LENGTH_LONG).show();

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQ_CODE_ADD){
            if(resultCode == RESULT_OK){
                Movie addMe = data.getExtras().getParcelable(MOVIE);
                movieList.add(addMe);
                Toast.makeText(this,  addMe.getName() + " was added", Toast.LENGTH_LONG).show();
            }
        }else if(requestCode == REQ_CODE_EDIT){
            if(resultCode == RESULT_OK){
                Movie editMe = data.getExtras().getParcelable(MOVIE);
                int index = data.getExtras().getInt(EDIT_INDEX);
                movieList.get(index).updateMovie(editMe);
                Toast.makeText(this,"Changes to " +  movieList.get(index).getName() + " where saved.", Toast.LENGTH_LONG).show();


            }

        }
    }

    public void editMovieListenerz(View v){
        ArrayList<String> titles = new ArrayList<String>();
        if(!movieList.isEmpty()) {
            for (Movie mov : movieList) {
                titles.add(mov.getName());

            }


            AlertDialog.Builder editThese = new AlertDialog.Builder(this);
            editThese.setTitle(R.string.editDialog).setItems(titles.toArray(new CharSequence[titles.size()]), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent editInt = new Intent(MainActivity.this, EditMovie.class);
                    editInt.putExtra(MOVIE, which);
                    editInt.putExtra(MOVIE_LIST, movieList);
                    startActivityForResult(editInt, REQ_CODE_EDIT);


                }
            });
            AlertDialog alert = editThese.create();
            alert.show();
        }else{
            AlertDialog.Builder noEdits = new AlertDialog.Builder(this);
            noEdits.setTitle(R.string.emptyList).setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog alert = noEdits.create();
            alert.show();

        }

    }

    public void deleteListener(View v){
        ArrayList<String> titles = new ArrayList<String>();
        if(!movieList.isEmpty()) {
            for (Movie mov : movieList) {
                titles.add(mov.getName());

            }

            AlertDialog.Builder deletThese = new AlertDialog.Builder(this);
            deletThese.setTitle(R.string.editDialog).setItems(titles.toArray(new CharSequence[titles.size()]), new DialogInterface.OnClickListener(){


                @Override
                public void onClick(DialogInterface dialog, int which) {
                   Movie removed =  movieList.remove(which);
                    Toast.makeText(MainActivity.this, removed.getName() + " was deleted.", Toast.LENGTH_LONG).show();
                }
            });
            AlertDialog alter = deletThese.create();
            alter.show();

        }else{
            AlertDialog.Builder noDeletes = new AlertDialog.Builder(this);
            noDeletes.setTitle(R.string.emptyList).setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog alert = noDeletes.create();
            alert.show();

        }

    }

}
