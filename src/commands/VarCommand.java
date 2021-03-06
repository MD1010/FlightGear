package commands;

import interfaces.ICommand;
import mappers.VariableMapper;
import models.Variable;
import utils.Consts;
import utils.HelperFuncs;


public class VarCommand implements ICommand {
    @Override
    public int doCommand(String[] args) throws Exception {
        HelperFuncs.throwIfNumOfArgumentsIsInvalid(args.length < 3, args, 3);

        String variableName = args[0];
        String equalSign = args[1];
        String rValue = args[2];
        Variable variable = new Variable();

        HelperFuncs.throwIfEqualSignDoesntExist(equalSign);

        if (rValue.equals(Consts.BIND_KEYWORD)) {
            HelperFuncs.throwIfNumOfArgumentsIsInvalid(args.length != 4, args, 4);
            String variablePath = args[3].replaceAll("\"", "");
            variable.isLocal = false;
            variable.path = variablePath;
        }
        else if (VariableMapper.isVariableExist(rValue)) {
            variable.value = VariableMapper.getVaraibleByKey(rValue).value;
            variable.isLocal = true;
        } else {
            throw new Exception("variable " + rValue + "is undefined");
        }

        if(variable.value == null) {
            variable.value = "0.0";
        }

        VariableMapper.setVariable(variableName, variable);
        return 1;
    }
}
