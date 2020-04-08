package commands;

import interfaces.ICommand;
import mappers.VariableMapper;
import models.Variable;
import utils.Consts;
import utils.HelperFuncs;


public class VarCommand implements ICommand {
    @Override
    public int doCommand(String[] args) {
        String variableName = args[0];
        String equalSign = args[1];
        String rValue = args[2];
        Variable variable = new Variable();

        if (rValue.equals(Consts.BIND_KEYWORD)) {
            String variablePath = args[3].replaceAll("\"", "");
            variable.isLocal = false;
            variable.path = variablePath;
        }
        else if (VariableMapper.isVariableExist(rValue)) {
            variable.value = VariableMapper.getVaraibleByKey(rValue).value;
            variable.isLocal = true;
        }

        if(variable.value == null) {
            variable.value = "0.0";
        }

        VariableMapper.setVariable(variableName, variable);
        return 1;
    }
}
