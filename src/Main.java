import interfaces.ICommand;
import mappers.CommandMapper;
import readers.CommandReader;
import readers.FileReader;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<String, ICommand> commandsMap = new CommandMapper().getCommandsMap();
        List<String> file = FileReader.readFile("program.txt");
        for (String line:file) {
            String[] programSplitedCommand = CommandReader.readCommand(line);
            if(commandsMap.containsKey(programSplitedCommand[0])) {
                String[] commandArgs = Arrays.copyOfRange(programSplitedCommand, 1, programSplitedCommand.length);
                commandsMap.get(programSplitedCommand[0]).doCommand(commandArgs);

            } else {
                // change variables
            }
        }
    }
}