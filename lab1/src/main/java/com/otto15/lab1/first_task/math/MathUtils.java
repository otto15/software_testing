package com.otto15.lab1.first_task.math;

public class MathUtils {
    public static double factorial(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must not be negative");
        }

        double result = 1;

        for (long factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
    }
}
