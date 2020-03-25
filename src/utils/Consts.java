package utils;

import java.util.HashMap;
import java.util.Map;

public class Consts {
    public static final String EQUAL_SIGN = "=";
    public static final String BIND_KEYWORD = "bind";
    public static final String FILE_NAME = "program.txt";

    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";

    public final static Map<String, Operator> operatorsMap = new HashMap<String, Operator>() {{
        put(PLUS, Operator.ADD);
        put(MINUS, Operator.SUBTRACT);
        put(MULTIPLY, Operator.MULTIPLY);
        put(DIVIDE, Operator.DIVIDE);
    }};

    public enum Operator {
        ADD(1), SUBTRACT(2), MULTIPLY(3), DIVIDE(4);
        final int precedence;

        Operator(int p) {
            precedence = p;
        }
    }

}