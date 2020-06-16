package com.zj;

/**
 * @description:
 * @author: zj
 * @date: Created in 2020/5/5 15:32
 * @version: 1.0
 * @modified By:
 */
public class weaponKnife extends Weapon {
    public weaponKnife() {
    }

    public weaponKnife(String id, String description) {
        super(id, description);
    }

    public weaponKnife(String id, String description, int damagePoint) {
        super(id, description, damagePoint);
    }

    @Override
    public void useArticle(Creature enemyCreature) {//改敌方的生命值
        enemyCreature.setHPValue(enemyCreature.getHPValue()+this.getDamagePoint());
    }
}
