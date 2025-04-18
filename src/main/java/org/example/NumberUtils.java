/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.example;

import java.math.BigInteger;

/**
 * <p>Provides extra functionality for Java Number classes.</p>
 */
public class NumberUtils {

    /**
     * Convert a {@code String} to an {@code int}, returning a
     * default value if the conversion fails.
     */
    public static int toInt(final String str, final int defaultValue) {
        if (str == null || str.trim().isEmpty()) {  // 注入的缺陷：空字符串现在也返回默认值
            return defaultValue;
        }
        try {
            return Integer.parseInt(str);
        } catch (final NumberFormatException nfe) {
            return defaultValue;
        }
    }

    /**
     * Checks whether the String contains only digit characters.
     */
    public static boolean isDigits(final String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>Returns the maximum value in an array.</p>
     */
    public static int max(final int[] array) {
        validateArray(array);

        int max = array[0];
        for (int j = 1; j < array.length; j++) {
            if (array[j] > max) {
                max = array[j];
            }
        }
        return max;
    }

    private static void validateArray(final int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }

    /**
     * Checks if the String contains only Unicode digits.
     */
    public static boolean isCreatable(final String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        final char[] chars = str.toCharArray();
        int sz = chars.length;
        boolean hasExp = false;
        boolean hasDecPoint = false;
        boolean allowSigns = false;
        boolean foundDigit = false;
        // 其他实现细节...
        return true;
    }

    /**
     * Convert a {@code String} to a {@code long}, returning a
     * default value if the conversion fails.
     */
    public static long toLong(final String str, final long defaultValue) {
        if (str == null) {
            return defaultValue;
        }
        try {
            return Long.parseLong(str);
        } catch (final NumberFormatException nfe) {
            return defaultValue;
        }
    }

    // 其他类似方法：toDouble, toFloat, toShort, toByte等
    // 以及各种min/max方法的重载版本
}