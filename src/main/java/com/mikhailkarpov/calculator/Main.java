package com.mikhailkarpov.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String ROMAN_NUMERAL_PATTERN = "^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$";
    private static String ARABIC_NUMERAL_PATTERN = "^[0-9]*$";

    public static void main(String[] args) {
        String[] userInput = getUserInput();

        if (userInput.length != 3)
            throw new IllegalArgumentException("Illegal input. Examples: '3 + 2', 'VI / III', etc.");

        ArithmeticOperation operation = getOperation(userInput[0], userInput[2], userInput[1]);
        double result = operation.execute();

        if (userInput[0].matches(ROMAN_NUMERAL_PATTERN)) {
            String resultStr = RomanNumConverter.intToRoman((int) result);
            System.out.println(resultStr);
        } else {
            System.out.println(result);
        }
    }

    private static String[] getUserInput() {
        String[] splittedInput = null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            splittedInput = input.split(" ");

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            return splittedInput;
        }
    }

    private static ArithmeticOperation getOperation(String a, String b, String operation) {
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
