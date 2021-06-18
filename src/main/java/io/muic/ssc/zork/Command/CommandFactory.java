package io.muic.ssc.zork.Command;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class CommandFactory {

    private static final List<Class<? extends Command>> REGISTERED_COMMANDS = Arrays.asList(
            ExitCommand.class
    );

    private static final Map<String, Command> COMMANDS_MAP = new HashMap<>();

    static {{
        for (Class<? extends Command> commandClass : REGISTERED_COMMANDS) {
            try {
                Command command = commandClass.getDeclaredConstructor().newInstance();
                COMMANDS_MAP.put(command.getCommand(), command);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }}

    public static Command get(String command) {
        return COMMANDS_MAP.get(command);
    }

    public static List<String> getAllCommands() {
        return COMMANDS_MAP.keySet().stream().collect(Collectors.toList());
    }

}
