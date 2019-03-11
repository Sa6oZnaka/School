package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

public class Dup extends UnaryOperation implements Operation {

    public Dup(Calculator calculator) {
        super(calculator, "dup");
    }

    @Override
    protected double doCalculate(double value) {
        getCalculator().addValue(value);
        return value;
    }

}
