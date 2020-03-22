package commands;

import interfaces.ICommand;
import mappers.VariableMapper;
import models.Variable;
import utils.Consts;


public class VarCommand implements ICommand {
    @Override
    public void doCommand(String[] args) throws Exception {
        if (args.length < 3) {
            throw new Exception("Syntax Error, Excpected atg least 3 arguments, got " + args.length);
        } else {
            String varaiableName = args[0];
            String equalSign = args[1];
            String rValue = args[2];

            if (!equalSign.equals(Consts.EQUAL_SIGN)) {
                throw new Exception("Syntax Error, Excpected = after variable name ");
            }
            Variable variable = new Variable();
            if(rValue.equals(Consts.BIND_KEYWORD)) {
                if (args.length != 4) {
                    throw new Exception("Syntax Error, Excpected exactly 4 arguments, got " + args.length);
                }
                String variablePath = args[3].replaceAll("\"", "");
                variable.isLocal = false;
                variable.value = variablePath;
            } else {
                if(VariableMapper.isVariableExist(rValue)) {
                    variable.isLocal = true;
                    // todo: get the value from the server and add the vairalbe with the value to the map

                } else {
                    throw new Exception("variable "+ rValue + "is undefined");
                }

            }
            /*
            dor = bind '/dor/value'        Map: dor: {.....}
            mis = mamamam

            "get " + Map[varaible] + " "
             */
            VariableMapper.setVariable(varaiableName, variable);
//            boolean isVariableFoundInXML = false;
//            for (XmlNode xmlNode : VariableMapper.xmlVariablesFile) {
//                if(xmlNode.node.equals(variablePath)){
//                    isVariableFoundInXML = true;
//                    break;
//                }
//            }
//            if (!isVariableFoundInXML) {
//                throw new Exception("Undefined path variable");
//            }
//            else {
//                VariableMapper.setVariable(varaiableName, variablePath);
//            }
        }
    }
}
