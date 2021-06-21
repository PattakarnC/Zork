package io.muic.ssc.zork;

import io.muic.ssc.zork.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int max_hp;
    private int hp;
    private int attackDmg;
    private boolean alive;
    private List<Item> inventory;

    public Player() {
        max_hp = 1000;
        hp = max_hp;
        attackDmg = 75;
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

    public void setAttackPower(int attackDmg) {
        this.attackDmg = attackDmg;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void pickUpItem(Item item) {
        inventory.add(item);
    }

    public void printStats() {
        System.out.println("[ Player's Stats ]");
        System.out.println("   HP: " + hp + "/" + max_hp);
        System.out.println("");
        System.out.println("[ Inventory ]");

        if (inventory.isEmpty()) {
            System.out.println("Your inventory is currently empty!");
        }
        else {
            for (Item item : inventory) {
                System.out.println("=> " + item.getName());
                System.out.println("     " + item.getDescription());
            }
        }
    }
}
