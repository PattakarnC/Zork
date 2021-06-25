package io.muic.ssc.zork.Item;

import io.muic.ssc.zork.Item.potion.Elixir;
import io.muic.ssc.zork.Item.potion.HiPotion;
import io.muic.ssc.zork.Item.potion.MegaPotion;
import io.muic.ssc.zork.Item.potion.Potion;
import io.muic.ssc.zork.Item.weapon.BladedStaff;
import io.muic.ssc.zork.Item.weapon.BusterSword;
import io.muic.ssc.zork.Item.weapon.MythrilSaber;
import io.muic.ssc.zork.Item.weapon.Weapon;

import java.util.Locale;

public class ItemFactory {

    public Weapon createWeapon(String input) {
        String weapon = input.trim().toLowerCase(Locale.ROOT);
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
