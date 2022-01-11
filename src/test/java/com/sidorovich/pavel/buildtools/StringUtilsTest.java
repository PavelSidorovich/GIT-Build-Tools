package com.sidorovich.pavel.buildtools;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    public static Object[][] validStringDataProvider() {
        return new Object[][] {
                { "10", Boolean.TRUE },
                { "-10", Boolean.FALSE },
                { "+10.0", Boolean.TRUE },
                { "-10.0", Boolean.FALSE },

        };
    }

    @ParameterizedTest
    @MethodSource("validStringDataProvider")
    void isPositiveNumber_shouldReturnTrue_whenStringNumberIsPositive(String str, Boolean expected) {
        final Boolean actual = StringUtils.isPositiveNumber(str);

        assertEquals(expected, actual);
    }

    public static Object[][] invalidStringDataProvider() {
        return new Object[][] {
                { "str" },
                { "25ff" },
                { "-25ff" },
                { "0x54" },
                { "" },
        };
    }

    @ParameterizedTest
    @MethodSource("invalidStringDataProvider")
    void isPositiveNumber_shouldThrowNumberFormatException_whenStringCannotBeConvertedToNumber(String str) {
        assertThrows(
                NumberFormatException.class,
                () -> StringUtils.isPositiveNumber(str)
        );
    }

}