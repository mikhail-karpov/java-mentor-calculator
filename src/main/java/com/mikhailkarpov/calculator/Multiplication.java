package com.mikhailkarpov.calculator;

public class Multiplication extends AbstractArithmeticOperation {

    public Multiplication(int a, int b) {
        super(a, b);
    }

    @Override
    public double execute() {
        return getA() * getB();
    }
}
