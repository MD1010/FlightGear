package utils;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static utils.Consts.operatorsMap;

public class ShuntingYard {

    private static boolean isHigerPrec(String op, String sub)
    {
        return (operatorsMap.containsKey(sub) && operatorsMap.get(sub).precedence >= operatorsMap.get(op).precedence);
    }

    public static String[] convertToPostfix(String[] infix)
    {
        StringBuilder output = new StringBuilder();
        Deque<String> stack  = new LinkedList<>();

        for (String token : infix) {
            // operator
            if (operatorsMap.containsKey(token)) {
                while ( ! stack.isEmpty() && isHigerPrec(token, stack.peek()))
                    output.append(stack.pop()).append(' ');
                stack.push(token);

                // left parenthesis
            } else if (token.equals("(")) {
                stack.push(token);

                // right parenthesis
            } else if (token.equals(")")) {
                while ( ! stack.peek().equals("("))
                    output.append(stack.pop()).append(' ');
                stack.pop();

                // digit
            } else {
                output.append(token).append(' ');
            }
        }

        while ( ! stack.isEmpty())
            output.append(stack.pop()).append(' ');

        // outpout = "9 8 + 3 5 /"
        // ["9 8 + 3 5 /"]
        return output.toString().split("\\s+");
    }
}
