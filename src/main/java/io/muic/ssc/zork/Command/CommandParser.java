package io.muic.ssc.zork.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class CommandParser {

    private List<String> allCommandSortedByLength = new ArrayList<>();
    {
        allCommandSortedByLength.addAll(CommandFactory.getAllCommands());
        allCommandSortedByLength.sort(((o1, o2) -> o2.length() - o1.length()));
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
        try {
            String cleanedInput = stringInput.toLowerCase(Locale.ROOT).trim();
            String cmd = matchInputToCommand(cleanedInput);
            String argString = cleanedInput.substring(cmd.length()).trim();
            return Arrays.asList(cmd, argString);
        }
        catch (NullPointerException e) {
            return null;
        }
    }
}
