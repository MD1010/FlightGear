package utils;

import mappers.VariableMapper;
import models.Variable;

import java.util.Arrays;
import java.util.Random;

public class ExpressionEvaluator {

    public static String[] switchVariablesToValues(String[] fullExpression) throws Exception {
        String[] expressionAfterEqualSign = Arrays.copyOfRange(fullExpression, 2, fullExpression.length);
        for (int wordIndex = 0; wordIndex < expressionAfterEqualSign.length; wordIndex++) {
            String word = expressionAfterEqualSign[wordIndex];
            if (VariableMapper.isVariableExist(word)) {
                Variable variable = VariableMapper.getVaraibleByKey(word);
                if (variable == null) {
                    throw new Exception("Variable is not defined");
                }

                // todo: Like mok until connecting to the server
                final int MIN_VALUE = 1;
                final int MAX_VALUE = 5;
                Random random = new Random();
                if (variable.value != null) {
                    expressionAfterEqualSign[wordIndex] = variable.value;
                } else {
                    expressionAfterEqualSign[wordIndex] = String.valueOf(random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE);
                }

            }
        }
        return expressionAfterEqualSign;
    }
}
