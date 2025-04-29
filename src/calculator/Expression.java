package calculator;

public class Expression implements ArithmeticExpression{
    private final ArithmeticExpression leftExpression;
    private final ArithmeticExpression rightExpression;
    private final Operator operator;

    public Expression(ArithmeticExpression leftExpression, ArithmeticExpression rightExpression, Operator operator) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
    }

    @Override
    public double evaluate() {
        double ans = 0;
        switch (operator){
            case ADD -> ans = leftExpression.evaluate() + rightExpression.evaluate();
            case DIVIDE -> ans = leftExpression.evaluate() / rightExpression.evaluate();
            case MULTIPLY -> ans = leftExpression.evaluate() * rightExpression.evaluate();
            case SUBTRACT -> ans = leftExpression.evaluate() - rightExpression.evaluate();
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        }
        return ans;
    }
}
