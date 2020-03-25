package commands;
import interfaces.ICommand;

public class OpenDataServerCommand implements ICommand {
    @Override
    public int doCommand(String[] args) {
        return 1;
    }
}
