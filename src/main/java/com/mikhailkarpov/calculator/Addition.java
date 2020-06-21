package com.mikhailkarpov.calculator;

public class Addition extends AbstractArithmeticOperation {

    public Addition(int a, int b) {
        super(a, b);
    }

    @Override
    public double execute() {
        return getA() + getB();
    }
}
