package utils;

import mappers.VariableMapper;
import models.Variable;

import java.util.Arrays;
import java.util.Random;

public class ExpressionEvaluator {

    public static String[] switchVariablesToValues(String[] fullExpression) throws Exception {
        String[] expressionAfterEqualSign = Arrays.copyOfRange(fullExpression, 2, fullExpression.length);
        for(int wordIndex = 0; wordIndex < expressionAfterEqualSign.length; wordIndex++) {
            String word = expressionAfterEqualSign[wordIndex];
            if(VariableMapper.isVariableExist(word)) {
                Variable variable = VariableMapper.getVaraibleByKey(word);
                if(variable == null) {
                    throw new Exception("Variable is not defined");
                }

                final int MIN_VALUE = 1;
                final int MAX_VALUE = 5;

                Random random = new Random();
                if(variable.value != null) {
                    expressionAfterEqualSign[wordIndex] = variable.value;
                } else {
                    expressionAfterEqualSign[wordIndex] = String.valueOf(random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE);
                }

            }
        }
        return expressionAfterEqualSign;
    }

//    private static int handleCalculation(SinglyLinkedListStack<Integer> stack, String[] el) {
//        int operand1, operand2;
//
//        for(int i = 0; i < el.length; i++) {
//            if( el[i].equals(ADD) || el[i].equals(SUB) || el[i].equals(MUL) || el[i].equals(DIV) ) {
//                operand2 = stack.pop();
//                operand1 = stack.pop();
//                switch(el[i]) {
//                    case ADD: {
//                        int local = operand1 + operand2;
//                        stack.push(local);
//                        break;
//                    }
//
//                    case SUB: {
//                        int local = operand1 - operand2;
//                        stack.push(local);
//                        break;
//                    }
//
//                    case MUL: {
//                        int local = operand1 * operand2;
//                        stack.push(local);
//                        break;
//                    }
//
//                    case DIV: {
//                        int local = operand1 / operand2;
//                        stack.push(local);
//                        break;
//                    }
//                }
//            } else {
//                stack.push(Integer.parseInt(el[i]));
//            }
//        }
//
//        return stack.pop();
//    }
//

}
