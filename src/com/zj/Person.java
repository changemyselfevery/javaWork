package com.zj;

/**
 * @description:
 * @author: zj
 * @date: Created in 2020/5/5 14:57
 * @version: 1.0
 * @modified By:
 */
public class Person extends Creature {
    @Override
    public void useArticle(Weapon weapon, Creature targetCreature) {
        weapon.useArticle(targetCreature);//用武器的使用方法作用在对象上
    }

}
