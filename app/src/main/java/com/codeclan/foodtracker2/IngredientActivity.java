package com.codeclan.foodtracker2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class IngredientActivity extends AppCompatActivity {

    private Larder larder;
    private ArrayList<Item> food;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient);

    }

    public  void onClick(View button){
        EditText itemET = (EditText) findViewById(R.id.item);
        String item = itemET.getText().toString();
        EditText weightET = (EditText) findViewById(R.id.weight);
        String weightSt = weightET.getText().toString();
        int weight = Integer.parseInt(weightSt);
        Intent intent = new Intent(this, MealActivity.class);
        intent.putExtra("weight", weight);
        intent.putExtra("item", item);
        startActivity(intent);

    }
}
