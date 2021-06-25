package io.muic.ssc.zork.Item.weapon;

import io.muic.ssc.zork.Item.Item;

public class Weapon extends Item {

    public int attackDamage;

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public Weapon(String name, String description, int attackDamage) {
        this.name = name;
        this.description = description;
        this.attackDamage = attackDamage;
    }
}
