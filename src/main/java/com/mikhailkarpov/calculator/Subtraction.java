package com.mikhailkarpov.calculator;

public class Subtraction extends AbstractArithmeticOperation {

    public Subtraction(int a, int b) {
        super(a, b);
    }

    @Override
    public double execute() {
        return getA() - getB();
    }
}
