package commands;
import interfaces.ICommand;

public class SleepCommand implements ICommand {
    @Override
    public int doCommand(String[] args) {
        try {
            Thread.sleep(Integer.parseInt(args[0]));
        } catch (Exception e) {}
        return 1;
    }
}
