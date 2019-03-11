package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

public class Sin extends UnaryOperation implements Operation {

    public Sin(Calculator calculator) {
        super(calculator, "sin");
    }

    @Override
    protected double doCalculate(double value) {
        return Math.sin(value);
    }

}
