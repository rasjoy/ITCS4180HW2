package com.example.joyrasmussen.hw2_group34;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class AddMovie extends AppCompatActivity {
    EditText year;
    EditText name;
    EditText description;
    EditText imdb;
    SeekBar rating;
    Spinner genre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        year = (EditText) findViewById(R.id.editYear);
        name = (EditText)findViewById(R.id.editText3);
        description = (EditText)findViewById(R.id.editDescription);
        imdb = (EditText) findViewById(R.id.editIMDB);
        rating = (SeekBar) findViewById(R.id.seekBar);
        genre = (Spinner) findViewById(R.id.dropdownGenre);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

    }
    public void addMovieListener(View v){
        String nameStr = name.getText().toString();
        String yrStr = year.getText().toString();
        String imdbStr = imdb.getText().toString();

        Pattern pattern = Pattern.compile("");

        String toastMessage = nameStr.isEmpty() ?  "Invalid Input, \nPlease provide a movie name" : "";

        toastMessage += yrStr.isEmpty() ? toastMessage.isEmpty() ? "Invalid input, \nPlease provide a year" : "\nPlease provide a year"
                : yrStr.length() != 4 || Integer.getInteger(yrStr) < 1889?  toastMessage.isEmpty() ?
                "Invalid input, \nPlease provide a valid year" : "\nPlease provide a valid year" : "";
        toastMessage += imdbStr.isEmpty() ? toastMessage.isEmpty() ? "Invalid input, \nPlease provide a IMDB link" : "\nPlease provide a IMDB link" : imdbStr
        if(!toastMessage.isEmpty()){
            Toast.makeText(this, toastMessage,Toast.LENGTH_LONG );
            return;
        }



    }
}
