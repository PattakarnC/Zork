package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.Player;
import io.muic.ssc.zork.item.Item;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class DropCommand implements Command{
    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return null;
    }

    @Override
    public String getDescription() {
        return "Drop item of choice that the player currently carries,";
    }

    @Override
    public void execute(Game game, List<String> args) {
        Player player = game.getPlayer();
        List<Item> inventory = player.getInventory();
        String itemToRemove = args.get(0).trim().toLowerCase(Locale.ROOT);

        if (args.size() < 1 || itemToRemove.equals("") ) {
            game.getOutput().println("Nothing to drop! Please specify the item you desire to drop.");
        }
        else {
            for (Item item : inventory) {
                if (item.getName().toLowerCase(Locale.ROOT).equals(itemToRemove)) {
                    inventory.remove(itemToRemove);
                    game.getOutput().println("You just dropped " + item.getName() + ".");
                    return;
                }
            }
            game.getOutput().println("That item is not presented in your inventory!");
        }
    }
}
