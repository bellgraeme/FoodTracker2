package com.codeclan.foodtracker2;
import android.content.Intent;
import android.view.View;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.DatePicker;


import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static com.codeclan.foodtracker2.MainActivity.FOODTRACKER;


public class MealActivity extends AppCompatActivity {
    private Meal meal;
    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    private String name;
    private Date date;
    private TextView dateView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

    }

    public static Calendar toCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }




//    public void addIngredient(){
//        Intent intent = new Intent(this, IngredientActivity.class);
//        startActivity(intent);
//    }


    public void createMeal(View button){
        Calendar cal = toCalendar(date);
        meal.setDate(cal);
//
//        EditText mealName = (EditText) findViewById(R.id.meal_name);
//        name = mealName.getText().toString();

        meal.setName(name);
        meal.zeroWeight();
        Log.d("meal",  meal.getName());

        SharedPreferences sharedPref = getSharedPreferences(FOODTRACKER, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Gson gson = new Gson();
        editor.putString(meal.getName(), gson.toJson(meal));
        editor.apply();
        Intent intent = new Intent();

        Bundle this_bundle= new Bundle();
        this_bundle.putString("myObj", "date");


    }



    public void addMealToSharedPreferences(View view){
        SharedPreferences sharedPref = getSharedPreferences(FOODTRACKER, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        Gson gson = new Gson();

//        //Add Meals to sharedPrefs as a JSON String. Then Apply.
//        editor.putString("Meal", gson.toJson(larder));
//        editor.apply();

        Toast.makeText(MealActivity.this, "Meal added to Diary", Toast.LENGTH_LONG).show();
    }





}
