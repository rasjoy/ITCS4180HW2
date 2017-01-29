package com.example.joyrasmussen.hw2_group34;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class AddMovie extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{
   private EditText year;
    private  EditText name;
    private  EditText description;
    private  EditText imdb;
    private  SeekBar rating;
    private  Spinner genre;
    private  TextView seekVal;
    private  ArrayList<Movie> movieList;
    private  String genreStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        year = (EditText) findViewById(R.id.editYear);
        name = (EditText) findViewById(R.id.editName);
        description = (EditText) findViewById(R.id.editDescription);
        imdb = (EditText) findViewById(R.id.editIMDB);
        rating = (SeekBar) findViewById(R.id.seekBar);
        genre = (Spinner) findViewById(R.id.dropdownGenre);
        seekVal = (TextView) findViewById(R.id.seekText);

        genreStr = "";


        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item){
           @Override
            public View getView(int position,View convertView, ViewGroup parent){
                View views =  super.getView(position, convertView, parent);
                return views;

            }
            @Override
            public int getCount(){
                int count = super.getCount();
                return count > 0 ? count - 1 :  count;

            }

        };
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapter.add("Action");
        adapter.add("Animation");
        adapter.add("Comedy");
        adapter.add("Documentary");
        adapter.add("Family");
        adapter.add("Horror");
        adapter.add("Crime");
        adapter.add("Others");
        adapter.add("Select");


       // adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        genre.setAdapter(adapter);
        genre.setSelection(adapter.getCount());
        genre.setOnItemSelectedListener(this);

        movieList = (ArrayList<Movie>) getIntent().getSerializableExtra(MainActivity.MOVIE_LIST);

        rating.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekVal.setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
    public void addMovieListener(View v){
        String nameStr = name.getText().toString();

        String yrStr = year.getText().toString();
        String imdbStr = imdb.getText().toString();
        String descriptStr = description.getText().toString();


        Pattern pattern = Pattern.compile("^(?:www\\.)?(?=(imdb\\.com))");


        String toastMessage = nameStr == null || nameStr.isEmpty() ?  "Invalid Input, \nPlease provide a movie name." : "";

        toastMessage += descriptStr.isEmpty() ? toastMessage.isEmpty() ?
                "Invalid input, \nPlease provide a description." : "\nPlease provide a description."
                : "";


        toastMessage += genreStr.equals("Select") ? toastMessage.isEmpty() ? "Invalid input, \nPlease select a movie genre." : "\nPlease select a movie genre." : "";

        toastMessage += yrStr.isEmpty() ? toastMessage.isEmpty() ? "Invalid input, \nPlease provide a year." : "\nPlease provide a year."
                : yrStr.length() != 4 || Integer.parseInt(yrStr) < 1889 ?  toastMessage.isEmpty() ?
                "Invalid input, \nPlease provide a year after movies were invented." : "\nPlease provide a year after movies were invented." : "";

        int yr = Integer.parseInt(yrStr);

        toastMessage += imdbStr.isEmpty() ? toastMessage.isEmpty() ?
                "Invalid input, \nPlease provide a IMDB link." : "\nPlease provide a IMDB link." :
                pattern.matcher(imdbStr).lookingAt() ? "" :"\nPlease provide a valid IMDB URL." ;


        if(!toastMessage.isEmpty()){
            Toast.makeText(this, toastMessage,Toast.LENGTH_LONG ).show();
            return;
        }
        if(movieList.size() > 0){
            for(Movie mov: movieList){
                if(yr == mov.getYear() && nameStr.equalsIgnoreCase(mov.getName())){
                    Toast.makeText(this, "The movie " + nameStr + " made in " + yr + " is already in the database.\nPlease enter another movie or return to the Main Screen", Toast.LENGTH_LONG ).show();
                    return;
                }
            }
        }
        int rate = rating.getProgress();

        Intent returnIntent = new Intent();
        returnIntent.putExtra(MainActivity.MOVIE, (Parcelable) new Movie(nameStr, descriptStr, genreStr, imdbStr, yr, rate));
        setResult(RESULT_OK, returnIntent);
        finish();



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        genreStr =(String) parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
