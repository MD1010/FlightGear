package commands;

import interfaces.ICommand;
import mappers.VariableMapper;
import models.Variable;
import utils.Consts;
import utils.ExpressionEvaluator;
import utils.HelperFuncs;
import utils.ShuntingYard;

import java.util.Arrays;

import static utils.ExpressionEvaluator.getExpressionNumericValue;

public class EqualCommand implements ICommand {
    @Override
    public int doCommand(String[] args) {

        if (args[2].equals(Consts.BIND_KEYWORD)) {
            String variableName = args[0];
            Variable newVaraible = VariableMapper.getVaraibleByKey(variableName);
            newVaraible.isLocal = false;
            newVaraible.path = args[3];
            VariableMapper.setVariable(variableName, newVaraible);
            return 1;
        }

        String[] mathExpression = Arrays.copyOfRange(args, 2, args.length);
        String variableValue = HelperFuncs.evaluateValue(mathExpression);
        Variable updatedVariable = VariableMapper.getVaraibleByKey(args[0]);
        updatedVariable.value = String.valueOf(variableValue);
//        ConnectCommand.sendCommandToSimulator("set " + updatedVariable.path + " " + updatedVariable.value);
        VariableMapper.setVariable(args[0], updatedVariable);
        return 1;

    }
}
