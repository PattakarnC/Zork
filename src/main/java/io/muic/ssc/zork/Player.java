package io.muic.ssc.zork;

import io.muic.ssc.zork.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int max_hp;
    private int hp;
    private int attackPower;
    private boolean alive;
    private List<Item> inventory;

    public Player(String name) {
        this.name = name;
        max_hp = 1000;
        hp = max_hp;
        attackPower = 75;
        alive = true;
        inventory = new ArrayList<>();
    }

    public void increaseHealth(int hpToGain) {
        if (hp + hpToGain >= max_hp) {
            hp = max_hp;
        }
        else {
            hp += hpToGain;
        }
    }

    public void decreaseHealth(int attackDmg) {
        hp -= attackDmg;
        if (hp <= 0) {
            alive = false;
        }
    }

    public int getMax_hp() {
        return max_hp;
    }

    public void setMax_hp(int max_hp) {
        this.max_hp = max_hp;
    }

    public int getHp() {
        return hp;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public List<Item> getInventory() {
        return inventory;
    }
}
