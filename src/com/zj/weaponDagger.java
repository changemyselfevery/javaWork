package com.zj;

/**
 * @description:
 * @author: zj
 * @date: Created in 2020/5/5 15:32
 * @version: 1.0
 * @modified By:
 */
public class weaponDagger extends Weapon {
    @Override
    //给敌人生命值造成伤害
    //道具使用方法，匕首
    //dagger 修改敌人的Hp,先要获取敌人的HP，在修改敌人的hp
    public void useArticle(Creature enemyCreature) {
        enemyCreature.setHPValue(enemyCreature.getHPValue()+this.getDamagePoint());

    }
}
