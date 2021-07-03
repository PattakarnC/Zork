package io.muic.ssc.zork.Map;

import io.muic.ssc.zork.GameOutput;
import io.muic.ssc.zork.Item.ItemFactory;
import io.muic.ssc.zork.Item.potion.Potion;
import io.muic.ssc.zork.Item.weapon.Weapon;
import io.muic.ssc.zork.Monster.Monster;
import io.muic.ssc.zork.Monster.MonsterFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CorneoColosseum extends Map{

    private GameOutput output = new GameOutput();
    private List<Room> roomList = new ArrayList<>();

    public CorneoColosseum() {
        setName("Corneo Colosseum");
        setDescription("A battle arena located at the heart of Wall Market. This place is crawling with monsters!");
        setTask("eliminate all monsters and the final boss");

        ItemFactory itemFactory = new ItemFactory();
        MonsterFactory monsterFactory = new MonsterFactory();

        Room room1 = new Room("Preparation Room");
        roomList.add(room1);
        Room room2 = new Room("Underground");
        roomList.add(room2);
        Room room3 = new Room("Yasuo's Dungeon");
        roomList.add(room3);
        Room room4 = new Room("Chocobo's Playground");
        roomList.add(room4);
        Room room5 = new Room("Room of Fate");
        roomList.add(room5);

        room1.setWestExit(room2);
        room2.setEastExit(room1);
        room2.setNorthExit(room3);
        room3.setSouthExit(room2);
        room3.setEastExit(room4);
        room4.setWestExit(room3);
        room4.setNorthExit(room5);

        setStartRoom(room1);

        Weapon sword = itemFactory.createWeapon("Buster Sword");
        Weapon saber = itemFactory.createWeapon("Mythril Saber");
        Potion megaPotion = itemFactory.createPotion("Mega-potion");
        Potion elixir = itemFactory.createPotion("Elixir");

        Monster yasuo = monsterFactory.createMonster("yasuo");
        Monster trooper = monsterFactory.createMonster("riot trooper");
        Monster chocobo = monsterFactory.createMonster("fat chocobo");
        Monster leviathan = monsterFactory.createMonster("leviathan");

        room1.setAllItem(sword);
        room2.setAllItem(megaPotion);
        room4.setAllItem(elixir);
        room5.setAllItem(saber);

        room2.setMonster(trooper);
        room3.setMonster(yasuo);
        room4.setMonster(chocobo);
        room5.setMonster(leviathan);
    }

    @Override
    public boolean taskComplete() {
        for (Room room : roomList) {
            if (room.containsMonster()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void printMap() {
        File file = new File("C:/Users/user/Desktop/layout/ColosseumLayout.txt");
        try {
            Scanner scanner = new Scanner(file);
            output.println("");
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                output.println(s);
            }
            output.println("");
        }
        catch (FileNotFoundException e) {
            output.println("");
            output.println("!!! An error occurred while loading the map !!!");
            output.println("");
        }
    }
}
