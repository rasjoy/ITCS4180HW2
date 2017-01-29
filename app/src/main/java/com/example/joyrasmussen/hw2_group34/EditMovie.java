package com.example.joyrasmussen.hw2_group34;

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

import java.util.ArrayList;

public class EditMovie extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText year;
    private  EditText name;
    private  EditText description;
    private  EditText imdb;
    private SeekBar rating;
    private Spinner genre;
    private TextView seekVal;
    private ArrayList<Movie> movieList;
    private  String genreStr;
    private Movie toEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_movie);

        year = (EditText) findViewById(R.id.editYear2);
        name = (EditText) findViewById(R.id.editName2);
        description = (EditText) findViewById(R.id.editDescription2);
        imdb = (EditText) findViewById(R.id.editIMDB2);
        rating = (SeekBar) findViewById(R.id.seekBar2);
        genre = (Spinner) findViewById(R.id.dropdownGenre2);
        seekVal = (TextView) findViewById(R.id.seekText2);
        genreStr = "";
        movieList = (ArrayList<Movie>) getIntent().getSerializableExtra(MainActivity.MOVIE_LIST);
        toEdit =  getIntent().getParcelableExtra(MainActivity.MOVIE);


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

        year.setText(toEdit.getYear());
        name.setText(toEdit.getName());
        description.setText(toEdit.getName());
        imdb.setText(toEdit.getImdb());
        rating.setProgress(toEdit.getRating());

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
        genre.setAdapter(adapter);
        genre.setSelection(adapter.getCount());
        genre.setOnItemSelectedListener(this);



    }

    public void editMovieListener(View v){








    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        genreStr =(String) parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
