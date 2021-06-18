package io.muic.ssc.zork.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandParser {

    private List<String> allCommandSortedByLength = new ArrayList<>();
    {
        allCommandSortedByLength.addAll(CommandFactory.getAllCommands());
        allCommandSortedByLength.sort(((o1, o2) -> o2.length() - o1.length()  ));
    }

    private String matchInputToCommand(String input) {
        for (String command : allCommandSortedByLength) {
            if (input.startsWith(command)) {
                return command;
            }
        }
        return null;
    }

    // "attack with weapon" -> ["attack with", "weapon"]
    public List<String> parse(String stringInput) {
        String cleanedInput = stringInput.trim();
        String cmd = matchInputToCommand(cleanedInput);
        Command command = CommandFactory.get(cmd);
        if (command.numArgs() > 0) {
            // TODO: so some checking for space later
            // TODO: handle invalid number of argument
            String argString = cleanedInput.substring(cmd.length() + 1);
            System.out.println(argString);
            return Arrays.asList(cmd, argString);
        }
        else {
            return Arrays.asList(cmd);
        }
    }
}
