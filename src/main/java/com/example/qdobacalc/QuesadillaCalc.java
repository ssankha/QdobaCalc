package com.example.qdobacalc;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class QuesadillaCalc extends AppCompatActivity {
    // TORTILLA INFO
    final int TORTILLA_CALORIES = 210;
    final int TORTILLA_PROTEIN = 6;

    boolean doubleTortillaSelected = false;
    boolean singleTortillaSelected = false;

    // PROTEIN INFO
    final int CHICKEN_CALORIES = 150;
    final int CHICKEN_PROTEIN = 16;
    final int STEAK_CALORIES = 230;
    final int STEAK_PROTEIN = 19;
    final int GROUND_BEEF_CALORIES = 190;
    final int GROUND_BEEF_PROTEIN = 17;
    final int SMOKED_BRISKET_CALORIES = 270;
    final int SMOKED_BRISKET_PROTEIN = 20;
    final int PULLED_PORK_CALORIES = 110;
    final int PULLED_PORK_PROTEIN = 13;
    final int IMPOSSIBLE_CALORIES = 180;
    final int IMPOSSIBLE_PROTEIN  = 13;

    boolean proteinChosen = false;
    int proteinCal = 0;
    int proteinNum = 0;

    // QUESO INFO


    // TOPPINGS INFO
    final int PICO_DE_GALLO_CALORIES = 10;
    final int PICO_DE_GALLO_PROTEIN = 0;
    final int SALSA_VERDE_CALORIES = 15;
    final int SALSA_VERDE_PROTEIN = 0;
    final int SALSA_ROJA_CALORIES = 20;
    final int SALSA_ROJA_PROTEIN = 1;
    final int HABANERO_SALSA_CALORIES = 20;
    final int HABANERO_SALSA_PROTEIN = 1;
    final int CORN_CALORIES = 50;
    final int CORN_PROTEIN = 2;
    final int GUACAMOLE_CALORIES = 170;
    final int GUACAMOLE_PROTEIN = 2;
    final int JALAPENOS_CALORIES = 15;
    final int JALAPENOS_PROTEIN = 0;
    final int SHREDDED_CHEESE_CALORIES = 110;
    final int SHREDDED_CHEESE_PROTEIN = 7;
    final int SHREDDED_LETTUCE_CALORIES = 110;
    final int SHREDDED_LETTUCE_PROTEIN = 7;
    final int SOUR_CREAM_CALORIES = 50;
    final int SOUR_CREAM_PROTEIN = 1;
    final int FAJITA_VEGETABLES_CALORIES = 35;
    final int FAJITA_VEGETABLES_PROTEIN = 1;
    final int QUESO_CALORIES = 90;
    final int QUESO_PROTEIN = 3;
    //final int ONIONS_CALORIES = 0;
    //final int ONION_PROTEIN = 0;

    boolean pico = false;
    boolean salsaVerde = false;
    boolean salsaRoja = false;
    boolean habaneroSalsa = false;
    boolean corn = false;
    boolean guacamole = false;
    boolean jalapeno = false;
    boolean cheese = false;
    boolean lettuce = false;
    boolean sourCream = false;
    boolean fajitaVegetables = false;
    boolean queso = false;


    // MACROS
    int totalCal = 0;
    int totalProtein = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quesadilla_calc);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#601400")));
    }

    public void tortillaChoice(View view) {
        switch (view.getId()) {

            case R.id.quesadilla_radio_double_tortilla:
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

            case R.id.quesadilla_radio_no_double_tortilla:
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

    public void proteinChoice(View view) {
        switch(view.getId()) {

            case R.id.quesadilla_radio_chicken:
                if(!proteinChosen) {
                    // no protein chosen
                    proteinCal = CHICKEN_CALORIES;
                    proteinNum = CHICKEN_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                    proteinChosen = true;
                }
                else {
                    // remove previous choice and add chicken macros
                    totalCal -= proteinCal;
                    totalProtein -= proteinNum;

                    proteinCal = CHICKEN_CALORIES;
                    proteinNum = CHICKEN_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                }

                updateData();
                break;

            case R.id.quesadilla_radio_double_chicken:
                if(!proteinChosen) {
                    // no protein chosen
                    proteinCal = 2*CHICKEN_CALORIES;
                    proteinNum = 2*CHICKEN_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                    proteinChosen = true;
                }
                else {
                    // remove previous choice and add double chicken macros
                    totalCal -= proteinCal;
                    totalProtein -= proteinNum;

                    proteinCal = 2*CHICKEN_CALORIES;
                    proteinNum = 2*CHICKEN_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                }

                updateData();
                break;

            case R.id.quesadilla_radio_steak:
                if(!proteinChosen) {
                    // no protein chosen
                    proteinCal = STEAK_CALORIES;
                    proteinNum = STEAK_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                    proteinChosen = true;
                }
                else {
                    // remove previous choice and add steak macros
                    totalCal -= proteinCal;
                    totalProtein -= proteinNum;

                    proteinCal = STEAK_CALORIES;
                    proteinNum = STEAK_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                }

                updateData();
                break;

            case R.id.quesadilla_radio_double_steak:
                if(!proteinChosen) {
                    // no protein chosen
                    proteinCal = 2*STEAK_CALORIES;
                    proteinNum = 2*STEAK_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                    proteinChosen = true;
                }
                else {
                    // remove previous choice and add steak macros
                    totalCal -= proteinCal;
                    totalProtein -= proteinNum;

                    proteinCal = 2*STEAK_CALORIES;
                    proteinNum = 2*STEAK_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                }

                updateData();
                break;

            case R.id.quesadilla_radio_ground_beef:
                if(!proteinChosen) {
                    // no protein chosen
                    proteinCal = GROUND_BEEF_CALORIES;
                    proteinNum = GROUND_BEEF_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                    proteinChosen = true;
                }
                else {
                    // remove previous choice and add ground beef macros
                    totalCal -= proteinCal;
                    totalProtein -= proteinNum;

                    proteinCal = GROUND_BEEF_CALORIES;
                    proteinNum = GROUND_BEEF_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                }

                updateData();
                break;

            case R.id.quesadilla_radio_double_ground_beef:
                if(!proteinChosen) {
                    // no protein chosen
                    proteinCal = 2*GROUND_BEEF_CALORIES;
                    proteinNum = 2*GROUND_BEEF_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                    proteinChosen = true;
                }
                else {
                    // remove previous choice and add double ground beef macros
                    totalCal -= proteinCal;
                    totalProtein -= proteinNum;

                    proteinCal = 2*GROUND_BEEF_CALORIES;
                    proteinNum = 2*GROUND_BEEF_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                }

                updateData();
                break;

            case R.id.quesadilla_radio_smoked_brisket:
                if(!proteinChosen) {
                    // no protein chosen
                    proteinCal = SMOKED_BRISKET_CALORIES;
                    proteinNum = SMOKED_BRISKET_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                    proteinChosen = true;
                }
                else {
                    // remove previous choice and add smoked brisket macros
                    totalCal -= proteinCal;
                    totalProtein -= proteinNum;

                    proteinCal = SMOKED_BRISKET_CALORIES;
                    proteinNum = SMOKED_BRISKET_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                }

                updateData();
                break;

            case R.id.quesadilla_radio_double_smoked_brisket:
                if(!proteinChosen) {
                    // no protein chosen
                    proteinCal = 2*SMOKED_BRISKET_CALORIES;
                    proteinNum = 2*SMOKED_BRISKET_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                    proteinChosen = true;
                }
                else {
                    // remove previous choice and add double smoked brisket macros
                    totalCal -= proteinCal;
                    totalProtein -= proteinNum;

                    proteinCal = 2*SMOKED_BRISKET_CALORIES;
                    proteinNum = 2*SMOKED_BRISKET_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                }

                updateData();
                break;

            case R.id.quesadilla_radio_pulled_pork:
                if(!proteinChosen) {
                    // no protein chosen
                    proteinCal = PULLED_PORK_CALORIES;
                    proteinNum = PULLED_PORK_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                    proteinChosen = true;
                }
                else {
                    // remove previous choice and add pulled pork macros
                    totalCal -= proteinCal;
                    totalProtein -= proteinNum;

                    proteinCal = PULLED_PORK_CALORIES;
                    proteinNum = PULLED_PORK_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                }

                updateData();
                break;

            case R.id.quesadilla_radio_double_pulled_pork:
                if(!proteinChosen) {
                    // no protein chosen
                    proteinCal = 2*PULLED_PORK_CALORIES;
                    proteinNum = 2*PULLED_PORK_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                    proteinChosen = true;
                }
                else {
                    // remove previous choice and add double pulled pork macros
                    totalCal -= proteinCal;
                    totalProtein -= proteinNum;

                    proteinCal = 2*PULLED_PORK_CALORIES;
                    proteinNum = 2*PULLED_PORK_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                }

                updateData();
                break;


            case R.id.quesadilla_radio_impossible:
                if(!proteinChosen) {
                    // no protein chosen
                    proteinCal = IMPOSSIBLE_CALORIES;
                    proteinNum = IMPOSSIBLE_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                    proteinChosen = true;
                }
                else {
                    // remove previous choice and add impossible macros
                    totalCal -= proteinCal;
                    totalProtein -= proteinNum;

                    proteinCal = IMPOSSIBLE_CALORIES;
                    proteinNum = IMPOSSIBLE_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                }

                updateData();
                break;

            case R.id.quesadilla_radio_double_impossible:
                if(!proteinChosen) {
                    // no protein chosen
                    proteinCal = 2*IMPOSSIBLE_CALORIES;
                    proteinNum = 2*IMPOSSIBLE_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                    proteinChosen = true;
                }
                else {
                    // remove previous choice and add impossible macros
                    totalCal -= proteinCal;
                    totalProtein -= proteinNum;

                    proteinCal = 2*IMPOSSIBLE_CALORIES;
                    proteinNum = 2*IMPOSSIBLE_PROTEIN;
                    totalCal += proteinCal;
                    totalProtein += proteinNum;
                }

                updateData();
                break;
        }
    }

    public void toppingsChoice(View view) {
        switch(view.getId()) {

            case R.id.quesadilla_checkbox_pico:
                if(!pico) {
                    totalCal += PICO_DE_GALLO_CALORIES;
                    totalProtein += PICO_DE_GALLO_PROTEIN;
                    pico = true;
                }
                else {
                    totalCal -= PICO_DE_GALLO_CALORIES;
                    totalProtein -= PICO_DE_GALLO_PROTEIN;
                    pico = false;
                }

                updateData();
                break;

            case R.id.quesadilla_checkbox_salsa_verde:
                if(!salsaVerde) {
                    totalCal += SALSA_VERDE_CALORIES;
                    totalProtein += SALSA_VERDE_PROTEIN;
                    salsaVerde = true;
                }
                else {
                    totalCal -= SALSA_VERDE_CALORIES;
                    totalProtein -= SALSA_VERDE_PROTEIN;
                    salsaVerde = false;
                }

                updateData();
                break;

            case R.id.quesadilla_checkbox_salsa_roja:
                if(!salsaRoja) {
                    totalCal += SALSA_ROJA_CALORIES;
                    totalProtein += SALSA_ROJA_PROTEIN;
                    salsaRoja = true;
                }
                else {
                    totalCal -= SALSA_ROJA_CALORIES;
                    totalProtein -= SALSA_ROJA_PROTEIN;
                    salsaRoja = false;
                }

                updateData();
                break;

            case R.id.quesadilla_checkbox_habanero_salsa:
                if(!habaneroSalsa) {
                    totalCal += HABANERO_SALSA_CALORIES;
                    totalProtein += HABANERO_SALSA_PROTEIN;
                    habaneroSalsa = true;
                }
                else {
                    totalCal -= HABANERO_SALSA_CALORIES;
                    totalProtein -= HABANERO_SALSA_PROTEIN;
                    habaneroSalsa = false;
                }

                updateData();
                break;

            case R.id.quesadilla_checkbox_corn:
                if(!corn) {
                    totalCal += CORN_CALORIES;
                    totalProtein += CORN_PROTEIN;
                    corn = true;
                }
                else {
                    totalCal -= CORN_CALORIES;
                    totalProtein -= CORN_PROTEIN;
                    corn = false;
                }

                updateData();
                break;

            case R.id.quesadilla_checkbox_guacamole:
                if(!guacamole) {
                    totalCal += GUACAMOLE_CALORIES;
                    totalProtein += GUACAMOLE_PROTEIN;
                    guacamole = true;
                }
                else {
                    totalCal -= GUACAMOLE_CALORIES;
                    totalProtein -= GUACAMOLE_PROTEIN;
                    guacamole = false;
                }

                updateData();
                break;

            case R.id.quesadilla_checkbox_jalapenos:
                if(!jalapeno) {
                    totalCal += JALAPENOS_CALORIES;
                    totalProtein += JALAPENOS_PROTEIN;
                    jalapeno = true;
                }
                else {
                    totalCal -= JALAPENOS_CALORIES;
                    totalProtein -= JALAPENOS_PROTEIN;
                    jalapeno = false;
                }

                updateData();
                break;

            case R.id.quesadilla_checkbox_shredded_cheese:
                if(!cheese) {
                    totalCal += SHREDDED_CHEESE_CALORIES;
                    totalProtein += SHREDDED_CHEESE_PROTEIN;
                    cheese = true;
                }
                else {
                    totalCal -= SHREDDED_CHEESE_CALORIES;
                    totalProtein -= SHREDDED_CHEESE_PROTEIN;
                    cheese = false;
                }

                updateData();
                break;

            case R.id.quesadilla_checkbox_shredded_lettuce:
                if(!lettuce) {
                    totalCal += SHREDDED_LETTUCE_CALORIES;
                    totalProtein += SHREDDED_LETTUCE_PROTEIN;
                    lettuce = true;
                }
                else {
                    totalCal -= SHREDDED_LETTUCE_CALORIES;
                    totalProtein -= SHREDDED_LETTUCE_PROTEIN;
                    lettuce = false;
                }

                updateData();
                break;


            case R.id.quesadilla_checkbox_sour_cream:
                if(!sourCream) {
                    totalCal += SOUR_CREAM_CALORIES;
                    totalProtein += SOUR_CREAM_PROTEIN;
                    sourCream = true;
                }
                else {
                    totalCal -= SOUR_CREAM_CALORIES;
                    totalProtein -= SOUR_CREAM_PROTEIN;
                    sourCream = false;
                }

                updateData();
                break;

            case R.id.quesadilla_checkbox_fajita_vegetables:
                if(!fajitaVegetables) {
                    totalCal += FAJITA_VEGETABLES_CALORIES;
                    totalProtein += FAJITA_VEGETABLES_PROTEIN;
                    fajitaVegetables = true;
                }
                else {
                    totalCal -= FAJITA_VEGETABLES_CALORIES;
                    totalProtein -= FAJITA_VEGETABLES_PROTEIN;
                    fajitaVegetables = false;
                }

                updateData();
                break;

            case R.id.quesadilla_checkbox_queso:
                if(!queso) {
                    totalCal += QUESO_CALORIES;
                    totalProtein += QUESO_PROTEIN;
                    queso = true;
                }
                else {
                    totalCal -= QUESO_CALORIES;
                    totalProtein -= QUESO_PROTEIN;
                    queso = false;
                }

                updateData();
                break;
        }
    }


    public void updateData() {
        TextView numCal = findViewById(R.id.quesadilla_num_calories);
        numCal.setText(String.valueOf(totalCal));

        TextView numProtein = findViewById(R.id.quesadilla_num_protein);
        numProtein.setText(String.valueOf(totalProtein));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
