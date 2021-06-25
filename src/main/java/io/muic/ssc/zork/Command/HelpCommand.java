package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Game;

import java.util.List;

public class HelpCommand implements Command{
    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Print all available commands.";
    }

    @Override
    public void execute(Game game, List<String> args) {
        if (game.isInGame()) {
            List<String> cmdList = CommandFactory.getInGameCommands();

            game.getOutput().println("");
            game.getOutput().println("========================================================");
            game.getOutput().println(" [ Available In-Game Commands ]");
            for (String command : cmdList) {
                game.getOutput().println("=> " + command);
                game.getOutput().println("    " + CommandFactory.get(command).getDescription());
            }
            game.getOutput().println("========================================================");
        }
        else {
            List<String> cmdList = CommandFactory.getOutGameCommands();

            game.getOutput().println("========================================================");
            game.getOutput().println(" [ Available Start Menu Commands ]");
            for (String command : cmdList) {
                game.getOutput().println("=> " + command);
                game.getOutput().println("    " + CommandFactory.get(command).getDescription());
            }
            game.getOutput().println("========================================================");
        }
    }
}
