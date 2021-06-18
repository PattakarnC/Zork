package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Game;

public interface Command {

    int numArgs();

    String getCommand();

    void execute(Game game);
}
