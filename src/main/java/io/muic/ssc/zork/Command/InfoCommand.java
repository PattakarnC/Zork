package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;
import io.muic.ssc.zork.Player;
import io.muic.ssc.zork.Room;
import io.muic.ssc.zork.monster.Monster;

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
        GameOutput output = game.getOutput();
        Player player = game.getPlayer();
        Room room = game.getCurrentRoom();
        Monster monster = room.getMonster();

        output.println("");
        output.println("========================================================");
        player.printStats();
        output.println("========================================================");
        room.printStats();
        output.println("========================================================");
        if (room.containsMonster()) {
            monster.printStats();
            output.println("========================================================");
        }
    }
}
