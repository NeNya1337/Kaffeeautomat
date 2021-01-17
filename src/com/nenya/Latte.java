package com.nenya;

public class Latte  extends Coffee{
    private int milk;
    private int foam;
    public Latte(int index, String name, int water, int milk, int beans){
        super(index, name, water, beans);
        this.milk = milk;
    }
    public void showDrink(){
        super.showDrink();
        System.out.print("It adds " + getMilk() + " ml milk. ");
    }
    public int getMilk(){
        return this.milk;
    }
    public void setMilk(int milk){
        this.milk = milk;
    }
    public int getFoam(){
        return this.foam;
    }
    public void setFoam(int foam){
        this.foam = foam;
    }
    public void beatMilk(int milk){
        setFoam(getMilk()- milk);
        setMilk(getMilk() - getFoam());
    }
    public String validate(int milk, int beans, int water){
        String missing = "";
        missing += super.validate(beans, water);
        if(milk < this.getMilk()) missing += "milk,";
        return missing;
    }
}
