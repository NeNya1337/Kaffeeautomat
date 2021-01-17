package com.nenya;



public class Main {

    public static void main(String[] args) {
	// write your code here
        Kaffeemaschine km = new Kaffeemaschine();
        System.out.println(checkMachine(km));
        km.startMachine();
        km.addDrink(new Coffee("kleiner Kaffee", 150, 15));
        km.addDrink(new Coffee("großer Kaffee", 250, 25));
        km.showDrinks();
    }

    private static String checkMachine(Kaffeemaschine km){
        return km.getStatus() ? "done" : "not done";
    }
}
