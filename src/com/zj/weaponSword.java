package com.zj;

/**
 * @description:
 * @author: zj
 * @date: Created in 2020/5/5 15:32
 * @version: 1.0
 * @modified By:
 */
public class weaponSword extends Weapon {
    public  weaponSword(String id,String description,int damagePoints){
        super(id,description,damagePoints);
    }

    @Override
    public void useArticle(Creature enemyCreature) {//修改敌方的hp this是武器的伤害值
            enemyCreature.setHPValue(enemyCreature.getHPValue()+this.getDamagePoint());
    }
}
