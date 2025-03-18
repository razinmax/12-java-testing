package com.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DecodeTest {
    @Test
    void Integer_Decode_Decimal() {
        assertEquals(123, Integer.decode("123"));
    }

    @Test
    void Integer_Decode_Octal() {
        assertEquals(511, Integer.decode("0777"));
    }

    @Test
    void Integer_Decode_Hex() {
        assertEquals(255, Integer.decode("0xFF"));
        assertEquals(171, Integer.decode("0XAB"));
        assertEquals(61, Integer.decode("#3D"));
    }

    @Test
    void Integer_Decode_PositiveSign() {
        assertEquals(456, Integer.decode("+456"));
        assertEquals(420, Integer.decode("+0644"));
        assertEquals(291, Integer.decode("+0x123"));
    }

    @Test
    void Integer_Decode_NegativeSign() {
        assertEquals(-99, Integer.decode("-99"));
        assertEquals(-83, Integer.decode("-0123"));
        assertEquals(-186, Integer.decode("-0xBA"));
    }

    @Test
    void Integer_Decode_InvalidFormat() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("xyz"));
        assertThrows(NumberFormatException.class, () -> Integer.decode("42+7"));
        assertThrows(NumberFormatException.class, () -> Integer.decode("25-3"));
        assertThrows(NumberFormatException.class, () -> Integer.decode("33 44 55"));
    }

    @Test
    void Integer_Decode_OutOfMaxValue() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("2147483648")); // Максимальное значение Integer + 1
    }

    @Test
    void Integer_Decode_NullValue() {
        assertThrows(NullPointerException.class, () -> Integer.decode(null));
    }

    @Test
    void Integer_Decode_EmptyString() {
        assertThrows(NumberFormatException.class, () -> Integer.decode(""));
    }

    @Test
    void Integer_Decode_WrongSignPosition() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("0x-FF"));
        assertThrows(NumberFormatException.class, () -> Integer.decode("0+567"));
        assertThrows(NumberFormatException.class, () -> Integer.decode("#-42"));
    }
}
