package commands;

import interfaces.ICommand;
import mappers.VariableMapper;
import utils.Consts;
import utils.XmlNode;


public class VarCommand implements ICommand {
    @Override
    public void doCommand(String[] args) throws Exception {
        if (args.length != 4) {
            throw new Exception("Syntax Error, Excpected exactly 3 arguments, got " + args.length);
        } else {
            String varaiableName = args[0];
            String equalSign = args[1];
            String bindKeyWord = args[2];
            String variablePath = args[3].replaceAll("\"", "");

            if (!equalSign.equals(Consts.EQUAL_SIGN)) {
                throw new Exception("Syntax Error, Excpected = after variable name ");
            }
            if (!bindKeyWord.equals(Consts.BIND_KEYWORD)) {
                throw new Exception("Syntax Error, Excpected bind after equal sign ");
            }
            boolean isVariableFoundInXML = false;
            for (XmlNode xmlNode : VariableMapper.xmlVariablesFile) {
                if(xmlNode.node.equals(variablePath)){
                    isVariableFoundInXML = true;
                    break;
                }
            }
            if (!isVariableFoundInXML) {
                throw new Exception("Undefined path variable");
            }
            else {
                VariableMapper.setVariable(varaiableName, variablePath);
            }
        }
    }
}
