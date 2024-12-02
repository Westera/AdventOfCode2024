package solutions.year2024;

import aocUtils.InputUtils;
import aocUtils.ConversionUtils;

import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

public class Day02AI {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Day02AI.class.getClassLoader().getResourceAsStream("2024_Day02.txt"); // You can replace this with your specific input stream
        List<String> lines = InputUtils.readLinesFromInputStream(inputStream);
        long safeCount = lines.stream()
                .map(line -> ConversionUtils.stringToIntArray(line, " "))
                .filter(Day02AI::isReportSafe)
                .count();
        System.out.println("Number of safe reports: " + safeCount);

        safeCount = lines.stream()
                .map(line -> ConversionUtils.stringToIntArray(line, " "))
                .filter(Day02AI::isReportSafeWithDampener)
                .count();

        System.out.println("Number of safe reports considering Problem Dampener: " + safeCount);
    }

    private static boolean isReportSafeWithDampener(int[] levels) {
        if (isReportSafe(levels)) {
            return true;
        }

        return IntStream.range(0, levels.length)
                .anyMatch(i -> isReportSafe(removeLevel(levels, i)));
    }

    private static boolean isReportSafe(int[] levels) {
        if (levels.length < 2) return false;

        boolean isIncreasing = levels[1] > levels[0];

        for (int i = 0; i < levels.length - 1; i++) {
            int diff = levels[i + 1] - levels[i];

            if (diff == 0 || Math.abs(diff) > 3 || (isIncreasing && diff < 0) || (!isIncreasing && diff > 0)) {
                return false;
            }
        }
        return true;
    }

    private static int[] removeLevel(int[] levels, int index) {
        return IntStream.range(0, levels.length)
                .filter(i -> i != index)
                .map(i -> levels[i])
                .toArray();
    }
}