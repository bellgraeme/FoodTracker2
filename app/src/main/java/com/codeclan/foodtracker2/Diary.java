package com.codeclan.foodtracker2;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



public class Diary {

    private ArrayList<Meal> meals;

    public Diary(){
        this.meals = new ArrayList<Meal>();
        Calendar date;
        date = Calendar.getInstance();
        Meal meal1 = new Meal("someMeal", date);
        Meal meal2 = new Meal("someMeal", date);
        Meal meal3 = new Meal("someMeal", date);
        Meal meal4 = new Meal("someMeal", date);
        Meal meal5 = new Meal("someMeal", date);
        Meal meal6 = new Meal("someMeal", date);
        meals.add(meal1);
        meals.add(meal2);
        meals.add(meal3);
        meals.add(meal4);
        meals.add(meal5);
        meals.add(meal6);

    }




    public ArrayList<Meal> setDiary() {
        return new ArrayList<Meal>(meals);
    }
    public ArrayList<Meal> getDiary(){
        return this.meals;
    }

    public void addMeal(Meal meal){
        this.meals.add(meal);
    }

    public Meal findMealByName(String name){
        for(Meal item : this.meals)
          if ( item.getName().equals(name))
              return item;
        return null;
    }



    public ArrayList<Meal> findAllMealsByDate(Date date){
        ArrayList<Meal> result = new ArrayList<Meal>();
        for(int i = 0; i < this.meals.size(); i++){
            if(date.equals(this.meals.get(i).getDate())){
                result.add(this.meals.get(i));
            }
        }
        return result;
    }

    public static Calendar toCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public ArrayList<Meal>findMealDateRange(Date start, Date end){
        ArrayList<Meal> meals = new ArrayList<Meal>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(start);
        ArrayList<Meal> result = new ArrayList<Meal>();
        while (calendar.getTime().before(end))
            for(Meal item : this.meals){
                    if (item.getDate().equals(calendar))
                    result.add(item);
                    calendar.add(Calendar.DATE, 1);
                }
        return result;
    }

}


