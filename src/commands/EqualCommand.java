package commands;

import interfaces.ICommand;
import mappers.VariableMapper;
import models.Variable;
import utils.ExpressionEvaluator;
import utils.HelperFuncs;
import utils.ShuntingYard;

import java.util.Arrays;

import static utils.ExpressionEvaluator.getExpressionNumericValue;

public class EqualCommand implements ICommand {
    @Override
    public int doCommand(String[] args) throws Exception {
        // noder = 0
        // number = 90 * 7
        // number = h0 * 3 + noder



        // noder - n
        // 100 - num
        // - number - 10
        HelperFuncs.throwIfEqualSignDoesntExist(args[1]);
        String[] expressionAfterEqualSign = ExpressionEvaluator.switchVariablesToValues(args);
        String[] rValuePostfix = ShuntingYard.convertToPostfix(expressionAfterEqualSign);
        double variableValue = getExpressionNumericValue(rValuePostfix);
        Variable newVar = new Variable();
        newVar.value = String.valueOf(variableValue);
        VariableMapper.setVariable(args[0],newVar);
        return 1;
        // args = [noder, = , h0, -, heading, /, 15]
        // retutrn: [4, -, 3, /, 20]
    }
}
