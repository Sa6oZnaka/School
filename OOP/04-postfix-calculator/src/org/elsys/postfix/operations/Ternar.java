package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

import java.util.EmptyStackException;

public class Ternar extends TrinaryOperation implements Operation {

    public Ternar(Calculator calculator) {
        super(calculator, "\\*-\\*");
    }

    @Override
    protected double doCalculate(double value1, double value2, double value3) {


        return - ( value1 * value2 * value3 );

    }

}
