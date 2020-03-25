package commands;
import interfaces.ICommand;

public class ConnectCommand implements ICommand {
    @Override
    public int doCommand(String[] args) {
        return 1;
    }
}
