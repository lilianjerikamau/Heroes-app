package models;

import java.util.ArrayList;

public class Heroes {
    private  String name;
    private  int age;
    private String power;
    private  String weakness;
    private int id;
    private static ArrayList<Heroes> instances = new ArrayList<>();
public Heroes(String name ,int age,String power,String weakness){
    this.name = name;
    this.age = age;
    this.weakness = weakness;
    this.power = power;
    instances.add(this);
    this.id = instances.size();
}



    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getPower() {
        return power;
    }
    public static ArrayList<Heroes> getInstances() {
        return instances;
    }
    public String getWeakness() {
        return weakness;
    }
    public static Heroes findById(int id) {return instances.get(id-1);}

    public static  Heroes createNewHero(){
    return new Heroes("Lilian",23,"Flying","Fire");
    }
    public static  Heroes createNewHero1(){
        return new Heroes("Grace",22,"Running","Strength");
    }
    public static  Heroes createNewHero3(){
        return new Heroes("Eda",20,"Strength","Running");
    }

}
