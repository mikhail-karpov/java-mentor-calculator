package com.mikhailkarpov.calculator;

import java.util.HashMap;
import java.util.Map;

public class RomanNumConverter {

    private static Map<Character, Integer> ROMAN_NUMERALS;
    private static String[] UNITS = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static String[] TENS = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static String[] HUNDREDS = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static String[] THOUSANDS = {"", "M", "MM", "MMM"};

    static {
        ROMAN_NUMERALS = new HashMap<>();

        ROMAN_NUMERALS.put('I', 1);
        ROMAN_NUMERALS.put('V', 5);
        ROMAN_NUMERALS.put('X', 10);
        ROMAN_NUMERALS.put('L', 50);
        ROMAN_NUMERALS.put('C', 100);
        ROMAN_NUMERALS.put('D', 500);
        ROMAN_NUMERALS.put('M', 1000);
    }

    public static int romanToInt(String roman) {
        int result = 0;
        for (int i = 0; i < roman.length(); i++) {
            int j = parseRomanNumeral(roman.charAt(i));
            result += j;

            if (i > 0 && j > parseRomanNumeral(roman.charAt(i - 1))) {
                result -= 2 * parseRomanNumeral(roman.charAt(i - 1));
            }
        }
        return result;
    }

    public static String intToRoman(int i) {
        if (i <= 0 || i > 3999)
            throw new IllegalArgumentException("Integers < 1 or > 3999 are not supported");

        return THOUSANDS[i / 1000] +
               HUNDREDS[(i % 1000) / 100] +
               TENS[(i % 100) / 10] +
               UNITS[i % 10];
    }

    private static int parseRomanNumeral(Character c) {
        Integer integer = ROMAN_NUMERALS.get(c);
        if (integer == null)
            throw new IllegalArgumentException("Invalid roman numeral " + c);
        return integer;
    }
}
