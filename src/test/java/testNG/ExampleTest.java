package testNG;

import Helpers.MathAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleTest {
    @Test
    public void simpleTest() {
        MathAssertions.assertSum(1, 1, 2, "1 + 1 должно быть равно 2");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        int result = 1 / 0; // Это вызовет ArithmeticException
    }

    @Test
    public void testLargeSum() {
        long a = 1_000_000_000L;
        long b = 1_000_000_000L;
        long expectedSum = 2_000_000_000L;
        Assert.assertEquals(a + b, expectedSum, "Сложение больших чисел не работает");
    }

    @Test
    public void testNegativeSum() {
        MathAssertions.assertSum(-1, -1, -2, "Сложение отрицательных чисел не работает");
    }
}
