package io.muic.ssc.zork;

import java.util.Scanner;

public class Game {

    private GameOutput output = new GameOutput();

    public void run() {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
        }
    }

    public void exit() {
        output.println("Game exit");
        System.exit(0);
    }
}
