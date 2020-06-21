package com.mikhailkarpov.calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @Test
    public void givenArabicNumerals_whenAddition_thenCorrect() {
        calculator = getCaclulator("3 + 2");
        assertEquals(5, calculator.calculate(), .1);
    }

    @Test
    public void givenArabicNumerals_whenSubtraction_thenCorrect() {
        calculator = getCaclulator("5 - 8");
        assertEquals(-3.0, calculator.calculate(), .1);
    }

    @Test
    public void givenArabicNumerals_whenMultiplication_thenCorrect() {
        calculator = getCaclulator("6 * 9");
        assertEquals(54.0, calculator.calculate(), .1);
    }

    @Test
    public void givenArabicNumerals_whenDivision_thenCorrect() {
        calculator = getCaclulator("3 / 4");
        assertEquals(.75, calculator.calculate(), .01);
    }

    @Test
    public void givenRomanNumerals_whenDivision_thenCorrect() {
        calculator = getCaclulator("VI / III");
        assertEquals(2.0, calculator.calculate(), .1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNonNumerals_thenException() {
        calculator = getCaclulator("x / y");
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNonSupportedOperation_thenException() {
        calculator = getCaclulator("3 % 2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenIllegalRange_thenException() {
        calculator = getCaclulator("13 + 2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenArabicAndNumericNumerals_thenException() {
        calculator = getCaclulator("3 + II");
    }

    private Calculator getCaclulator(String args) {
        String[] s = args.split(" ");
        return new Calculator(s[0], s[2], s[1]);
    }
}