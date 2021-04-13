package com.example.qdobacalc;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#601400")));
    }

    public void onClick(View view) {
        switch(view.getId()) {

            case R.id.burrito_button:
                Intent intent= new Intent(this, BurritoCalc.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
