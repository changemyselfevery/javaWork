package com.zj;

/**
 * @description:
 * @author: zj
 * @date: Created in 2020/5/5 14:55
 * @version: 1.0
 * @modified By:
 */
public class MonsterWolf extends Creature {
    @Override
    public void useArticle(Weapon weapon, Creature targetCreature) {
        weapon.useArticle(targetCreature);//狼和人一样可以使用武器作用于对方
    }
}
