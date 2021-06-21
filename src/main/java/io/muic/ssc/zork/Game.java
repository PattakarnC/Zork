package io.muic.ssc.zork;

import io.muic.ssc.zork.Command.Command;
import io.muic.ssc.zork.Command.CommandFactory;
import io.muic.ssc.zork.Command.CommandParser;

import java.util.List;
import java.util.Scanner;

public class Game {

    private GameOutput output = new GameOutput();
    private CommandParser commandParser = new CommandParser();
    private Player player;
    private Room currentRoom;

    public void run() {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            List<String> words = commandParser.parse(input);
            Command command = CommandFactory.get(words.get(0));  //get command from user input
            if (command != null) {
                command.execute(this, words.subList(1, words.size()));
            }
        }
    }

    public GameOutput getOutput() {
        return output;
    }

    public void exit() {
        System.exit(0);
    }

    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void moveRoom(Room room) {
        currentRoom = room;
    }
}
