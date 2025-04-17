package junit;

import Helpers.MathAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExampleTest {
    @Test
    void simpleTest() {
        MathAssertions.assertionsSum(1, 1, 2, "1 + 1 должно быть равно 2");
    }

    @Test
    void testDivisionByZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            int result = 1 / 0; // Это вызовет ArithmeticException
        }, "Деление на ноль должно вызывать ArithmeticException");
    }

    @Test
    public void testLargeSum() {
        long a = 1_000_000_000L;
        long b = 1_000_000_000L;
        long expectedSum = 2_000_000_000L;
        Assertions.assertEquals(a + b, expectedSum, "Сложение больших чисел не работает");
    }

    @Test
    public void testNegativeSum() {
        MathAssertions.assertionsSum(-1, -1, -2, "Сложение отрицательных чисел не работает");
    }
}
