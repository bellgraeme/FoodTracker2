package com.codeclan.foodtracker2;

import android.telecom.Call;

import java.net.InterfaceAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Meal implements Comparable<Meal>{

    private String  name;
    private Calendar cal;
    private HashMap<Item, Integer> ingredients;

    public Meal(String name, Calendar date) {
        this.name = name;
        this.ingredients = new HashMap<Item, Integer>();
        this.cal = cal.getInstance();
    }

    public String getDate() {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = format1.format(this.cal.getTime());
        return formatted;
    }

    public Calendar calendarTime(){
        return this.cal;
    }

    public void setDate(Calendar date) {
        this.cal = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Item, Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(HashMap<Item, Integer> ingredients) {
        this.ingredients = ingredients;
    }


    public Integer itemTotalCalories(){
        HashMap<Item, Integer> ingredients = this.ingredients;
        Integer itemCalories = 0;
        for(Item item : ingredients.keySet()){
            itemCalories += item.getCalories();

        }
        return itemCalories;
    }

    public Integer itemTotalMealWeight(){
        Integer mealSize = 0;
        HashMap<Item, Integer> ingredients = this.ingredients;
        for(Integer item : ingredients.values()){
            mealSize += item;
        }
        return  mealSize;
    }

    public void totalCalories(){
        HashMap<Item, Integer> ingredients = this.ingredients;

    }

    public Integer getTotalCalories(){
        HashMap<Item, Integer> ingredients = this.ingredients;
        Integer itemCalories = 0;
        Integer mealSize = 0;
        for(Item item : ingredients.keySet()){
            itemCalories += item.getCalories();
        }
        for(Integer value : ingredients.values()){
            mealSize += value;
        }
        Integer totalCalorie = (itemCalories/ingredients.size())* mealSize;
        return totalCalorie/100;
    }

    public Integer getTotalFat(){
        HashMap<Item, Integer> ingredients = this.ingredients;
        Integer itemFat = 0;
        Integer mealSize = 0;
        for(Item item : ingredients.keySet()){
            itemFat += item.getFat();
        }
        for(Integer value : ingredients.values()){
            mealSize += value;
        }
        Integer totalFat = (itemFat/ingredients.size())* mealSize;
        return totalFat/100;
    }

    public Integer getTotalProtein(){
        HashMap<Item, Integer> ingredients = this.ingredients;
        Integer itemProtein = 0;
        Integer mealSize = 0;
        for(Item item : ingredients.keySet()){
            itemProtein += item.getProtein();
        }
        for(Integer value : ingredients.values()){
            mealSize += value;
        }
        Integer totalProtein = (itemProtein/ingredients.size())* mealSize;
        return totalProtein/100;
    }

    public Integer getTotalCarbohydrates(){
        HashMap<Item, Integer> ingredients = this.ingredients;
        Integer itemCarb = 0;
        Integer mealSize = 0;
        for(Item item : ingredients.keySet()){
            itemCarb += item.getCarbohydrate();
        }
        for(Integer value : ingredients.values()){
            mealSize += value;
        }
        Integer totalCarb = (itemCarb/ingredients.size())* mealSize;
        return totalCarb/100;
    }



    public void addItemToMeal(Item item, Integer amount){
        this.ingredients.put(item, amount);
    }


    public static Comparator<Meal> MealDateComparator = new Comparator<Meal>() {
        @Override
        public int compare(Meal meal, Meal t1) {

            Calendar date = meal.calendarTime();
            Calendar date1 = t1.calendarTime();

            return date.compareTo(date1);
        }
    };

    @Override
    public int compareTo(Meal meal) {
        return 0;
    }

    public void zeroWeight(){
        Map<Item, Integer> ingredients = this.ingredients;
        for(Iterator<Map.Entry<Item, Integer>> it = ingredients.entrySet().iterator();
            it.hasNext();)
        {Map.Entry < Item, Integer > entry = it.next() ;
            if (entry.getValue().equals(0)) {
                it.remove();
            }
        }
    }


    public static Calendar toCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
}

