package expressions;

import interfaces.IExpression;

public class Mul extends BinaryExpression implements IExpression {
    public Mul(IExpression left, IExpression right) {
        super(left, right);
    }

    public double calculate() {
        return super.left.calculate() * super.right.calculate();
    }
}
