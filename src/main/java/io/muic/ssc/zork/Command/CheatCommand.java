package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;
import io.muic.ssc.zork.Player;

import java.util.List;

public class CheatCommand implements Command{
    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return "cheat";
    }

    @Override
    public String getDescription() {
        return "Use this command when you want to experience what it is like to become a god.";
    }

    @Override
    public void execute(Game game, List<String> args) {
        Player player = game.getPlayer();
        GameOutput output = game.getOutput();

        player.setAttackPower(999999999);
        player.setMax_hp(999999999);
        player.increaseHealth(player.getMax_hp());
        output.println("");
        output.println("May the force be with you :)");
        output.println("");

    }
}
