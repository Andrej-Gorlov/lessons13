package testNG;

import Helpers.MathAssertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterTest {
    @DataProvider(name = "dataProvider")
    public Object[][] dataProviderMethod() {
        return new Object[][] {
                { 1, 1, 2 },
                { 2, 3, 5 },
                { 5, 5, 10 },
                { -1, -1, -2 },
                { -3, 3, 0 },
                { 0, 0, 0 },
                { Integer.MAX_VALUE, 1, Integer.MIN_VALUE }, // Должен выдать = Сложение не работает для 2.147483647E9 и 1.0
                { Integer.MIN_VALUE, -1, Integer.MAX_VALUE }, // Должен выдать = Сложение не работает для -2.147483648E9 и -1.0
                { 1.5, 2.5, 4.0 },
                { -1.5, -0.5, -2.0 },
                { Double.POSITIVE_INFINITY, 1, Double.POSITIVE_INFINITY },
                { Double.NaN, 1, Double.NaN }
        };
    }

    @Test(dataProvider = "dataProvider")
    public void parameterizedTest(double a, double b, double expectedSum) {
        MathAssertions.assertSum(a, b, expectedSum, "Сложение не работает для " + a + " и " + b);
    }
}
