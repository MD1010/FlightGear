package expressions;

import interfaces.IExpression;

public class Minus extends BinaryExpression implements IExpression {
    public Minus(IExpression left, IExpression right) {
        super(left, right);
    }

    public double calculate() {
        return super.left.calculate() - super.right.calculate();
    }
}
