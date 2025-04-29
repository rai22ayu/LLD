package calculator;

public class Number implements ArithmeticExpression{
    private double value;

    @Override
    public double evaluate() {
        return value;
    }
}
