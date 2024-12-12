package solutions.year2024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Day07Test {

    @Test
    void testExampleInput() {
        List<String> lines = new ArrayList<>(List.of("190: 10 19", "3267: 81 40 27", "83: 17 5", "156: 15 6", "7290: 6 8 6 15", "161011: 16 10 13", "192: 17 8 14", "21037: 9 7 18 13", "292: 11 6 16 20"));
        long result = Day07.sumTrueEquations(lines, false);
        Assertions.assertEquals(3749, result);
    }

    @Test
    void testExampleInputWithConcat() {
        List<String> lines = new ArrayList<>(List.of("190: 10 19", "3267: 81 40 27", "83: 17 5", "156: 15 6", "7290: 6 8 6 15", "161011: 16 10 13", "192: 17 8 14", "21037: 9 7 18 13", "292: 11 6 16 20"));
        long result = Day07.sumTrueEquations(lines, true);
        Assertions.assertEquals(11387, result);
    }
}
