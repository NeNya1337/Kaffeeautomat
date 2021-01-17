package com.nenya;

public class Drink {
    private final String name;
    private final int water;

    public Drink(String name, int water){
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
}