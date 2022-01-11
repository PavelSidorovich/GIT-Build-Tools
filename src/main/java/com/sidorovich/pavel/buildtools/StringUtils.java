package com.sidorovich.pavel.buildtools;

import org.apache.commons.lang3.math.NumberUtils;

public class StringUtils {

    private static final String PLUS_SIGN = "+";
    private static final String MINUS_SIGN = "-";

    static boolean isPositiveNumber(String str) {
        /*
         * Plus sign need to be removed so that method
         * NumberUtils.isParsable(String str) return true in case of +1.0
         */
        str = org.apache.commons.lang3.StringUtils.removeStart(str, PLUS_SIGN);

        if (NumberUtils.isParsable(str)) {
            return !org.apache.commons.lang3.StringUtils.startsWith(str, MINUS_SIGN);
        }
        throw new NumberFormatException();
    }

}
