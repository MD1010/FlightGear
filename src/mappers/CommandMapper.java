package mappers;
import commands.*;
import interfaces.ICommand;
import utils.Consts;

import java.util.HashMap;
import java.util.Map;

public class CommandMapper {
    Map<String, ICommand> commandsMap = new HashMap<>();

    public CommandMapper() {
        this.init();
    }

    public Map<String, ICommand> getCommandsMap() {
        return commandsMap;
    }

    public void init() {
        commandsMap.put("openDataServer", new OpenDataServerCommand());
        commandsMap.put("connect", new ConnectCommand());
        commandsMap.put("var", new VarCommand());
        commandsMap.put("print", new PrintCommand());
        commandsMap.put("sleep", new SleepCommand());
        commandsMap.put(Consts.EQUAL_SIGN, new EqualCommand());
    }
}
