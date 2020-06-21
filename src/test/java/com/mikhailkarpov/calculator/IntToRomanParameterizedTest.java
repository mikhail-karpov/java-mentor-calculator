package com.mikhailkarpov.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IntToRomanParameterizedTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {39, "XXXIX"},
                {246, "CCXLVI"},
                {789, "DCCLXXXIX"},
                {2421, "MMCDXXI"},
                {150, "CL"},
                {207, "CCVII"},
                {1009, "MIX"},
                {3065, "MMMLXV"}
        });
    }

    private int i;
    private String expectedRoman;

    public IntToRomanParameterizedTest(int i, String expectedRoman) {
        this.i = i;
        this.expectedRoman = expectedRoman;
    }

    @Test
    public void shouldReturnCorrectRoman() {
        String actualRoman = RomanNumConverter.intToRoman(i);
        Assert.assertEquals(expectedRoman, actualRoman);
    }
}