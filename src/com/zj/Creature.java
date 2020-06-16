package com.zj;

import java.util.ArrayList;

/**
 * @description:
 * @author: zj
 * @date: Created in 2020/5/5 14:34
 * @version: 1.0
 * @modified By:
 */
public abstract class Creature {
   private String id;
   private String description;
   private int  HPValue;
   //装备应该是creature属性，但是此时只有一种武器，也不允许换武器
    private Weapon currentWeapon;
    private Room currentRoom;

    //如果生物不是只有一武器
//    private ArrayList<Weapon> weapons=new ArrayList<>();

    //抽象类不能实例化
    //当前生物用一种武器打另一种妖怪 抽象类
    //abstract是申明功能，没有实现，不同的生物使工具的方法不同
    //生物没有确定之前，没有办法写出道具的具体使用方法，因此只有写一个声明在这里
    public abstract void useArticle(Weapon weapon, Creature targetCreature);

    public Creature() {
    }


    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Creature(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public Creature(String id, String description, int HPValue) {
        this.id = id;
        this.description = description;
        this.HPValue = HPValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHPValue() {
        return HPValue;
    }

    public void setHPValue(int HPValue) {
        this.HPValue = HPValue;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

//    public ArrayList<Weapon> getWeapons() {
//        return weapons;
//    }

//    public void setWeapons(ArrayList<Weapon> weapons) {
//        this.weapons = weapons;
//    }
}
