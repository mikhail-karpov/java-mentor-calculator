package com.mikhailkarpov.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RomanToIntParameterizedTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"XXXIX", 39},
                {"CCXLVI", 246},
                {"DCCLXXXIX", 789},
                {"MMCDXXI", 2421},
                {"CL", 150},
                {"CCVII", 207},
                {"MIX", 1009},
                {"MMMLXV", 3065}
        });
    }

    private String roman;
    private int expectedInteger;

    public RomanToIntParameterizedTest(String roman, int expectedInteger) {
        this.roman = roman;
        this.expectedInteger = expectedInteger;
    }

    @Test
    public void shouldReturnCorrectInteger() {
        int actualInteger = RomanNumConverter.romanToInt(roman);
        assertEquals(expectedInteger, actualInteger);
    }

}