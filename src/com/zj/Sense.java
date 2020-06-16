package com.zj;

import java.util.Scanner;

/**
 * @description:
 * @author: zj
 * @date: Created in 2020/5/5 15:47
 * @version: 1.0
 * @modified By:
 */
public class Sense {
    //场景
   private Person person=new Person();
   private MonsterWolf wolf1=new MonsterWolf();
   private MonsterWolf wolf2=new MonsterWolf();
   private MonsterWolf wolf3=new MonsterWolf();
   private MonsterWolfSet monsterWolfSet=new MonsterWolfSet();
   private RoomSet roomSet =new RoomSet();
   private Room room1=new Room("迷谷","1");
   private Room room2=new Room("草原","2");
   private Room room3=new Room("华山","3");
   private Room room4=new Room("恒山","4");
   private Room room5=new Room("衡山","5");
//private Room room1,room2,room3,room4,room5;
   Ui ui=new Ui();
    public void initSense(){
        initPerson();
        initMonster();
        initRoom(roomSet);

    }
    public void initRoom(RoomSet roomSet){
        roomSet.addRoom(room1);
        roomSet.addRoom(room2);
        roomSet.addRoom(room3);
        roomSet.addRoom(room4);
        roomSet.addRoom(room5);

        room1.setExit("east",room3);
        room1.setExit("west",room2);
        room1.setExit("south",room4);

        room2.setExit("east",room1);
        room2.setExit("south",room4);
        room2.setExit("north",room3);


        room3.setExit("west",room1);
        room3.setExit("south",room5);
        room3.setExit("north",room2);

        room4.setExit("north",room1);
        room4.setExit("east",room5);
        room4.setExit("north",room2);

        room5.setExit("west",room4);
        room5.setExit("north",room3);
    }
    public void initPerson(){
        person.setId("201902157");
        person.setDescription("独孤");
        person.setHPValue(200);
        person.setCurrentWeapon(new weaponSword("pw1","倚天剑",-50));
        person.setCurrentRoom(room1);

    }
    public void initMonster(){
        wolf1.setId("令狐冲");
        wolf1.setDescription("1");
        wolf1.setHPValue(100);
        wolf1.setCurrentWeapon(new weaponKnife("mw1","大刀",-30));

        wolf2.setId("恶人");
        wolf2.setDescription("2");
        wolf2.setHPValue(100);
        wolf2.setCurrentWeapon(new weaponKnife("mw2","大刀",-20));

        wolf3.setId("金毛狮王");
        wolf3.setDescription("3");
        wolf3.setHPValue(100);
        wolf3.setCurrentWeapon(new weaponKnife("mw3","大刀",-25));

        monsterWolfSet.getMonsterWolves().add(wolf1);
        monsterWolfSet.getMonsterWolves().add(wolf2);
        monsterWolfSet.getMonsterWolves().add(wolf3);

    }
    public void play() {
        ui.displayStaus(this);//this就是当前场景

        //与用户交互
        Scanner in = new Scanner(System.in);
        while (true) {
            //用户输入命令

            String command = in.nextLine();
            String[] cmdLineItem = command.split(" ");
            //chop help bye 其他（）
            if(cmdLineItem[0].equals("bye")){
                ui.displayBye();
                System.exit(0);
            }else if(cmdLineItem[0].equals("help")){
                ui.displayHelpMsg();
            }else if(cmdLineItem[0].equals("chop")){
                //自己设置了一个搜索地函数
                //但是我们不能使wolf的生命值为负 生命值为正才可以砍
                if(this.getMonsterWolfSet().get(cmdLineItem[1]).getHPValue()>0) {
                    this.getPerson().useArticle(getPerson().getCurrentWeapon(), this.getMonsterWolfSet().get(cmdLineItem[1]));
                }
                if(this.getMonsterWolfSet().get(cmdLineItem[1]).getHPValue()==0){
                    ui.tipsMsg(person,this.getMonsterWolfSet().get(cmdLineItem[1]));
                }

                //如果所有妖怪生命值为0，则人赢了
                int sumValue=0;
                for(MonsterWolf monsterWolf:this.getMonsterWolfSet().getMonsterWolves()){
                    sumValue=monsterWolf.getHPValue()+sumValue;
                }
                if(sumValue==0){
                    ui.displayWin(this);
                    System.exit(0);
                }
                //妖怪随机砍人 有时候砍 有时候不砍  但是这里的妖怪是要房间里有的，不能暗箭伤人吧，嘻嘻
//                for (MonsterWolf item:monsterWolfSet.getMonsterWolves()){
//                        if(Utils.randomMonsterChop()==1){
//                            item.useArticle(item.getCurrentWeapon(),this.getPerson());
//                            ui.displayDamageMsg(item,person);
//                        }
//                }
                //是当前场景 当前人的当前房间 里妖怪集合
                for(MonsterWolf item:this.getPerson().getCurrentRoom().getWolves()){
                    if(Utils.randomMonsterChop()==1){
                        item.useArticle(item.getCurrentWeapon(),this.getPerson());
                        ui.displayDamageMsg(item,person);
                    }
                }
                if(this.getPerson().getHPValue()==0){
                    ui.displayLost(this);
                    System.exit(0);
                }

            }else if(cmdLineItem[0].equals("go")){
                //如果输入1,就可以到达响应的房间
                //输入对应房间的id,到达输入的房间
               for(Room value:this.getPerson().getCurrentRoom().getExits().values()){
                   if(value.getId().equals(cmdLineItem[1])){
                       this.getPerson().setCurrentRoom(value);
                       //找到狼，让狼随机出现在房间里 0k
                       for(MonsterWolf monsterWolf:this.monsterWolfSet.getMonsterWolves()){

                           if(Utils.randomMonsterChop()==1){
                               value.randomAddWolf(monsterWolf);
                           }
                       }
                   }
               }

            }else{
                ui.displayErrorCmd();
                ui.displayHelpMsg();
            }
            ui.displayStaus(this);//this就是当前场景

        }
    }
    public boolean judgeSuceece(){
        boolean flagPersonSuceece=true;
        if(person.getHPValue()<=0){
            flagPersonSuceece=false;
        }
        return flagPersonSuceece;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public RoomSet getRoomSet() {
        return roomSet;
    }

    public void setRoomSet(RoomSet roomSet) {
        this.roomSet = roomSet;
    }

    //    public MonsterWolf getWolf1() {
//        return wolf1;
//    }
//
//    public void setWolf1(MonsterWolf wolf1) {
//        this.wolf1 = wolf1;
//    }

//    public MonsterWolf getWolf2() {
//        return wolf2;
//    }
//
//    public void setWolf2(MonsterWolf wolf2) {
//        this.wolf2 = wolf2;
//    }

//    public MonsterWolf getWolf3() {
//        return wolf3;
//    }
//
//    public void setWolf3(MonsterWolf wolf3) {
//        this.wolf3 = wolf3;
//    }

    public MonsterWolfSet getMonsterWolfSet() {
        return monsterWolfSet;
    }

    public void setMonsterWolfSet(MonsterWolfSet monsterWolfSet) {
        this.monsterWolfSet = monsterWolfSet;
    }
}
