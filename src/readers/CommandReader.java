package readers;

import interfaces.ICommand;
import mappers.VariableMapper;
import utils.Consts;
import utils.HelperFuncs;

import java.util.Arrays;
import java.util.Map;


public class CommandReader {
    public static String[] trimCommand(String commandString) {
        commandString = commandString.trim();
        return commandString.split(" ");
    }

    public static void parser(String[] fileData, Map<String, ICommand> commandsMap, Map<String, ICommand> loopsCommandsMap) throws Exception {
        for (int lineIndex = 0; lineIndex < fileData.length; lineIndex++) {
            String[] programSplitedCommand = CommandReader.trimCommand(fileData[lineIndex]);
            System.out.println(fileData[lineIndex]);
            if (commandsMap.containsKey(programSplitedCommand[0])) {
                String[] commandArgs = Arrays.copyOfRange(programSplitedCommand, 1, programSplitedCommand.length);

                commandsMap.get(programSplitedCommand[0]).doCommand(commandArgs);
            } else if (VariableMapper.isVariableExist(programSplitedCommand[0])) {
                commandsMap.get(Consts.EQUAL_SIGN).doCommand(programSplitedCommand);
                // var number = bind "///"
                // ...
                // ...
                // var noder = number

                // **** number = ???? => set map[number] ????
            } else {
                // while number < 100 {
                // }

                if (loopsCommandsMap.containsKey(programSplitedCommand[0])) {
                    String[] commandsUntillEndOfFile = Arrays.copyOfRange(fileData, lineIndex, fileData.length);
                    int linesToRead = HelperFuncs.countLinesUntillClosingBrancket(commandsUntillEndOfFile);
                    String[] commandsOfWhileLoop = Arrays.copyOfRange(fileData, lineIndex, lineIndex+linesToRead);
                    loopsCommandsMap.get(programSplitedCommand[0]).doCommand(commandsOfWhileLoop);
                    System.out.println(123);

                }
            }

        }
    }

    public static String[] lexer() {
        return FileReader.readFile(Consts.FILE_NAME);

    }
}
