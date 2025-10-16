// ****************************************************************
// MathUtils.java
//
// Provides static mathematical utility functions.
// ****************************************************************

public class MathUtils {

    //-------------------------------------------------------------
    // Returns the factorial of the argument given
    //-------------------------------------------------------------
    public static int factorial(int n) throws IllegalArgumentException {
        if (n < 0)
            throw new IllegalArgumentException("Factorial is not defined for negative numbers: " + n);

        if (n > 16)
            throw new IllegalArgumentException("Value too large to compute factorial (must be <= 16): " + n);

        int fac = 1;
        for (int i = n; i > 0; i--)
            fac *= i;

        return fac;
    }
}
