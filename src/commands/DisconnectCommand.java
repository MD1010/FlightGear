package commands;

import interfaces.ICommand;
import readers.DataServerReader;

import java.io.IOException;

public class DisconnectCommand implements ICommand {
    @Override
    public int doCommand(String[] args) {
        try {
            DataServerReader.closeConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
