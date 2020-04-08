package utils;

import mappers.CommandMapper;
import mappers.VariableMapper;
import models.Variable;
import readers.CommandReader;

import java.util.Arrays;

public class HelperFuncs {

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
            //if (variable.value == null) {
                //Random random = new Random();
                //return random.nextDouble();
            //}
            return Double.parseDouble(variable.value);
        } else {
            return Double.parseDouble(variableOrValue);
        }
    }

    public static String getVariableKeyByPath(String XMLPath) {
        for (String var : VariableMapper.symbolMap.keySet()) {
            if (!VariableMapper.symbolMap.get(var).isLocal) {
                if (VariableMapper.symbolMap.get(var).path.equals(XMLPath)) {
                    return var;
                }
            }


        }
        return null;
    }

    public static int executeCommand(String lineToExecute, int lineIndex) {
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

            if (CommandMapper.loopsCommandsMap.containsKey(firstCommandWord)) {
                String[] commandsUntillEndOfFile = Arrays.copyOfRange(CommandReader.commands, lineIndex, CommandReader.commands.length);
                int linesToRead = HelperFuncs.countLinesUntillClosingBrancket(commandsUntillEndOfFile);
                String[] commandsOfWhileLoop = Arrays.copyOfRange(CommandReader.commands, lineIndex, lineIndex + linesToRead);
                CommandMapper.loopsCommandsMap.get(firstCommandWord).doCommand(commandsOfWhileLoop, lineIndex + 1);
                lineIndex += linesToRead;

            }
        }
        return lineIndex;
    }

    public static String[] addSpaces(String[] lines) {
        final String specialChars = "+-*/()=";
        for(int lineIndex = 0; lineIndex < lines.length; lineIndex++) {
            String newLine = "";
            for (int charIndex = 0; charIndex < lines[lineIndex].length(); charIndex++){
                String currentChar = String.valueOf(lines[lineIndex].charAt(charIndex));
                if(specialChars.contains(currentChar)) {
                    if(charIndex - 1 >= 0) {
                        char previousChar = lines[lineIndex].charAt(charIndex - 1);
                        if (previousChar != ' ') {
                           newLine += " ";
                        }
                    }
                    newLine += currentChar;

                    if(charIndex + 1 < lines[lineIndex].length()) {
                        char nextChar = lines[lineIndex].charAt(charIndex + 1);
                        if (nextChar != ' ') {
                            newLine += " ";
                        }
                    }
                } else {
                    newLine += currentChar;
                }
            }

            lines[lineIndex] = newLine;
        }

        return lines;
    }
}
