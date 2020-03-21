package readers;

public class CommandReader {
    public static String[] readCommand(String commandString){
        commandString = commandString.trim();
        return commandString.split(" ");
    }
}
