import interfaces.ICommand;
import mappers.CommandMapper;
import mappers.VariableMapper;
import readers.CommandReader;

import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {

        CommandReader.parser();
//        VariableMapper.printSymbolMap();
    }
}