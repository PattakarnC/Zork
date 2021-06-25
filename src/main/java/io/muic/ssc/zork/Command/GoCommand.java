package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.Player;
import io.muic.ssc.zork.Map.Room;

import java.util.List;
import java.util.Locale;

public class GoCommand implements Command{
    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "go";
    }

    @Override
    public String getDescription() {
        return "Move player to the room as specified by the direction, e.g. north, east, west, and south." ;
    }

    @Override
    public void execute(Game game, List<String> args) {
        Player player = game.getPlayer();
        Room room = game.getCurrentRoom();
        String direction = args.get(0).trim().toLowerCase(Locale.ROOT);

        if (args.size() < 1 || direction.equals("")) {
            game.getOutput().println("Please specify the direction you want to move!");
        }
        else {
            if (room.getAllExits().contains(direction)) {
                if (direction.equals("north")) {
                    game.moveRoom(room.getNorthExit());
                }
                else if (direction.equals("south")) {
                    game.moveRoom(room.getSouthExit());
                }
                else if (direction.equals("east")) {
                    game.moveRoom(room.getEastExit());
                }
                else {
                    game.moveRoom(room.getWestExit());
                }
                player.increaseHealth(100);
                game.getOutput().println("You have successfully moved to the room at " + direction + ".");
                game.getOutput().println("Your HP will recover by 100 HP.");
            }
            else {
                game.getOutput().println("There's no exit there!");
                game.getOutput().println("Type [ info ] to get available exit(s).");
            }
        }
    }
}
