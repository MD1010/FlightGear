package commands;
import interfaces.ICommand;
import readers.DataServerReader;

import java.io.IOException;

public class OpenDataServerCommand implements ICommand {
    @Override
    public int doCommand(String[] args) throws IOException {
        DataServerReader.openServerConnection(Integer.parseInt(args[0]));
        return 1;
    }
}
