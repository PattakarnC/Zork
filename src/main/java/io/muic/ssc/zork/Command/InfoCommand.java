package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.Player;
import io.muic.ssc.zork.item.Item;

import java.util.List;

public class InfoCommand implements Command {

    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return "info";
    }

    //TODO: display current room info
    @Override
    public void execute(Game game, List<String> args) {
        Player player = game.getPlayer();
        System.out.println();
        System.out.println("========================================================");
        System.out.println("[ Player's Stats ]");
        System.out.println("   HP: " + player.getHp() + "/" + player.getMax_hp());
        System.out.println();
        System.out.println("[ Inventory ]");
        for (Item item : player.getInventory()) {
            System.out.println("=> " + item.getName());
            System.out.println("     " + item.getDescription());
            System.out.println();
        }
        System.out.println("========================================================");
    }
}
