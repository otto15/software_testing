package com.otto15.lab1.first_task.math;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MathUtilsTest {
    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 1),
                Arguments.of(4, 24),
                Arguments.of(16, 20_922_789_888_000L)
        );
    }

    @Test
    void throwExceptionWhenNegativeNumberIsGiven() {
        assertThrows(IllegalArgumentException.class, () -> MathUtils.factorial(-1));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void executeNormally(long n, long expectedResult) {
        assertEquals(MathUtils.factorial(n), expectedResult);
    }
}