package io.muic.ssc.zork.Command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.GameOutput;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveCommand implements Command{
    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "Load game state from saved point, this command only available at when start the game.";
    }

    @Override
    public void execute(Game game, List<String> args) {
        GameOutput output = game.getOutput();
        String fileName = args.get(0);

        File file = new File("C://Users//user//Desktop//savefile//" + fileName + ".txt");

        if (args.size() < 1 || fileName.equals("")) {
            output.println("Please specify your save name!");
        }
        else {
            try {
                if (!file.createNewFile()) {      //check if the filename already exists
                    output.println("Cannot save withh that name! There is already a file name " + fileName + " on this system");
                }
                else {                            //if not, create a new text file and keep the data in it
                    output.println("Now saving...");
                    FileWriter saveFile = new FileWriter("C://Users//user//Desktop//savefile//" + fileName + ".txt");
                    saveFile.write(game.getInputTracker());
                    saveFile.close();
                    output.println("All done! You have successfully saved your progress.");
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
