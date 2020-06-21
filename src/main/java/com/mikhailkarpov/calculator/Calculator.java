package com.mikhailkarpov.calculator;

public class Calculator {

    private static String ROMAN_NUMERAL_PATTERN = "^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$";
    private static String ARABIC_NUMERAL_PATTERN = "^[0-9]*$";

    public static void main(String[] args) {
        if (args.length != 3)
            throw new IllegalArgumentException("Illegal input. Examples: '3 + 2', 'VI / III', etc.");

        Calculator calculator = new Calculator(args[0], args[2], args[1]);
        double result = calculator.calculate();
        System.out.println(result);
    }

    private ArithmeticOperation operation;

    public Calculator(String a, String b, String operation) {
        this.operation = getOperation(a, b, operation);
    }

    public double calculate() {
        return operation.execute();
    }

    private ArithmeticOperation getOperation(String a, String b, String operation) {
        int x;
        int y;

        if (a.matches(ROMAN_NUMERAL_PATTERN) && b.matches(ROMAN_NUMERAL_PATTERN)) {
            x = RomanNumConverter.romanToInt(a);
            y = RomanNumConverter.romanToInt(b);
        } else if (a.matches(ARABIC_NUMERAL_PATTERN) && b.matches(ARABIC_NUMERAL_PATTERN)) {
            x = Integer.parseInt(a);
            y = Integer.parseInt(b);
        } else {
            throw new IllegalArgumentException("Illegal input. Only arabic or roman numerals are supported");
        }

        if (x < 1 || x > 10 || y < 1 || y > 10) {
            throw new IllegalArgumentException("Only integers from 1 to 10 are supported");
        }

        switch (operation) {
            case "+":
                return new Addition(x, y);
            case "-":
                return new Subtraction(x, y);
            case "*":
                return new Multiplication(x, y);
            case "/":
                return new Division(x, y);
            default:
                throw new IllegalArgumentException("Unsupported operation: " + operation);
        }
    }
}
