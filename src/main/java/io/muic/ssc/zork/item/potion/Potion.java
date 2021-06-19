package io.muic.ssc.zork.item.potion;

import io.muic.ssc.zork.item.Item;

public class Potion extends Item {

    public int increasedHp;

    public int getIncreaseHp() {
        return increasedHp;
    }

    public Potion(String name, String description, int increaseHp) {
        this.name = name;
        this.description = description;
        this.increasedHp = increaseHp;
    }
}
