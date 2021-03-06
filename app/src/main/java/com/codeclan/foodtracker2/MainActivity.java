package com.codeclan.foodtracker2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainActivity extends AppCompatActivity {


    public static final String FOODTRACKER = "foodtracker";
    private Diary diary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPref = getSharedPreferences(FOODTRACKER, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.clear();
//        editor.commit();


        diary = new Diary();
        diary.setDiary();
        ArrayList<Meal>list = diary.getDiary();

        String diary = sharedPref.getString("foodDiary", new ArrayList<Meal>().toString());
        Gson gson = new Gson();
        Log.d("DIARY", diary);
        TypeToken<ArrayList<Meal>> token = new TypeToken<ArrayList<Meal>>(){};
        ArrayList<Meal> foodTracker = gson.fromJson(diary, token.getType());

        DiaryAdapter diaryAdapter = new DiaryAdapter(this,foodTracker);
        ListView listview = (ListView) findViewById(R.id.diary_list);
        listview.setAdapter(diaryAdapter);
    }

    public void onItemClicked(View view){
        TextView textView = (TextView) findViewById(R.id.mealName);
        Meal meal = (Meal)textView.getTag();

        Intent intent = new Intent(this , BreakdownActivity.class);
        intent.putExtra("meal", meal);
        startActivity(intent);
    }

    public void createMealButtonClicked(View button) {
        Intent intent = new Intent(this, MealActivity.class);
        startActivity(intent);
    }
}
