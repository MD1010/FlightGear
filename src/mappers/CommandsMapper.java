package mappers;

import commands.*;
import interfaces.ICommand;
import interfaces.IMapper;
import java.util.HashMap;
import java.util.Map;

public class CommandsMapper implements IMapper {
    Map<String, ICommand> commandsMap = new HashMap<>();

    @Override
    public void init() {
        commandsMap.put("openDataServer", new OpenDataServerCommand());
        commandsMap.put("connect", new ConnectCommand());
        commandsMap.put("var", new VarCommand());
        commandsMap.put("print", new PrintCommand());
        commandsMap.put("sleep", new SleepCommand());
    }
}
