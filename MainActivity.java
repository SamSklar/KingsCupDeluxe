package com.example.samsklar.kingscupdeluxe;

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

    public void playButtonClick(View view){
        Intent intent = new Intent(this, PlayGameActivity.class);
        startActivity(intent);
    }

    public void gameDescriptionButton(View view) {
        Intent intent = new Intent(this, GameDescriptionActivity.class);
        startActivity(intent);
    }
}
