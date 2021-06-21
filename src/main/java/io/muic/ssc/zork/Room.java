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
    private List<Item> allItem;
    private Monster monster;

    public Room(String description) {
        north = null;
        south = null;
        east = null;
        west = null;
        allExits = new ArrayList<>();
        this.description = description;
        allItem = new ArrayList<>();
        monster = null;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room room) {
        this.north = room;
        allExits.add("north");
        room.allExits.add("south");
        north.south = this;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room room) {
        this.south = room;
        allExits.add("south");
        room.allExits.add("north");
        south.north = this;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room room) {
        this.east = room;
        allExits.add("east");
        room.allExits.add("west");
        east.west = this;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room room) {
        this.west = room;
        allExits.add("west");
        room.allExits.add("east");
        west.east = this;
    }

    public List<String> getAllExits() {
        return allExits;
    }

    public String getDescription() {
        return description;
    }

    public void setAllItem(Item allItem) {
        this.allItem.add(allItem);
    }

    public void removeItem(Item item) {
        this.allItem.remove(item);
    }

    public List<Item> getAllItems() {
        return allItem;
    }

    public boolean containsItem() {
        return !allItem.isEmpty();
    }

    public Monster getMonster() {
        return monster;
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

    public void printStats() {
        System.out.println("[ Current Room ]");
        System.out.println("   Available Exits: " + getAllExits());
        if (!allItem.isEmpty()) {
            List<String> itemList = new ArrayList<>();
            for (Item item : allItem) {
                itemList.add(item.getName());
            }
            System.out.println("   Item(s): " + itemList);
        }
        else {
            System.out.println("   No item can be picked up in this room.");
        }
    }
}
