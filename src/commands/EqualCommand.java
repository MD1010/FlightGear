package commands;

import interfaces.ICommand;
import utils.ExpressionEvaluator;
import utils.HelperFuncs;

import java.util.Arrays;

public class EqualCommand implements ICommand {
    @Override
    public void doCommand(String[] args) throws Exception {
        // noder = 0
        // number = 90 * 7
        // number = h0 * 3 + noder
        HelperFuncs.throwIfEqualSignDoesntExist(args[1]);
        ExpressionEvaluator.switchVariablesToValues(args);
        String lValue = args[0];
        String[] rValue = Arrays.copyOfRange(args, 1, args.length);
//        getExpressionValue(rValue);
//        VariableMapper.symbolMap.get
    }
}
