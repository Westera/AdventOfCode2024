package solutions.year2024;

import aocUtils.InputUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

class Day05Test {
    @Test
    void testExampleInput() throws IOException {
        Map<Integer, List<Integer>> rulesAfter = new HashMap<>();
        Map<Integer, List<Integer>> rulesBefore = new HashMap<>();
        String input = InputUtils.readInputStreamAsString(Day05Test.class.getClassLoader().getResourceAsStream("2024_Day05Test.txt"));
        String[] parts = input.split("\n\n");
        parts[0].lines().forEach(rule -> {
            String[] ruleParts = rule.split("\\|");
            int ruleBefore = Integer.parseInt(ruleParts[0]);
            int ruleAfter = Integer.parseInt(ruleParts[1]);
            rulesAfter.computeIfAbsent(ruleBefore, _ -> new ArrayList<>()).add(ruleAfter);
            rulesBefore.computeIfAbsent(ruleAfter, _ -> new ArrayList<>()).add(ruleBefore);
        });
        List<List<Integer>> seriesPagesToPrint = parts[1].lines().map(line -> {
            String[] pageParts = line.split(",");
            return Arrays.stream(pageParts).map(Integer::parseInt).toList();
        }).toList();
        long total = Day05.calcPrintUpdateSum(rulesBefore, rulesAfter, seriesPagesToPrint);
        Assertions.assertEquals(143, total);
    }

    @Test
    void testExampleInputWithCorrection() throws IOException {
        Map<Integer, List<Integer>> rulesAfter = new HashMap<>();
        Map<Integer, List<Integer>> rulesBefore = new HashMap<>();
        String input = InputUtils.readInputStreamAsString(Day05Test.class.getClassLoader().getResourceAsStream("2024_Day05Test.txt"));
        String[] parts = input.split("\n\n");
        parts[0].lines().forEach(rule -> {
            String[] ruleParts = rule.split("\\|");
            int ruleBefore = Integer.parseInt(ruleParts[0]);
            int ruleAfter = Integer.parseInt(ruleParts[1]);
            rulesAfter.computeIfAbsent(ruleBefore, _ -> new ArrayList<>()).add(ruleAfter);
            rulesBefore.computeIfAbsent(ruleAfter, _ -> new ArrayList<>()).add(ruleBefore);
        });
        List<List<Integer>> seriesPagesToPrint = parts[1].lines().map(line -> {
            String[] pageParts = line.split(",");
            return Arrays.stream(pageParts).map(Integer::parseInt).toList();
        }).toList();
        long total = Day05.calcCorrectedSum(rulesBefore, rulesAfter, seriesPagesToPrint);
        Assertions.assertEquals(123, total);
    }
}
