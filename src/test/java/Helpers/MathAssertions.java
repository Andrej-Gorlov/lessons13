package Helpers;

import org.junit.jupiter.api.Assertions;
import org.testng.Assert;

public class MathAssertions {
    public static void assertSum(double a, double b, double expected, String message) {
        Assert.assertEquals(a + b, expected, message);
    }
    public static void assertionsSum(double a, double b, double expected, String message) {
        Assertions.assertEquals(expected, a + b, message);
    }
}
