package commands;

import interfaces.ICommand;
import mappers.VariableMapper;
import models.Variable;
import utils.Consts;
import utils.ExpressionEvaluator;
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
            variable.value = "0.0";
            VariableMapper.setVariable(variableName, variable);
            return 1;
        }
        if (args[2].equals(Consts.BIND_KEYWORD)) {
            variable.path = args[3];
            variable.isLocal = false;
            VariableMapper.setVariable(variableName, variable);
            return 1;
        }

//        String[] rvalue = Arrays.copyOfRange(args, 2, args.length);
        String[] expressionAfterEqualSign = ExpressionEvaluator.switchVariablesToValues(args);
        String[] rValuePostfix = ShuntingYard.convertToPostfix(expressionAfterEqualSign);
        double variableValue = getExpressionNumericValue(rValuePostfix);
        variable.isLocal = true;
        variable.value = String.valueOf(variableValue);
        VariableMapper.setVariable(variableName, variable);
        return 1;
    }
}

//        String variableName = args[0];
//        String equalSign = args[1];
//        String rValue = args[2];


//        if (rValue.equals(Consts.BIND_KEYWORD)) {
//            String variablePath = args[3].replaceAll("\"", "");
//            variable.isLocal = false;
//            variable.path = variablePath;
//        } else if (VariableMapper.isVariableExist(rValue)) {
//            variable.value = VariableMapper.getVaraibleByKey(rValue).value;
//            variable.isLocal = true;
//        }
//
//        if (variable.value == null) {
//            variable.value = "0.0";
//        }
//
//        VariableMapper.setVariable(variableName, variable);

