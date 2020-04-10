package utils;

import mappers.VariableMapper;

import java.util.List;

import static utils.HelperFuncs.getVariableKeyByPath;

public class VariableAssign {
    public static void updateExistingVariables(String[] updatedVariablesValues) {
        final String[] varaiblesSentFromServer = {"simX", "simY", "simZ"};
        System.out.println("updatedVariablesValues"+ updatedVariablesValues[0] +" " + updatedVariablesValues[1] + "   " + updatedVariablesValues[2]);
        for (int varIndex = 0; varIndex < updatedVariablesValues.length; varIndex++) {
            System.out.println("VariableMapper.symbolMap"+ VariableMapper.symbolMap.isEmpty());
            List<String> variableNames = getVariableKeyByPath(varaiblesSentFromServer[varIndex]);
            for(String variableName : variableNames) {
                System.out.println("111111111111111111111" + variableName +"  " + updatedVariablesValues[varIndex]);
                VariableMapper.symbolMap.get(variableName).value = Double.parseDouble(updatedVariablesValues[varIndex]);
            }
        }

    }
}

