package io.muic.ssc.zork;

import io.muic.ssc.zork.Command.Command;
import io.muic.ssc.zork.Command.CommandParser;

public class Main {
    public static void main(String[] args) {
//        Game game = new Game();
//        game.run();

        CommandParser commandParser = new CommandParser();
        System.out.println(commandParser.parse("exit hello"));
    }
}
