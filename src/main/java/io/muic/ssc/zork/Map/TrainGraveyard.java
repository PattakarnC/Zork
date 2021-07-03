package io.muic.ssc.zork.Map;

import io.muic.ssc.zork.Game;
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

public class TrainGraveyard extends Map{

    private GameOutput output = new GameOutput();
    private List<Room> roomList = new ArrayList<>();

    public TrainGraveyard() {
        setName("Train Graveyard");
        setDescription("A train graveyard located inside the city of Midgar. " +
                "This area has become a junkyard for old and abandoned trains.");
        setTask("eliminate all monsters and gather all items around the map");

        ItemFactory itemFactory = new ItemFactory();
        MonsterFactory monsterFactory = new MonsterFactory();

        Room room1 = new Room("Entrance");
        roomList.add(room1);
        Room room2 = new Room("Train Platform");
        roomList.add(room2);
        Room room3 = new Room("Haunted Switchyard");
        roomList.add(room3);
        Room room4 = new Room("Facility Room");
        roomList.add(room4);
        Room room5 = new Room("Control Room");
        roomList.add(room5);
        Room room6 = new Room("Abandoned Bogie");
        roomList.add(room6);
        Room room7 = new Room("Ticket Booth");
        roomList.add(room7);

        room1.setNorthExit(room2);
        room2.setSouthExit(room1);
        room2.setWestExit(room3);
        room2.setEastExit(room4);
        room3.setEastExit(room2);
        room3.setNorthExit(room5);
        room5.setSouthExit(room3);
        room4.setWestExit(room2);
        room4.setNorthExit(room6);
        room6.setSouthExit(room4);
        room6.setEastExit(room7);
        room7.setWestExit(room6);

        setStartRoom(room1);

        Weapon sword = itemFactory.createWeapon("Buster Sword");
        Weapon staff = itemFactory.createWeapon("Bladed Staff");
        Potion elixir = itemFactory.createPotion("Elixir");
        Potion hipotion = itemFactory.createPotion("Hi-potion");


        Monster yasuo = monsterFactory.createMonster("yasuo");
        Monster yasuo2 = monsterFactory.createMonster("yasuo");
        Monster trooper = monsterFactory.createMonster("riot trooper");
        Monster trooper2 = monsterFactory.createMonster("riot trooper");
        Monster trooper3 = monsterFactory.createMonster("riot trooper");

        room1.setAllItem(sword);
        room1.setAllItem(hipotion);
        room3.setAllItem(staff);
        room3.setAllItem(hipotion);
        room6.setAllItem(elixir);

        room2.setMonster(trooper);
        room3.setMonster(yasuo);
        room4.setMonster(yasuo2);
        room5.setMonster(trooper2);
        room7.setMonster(trooper3);
    }

    @Override
    public boolean taskComplete() {
        for (Room room : roomList) {
            if (room.containsItem() || room.containsMonster()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void printMap() {
        File file = new File("C:/Users/user/Desktop/layout/GraveyardLayout.txt");
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
