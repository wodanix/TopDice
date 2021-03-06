package com.wodanix.topdice;


import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class DiceActivity extends AppCompatActivity {
    private ImageView dice;
    private int counter;
    private TextView amountRolesText;
    private int diceType = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dice = findViewById(R.id.dice);
        Button roleButton = findViewById(R.id.roleButton);
        Button resetButton = findViewById(R.id.resetButton);
        amountRolesText = findViewById(R.id.amoutRolesText);
        Spinner diceTypeSpinner = findViewById(R.id.diceTypeSpinner);
        ArrayAdapter<CharSequence> diceTypeAdapter = ArrayAdapter.createFromResource(this, R.array.diceTypes, R.layout.support_simple_spinner_dropdown_item);
        diceTypeSpinner.setAdapter(diceTypeAdapter);
        diceTypeSpinner.setSelection(1);

        roleButton.setOnClickListener(view -> roleDices(diceType));
        resetButton.setOnClickListener(view -> resetCounter());
        diceTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String valueSelected = diceTypeAdapter.getItem(position).toString();
                switch (valueSelected) {
                    case "D4":
                        diceType = 4;
                        break;
                    case "D6":
                        diceType = 6;
                        break;
                    case "D8":
                        diceType = 8;
                        break;
                    case "D10":
                        diceType = 10;
                        break;
                    case "D12":
                        diceType = 12;
                        break;
                    case "D16":
                        diceType = 16;
                        break;
                    case "D20":
                        diceType = 20;
                        break;
                    case "D100":
                        diceType = 100;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                diceType = 6;
            }
        });
    }

    private void resetCounter() {
        counter = 0;
        setCounterText();
    }

    private void setCounterText() {
        amountRolesText.setText(String.format("you rolled the dice %s times", counter));
    }

    private void roleDices(int max) {
        int number = generateNumber(max);
        setDiceView(number, max);
        addCounter();
    }

    private void addCounter() {
        counter++;
        setCounterText();
    }

    private void setDiceView(int number, int max) {
        switch (number) {
            case 1:
                if (max == 4 || max == 8 || max == 20) {
                    dice.setImageResource(R.drawable.d4_1);
                } else if (max == 10) {
                    dice.setImageResource(R.drawable.d10_1);
                } else if (max == 12) {
                    dice.setImageResource(R.drawable.d12_1);
                } else {
                    dice.setImageResource(R.drawable.d1);
                }
                break;
            case 2:
                if (max == 4 || max == 8 || max == 20) {
                    dice.setImageResource(R.drawable.d4_2);
                } else if (max == 10){
                    dice.setImageResource(R.drawable.d10_2);
                } else if (max == 12) {
                    dice.setImageResource(R.drawable.d12_2);
                } else {
                    dice.setImageResource(R.drawable.d2);
                }
                break;
            case 3:
                if (max == 4 || max == 8 || max == 20) {
                    dice.setImageResource(R.drawable.d4_3);
                } else if (max == 10){
                    dice.setImageResource(R.drawable.d10_3);
                } else if (max == 12) {
                    dice.setImageResource(R.drawable.d12_3);
                } else {
                    dice.setImageResource(R.drawable.d3);
                }
                break;
            case 4:
                if (max == 4 || max == 8 || max == 20) {
                    dice.setImageResource(R.drawable.d4_4);
                } else if (max == 10){
                    dice.setImageResource(R.drawable.d10_4);
                } else if (max == 12) {
                    dice.setImageResource(R.drawable.d12_4);
                } else {
                    dice.setImageResource(R.drawable.d4);
                }
                break;
            case 5:
                if (max == 8 || max == 20) {
                    dice.setImageResource(R.drawable.d8_5);
                } else if (max == 10){
                    dice.setImageResource(R.drawable.d10_5);
                } else if (max == 12) {
                    dice.setImageResource(R.drawable.d12_5);
                } else {
                    dice.setImageResource(R.drawable.d5);
                }
                break;
            case 6:
                if (max == 8 || max == 20) {
                    dice.setImageResource(R.drawable.d8_6);
                } else if (max == 10){
                    dice.setImageResource(R.drawable.d10_6);
                } else if (max == 12) {
                    dice.setImageResource(R.drawable.d12_6);
                } else {
                    dice.setImageResource(R.drawable.d6);
                }
                break;
            case 7:
                if(max == 8 || max == 20){
                    dice.setImageResource(R.drawable.d8_7);
                } else if (max == 10){
                    dice.setImageResource(R.drawable.d10_7);
                } else if (max == 12) {
                    dice.setImageResource(R.drawable.d12_7);
                }
                break;
            case 8:
                if(max == 8 || max == 20){
                    dice.setImageResource(R.drawable.d8_8);
                } else if (max == 10){
                    dice.setImageResource(R.drawable.d10_8);
                } else if (max == 12) {
                    dice.setImageResource(R.drawable.d12_8);
                }
                break;
            case 9:
                if(max == 20){
                    dice.setImageResource(R.drawable.d20_9);
                } else if (max == 10){
                    dice.setImageResource(R.drawable.d10_9);
                } else if (max == 12) {
                    dice.setImageResource(R.drawable.d12_9);
                }
                break;
            case 10:
                if(max == 20){
                    dice.setImageResource(R.drawable.d20_10);
                } else if (max == 10){
                    dice.setImageResource(R.drawable.d10_10);
                } else if (max == 12) {
                    dice.setImageResource(R.drawable.d12_10);
                }
                break;
            case 11:
                if(max == 20){
                    dice.setImageResource(R.drawable.d20_11);
                } else if (max == 12) {
                    dice.setImageResource(R.drawable.d12_11);
                }
                break;
            case 12:
                if(max == 20){
                    dice.setImageResource(R.drawable.d20_12);
                } else if (max == 12) {
                    dice.setImageResource(R.drawable.d12_12);
                }
                break;
            case 13:
                if(max == 20){
                    dice.setImageResource(R.drawable.d20_13);
                }
                break;
            case 14:
                if(max == 20){
                    dice.setImageResource(R.drawable.d20_14);
                }
                break;
            case 15:
                if(max == 20){
                    dice.setImageResource(R.drawable.d20_15);
                }
                break;
            case 16:
                if(max == 20){
                    dice.setImageResource(R.drawable.d20_16);
                }
                break;
            case 17:
                if(max == 20){
                    dice.setImageResource(R.drawable.d20_17);
                }
                break;
            case 18:
                if(max == 20){
                    dice.setImageResource(R.drawable.d20_18);
                }
                break;
            case 19:
                if(max == 20){
                    dice.setImageResource(R.drawable.d20_19);
                }
                break;
            case 20:
                if(max == 20){
                    dice.setImageResource(R.drawable.d20_20);
                }
                break;
        }
    }


    private int generateNumber(int max) {
        Random random = new Random();
        int number = random.nextInt(max);
        number++;
        return number;
    }
}