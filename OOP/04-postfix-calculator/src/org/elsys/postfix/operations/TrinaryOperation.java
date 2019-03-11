package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

import java.util.EmptyStackException;

public abstract class TrinaryOperation extends AbstractOperation {

    public TrinaryOperation(Calculator calculator, String token) {
        super(calculator, token);
    }

    @Override
    public void calculate() {

        double value1 = getCalculator().popValue();
        double value2 = getCalculator().popValue();
        double value3 = getCalculator().popValue();

        double result = doCalculate(value1, value2, value3);
        getCalculator().addValue(result);
    }

    protected abstract double doCalculate(double value1, double value2, double value3);
}
