package solutions.year2024;

import aocUtils.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day01Test {

    @Test
    public void testDiffCalcEqual() {
        int result = Day01.calcDiff(5, 5);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testDiffCalcLeftLargerThanRight() {
        int result = Day01.calcDiff(8, 5);
        Assertions.assertEquals(3, result);
    }

    @Test
    public void testDiffCalcLeftSmallerThanRight() {
        int result = Day01.calcDiff(5, 8);
        Assertions.assertEquals(3, result);
    }

    @Test
    public void testExampleInputTotalDiff() {
        Pair<List<Integer>, List<Integer>> input = new Pair<>(List.of(1, 2, 3, 3, 3, 4), List.of(3, 3, 3, 4, 5, 9));
        int result = Day01.calcTotalDiff(input);
        Assertions.assertEquals(11, result);
    }

    @Test
    public void testExampleInputSimilarity() {
        Pair<List<Integer>, List<Integer>> input = new Pair<>(List.of(1, 2, 3, 3, 3, 4), List.of(3, 3, 3, 4, 5, 9));
        int result = Day01.calcSimilarityScore(input);
        Assertions.assertEquals(31, result);
    }
}