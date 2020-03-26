package commands;

import interfaces.ICommand;
import mappers.ConditionMapper;
import utils.HelperFuncs;

import java.util.Arrays;

public class WhileCommand implements ICommand {
    @Override
    public int doCommand(String[] args) throws Exception {
        String[] firstWhileLineSplittedBySpace = args[0].split(" ");
        String[] condion =  Arrays.copyOfRange(firstWhileLineSplittedBySpace, 1, firstWhileLineSplittedBySpace.length -1);
        String conditionFirstValue = condion[0];
        String conditionSign = condion[1];
        String conditionSecondValue = condion[2];

        double firstConditionValue = HelperFuncs.getValueOrVariableValue(conditionFirstValue);
        double secondConditionValue = HelperFuncs.getValueOrVariableValue(conditionSecondValue);
        while(ConditionMapper.condationsMap.get(conditionSign).isConditionHappening(firstConditionValue,
                                                                                    secondConditionValue)) {
            firstConditionValue = HelperFuncs.getValueOrVariableValue(conditionFirstValue);
            secondConditionValue = HelperFuncs.getValueOrVariableValue(conditionSecondValue);
        }

        // + 1 because the line of the }
        return args.length + 1;
    }
}
