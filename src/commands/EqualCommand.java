package commands;

import interfaces.ICommand;

import java.util.Arrays;

public class EqualCommand implements ICommand {
    @Override
    public void doCommand(String[] args) throws Exception {
        // noder = 0
        // number = 90 * 7
        // number = h0 * 3 + noder
        // args -> v = 1
        String lValue = args[0];
        String[] rValue = Arrays.copyOfRange(args, 1, args.length);
//        getExpressionValue(rValue);
//        VariableMapper.symbolMap.get
    }
}
