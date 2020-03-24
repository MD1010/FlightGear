package expressions;

import interfaces.IExpression;

public class Minus extends BinaryExpression implements IExpression {
    public double calculate() {
        return super.left.calculate() - super.right.calculate();
    }
}
