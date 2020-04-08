package commands;

import interfaces.ICommand;
import mappers.CommandMapper;
import mappers.VariableMapper;
import models.Variable;
import utils.ExpressionEvaluator;
import utils.HelperFuncs;
import utils.ShuntingYard;

import java.util.Arrays;

import static utils.ExpressionEvaluator.getExpressionNumericValue;

public class EqualCommand implements ICommand {
    @Override
    public int doCommand(String[] args) {
        // noder = 0
        // number = 90 * 7
        // number = h0 * 3 + noder



        // noder - n
        // 100 - num
        // - number - 10
        String[] expressionAfterEqualSign = ExpressionEvaluator.switchVariablesToValues(args);
        String[] rValuePostfix = ShuntingYard.convertToPostfix(expressionAfterEqualSign);
        double variableValue = getExpressionNumericValue(rValuePostfix);
        Variable updatedVariable = VariableMapper.getVaraibleByKey(args[0]);
        updatedVariable.value = String.valueOf(variableValue);
        ConnectCommand.sendCommandToSimulator("set " + updatedVariable.path + " " + updatedVariable.value);
        VariableMapper.setVariable(args[0], updatedVariable);
        return 1;
        // args = [noder, = , h0, -, heading, /, 15]
        // retutrn: [4, -, 3, /, 20]
    }
}
