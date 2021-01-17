package com.nenya;

import java.util.*;

public class Kaffeemaschine {
    private final String name;
    private final boolean status;
    private static final int maxBeans = 255;
    private static final int maxWater = 3000;
    private static final int maxMilk = 3000;
    private static final int maxTrash = 20;
    private static final double beanWeight = 0.2;
    private int beans;
    private int water;
    private int milk;
    private double trash;
    private final Scanner sc = new Scanner(System.in);
    public final ArrayList<Drink> drinks = new ArrayList<>();

    public Kaffeemaschine(String name){
        this.name = name;
        this.status = true;
        this.trash = 0;
        this.water = 0;
        this.beans = 0;
    }

    public String getName(){
        return this.name;
    }

    public void addDrink(Drink drink){
        drinks.add(drink);
    }

    public int countDrinks(){
        return drinks.size();
    }

    public void showDrinks(){
        System.out.println("This machine can do " + drinks.size() + " different drinks.");
        int i = 1;
        for (Drink drink : drinks){
            System.out.print("\n" + i +": ");
            drink.showDrink();
            i++;
        }
    }

    public void makeDrink(){
        System.out.println("Please type the drink number!");
        int index = sc.nextInt()-1;
        String missing;
        System.out.println("you have " + getMilk() + "ml milk, " + getBeans() + " beans and " + getWater() + "ml water.");
        if(drinks.get(index) instanceof Latte){
            missing = ((Latte) drinks.get(index)).validate(getMilk(), getBeans(), getWater());
            requestIngredients(missing, index);
        } else if(drinks.get(index) instanceof Coffee){
            missing = ((Coffee) drinks.get(index)).validate(getBeans(), getWater());
            requestIngredients(missing, index);
        } else {
            missing = drinks.get(index).validate(getWater());
            requestIngredients(missing, index);
        }
        this.water -= drinks.get(index).getWater();
        if(drinks.get(index) instanceof Coffee) {
            this.beans -= ((Coffee) drinks.get(index)).getBeans();
            this.trash += ((Coffee) drinks.get(index)).getBeans()*beanWeight;
        }
        if(drinks.get(index) instanceof Latte) this.milk -= ((Latte) drinks.get(index)).getMilk();
        System.out.println("you still have " + getMilk() + "ml milk, " + getBeans() + " beans and " + getWater() + "ml water.");
        System.out.println("Making " + drinks.get(index).getClass().getName());
    }

    public void startMachine(){
        if(this.trash >= maxTrash) requestTrash();
        System.out.println("Machine started");
    }

    public boolean getStatus(){
        return this.status;
    }
    public int getWater(){
        return this.water;
    }
    private void fillWater(int amount){
        this.water += amount;
    }
    private void requestIngredients(String missing, int index){
        if(missing.contains("milk")){
            while(getMilk() < ((Latte) drinks.get(index)).getMilk()) {
                System.out.println("you got milk: " + getMilk());
                System.out.println(("you need milk: " + ((Latte) drinks.get(index)).getMilk()));
                requestMilk();
            }
        }
        if(missing.contains("water")){
            while(getWater() < drinks.get(index).getWater()){
                System.out.println("you got water: " + getWater());
                System.out.println(("you need water: " + drinks.get(index).getWater()));
                requestWater();
            }
        }
        if(missing.contains("beans")){
            while(getBeans() < ((Coffee) drinks.get(index)).getBeans()) {
                System.out.println("you got beans: " + getBeans());
                System.out.println(("you need beans: " + ((Coffee) drinks.get(index)).getBeans()));
                requestBeans();
            }
        }
    }

    private void requestWater(){
        int amount;
        try {
            System.out.println("Please fill the water! Input amount:");
            amount = sc.nextInt();
            if (amount + water > maxWater) throw new OverflowException("Too much water!");
            fillWater(amount);
        } catch(OverflowException oe){
            System.out.println("KM: " + getWater());
            System.out.println(oe.getMessage());
        } catch (Exception e){
            System.out.print("KM: ");
            System.out.println("That's no valid amount!");
        }

    }
    public int getMilk(){
        return this.milk;
    }
    private void fillMilk(int amount){
        this.milk += amount;
    }
    private void requestMilk(){
        int amount;
        try {
            System.out.println("Please fill the milk! Input amount:");
            amount = sc.nextInt();
            if (amount + milk > maxMilk) throw new OverflowException("Too much milk!");
            fillMilk(amount);
        } catch(OverflowException oe){
            System.out.println("KM: " + getMilk());
            System.out.println(oe.getMessage());
        } catch (Exception e){
            System.out.print("KM: ");
            System.out.println("That's no valid amount!");
        }

    }
    private int getBeans(){
        return beans;
    }
    private void fillBeans(int amount){
        this.beans += amount;
    }
    private void requestBeans(){
        int amount;
        try {
            System.out.println("Please fill the beans! Input amount:");
            amount = sc.nextInt();
            if (amount + beans > maxBeans) throw new OverflowException("Too much beans!");
            System.out.println("filling " + amount + " beans");
            fillBeans(amount);
        } catch(OverflowException oe){
            System.out.println(oe.getMessage());
        } catch (Exception e){
            System.out.println("That's no valid amount!");
        }
    }
    private void requestTrash(){
        System.out.println("Please empty the trash bin! Input 'y' to confirm.");
        String input = sc.next();
        if(input.equals("y")) {
            emptyTrash();
        }
    }
    private void emptyTrash(){
        this.trash = 0;
    }
}
