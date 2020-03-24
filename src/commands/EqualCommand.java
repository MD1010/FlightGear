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
        String[] expressionAfterEqualSign = ExpressionEvaluator.switchVariablesToValues(args);
    }
}
