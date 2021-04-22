package models;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private int id;
//    private  String squadHeroes;
    private String name;
    private String mission;
    private int size;
    private static ArrayList<Heroes>squadHeroes = new ArrayList<>();
    private static ArrayList<Squad> instances = new ArrayList<>();
    public Squad( String name, String mission, int size) {

        this.name =name;
        this.mission =mission;
        this.size =size;
        this.squadHeroes = new ArrayList<>();
        this.id = instances.size();
        instances.add(this);

    }

    public int getId() {
        return id;
    }

    public String getMission() {
        return mission;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
    public static ArrayList<Squad> getInstances() {
        return instances;
    }
    public  static Squad findById(int id) {
        return instances.get(id-1);
    }
    public void setSquadHeroes(Heroes newMember) {
        squadHeroes.add(newMember);
    }
    public ArrayList<Heroes> getSquadHeroes(){
        return squadHeroes;
    }
    public static void clearAllSquads(){ instances.clear(); }
    public void clearAllSquadHeroes(){ getSquadHeroes().clear(); }

    public static Squad createNewSquad(){return new Squad("Avengers","fight crime",5);}
    public static Squad createNewSquad1(){return new Squad("Teen Titans","rescue animals",3);}



}
