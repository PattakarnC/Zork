package io.muic.ssc.zork.Monster;

public class Monster {

    private String name;
    private String description;
    private int maxHp;
    private int hp;
    private int attackDmg;
    private boolean alive;

    public Monster(String name, String description, int hp, int attackDmg) {
        this.name = name;
        this.description = description;
        this.maxHp = hp;
        this.hp = hp;
        this.attackDmg = attackDmg;
        alive = true;
    }

    public void decreaseHealth(int attackDmg) {
        hp -= attackDmg;
        if (hp <= 0) {
            hp = 0;
            alive = false;
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public int getAttackDmg() {
        return attackDmg;
    }

    public boolean isAlive() {
        return alive;
    }

    public void printStats() {
        System.out.println("[ Monster's Stats ]");
        System.out.println("   Name: " + name);
        System.out.println("   HP: " + hp + "/" + maxHp);
        System.out.println("   Description: " + description);
    }
}

