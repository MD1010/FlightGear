package commands;
import interfaces.ICommand;

public class SleepCommand implements ICommand {
    @Override
    public int doCommand(String[] args) {
        return 1;
    }
}
