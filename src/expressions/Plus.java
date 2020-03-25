package expressions;

import interfaces.IExpression;

public class Plus extends BinaryExpression implements IExpression {
    public Plus(IExpression left, IExpression right) {
        super(left, right);
    }

    public double calculate() {
        return super.left.calculate() + super.right.calculate();
    }
}
