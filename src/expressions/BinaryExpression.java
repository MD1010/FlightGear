package expressions;

import interfaces.IExpression;

public class BinaryExpression{
    public IExpression left;
    public IExpression right;

    public BinaryExpression(IExpression left, IExpression right) {
        this.left = left;
        this.right = right;
    }
}
