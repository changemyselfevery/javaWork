package com.zj;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @description:
 * @author: zj
 * @date: Created in 2020/5/19 17:36
 * @version: 1.0
 * @modified By:
 */
public class RoomSet {
private ArrayList<Room> roomSetScene=new ArrayList<>();
public void addRoom(Room room){
    roomSetScene.add(room);
}

    public RoomSet() {
    }

    public ArrayList<Room> getRoomSet() {
        return roomSetScene;
    }

    public void setRoomSet(ArrayList<Room> roomSet) {
        this.roomSetScene = roomSet;
    }
}
