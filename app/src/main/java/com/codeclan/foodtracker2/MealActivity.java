package com.codeclan.foodtracker2;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static com.codeclan.foodtracker2.MainActivity.FOODTRACKER;


public class MealActivity extends AppCompatActivity {
    private Meal meal;
    private Date date;
    private String name;
    String day;
    String month;
    String year;
    String item;
    int weight;
    private Larder larder;
    private ArrayList<Item> food;
    Calendar cal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);
        item = getIntent().getStringExtra("item");
        weight = getIntent().getIntExtra("weight", weight);
        larder = new Larder();
        larder.setLarder();
        food = larder.getFood();
        meal = new Meal("temp", cal);
        addItemToMeal(item, weight);

    }

    public void addItemToMeal(String name, int weight){
        Item item = larder.getItemByName(name);
        meal.addItemToMeal(item, weight);
    }

    public static Calendar toCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }


    public void addIngredient(View button) {
        Intent intent = new Intent(this, IngredientActivity.class);
        startActivity(intent);
    }


    public void createMeal(View button) {
        EditText dayET = (EditText)findViewById(R.id.day);
        day = dayET.getText().toString();
        EditText monthET = (EditText)findViewById(R.id.month);
        month = monthET.getText().toString();
        EditText yearET = (EditText)findViewById(R.id.year);
        year = yearET.getText().toString();
        String dateString = year + "-" + month + "-" + day;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date selectedDate = formatter.parse(dateString);
            Calendar cal = toCalendar(selectedDate);
            meal.setDate(cal);
        }catch(ParseException pe){
            Log.d("Date failed", pe.getMessage());
            meal.setDate(cal);
        }

        EditText mealName = (EditText) findViewById(R.id.edit_name);
        name = mealName.getText().toString();
        meal.setName(name);
        meal.zeroWeight();
        Log.d("meal", meal.getName());

        SharedPreferences sharedPref = getSharedPreferences(FOODTRACKER, Context.MODE_PRIVATE);
        String diary = sharedPref.getString("foodDiary",  new ArrayList<Meal>().toString());
        Gson gson = new Gson();
        TypeToken<ArrayList<Meal>> token = new TypeToken<ArrayList<Meal>>(){};
        ArrayList<Meal> foodTracker = gson.fromJson(diary, token.getType());

        foodTracker.add(meal);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("foodDiary", gson.toJson(foodTracker));
        editor.apply();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
