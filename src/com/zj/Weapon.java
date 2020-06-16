package com.zj;

/**
 * @description:
 * @author: zj
 * @date: Created in 2020/5/5 14:45
 * @version:
 * @modified By:
 */
public abstract class Weapon {
   private String id;
   private String description;
   private int damagePoint;
    //武器的使用方法，本身归属于武器
    //使用道具，但是武器增莫用 还是要根据不同的武器是什么
    public abstract void useArticle(Creature enemyCreature);
    //类里只要有一个抽象函数就是抽心类了
    //参数需要吗 工具需要作用对象

    public Weapon() {
    }

    public Weapon(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public Weapon(String id, String description, int damagePoint) {
        this.id = id;
        this.description = description;
        this.damagePoint = damagePoint;
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

    public int getDamagePoint() {
        return damagePoint;
    }

    public void setDamagePoint(int damagePoint) {
        this.damagePoint = damagePoint;
    }
}
