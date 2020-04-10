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


public class VarCommand implements ICommand {
    @Override
    public int doCommand(String[] args) {
        String variableName = args[0];
        Variable variable = new Variable();
        if (args.length == 1) {
            variable.isLocal = true;
            variable.value = 0.0;
            VariableMapper.setVariable(variableName, variable);
            return 1;
        }
        if (args[2].equals(Consts.BIND_KEYWORD)) {
            variable.path = args[3];
            variable.isLocal = false;
            VariableMapper.setVariable(variableName, variable);
            return 1;
        }

        String[] mathExpression = Arrays.copyOfRange(args, 2, args.length);
        double result = HelperFuncs.evaluateValue(mathExpression);
        variable.isLocal = true;
        variable.value = result;
        VariableMapper.setVariable(variableName, variable);
        return 1;
    }
}