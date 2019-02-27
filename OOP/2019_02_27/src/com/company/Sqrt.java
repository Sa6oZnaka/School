package com.company;


public class Sqrt extends BaseOperation implements Operation {

    public Sqrt(Calculator calculator) {
        super("sqrt", calculator);
    }

    @Override
    public void execute() {
        double value = getCalculator().pop();
        getCalculator().push(Math.sqrt(value));
    }
}