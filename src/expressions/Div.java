package expressions;

import interfaces.IExpression;

public class Div extends BinaryExpression implements IExpression {
    public Div(IExpression left, IExpression right) {
        super(left, right);
    }

    public double calculate() {
        return super.left.calculate() / super.right.calculate();
    }
}
