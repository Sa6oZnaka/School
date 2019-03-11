package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

import java.util.EmptyStackException;

public class Minus extends BinaryOperation implements Operation {

    public Minus(Calculator calculator) {
        super(calculator, "-");
    }

    @Override
    protected double doCalculate(double value1, double value2) {

        return value2 - value1;

    }

}
