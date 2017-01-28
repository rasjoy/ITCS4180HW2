package com.example.joyrasmussen.hw2_group34;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAddClickListener(View v){
        Intent addIntent = new Intent(MainActivity.this, AddMovie.class);
        startActivity(addIntent);


    }
}
