package com.example.qdobacalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;


public class BurritoCalc extends AppCompatActivity {

    // TORTILLA INFO
    final int TORTILLA_CALORIES = 210;
    final int TORTILLA_PROTEIN = 6;

    boolean doubleTortillaSelected = false;
    boolean singleTortillaSelected = false;

    // RICE INFO
    final int WHITE_RICE_CALORIES = 190;
    final int WHITE_RICE_PROTEIN = 3;
    final int BROWN_RICE_CALORIES = 170;
    final int BROWN_RICE_PROTEIN = 4;

    boolean whiteRice = false;
    boolean brownRice = false;







    int totalCal = 0;
    int totalProtein = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.burrito_calc);

        TextView numCal = findViewById(R.id.burrito_num_calories);
        numCal.setText(String.valueOf(totalCal));

        TextView numProtein = findViewById(R.id.burrito_num_protein);
        numProtein.setText(String.valueOf(totalProtein));
    }

    public void onRadioButtonClicked(View view) {
        switch (view.getId()) {

            case R.id.burrito_radio_double_tortilla:
                if (!doubleTortillaSelected && !singleTortillaSelected) {
                    // no options selected
                    totalCal += 2 * TORTILLA_CALORIES;
                    totalProtein += 2 * TORTILLA_PROTEIN;
                    doubleTortillaSelected = true;
                } else if (singleTortillaSelected && !doubleTortillaSelected) {
                    // changing from single tortilla to double tortilla
                    totalCal += 210;
                    totalProtein += 6;
                    singleTortillaSelected = false;
                    doubleTortillaSelected = true;
                }

                updateData();

                break;

            case R.id.burrito_radio_no_double_tortilla:
                if (!doubleTortillaSelected && !singleTortillaSelected) {
                    // no options selected
                    totalCal += TORTILLA_CALORIES;
                    totalProtein += TORTILLA_PROTEIN;
                    singleTortillaSelected = true;
                }
                else if(doubleTortillaSelected && !singleTortillaSelected) {
                    // switch from double tortilla to single tortilla
                    totalCal -= TORTILLA_CALORIES;
                    totalProtein -= TORTILLA_PROTEIN;
                    doubleTortillaSelected = false;
                    singleTortillaSelected = true;
                }

                updateData();
                break;

        }
    }

    public void onCheckboxClicked(View view) {

    }


    public void updateData() {
        TextView numCal = findViewById(R.id.burrito_num_calories);
        numCal.setText(String.valueOf(totalCal));

        TextView numProtein = findViewById(R.id.burrito_num_protein);
        numProtein.setText(String.valueOf(totalProtein));
    }
}
