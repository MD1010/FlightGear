package expressions;

import interfaces.IExpression;
public class Number implements IExpression {
    public double value;

    public Number(double value) {
        this.value = value;
    }

    public double calculate() {
        return value;
    }
}
