package solutions.year2024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day03Test {

    @Test
    public void testExampleInputNoFaultTolerance() {
        long total = Day03.getSumOfCorrectMulOps("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))");
        Assertions.assertEquals(161, total);
    }

    @Test
    public void testExampleInputOneFaultTolerance() {
        long total = Day03.getSumOfCorrectMulOpsWithDoAndDont("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))");
        Assertions.assertEquals(48, total);
    }
}
