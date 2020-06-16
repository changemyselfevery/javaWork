package com.zj;

import java.util.ArrayList;

/**
 * @description:
 * @author: zj
 * @date: Created in 2020/5/5 15:53
 * @version: 1.0
 * @modified By:
 */
public class MonsterWolfSet {
  private  ArrayList<MonsterWolf> monsterWolves=new ArrayList<>();
  //增删改查
  //狼的集合
//写一个函数根据id为字符串来查找并返回
  public MonsterWolf get(String id){
    MonsterWolf monsterWolf=null;
    for(MonsterWolf item:monsterWolves){
      if(item.getDescription().equals(id)){
        monsterWolf=item;
        break;//赋值完成以后就不做了
      }
    }
    return monsterWolf;
  }
  public MonsterWolfSet() {
  }

  public MonsterWolfSet(ArrayList<MonsterWolf> monsterWolves) {
    this.monsterWolves = monsterWolves;
  }

  public ArrayList<MonsterWolf> getMonsterWolves() {
    return monsterWolves;
  }

  public void setMonsterWolves(ArrayList<MonsterWolf> monsterWolves) {
    this.monsterWolves = monsterWolves;
  }
}
