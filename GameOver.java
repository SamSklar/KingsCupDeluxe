package com.example.samsklar.kingscupdeluxe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by samsklar on 6/15/16.
 */
public class GameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);
    }


    public void playAgainButtonClicked(View view) {
        Intent intent = new Intent(this, PlayGameActivity.class);
        startActivity(intent);
    }

    public void homeButtonClicked(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
