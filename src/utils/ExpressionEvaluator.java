package utils;

import expressions.Number;
import expressions.*;
import interfaces.IExpression;
import mappers.VariableMapper;
import models.Variable;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

import static utils.Consts.*;

public class ExpressionEvaluator {

    public static String[] switchVariablesToValues(String[] fullExpression) {
        String[] expressionAfterEqualSign = Arrays.copyOfRange(fullExpression, 2, fullExpression.length);
        for (int wordIndex = 0; wordIndex < expressionAfterEqualSign.length; wordIndex++) {
            String word = expressionAfterEqualSign[wordIndex];
            if (VariableMapper.isVariableExist(word)) {
                Variable variable = VariableMapper.getVaraibleByKey(word);

                // todo: Like mok until connecting to the server
                final int MIN_VALUE = 1;
                final int MAX_VALUE = 5;
                Random random = new Random();
                if (variable.value != null) {
                    expressionAfterEqualSign[wordIndex] = variable.value;
                } else {
                    //expressionAfterEqualSign[wordIndex] = String.valueOf(random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE);
                }
            }

        }
        return expressionAfterEqualSign;
    }

    public static double getExpressionNumericValue(String[] expression) {
        IExpression operand1, operand2;
        Stack<IExpression> stack = new Stack<>();

        stack.push(new Number(0));

        for (String s : expression) {
            if (operatorsMap.containsKey(s)) {
                operand2 = stack.pop();
                operand1 = stack.pop();
                switch (s) {
                    case PLUS: {
                        stack.push(new Plus(operand1, operand2));
                        break;
                    }

                    case MINUS: {
                        stack.push(new Minus(operand1, operand2));
                        break;
                    }

                    case MULTIPLY: {
                        stack.push(new Mul(operand1, operand2));
                        break;
                    }

                    case DIVIDE: {
                        stack.push(new Div(operand1, operand2));
                        break;
                    }
                }
            } else {
                stack.push(new Number(Double.parseDouble(s)));
            }
        }

        return stack.pop().calculate();
    }
}

