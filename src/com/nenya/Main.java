package com.nenya;


import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
	// write your code here
        Kaffeemaschine km = new Kaffeemaschine("Küche");
        System.out.println(checkMachine(km));
        km.startMachine();
        km.addDrink(new Coffee(km.countDrinks(), "kleiner Kaffee", 150, 15));
        km.addDrink(new Coffee(km.countDrinks(), "großer Kaffee", 250, 25));
        km.addDrink(new Latte(km.countDrinks(), "kleiner Latte", 75, 75, 15));
        km.addDrink(new Latte(km.countDrinks(), "großer Latte", 125, 125, 15));
        km.addDrink(new Drink(km.countDrinks(), "heißes Wasser", 250));
        while(true) {
            if (!showServices(km)) break;
        }
    }

    private static String checkMachine(Kaffeemaschine km){
        return km.getStatus() ? "done" : "not done";
    }

    private static boolean showServices(Kaffeemaschine km){
        final Scanner sc = new Scanner(System.in);
        boolean off = true;
        System.out.println("\nThis ist the Kaffeemaschine " + km.getName() + ".");
        try{
            System.out.println("What can I do for you?");
            System.out.println("1 - List drinks");
            System.out.println("2 - Make drink");
            System.out.println("3 - check machine status");
            System.out.println("4 - shut off machine");
            int command = sc.nextInt();
            switch (command) {
                case 1 -> km.showDrinks();
                case 2 -> km.makeDrink();
                case 3 -> System.out.println("Checking machine...");
                case 4 -> off = false;
                default -> throw new ActionNotFoundException();
            }
        } catch(ActionNotFoundException anfe){
            System.out.print("Main: ");
            System.out.println(anfe.getMessage());
        } catch(Exception e){
            System.out.print("Main: ");
            System.out.println("Invalid input. Try again!");
        }
        return off;
    }
}
