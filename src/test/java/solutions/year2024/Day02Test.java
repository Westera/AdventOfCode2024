package solutions.year2024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day02Test {

    @Test
    public void testExampleInputNoFaultTolerance() {
        long total = Day02.totalSafeReports(List.of("7 6 4 2 1", "1 2 7 8 9", "9 7 6 2 1", "1 3 2 4 5", "8 6 4 4 1", "1 3 6 7 9"));
        Assertions.assertEquals(2, total);
    }

    @Test
    public void testExampleInputOneFaultTolerance() {
        long total = Day02.totalSafeReportsDampened(List.of("7 6 4 2 1", "1 2 7 8 9", "9 7 6 2 1", "1 3 2 4 5", "8 6 4 4 1", "1 3 6 7 9"));
        Assertions.assertEquals(4, total);
    }
}
