package com.codeclan.foodtracker2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Calendar;

import static com.codeclan.foodtracker2.MainActivity.FOODTRACKER;

public class BreakdownActivity extends AppCompatActivity {

    Meal meal;
    Larder larder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakdown);
        larder.setLarder();


//        meal =(Meal)getIntent().getSerializableExtra("meal");



//        TextView name = (TextView)findViewById(R.id.name);
//        name.setText(meal.getName());
//        TextView date = (TextView)findViewById(R.id.date);
//        date.setText(meal.calendarTime().toString());
//        TextView calories = (TextView)findViewById(R.id.total_cal);
//        calories.setText(meal.getTotalCalories());
//        TextView protein = (TextView)findViewById(R.id.total_protein);
//        calories.setText(meal.getTotalProtein());
//        TextView fat = (TextView)findViewById(R.id.total_fat);
//        calories.setText(meal.getTotalFat());
//        TextView carbs = (TextView)findViewById(R.id.carb);
//        calories.setText(meal.getTotalCarbohydrates());
    }


}
