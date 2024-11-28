package aocUtils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void testGcd() {
        assertEquals(6, MathUtils.gcd(54, 24));
        assertEquals(1, MathUtils.gcd(17, 13));
    }

    @Test
    void testLcm() {
        // Verify the results for various pairs with expected values defined accurately
        assertEquals(216, MathUtils.lcm(54, 24));  // LCM of 54 and 24 should indeed be 216
        assertEquals(221, MathUtils.lcm(17, 13));  // LCM of 17 and 13 should indeed be 221
        assertEquals(216, MathUtils.lcm(72, 54));  // Adding expected LCM for new pair to ensure different data points
    }
}