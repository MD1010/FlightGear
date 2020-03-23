package utils;

public class ExpressionEvaluator {

    private static int handleCalculation(SinglyLinkedListStack<Integer> stack, String[] el) {
        int operand1, operand2;

        for(int i = 0; i < el.length; i++) {
            if( el[i].equals(ADD) || el[i].equals(SUB) || el[i].equals(MUL) || el[i].equals(DIV) ) {
                operand2 = stack.pop();
                operand1 = stack.pop();
                switch(el[i]) {
                    case ADD: {
                        int local = operand1 + operand2;
                        stack.push(local);
                        break;
                    }

                    case SUB: {
                        int local = operand1 - operand2;
                        stack.push(local);
                        break;
                    }

                    case MUL: {
                        int local = operand1 * operand2;
                        stack.push(local);
                        break;
                    }

                    case DIV: {
                        int local = operand1 / operand2;
                        stack.push(local);
                        break;
                    }
                }
            } else {
                stack.push(Integer.parseInt(el[i]));
            }
        }

        return stack.pop();
    }


}
