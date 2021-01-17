package com.nenya;

import java.util.*;

public class Kaffeemaschine {
    private final String name;
    private final boolean status;
    private static final int maxBeans = 255;
    private static final int maxWater = 3000;
    private static final int maxTrash = 20;
    private static final double beanWeight = 0.2;
    private int beans;
    private int water;
    private int trash;
    private final Scanner sc = new Scanner(System.in);
    private final ArrayList<Drink> drinks = new ArrayList<>();

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

    public void showDrinks(){
        System.out.println("This machine can do " + drinks.size() + " different drinks.");
        for (Drink drink : drinks){
            drink.showDrink();
        }
    }

    public void startMachine(){
        if(this.trash >= maxTrash) requestTrash();
        if(this.water == 0) requestWater();
        if(this.beans == 0) requestBeans();
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
    private void requestWater(){
        int amount = 0;
        while(amount == 0){
            try {
                System.out.println("Please fill the water! Input amount:");
                amount = sc.nextInt();
                if (amount + water > maxWater) throw new OverflowException("Too much water!");
                fillWater(amount);
            } catch(OverflowException oe){
                System.out.println(oe.getMessage());
            } catch (Exception e){
                System.out.println("That's no valid amount!");
            }
        }
    }
    private void fillBeans(int amount){
        this.beans += amount;
    }
    private void requestBeans(){
        int amount = 0;
        while(amount == 0){
            try {
                System.out.println("Please fill the beans! Input amount:");
                amount = sc.nextInt();
                if (amount + beans > maxBeans) throw new OverflowException("Too much beans!");
                fillBeans(amount);
            } catch(OverflowException oe){
                System.out.println(oe.getMessage());
            } catch (Exception e){
                System.out.println("That's no valid amount!");
            }
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


    public Exception overFlowException;
}
