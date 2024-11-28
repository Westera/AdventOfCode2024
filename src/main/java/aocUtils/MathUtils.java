package aocUtils;

/**
 * Utility class providing mathematical functions.
 */
public class MathUtils {

    /**
     * Computes the greatest common divisor (GCD) of two integers using the Euclidean algorithm.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the greatest common divisor of the two given integers
     */
    public static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    /**
     * Computes the least common multiple (LCM) of two integers.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the least common multiple of the two given integers
     */
    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }
}