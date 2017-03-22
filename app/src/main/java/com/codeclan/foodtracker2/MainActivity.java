package com.codeclan.foodtracker2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

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

        diary = new Diary();
        ArrayList<Meal> list = diary.setDiary();

        SharedPreferences sharedPref = getSharedPreferences(FOODTRACKER, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Gson gson = new Gson();
        editor.putString("Diary", gson.toJson(list));
        editor.apply();

        String diary = sharedPref.getString("Diary", "Nothing here");

        TypeToken<ArrayList<Diary>> token = new TypeToken<ArrayList<Diary>>() {
        };
        ArrayList<Diary> foodTracker = gson.fromJson(diary, token.getType());

        DiaryAdapter diaryAdapter = new DiaryAdapter(this, list);
        ListView listview = (ListView) findViewById(R.id.diary_list);
        listview.setAdapter(diaryAdapter);
    }

    public void createMealButtonClicked(View button) {
        Intent intent = new Intent(this, MealActivity.class);
        startActivity(intent);
    }
}
