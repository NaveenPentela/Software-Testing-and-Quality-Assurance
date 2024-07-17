/**
 * STQA PRAC-1
 * Fan ID: pent0020
 * Name: Naveen Pentela
 */
public class Factorial {
    /**
     * Returns the factorial of the argument given
     *
     * @param n the number for which to calculate the factorial
     * @return the factorial
     */
    public static int factorial(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("java.lang.IllegalArgumentException: Factorial is undefined for negative integers");
        } else if (n > 16) {
            throw new IllegalArgumentException("Factorial(" + n + ") is too large - overflow occurs!");
        }

        int fact = 1;
        for (int i = n; i > 0; i--)
            fact *= i;
        return fact;
    }
}
