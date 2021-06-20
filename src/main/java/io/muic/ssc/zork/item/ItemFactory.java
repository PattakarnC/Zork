package io.muic.ssc.zork.item;

import io.muic.ssc.zork.item.potion.Elixir;
import io.muic.ssc.zork.item.potion.HiPotion;
import io.muic.ssc.zork.item.potion.MegaPotion;
import io.muic.ssc.zork.item.potion.Potion;
import io.muic.ssc.zork.item.weapon.BladedStaff;
import io.muic.ssc.zork.item.weapon.BusterSword;
import io.muic.ssc.zork.item.weapon.MythrilSaber;
import io.muic.ssc.zork.item.weapon.Weapon;

import java.util.Locale;

public class ItemFactory {

    public Weapon createWeapon(String input) {
        String weapon = input.toLowerCase(Locale.ROOT);
        if (weapon.equals("buster sword")) {
            return new BusterSword();
        }
        else if (weapon.equals("bladed staff")) {
            return new BladedStaff();
        }
        else if (weapon.equals("mythril saber")) {
            return new MythrilSaber();
        }
        return null;
    }

    public Potion createPotion(String input) {
        String potion = input.toLowerCase(Locale.ROOT);
        if (potion.equals("elixir")) {
            return new Elixir();
        }
        else if (potion.equals("hi-potion")) {
            return new HiPotion();
        }
        else if (potion.equals("mega-potion")) {
            return new MegaPotion();
        }
        return null;
    }
}
