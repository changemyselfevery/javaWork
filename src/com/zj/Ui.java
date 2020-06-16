package com.zj;

import java.util.Map;
import java.util.Scanner;

/**
 * @description:
 * @author: zj
 * @date: Created in 2020/5/13 13:05
 * @version: 1.0
 * @modified By:
 */
public class Ui {
//用户交互
    public void displayStaus(Sense sense){
        System.out.println("-------------------------------------------------------");
        //我要输出人的信息，人在场景中实例，怎么获取呢
        System.out.println("现在你位于： " +sense.getPerson().getCurrentRoom());
        System.out.println("*******************************************************");
        System.out.println("你可以战斗的场地有 :");
        for(Room room:sense.getPerson().getCurrentRoom().getExits().values()){
            System.out.print(room+"("+room.getId()+"）" +" ");
        }
        System.out.println("");
        System.out.println("*******************************************************");
        System.out.println(sense.getPerson().getDescription()+":"+sense.getPerson().getHPValue());
//        for(MonsterWolf item:sense.getMonsterWolfSet().getMonsterWolves()){
//            System.out.print(item.getId()+"("+item.getDescription()+")"+":"+item.getHPValue()+"   ");
//        }
       //输出当前场景 人的 当前房间里 的怪兽集合，随机出现
        System.out.println("阻挡你的敌人有: ");
        //但是要当前场景里 人的当前房间里 怪兽集合生命值要大于0

        for(MonsterWolf monsterWolf:sense.getPerson().getCurrentRoom().getWolves()){
            if(monsterWolf.getHPValue()>0) {
                System.out.print(monsterWolf.getId() + "(" + monsterWolf.getDescription() + ")" + ":" + monsterWolf.getHPValue() + " ");
            }
        }
        System.out.println();
        System.out.println("-------------------------------------------------------");
    }

    public void displayHelpMsg(){
        System.out.println("4条可用命令--chop(chop wolf1)  go(go 1) bye help--");
    }
    public void displayBye(){
        System.out.println("bye bye");
    }
    public void displayErrorCmd(){
        System.out.println("输入非法命令");
    }
    //狼一 对小吴 造成了 30 的伤害
    public void displayDamageMsg(Creature attackCreature,Creature targetCreature){
        System.out.println(attackCreature.getId()+"对"+targetCreature.getDescription()+"造成了"+attackCreature.getCurrentWeapon().getDamagePoint()+"的伤害");

        System.out.println(targetCreature.getDescription()+"对"+attackCreature.getId()+"造成了"+targetCreature.getCurrentWeapon().getDamagePoint()+"的伤害");
    }
    public void displayWin(Sense sense){
        System.out.println("恭喜"+sense.getPerson().getDescription()+"你赢了");
    }
    public void displayLost(Sense sense){
        System.out.println(sense.getPerson().getDescription()+"你输了");
    }
    public void tipsMsg(Creature attackCreature,Creature targetCreature){
        System.out.println("---------------恭喜你!!！"+attackCreature.getDescription()+" 消灭了 "+targetCreature.getId()+"---------------");
        System.out.println("------------所以继续前进吧，后面还有未知的旅途-------------");
    }

}
