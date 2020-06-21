package com.mikhailkarpov.calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumConverterTest {

    @Test
    public void whenIntToRoman_thenCorrect() {
        String actualRoman = RomanNumConverter.intToRoman(3905);
        assertEquals("MMMCMV", actualRoman);
    }

    @Test
    public void whenRomanToInt_thenCorrect() {
        int actualInt = RomanNumConverter.romanToInt("MMMCMV");
        assertEquals(3905, actualInt);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNegativeInteger_whenIntToRoman_thenThrowException() {
        RomanNumConverter.intToRoman(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenZeroInteger_whenIntToRoman_thenThrowException() {
        RomanNumConverter.intToRoman(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidRomanNumeral_whenRomanToInt_thenThrowException() {
        RomanNumConverter.romanToInt("abcde");
    }
}