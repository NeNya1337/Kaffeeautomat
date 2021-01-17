package com.nenya;

public class Drink {
    private final String name;
    private final int index;
    private final int water;

    public Drink(int index, String name, int water){
        this.index = index;
        this.name = name;
        this.water = water;
    }
    public void showDrink(){
        System.out.print("The drink " + getName() + " needs " + getWater() + "ml of water. ");
    }
    public String getName(){
        return this.name;
    }
    public int getWater(){
        return this.water;
    }
    public String validate(int water){
        String missing = "";
        if(water < this.getWater()) missing += "water,";
        return missing;
    }
/*
    public int getMilk() {
        return 0;
    }*/
}