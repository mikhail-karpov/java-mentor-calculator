package com.mikhailkarpov.calculator;

public class Division extends AbstractArithmeticOperation {

    public Division(int a, int b) {
        super(a, b);
    }

    @Override
    public double execute() {
        int b = getB();
        if (b == 0)
            throw new IllegalArgumentException("Denominator equals 0");

        return (double) getA() / b;
    }
}
