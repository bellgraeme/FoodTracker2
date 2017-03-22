package com.codeclan.foodtracker2;


import java.util.ArrayList;

public class Larder {



    ArrayList<Item> food;

    public Larder() {
        this.food = new ArrayList<Item>();
        food.add(new Item("carrot", 40,0,0,35));
        food.add(new Item("sausage",70,10,10,15));
        food.add(new Item("potato", 60,2,0,80));
        food.add(new Item("milk", 55,10,5,60));
        food.add(new Item("beer", 200,0,0,60));
    }

    public ArrayList<Item> setLarder() {
        return new ArrayList<Item>(food) ;
    }

    public ArrayList<Item> getFood() {
        return food;
    }


    public void addItemToLarder(Item item){
        this.food.add(item);
    }


    public Item getItemByName(String name){
        for(Item item : this.food){
            if(item.getName().equals(name)){
                return item;
            }
        }
        return null;
    }

    public int getLarderSize(){
        return this.food.size();
    }

    public ArrayList<String> getNames(){
        ArrayList<String> result = new ArrayList<>();
        for(Item item :  this.food){
            result.add(item.getName());
        }
        return result;
    }



}
