package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;

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
        GameOutput output = game.getOutput();

        output.println("");
        output.println("Now exiting the game...");
        output.println("Thank you for playing!");
        output.println("");
        output.println(" _______   ______     ______    _______  .______   ____    ____  _______ \n" +
                " /  _____| /  __  \\   /  __  \\  |       \\ |   _  \\  \\   \\  /   / |   ____|\n" +
                "|  |  __  |  |  |  | |  |  |  | |  .--.  ||  |_)  |  \\   \\/   /  |  |__   \n" +
                "|  | |_ | |  |  |  | |  |  |  | |  |  |  ||   _  <    \\_    _/   |   __|  \n" +
                "|  |__| | |  `--'  | |  `--'  | |  '--'  ||  |_)  |     |  |     |  |____ \n" +
                " \\______|  \\______/   \\______/  |_______/ |______/      |__|     |_______|\n" +
                "                                                                          ");
        game.exit();
    }
}
