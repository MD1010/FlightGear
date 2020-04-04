package commands;

import interfaces.ICommand;
import mappers.VariableMapper;

public class PrintCommand implements ICommand {
    @Override
    public int doCommand(String[] args) {
        if (args[0].startsWith("\"")) {
            String output = "";
            for (String substring : args) {
                substring = substring.replaceAll("\"", "");
                output = output.concat(substring + " ");
            }

            System.out.println(output);
        } else {
            if (VariableMapper.isVariableExist(args[0])) {
//                String[] expression = Arrays.copyOfRange(args, 1, args.length);
//                double expressionValue = ExpressionEvaluator.getExpressionNumericValue(args[0]);
                String expressionValue = VariableMapper.getVaraibleByKey(args[0]).value;
                System.out.println(expressionValue);
            } else {
                System.out.println("Variable " + args[0] + " is not defined");
            }

        }
        return 1;
    }
}
