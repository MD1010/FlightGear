import interfaces.ICommand;
import mappers.CommandMapper;
import mappers.VariableMapper;
import readers.CommandReader;

import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<String, ICommand> commandsMap = new CommandMapper().getCommandsMap();
        String[] fileData = CommandReader.lexer();
        CommandReader.parser(fileData,commandsMap);
        VariableMapper.printSymbolMap();
    }
}