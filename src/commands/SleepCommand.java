package commands;
import interfaces.ICommand;

public class SleepCommand implements ICommand {
    @Override
    public int doCommand(String[] args) throws Exception {
        Thread.sleep(Integer.parseInt(args[0]));
        return 1;
    }
}
