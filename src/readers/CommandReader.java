package readers;

import interfaces.ICommand;
import mappers.VariableMapper;
import utils.Consts;

import java.util.Arrays;
import java.util.Map;


public class CommandReader {
    public static String[] trimCommand(String commandString) {
        commandString = commandString.trim();
        return commandString.split(" ");
    }

    public static void parser(String[] fileData, Map<String, ICommand> commandsMap) throws Exception {
        for (String line : fileData) {
            String[] programSplitedCommand = CommandReader.trimCommand(line);
            System.out.println(line);
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
            }
        }
    }

    public static String[] lexer() {
        return FileReader.readFile(Consts.FILE_NAME);

    }
}
