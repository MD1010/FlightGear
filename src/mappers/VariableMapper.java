package mappers;

import models.Variable;
import readers.FileReader;
import models.XmlNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VariableMapper {
    public static List<XmlNode> xmlVariablesFile = FileReader.readXMLFile("generic_small.xml");

    public static Map<String, Variable> symbolMap = new HashMap<>();

    public static void setVariable(String variableName, Variable variable) {
        symbolMap.put(variableName, variable);
    }

    public static boolean isVariableExist(String variableName) {
        return symbolMap.containsKey(variableName);
    }

    public static void printSymbolMap() {
        for (Map.Entry<String, Variable> entry : symbolMap.entrySet()) {
            String key = entry.getKey();
            Variable value = entry.getValue();
            System.out.println("key= "+key + " value= " + value.value +" isLocal=" + value.isLocal);
        }
    }
}
