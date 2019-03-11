package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

import java.util.EmptyStackException;

public class Plus extends BinaryOperation implements Operation {

    public Plus(Calculator calculator) {
        super(calculator, "+");
    }

    @Override
    protected double doCalculate(double value1, double value2) {

        //if((Double)value1 == null || (Double)value2 == null) {
        //    throw new EmptyStackException();
        //}
        return value1 + value2;

    }

}
