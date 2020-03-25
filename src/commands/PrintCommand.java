package commands;
import interfaces.ICommand;

public class PrintCommand implements ICommand {
    @Override
    public int doCommand(String[] args) {
        return 1;
    }
}
