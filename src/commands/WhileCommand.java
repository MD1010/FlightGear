package commands;

import interfaces.ICommand;

import java.util.Arrays;

public class WhileCommand implements ICommand {
    @Override
    public int doCommand(String[] args) throws Exception {
        String[] firstWhileLineSplittedBySpace = args[0].split(" ");
        String[] condion =  Arrays.copyOfRange(firstWhileLineSplittedBySpace, 1, firstWhileLineSplittedBySpace.length -1);
//        while()
        return 0;
    }
}
