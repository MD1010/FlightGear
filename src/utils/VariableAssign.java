package utils;

import mappers.VariableMapper;

import static utils.HelperFuncs.getVariableKeyByPath;

public class VariableAssign {
    public static void updateExistingVariables(String[] updatedVariablesValues) {
        final String[] varaiblesSentFromServer = {"simX", "simY", "simZ"};
//  FileReader.xmlVariables
        for (int varIndex = 0; varIndex < updatedVariablesValues.length; varIndex++) {
            System.out.println("updatedVariablesValues"+ updatedVariablesValues[0] +" " + updatedVariablesValues[1] + "   " + updatedVariablesValues[2]);
            System.out.println("VariableMapper.symbolMap"+ VariableMapper.symbolMap.isEmpty());
            String variableNameFoundByPath = getVariableKeyByPath(updatedVariablesValues[varIndex]);
            if(variableNameFoundByPath != null){
              VariableMapper.symbolMap.get(variableNameFoundByPath).value = Double.parseDouble(updatedVariablesValues[varIndex]);
            }


        }

    }
}

