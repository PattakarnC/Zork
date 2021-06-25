package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.Player;
import io.muic.ssc.zork.Map.Room;
import io.muic.ssc.zork.Item.Item;

import java.util.List;
import java.util.Locale;

public class TakeCommand implements Command{
    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "take";
    }

    @Override
    public String getDescription() {
        return "Take command is used to pick up the Item in the current room." ;
    }

    @Override
    public void execute(Game game, List<String> args) {
        Player player = game.getPlayer();
        Room room = game.getCurrentRoom();
        String itemToTake = args.get(0).trim().toLowerCase(Locale.ROOT);

        if (args.size() < 1 || itemToTake.equals("")) {
            game.getOutput().println("You cannot just take nothing! Please specify the Item you desire to take.");
        }
        else {
            for (Item item : room.getAllItems()) {
                if (item.getName().toLowerCase(Locale.ROOT).equals(itemToTake)) {
                    player.pickUpItem(item);
                    room.removeItem(item);
                    game.getOutput().println("You just picked up " + item.getName() + "!");
                    return;
                }
            }
            game.getOutput().println(args.get(0) + " cannot be found in this room.");
        }
    }
}
