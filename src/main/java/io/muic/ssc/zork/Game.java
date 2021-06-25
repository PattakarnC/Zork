package io.muic.ssc.zork;

import io.muic.ssc.zork.Command.Command;
import io.muic.ssc.zork.Command.CommandFactory;
import io.muic.ssc.zork.Command.CommandParser;
import io.muic.ssc.zork.Map.Map;
import io.muic.ssc.zork.Map.Room;
import io.muic.ssc.zork.Map.TestMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private GameOutput output = new GameOutput();
    private CommandParser commandParser = new CommandParser();
    private static Player player;
    private Room currentRoom;
    private boolean isRunning = true;
    private boolean inGame;
    private boolean outGame;
    private StringBuilder inputTracker = new StringBuilder();

    public static List<Map> listOfLevels = new ArrayList<>();
    public static Map currentLevel;

    public void run() {
//        while(true) {
//            Scanner scanner = new Scanner(System.in);
//            String input = scanner.nextLine();
//            List<String> words = commandParser.parse(input);
//            Command command = CommandFactory.get(words.get(0));  //get command from user input
//            if (command != null) {
//                command.execute(this, words.subList(1, words.size()));
//            }
//        }
        player = new Player();
        Map level1 = new TestMap();
        listOfLevels.add(level1);

        for (Map level : listOfLevels) {
            currentLevel = level;
            System.out.println("Welcome to " + level.name);
            System.out.println("Your objective is to " + level.task);
            currentRoom = level.startRoom;
            while (isRunning) {
                inGame = true;
                Scanner in = new Scanner(System.in);
                String s = in.nextLine();
                List<String> words = commandParser.parse(s, isInGame());
                Command command = CommandFactory.get(words.get(0));
                if (command != null) {
                    command.execute(this, words.subList(1, words.size()));
                    addInputTracker(s);
                }
                else {
                    System.out.println("Unknown command [" + s + "].");
                }
                if (level.taskComplete()){
                    //System.out.println("!!!!Objective completed!!!!");
                    //this.exit();
                }
            }
        }
    }

    public GameOutput getOutput() {
        return output;
    }

    public void quit() {
        isRunning = false;
    }

    public void exit() {
        System.exit(0);
    }

    public static Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void moveRoom(Room room) {
        currentRoom = room;
    }

    public void setGameStatus(Boolean isRunning) {
        this.isRunning = isRunning;
    }

    public boolean isInGame() {
        return inGame;
    }

    public boolean isOutGame() {
        return outGame;
    }

    public void addInputTracker(String input) {
        inputTracker.append(input);
        inputTracker.append("\n");
    }

    public String getInputTracker() {
        return inputTracker.toString();
    }
}
