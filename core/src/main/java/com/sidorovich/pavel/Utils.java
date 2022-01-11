package com.sidorovich.pavel;

import com.sidorovich.pavel.buildtools.StringUtils;

import java.util.Arrays;

public class Utils {

    public static boolean isAllPositiveNumbers(String... str){
        return Arrays.stream(str).allMatch(StringUtils::isPositiveNumber);
    }

}
