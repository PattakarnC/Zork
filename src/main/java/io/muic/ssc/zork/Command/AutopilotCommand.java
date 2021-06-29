package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;
import io.muic.ssc.zork.Map.Map;
import io.muic.ssc.zork.Map.MapFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class AutopilotCommand implements Command{
    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "autopilot";
    }

    @Override
    public String getDescription() {
        return "Run this game in autopilot mode using the list of command in the file, this command only available while playing game";
    }

    //TODO: create autopilot file, make name in Map class private
    @Override
    public void execute(Game game, List<String> args) {
        GameOutput output = game.getOutput();
        String mapName = args.get(0);

        Map currentLevel = game.getCurrentLevel();

        if (args.size() < 1 || mapName.equals("")) {
            output.println("Please specify the file name!");
        }
        else {
            for (Map map : MapFactory.getAvailableMap().values()) {
                if (currentLevel.name.equals(map.name)) {
                    game.initiate(map.name);

                    File file = new File("C:/Users/user/Desktop/savefile/" + mapName + ".txt");

                    try {
                        Scanner scanner = new Scanner(file);
                        CommandParser commandParser = new CommandParser();
                        while (scanner.hasNextLine()) {
                            String s = scanner.nextLine();
                            List<String> words = commandParser.parse(s, true);
                            if (words != null) {
                                Command command = CommandFactory.get(words.get(0));
                                if (command != null) {
                                    command.execute(game, words.subList(1, words.size()));
                                }
                            }
                        }
                    }
                    catch (FileNotFoundException e) {
                        output.println("!!! File not found !!!");
                    }
                }
            }
        }
    }
}
