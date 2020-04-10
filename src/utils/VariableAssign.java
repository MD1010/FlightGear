package utils;

import mappers.VariableMapper;
import readers.FileReader;

import static utils.HelperFuncs.getVariableKeyByPath;

public class VariableAssign {
    public static void updateExistingVariables(String[] updatedVariablesValues) {
       /* final String[] {"simX", "simY", "simZ"}*/
//  FileReader.xmlVariables
        for (int varIndex = 0; varIndex < updatedVariablesValues.length; varIndex++) {
         String varPathFromXML = FileReader.xmlVariables.get(varIndex).node;
         String variableNameFoundByPath = getVariableKeyByPath(varPathFromXML);
            if (variableNameFoundByPath != null){
                VariableMapper.symbolMap.get(variableNameFoundByPath).value = Double.parseDouble(updatedVariablesValues[varIndex]);
            }
        }

    }
}

