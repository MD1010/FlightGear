package mappers;

import commands.*;
import interfaces.ICommand;
import interfaces.ILoopCommand;
import utils.Consts;

import java.util.HashMap;
import java.util.Map;

public class CommandMapper {
    public static Map<String, ICommand> commandsMap = new HashMap<String, ICommand>() {{
        //put("openDataServer", new OpenDataServerCommand());
        //put("connect", ConnectCommand.getInstance());
        put("var", new VarCommand());
        put("print", new PrintCommand());
        put("sleep", new SleepCommand());
        put("return", new ReturnCommand());
        put(Consts.EQUAL_SIGN, new EqualCommand());


    }};
    public static Map<String, ILoopCommand> loopsCommandsMap = new HashMap<String, ILoopCommand>() {{
        put("while", new WhileCommand());
    }};
}
