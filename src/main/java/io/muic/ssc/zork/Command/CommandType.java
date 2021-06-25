package io.muic.ssc.zork.Command;

public enum CommandType {
    INFO(InfoCommand.class, "info", true, false),
    TAKE(TakeCommand.class, "take", true, false),
    DROP(DropCommand.class, "drop", true, false),
    ATTACK(AttackWithCommand.class, "attack with", true, false),
    GO(GoCommand.class, "go", true, false),
    HELP(HelpCommand.class, "help", true, true),
    QUIT(QuitCommand.class, "quit", true, false),
    SAVE(SaveCommand.class, "save", true, false),
    EXIT(ExitCommand.class, "exit",  false, true);

    private Class<? extends Command> commandClass;
    private String commandName;
    private boolean inGame;
    private boolean outGame;

    CommandType(Class<? extends Command> commandClass, String commandName, Boolean inGame, Boolean outGame) {
        this.commandClass = commandClass;
        this.commandName = commandName;
        this.inGame = inGame;
        this.outGame = outGame;
    }

    public Class<? extends Command> getCommandClass() {
        return commandClass;
    }

    public String getCommandName() {
        return commandName;
    }

    public boolean isInGame() {
        return inGame;
    }

    public boolean isOutGame() {
        return outGame;
    }
}
