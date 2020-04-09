package commands;

import interfaces.ICommand;
import utils.HelperFuncs;

import java.util.Arrays;

public class ReturnCommand implements ICommand {
    @Override
    public int doCommand(String[] args) {
        return (int)Double.parseDouble(HelperFuncs.evaluateValue(args));
    }
}
