package readers;

import mappers.CommandMapper;
import mappers.VariableMapper;
import utils.HelperFuncs;

import java.util.Arrays;


public class CommandReader {
    public static String[] commands;

    public static String[] splitAndRemoveSpaces(String commandString) {
        commandString = commandString.trim();
        return commandString.split(" ");
    }

    public static int runCommands(String[] testCommands) {
        commands = HelperFuncs.addSpaces(testCommands);
        int lineIndex;
        for (lineIndex = 0; lineIndex < commands.length - 1; lineIndex++) {
            System.out.println("current row " + commands[lineIndex]);
            lineIndex = HelperFuncs.executeCommand(commands[lineIndex], lineIndex);
        }
        String[] splittedCommand = CommandReader.splitAndRemoveSpaces(commands[lineIndex]);
        String[] commandArgs = Arrays.copyOfRange(splittedCommand, 1, splittedCommand.length);
        int returnedValue = CommandMapper.commandsMap.get("return").doCommand(commandArgs);
        VariableMapper.clearMap();

        return returnedValue;
    }
}
