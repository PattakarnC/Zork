package io.muic.ssc.zork;

import io.muic.ssc.zork.Command.Command;
import io.muic.ssc.zork.Command.CommandFactory;
import io.muic.ssc.zork.Command.CommandParser;
import io.muic.ssc.zork.Map.Map;
import io.muic.ssc.zork.Map.MapFactory;
import io.muic.ssc.zork.Map.Room;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Game {

    private GameOutput output = new GameOutput();
    private CommandParser commandParser = new CommandParser();
    private static Player player = new Player();
    private static Room currentRoom;
    private boolean isRunning = true;
    private boolean inGame;
    private boolean outGame;
    private StringBuilder inputTracker = new StringBuilder();

    public static Map currentLevel;

    public boolean continuePlaying;

    public void run() {

        welcomeScreen();

        while (isRunning) {         //TODO: solve unknown input
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            List<String> words = commandParser.parse(s, isInGame());
            Command command = CommandFactory.get(words.get(0));

            if (continuePlaying) {                      //If the player wants to continue from their last checkpoint
                if (command != null) {
                    command.execute(this, words.subList(1, words.size()));
                    if (!command.getCommand().equals("save") && !command.getCommand().equals("load") && !command.getCommand().equals("quit")) {
                        addInputTracker(s);
                    }
                }
            }
            else {                                      //If not, start a new game
                if (command != null) {
                    command.execute(this, words.subList(1, words.size()));
                    if (!command.getCommand().equals("save") && !command.getCommand().equals("load") && !command.getCommand().equals("quit")) {
                        addInputTracker(s);
                    }
                }
                else {
                    System.out.println("Unknown command [" + s + "].");
                }
            }
        }
    }


    public void welcomeScreen() {
        output.println("Welcome to Zork Game: Final Fantasy Edition!");
        output.println("          Available Command");
        for (String cmd : CommandFactory.getOutGameCommands()) {
            output.println("              [ " + cmd + " ]");
        }
        setOutGame(true);
        setInGame(false);

        while (isOutGame() == true) {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            List<String> words = commandParser.parse(s, isInGame());
            Command command = CommandFactory.get(words.get(0));
            if (command != null) {
                command.execute(this, words.subList(1, words.size()));
                if (command.getCommand().equals("play")) {
                    if (isInGame()) {
                        addInputTracker(s);
                    }
                }     //!command.getCommand().equals("load") && !command.getCommand().equals("quit"))
            }
            else {
                System.out.println("Unknown command [" + s + "].");
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

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public boolean isOutGame() {
        return outGame;
    }

    public void setOutGame(boolean outGame) {
        this.outGame = outGame;
    }

    public void addInputTracker(String input) {
        inputTracker.append(input);
        inputTracker.append("\n");
    }

    public String getInputTracker() {
        return inputTracker.toString();
    }

    public static Map getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(String currentLevel) {
        for (String level : MapFactory.getAvailableMap().keySet()) {
            if (currentLevel.toLowerCase(Locale.ROOT).equals(level.toLowerCase(Locale.ROOT))) {
                MapFactory factory = new MapFactory();
                this.currentLevel = factory.createMap(level);
                this.currentRoom = this.currentLevel.startRoom;
            }
        }
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public void initiate(String mapName) {
        player = new Player();
//        MapFactory factory = new MapFactory();
//        currentLevel = factory.createMap(mapName);
        setCurrentLevel(mapName);
//        currentRoom = currentLevel.startRoom;
//        if (currentLevel == null) {
//            currentRoom = null;
//        }
//        else {
//            currentRoom = currentLevel.startRoom;
//        }
//        inputTracker = new StringBuilder();
    }
}
