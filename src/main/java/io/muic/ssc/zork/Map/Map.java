package io.muic.ssc.zork.Map;

public abstract class Map {
    private String name;
    private String task;
    private Room startRoom;
    public abstract boolean taskComplete();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Room getStartRoom() {
        return startRoom;
    }

    public void setStartRoom(Room startRoom) {
        this.startRoom = startRoom;
    }

    public abstract void printMap();
}
