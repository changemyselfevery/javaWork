package com.zj;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @description:
 * @author: zj
 * @date: Created in 2020/5/19 17:36
 * @version: 1.0
 * @modified By:
 */
public class Room {
    private String description;
    private String id;

    public Room(String description, String id) {
        this.description = description;
        this.id = id;
    }

    private HashMap<String,Room> exits=new HashMap<>();
    private ArrayList<MonsterWolf> wolves=new ArrayList<>();
    public void randomAddWolf(MonsterWolf monsterWolf){
        wolves.add(monsterWolf);
    }

    public String getId() {
        return id;
    }

    public ArrayList<MonsterWolf> getWolves() {
        return wolves;
    }

    public void setWolves(ArrayList<MonsterWolf> wolves) {
        this.wolves = wolves;
    }

    public Room() {
    }
    public void setExit(String direction,Room room){
        exits.put(direction,room);
    }
    @Override
    public String toString(){
        return this.description;
    }
    public HashMap<String, Room> getExits() {
        return exits;
    }

    public void setExits(HashMap<String, Room> exits) {
        this.exits = exits;
    }

    public Room(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
