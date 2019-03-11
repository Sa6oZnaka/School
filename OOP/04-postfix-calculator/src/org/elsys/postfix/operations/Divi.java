package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

import java.util.EmptyStackException;

public class Divi extends BinaryOperation implements Operation {

    public Divi(Calculator calculator) {
        super(calculator, "/");
    }

    @Override
    protected double doCalculate(double value1, double value2) {


        return value1 / value2;

    }

}
