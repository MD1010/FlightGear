package readers;

import mappers.VariableMapper;
import utils.HelperFuncs;


public class CommandReader {
    public static String[] commands;

    public static String[] splitAndRemoveSpaces(String commandString) {
        commandString = commandString.trim();
        return commandString.split(" ");
    }

    public static void runCommands(String[] testCommands) {
        commands = HelperFuncs.addSpaces(testCommands);
        for (int lineIndex = 0; lineIndex < commands.length; lineIndex++) {
            System.out.println("current row " + commands[lineIndex]);
            lineIndex = HelperFuncs.executeCommand(commands[lineIndex], lineIndex);
        }

        VariableMapper.clearMap();
    }
}
