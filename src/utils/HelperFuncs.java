package utils;

import interfaces.ICommand;
import mappers.CommandMapper;
import mappers.VariableMapper;
import models.Variable;
import readers.CommandReader;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class HelperFuncs {
    public static void throwIfNumOfArgumentsIsInvalid(boolean predicate, String[] args, int expectedNumOfArgs) throws Exception {
        if (predicate) {
            throw new Exception("Syntax Error, Excpected" + expectedNumOfArgs + " got " + args.length);
        }
    }

    public static void throwIfEqualSignDoesntExist(String argumnet) throws Exception {
        if (!argumnet.equals(Consts.EQUAL_SIGN)) {
            throw new Exception("Syntax Error, Excpected = after variable name ");
        }
    }

    public static int countLinesUntillClosingBrancket(String[] text) {
        int lineCounter = 0;
        for (String line : text) {
            if (line.equals("}")) break;
            lineCounter++;
        }
        return lineCounter;
    }

    public static double getValueOrVariableValue(String variableOrValue) {
        Variable variable = VariableMapper.getVaraibleByKey(variableOrValue);
        if (variable != null) {
            // todo: delete random
            if (variable.value == null) {
                Random random = new Random();
                return random.nextDouble();
            }
            return Double.parseDouble(variable.value);
        } else {
            return Double.parseDouble(variableOrValue);
        }
    }

    public static String getVariableKeyByPath(String XMLPath){
        for(String var: VariableMapper.symbolMap.keySet()){
            if(VariableMapper.symbolMap.get(var).path.equals(XMLPath)){
                return var;
            }

        }
    }

    public static int executeCommand(String lineToExecute, int lineIndex) throws Exception {
        // check if first word is a command name
        String[] splittedCommand = CommandReader.splitAndRemoveSpaces(lineToExecute);
        String firstCommandWord = splittedCommand[0];
        String[] commandArgs = Arrays.copyOfRange(splittedCommand, 1, splittedCommand.length);
        if (CommandMapper.commandsMap.containsKey(firstCommandWord)) {
            CommandMapper.commandsMap.get(firstCommandWord).doCommand(commandArgs);
            // check if the first word is a variable name
        } else if (VariableMapper.isVariableExist(firstCommandWord)) {
            CommandMapper.commandsMap.get(Consts.EQUAL_SIGN).doCommand(splittedCommand);

            // var number = bind "///"
            // ...
            // ...
            // var noder = number

            // **** number = ???? => set map[number] ????
        } else {
            // while number < 100 {
            // }

            if ( CommandMapper.loopsCommandsMap.containsKey(firstCommandWord)) {
                String[] commandsUntillEndOfFile = Arrays.copyOfRange(ReadCommandFile.fileData, lineIndex, ReadCommandFile.fileData.length);
                int linesToRead = HelperFuncs.countLinesUntillClosingBrancket(commandsUntillEndOfFile);
                String[] commandsOfWhileLoop = Arrays.copyOfRange(ReadCommandFile.fileData, lineIndex, lineIndex + linesToRead);
                CommandMapper.loopsCommandsMap.get(firstCommandWord).doCommand(commandsOfWhileLoop,lineIndex+1);
                lineIndex += linesToRead;

            }
        }
        return lineIndex;
    }
}
