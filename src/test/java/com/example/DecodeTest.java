package com.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DecodeTest {

    @Test
    void Integer_Decode_Decimal() {
        assertEquals(42, Integer.decode("42")); // десятичное число
    }

    @Test
    void Integer_Decode_NegativeDecimal() {
        assertEquals(-42, Integer.decode("-42")); // отрицательное десятичное число
    }

    @Test
    void Integer_Decode_Hexadecimal() {
        assertEquals(0x2A, Integer.decode("0x2A")); // шестнадцатеричное число
    }

    @Test
    void Integer_Decode_NegativeHexadecimal() {
        assertEquals(-0x2A, Integer.decode("-0x2A")); // отрицательное шестнадцатеричное число
    }

    @Test
    void Integer_Decode_Octal() {
        assertEquals(010, Integer.decode("010")); // восьмеричное число
    }

    @Test
    void Integer_Decode_NegativeOctal() {
        assertEquals(-010, Integer.decode("-010")); // отрицательное восьмеричное число
    }

    @Test
    void Integer_Decode_Zero() {
        assertEquals(0, Integer.decode("0")); // число 0
    }

    @Test
    void Integer_Decode_Null() {
        assertThrows(NullPointerException.class, () -> Integer.decode(null)); // строка null
    }

    @Test
    void Integer_Decode_EmptyString() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("")); // пустая строка
    }
}
