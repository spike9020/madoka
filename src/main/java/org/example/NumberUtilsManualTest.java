package org.example;

public class NumberUtilsManualTest {
    public static void main(String[] args) {
        System.out.println("Running manual tests for NumberUtils");

        // 测试toInt方法
        testToInt();

        // 测试isDigits方法
        testIsDigits();

        // 测试max方法
        testMax();
    }

    private static void testToInt() {
        System.out.println("\nTesting toInt(String str, int defaultValue):");

        // 正常数字字符串
        int result1 = NumberUtils.toInt("123", 0);
        System.out.println("Test 1: " + (result1 == 123 ? "PASS" : "FAIL"));

        // 非数字字符串
        int result2 = NumberUtils.toInt("abc", -1);
        System.out.println("Test 2: " + (result2 == -1 ? "PASS" : "FAIL"));

        // null输入
        int result3 = NumberUtils.toInt(null, 10);
        System.out.println("Test 3: " + (result3 == 10 ? "PASS" : "FAIL"));

        // 空字符串 - 这个会暴露我们注入的缺陷
        int result4 = NumberUtils.toInt("", 5);
        System.out.println("Test 4: " + (result4 == 0 ? "PASS" : "FAIL") +
                " (Expected: 0, Actual: " + result4 + ")");
    }

    private static void testIsDigits() {
        System.out.println("\nTesting isDigits(String str):");

        // 纯数字字符串
        boolean result1 = NumberUtils.isDigits("12345");
        System.out.println("Test 1: " + (result1 ? "PASS" : "FAIL"));

        // 包含非数字字符
        boolean result2 = NumberUtils.isDigits("123a45");
        System.out.println("Test 2: " + (!result2 ? "PASS" : "FAIL"));

        // 空字符串
        boolean result3 = NumberUtils.isDigits("");
        System.out.println("Test 3: " + (!result3 ? "PASS" : "FAIL"));
    }

    private static void testMax() {
        System.out.println("\nTesting max(int[] array):");

        // 正常数组
        int result1 = NumberUtils.max(new int[]{3, 1, 4, 2});
        System.out.println("Test 1: " + (result1 == 4 ? "PASS" : "FAIL"));

        // 空数组
        try {
            int result2 = NumberUtils.max(new int[]{});
            System.out.println("Test 2: FAIL (Expected exception)");
        } catch (IllegalArgumentException e) {
            System.out.println("Test 2: PASS (Exception caught as expected)");
        }

        // 单个元素数组
        int result3 = NumberUtils.max(new int[]{7});
        System.out.println("Test 3: " + (result3 == 7 ? "PASS" : "FAIL"));
    }
}