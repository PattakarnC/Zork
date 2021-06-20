package io.muic.ssc.zork;

import io.muic.ssc.zork.item.Item;
import io.muic.ssc.zork.monster.Monster;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private List<String> allExits;
    private String description;
    private List<Item> item;
    private Monster monster;

    public Room(String description) {
        north = null;
        south = null;
        east = null;
        west = null;
        allExits = new ArrayList<>();
        this.description = description;
        item = new ArrayList<>();
        monster = null;
    }

    public void setNorth(Room room) {
        this.north = room;
        allExits.add("North");
        room.allExits.add("South");
        north.south = this;
    }

    public void setSouth(Room room) {
        this.south = room;
        allExits.add("South");
        room.allExits.add("North");
        south.north = this;
    }

    public void setEast(Room room) {
        this.east = room;
        allExits.add("East");
        room.allExits.add("West");
        east.west = this;
    }

    public void setWest(Room room) {
        this.west = room;
        allExits.add("West");
        room.allExits.add("East");
        west.east = this;
    }

    public List<String> getPossibleExit() {
        return allExits;
    }

    public String getDescription() {
        return description;
    }

    public void setItem(Item item) {
        this.item.add(item);
    }

    public void removeItem(Item item) {
        this.item.remove(item);
    }

    public boolean containsItem() {
        return !item.isEmpty();
    }


    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public boolean containsMonster() {
        return monster != null;
    }

    public void removeMonster() {
        monster = null;
    }
}
