package com.otto15.lab1.first_task.math;

import com.otto15.lab1.first_task.math.ArcsinCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArcsinCalculatorTest {
    private final ArcsinCalculator calculator = new ArcsinCalculator();

    static Stream<Arguments> validArguments() {
        return Stream.of(
                Arguments.of(85, -1, 1E-1, -Math.PI / 2),
                Arguments.of(85, 1, 1E-1, Math.PI / 2),
                Arguments.of(4, 0, 0, 0),
                Arguments.of(80, 0.3, 1E-4, 0.30469265401),
                Arguments.of(80, -0.65, 1E-4, -0.7075844367253)
        );
    }

    static Stream<Arguments> invalidArguments() {
        return Stream.of(
                Arguments.of(-1, 1),
                Arguments.of(86, 1),
                Arguments.of(2, -2),
                Arguments.of(2, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidArguments")
    @DisplayName("Throw correctly IllegalArgumentException with invalid args")
    void throwIllegalArgumentExceptionWhenInvalidArgsGiven(long n, double x) {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(n, x));
    }

    @ParameterizedTest
    @MethodSource("validArguments")
    @DisplayName("Calculate arcsin correctly")
    void executeCorrectly(long n, double x, double delta, double expectedResult) {
        assertEquals(expectedResult, calculator.calculate(n, x), delta);
    }
}