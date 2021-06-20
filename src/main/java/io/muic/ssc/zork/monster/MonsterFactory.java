package io.muic.ssc.zork.monster;

import java.util.Locale;

public class MonsterFactory {
    public Monster createMonster(String input) {
        String monster = input.toLowerCase(Locale.ROOT);
        if (monster.equals("riot trooper")) {
            return new RiotTrooper();
        }
        else if (monster.equals("yasuo")) {
            return new Yasuo();
        }
        else if (monster.equals("leviathan")) {
            return new Leviathan();
        }
        return null;
    }
}
