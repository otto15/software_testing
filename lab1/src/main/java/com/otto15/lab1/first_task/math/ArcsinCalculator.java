package com.otto15.lab1.first_task.math;

public class ArcsinCalculator {
    public double calculate(long n, double x) {
        validateArgs(n, x);

        double result = 0;
        for (long i = 0; i <= n; ++i) {
            if (i == 85) {
                System.out.println(12);
            }
            result += processIteration(i, x);
        }

        return result;
    }

    private void validateArgs(long n, double x) {
        if (n < 0) {
            throw new IllegalArgumentException("Parameter n must not be negative");
        }

        if (n > 85) {
            throw new IllegalArgumentException("To avoid an infinity value parameter n must be less than 86");
        }

        if (x < -1 || x > 1) {
            throw new IllegalArgumentException("arcsin is defined in range [-1; 1]");
        }
    }

    private double processIteration(long n, double x) {
        return MathUtils.factorial(2 * n) * Math.pow(x, 2 * n + 1)
                / (Math.pow(4, n) * Math.pow(MathUtils.factorial(n), 2) * (2 * n + 1));
    }
}
