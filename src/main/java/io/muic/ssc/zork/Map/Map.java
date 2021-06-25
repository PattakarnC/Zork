package io.muic.ssc.zork.Map;

public abstract class Map {
    public String name;
    public String task;
    public Room startRoom;
    public abstract boolean taskComplete();
}
