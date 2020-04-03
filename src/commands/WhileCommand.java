package commands;

import interfaces.ILoopCommand;
import mappers.ConditionMapper;
import utils.HelperFuncs;

import java.util.Arrays;

public class WhileCommand implements ILoopCommand {
    public int doCommand(String[] args, int lineToReadFromIndex) throws Exception {
        String[] firstWhileLineSplittedBySpace = args[0].split(" ");
        String[] condition = Arrays.copyOfRange(firstWhileLineSplittedBySpace, 1, firstWhileLineSplittedBySpace.length - 1);
        String conditionLeftOperand = condition[0];
        String conditionSign = condition[1];
        String conditionRightOperand = condition[2];
        String[] commandsInsideLoop = Arrays.copyOfRange(args, 1, args.length);
        // number < 100
        // number >= n
        // 3803 == number

        double firstConditionValue = HelperFuncs.getValueOrVariableValue(conditionLeftOperand);
        double secondConditionValue = HelperFuncs.getValueOrVariableValue(conditionRightOperand);

        while (ConditionMapper.condationsMap.get(conditionSign).isConditionHappening(firstConditionValue, secondConditionValue)) {
            System.out.println("Sheni damog!!!!!!");
            for (String commandToExexute : commandsInsideLoop) {
                HelperFuncs.executeCommand(commandToExexute, lineToReadFromIndex);
                firstConditionValue = HelperFuncs.getValueOrVariableValue(conditionLeftOperand);
                secondConditionValue = HelperFuncs.getValueOrVariableValue(conditionRightOperand);
            }
        }

        // + 1 because the line of the }
        return args.length + 1;
    }
}
