package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;
import io.muic.ssc.zork.Map.Map;
import io.muic.ssc.zork.Map.MapFactory;

import java.util.List;
import java.util.Locale;

public class PlayCommand implements Command {
    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "play";
    }

    @Override
    public String getDescription() {
        return "Play new game, this command only available at when start the game.";
    }

    @Override
    public void execute(Game game, List<String> args) {
        GameOutput output = game.getOutput();
        String cleanedInput = args.get(0).toLowerCase(Locale.ROOT).trim();
        
        if (args.size() < 1 || args.get(0).equals("")) {
            output.println("Please specify the map name you wish to play!");
        }
        else {
            for (String map : MapFactory.getAvailableMap().keySet()) {
                if (map.toLowerCase(Locale.ROOT).equals(cleanedInput)) {
                    game.setCurrentLevel(map);

                    output.println("");
                    output.println("game start!");
                    output.println("");

                    output.println("Welcome to " + game.getCurrentLevel().name);
                    output.println("Your objective is to " + game.getCurrentLevel().task);
                    output.println("");

                    game.setInGame(true);
                    game.setOutGame(false);
                    return;
                }
            }
            output.println("Incorrect map name. Check your spelling!");
        }
    }
}
