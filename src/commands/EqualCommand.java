package commands;

import interfaces.ICommand;
import mappers.VariableMapper;
import models.Variable;
import utils.Consts;
import utils.ExpressionEvaluator;
import utils.ShuntingYard;

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
        if (args[2].equals(Consts.BIND_KEYWORD)) {
            String variableName = args[0];
            Variable newVaraible = VariableMapper.getVaraibleByKey(variableName);
            newVaraible.isLocal = false;
            newVaraible.path = args[3];
            VariableMapper.setVariable(variableName, newVaraible);
            return 1;
        }
        String[] expressionAfterEqualSign = ExpressionEvaluator.switchVariablesToValues(args);
        String[] rValuePostfix = ShuntingYard.convertToPostfix(expressionAfterEqualSign);
        double variableValue = getExpressionNumericValue(rValuePostfix);
        Variable updatedVariable = VariableMapper.getVaraibleByKey(args[0]);
        updatedVariable.value = String.valueOf(variableValue);
//        ConnectCommand.sendCommandToSimulator("set " + updatedVariable.path + " " + updatedVariable.value);
        VariableMapper.setVariable(args[0], updatedVariable);
        return 1;
        // args = [noder, = , h0, -, heading, /, 15]
        // retutrn: [4, -, 3, /, 20]
    }
}
