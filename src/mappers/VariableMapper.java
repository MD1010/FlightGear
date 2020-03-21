package mappers;

import readers.FileReader;
import utils.XmlNode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VariableMapper {
    public static List<XmlNode> xmlVariablesFile =  FileReader.readXMLFile("generic_small.xml");
    public static Map<String, String> symbolMap = new HashMap<>();

    public static void setVariable(String variableName, String variableValue) {
        symbolMap.put(variableName, variableValue);
    }
}
