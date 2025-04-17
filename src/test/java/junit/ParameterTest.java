package junit;

import Helpers.MathAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ParameterTest {
    static Stream<Arguments> dataProviderMethod() {
        return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(2, 3, 5),
                Arguments.of(5, 5, 10),
                Arguments.of(-1, -1, -2),
                Arguments.of(-3, 3, 0),
                Arguments.of(0, 0, 0),
                Arguments.of(Integer.MAX_VALUE, 1, Integer.MIN_VALUE), // Должен выдать = Сложение не работает для 2.147483647E9 и 1.0
                Arguments.of(Integer.MIN_VALUE, -1, Integer.MAX_VALUE), // Должен выдать = Сложение не работает для -2.147483648E9 и -1.0
                Arguments.of(1.5, 2.5, 4.0),
                Arguments.of(-1.5, -0.5, -2.0),
                Arguments.of(Double.POSITIVE_INFINITY, 1, Double.POSITIVE_INFINITY),
                Arguments.of(Double.NaN, 1, Double.NaN)
        );
    }

    @ParameterizedTest
    @MethodSource("dataProviderMethod")
    public void parameterizedTest(double a, double b, double expectedSum) {
        MathAssertions.assertionsSum(a, b, expectedSum, "Сложение не работает для " + a + " и " + b);
    }
}
