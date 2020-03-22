package readers;

import interfaces.ICommand;
import utils.Consts;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class CommandReader {
    public static String[] trimCommand(String commandString){
        commandString = commandString.trim();
        return commandString.split(" ");
    }

    public static void parser(String[] fileData, Map<String, ICommand> commandsMap) throws Exception {
        for (String line:fileData) {
            String[] programSplitedCommand = CommandReader.trimCommand(line);
            System.out.println(line);
            if(commandsMap.containsKey(programSplitedCommand[0])) {
                String[] commandArgs = Arrays.copyOfRange(programSplitedCommand, 1, programSplitedCommand.length);
                commandsMap.get(programSplitedCommand[0]).doCommand(commandArgs);
            } else {
                // change variables
            }
        }
    }

    public static String[] lexer(){
       return FileReader.readFile(Consts.FILE_NAME);

    }
}
