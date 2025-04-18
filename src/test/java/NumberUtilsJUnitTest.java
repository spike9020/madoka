import org.example.NumberUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import static org.junit.Assert.*;

public class NumberUtilsJUnitTest {
    
    @Test
    public void testToInt() {
        int a = 1 / 0;
        // 正常数字字符串
        assertEquals(123, NumberUtils.toInt("123", 0));
        
        // 非数字字符串
        assertEquals(-1, NumberUtils.toInt("abc", -1));
        
        // null输入
        assertEquals(10, NumberUtils.toInt(null, 10));// 这个测试会失败
        
        // 空字符串 - 这个会暴露我们注入的缺陷
        assertEquals(5, NumberUtils.toInt("", 5));


    }
    
    @Test
    public void testIsDigits() {
        // 纯数字字符串
        assertTrue(NumberUtils.isDigits("12345"));
        
        // 包含非数字字符
        assertFalse(NumberUtils.isDigits("123a45"));
        
        // 空字符串
        assertFalse(NumberUtils.isDigits(""));
    }
    
    @Test
    public void testMax() {
        // 正常数组
        assertEquals(4, NumberUtils.max(new int[]{3, 1, 4, 2}));
        
        // 空数组
        try {
            NumberUtils.max(new int[]{});
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // 预期异常
        }
        
        // 单个元素数组
        assertEquals(7, NumberUtils.max(new int[]{7}));
    }
}

@RunWith(Suite.class)
@SuiteClasses({
    NumberUtilsJUnitTest.class
    // 可以添加更多的测试类
})
class NumberUtilsTestSuite {
    // 测试套件类，用于批量运行测试
}