package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Game;
import java.util.List;

public class ExitCommand implements Command {

    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "Exit the whole game";
    }

    @Override
    public void execute(Game game, List<String> args) {
        game.getOutput().println("Game exit");
        game.exit();
    }
}
