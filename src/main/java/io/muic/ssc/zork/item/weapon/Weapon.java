package io.muic.ssc.zork.item.weapon;

import io.muic.ssc.zork.item.Item;

public class Weapon extends Item {

    public int attackDamage;

    public int getAttackDamage() {
        return attackDamage;
    }

    public Weapon(String name, String description, int attackDamage) {
        this.name = name;
        this.description = description;
        this.attackDamage = attackDamage;
    }
}
