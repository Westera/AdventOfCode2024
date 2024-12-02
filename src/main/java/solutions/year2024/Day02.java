package solutions.year2024;

import aocUtils.InputUtils;
import aocUtils.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Day02 {

    private static final Logger logger = Logger.getLogger(Day02.class.getName());

    public static void main(String[] args) {
        try (InputStream inputStream = Day02.class.getClassLoader().getResourceAsStream("2024_Day02.txt")) {
            if (inputStream == null) {
                logger.log(Level.SEVERE, "File not found: 2024_Day01.txt");
                return;
            }
            run(inputStream);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "An error occurred while processing the file", e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An unexpected error occurred", e);
        }
    }

    public static void run(InputStream inputStream) throws IOException {
        List<String> rows = InputUtils.readLinesFromInputStream(inputStream);

        long totalSafeReports = totalSafeReports(rows);
        logger.info("Safe reports: " + totalSafeReports);

        totalSafeReports = totalSafeReportsDampened(rows);
        logger.info("Safe reports: " + totalSafeReports);
    }

    public static boolean isReportSafe(String report) {
        var translated = StringUtils.extractNumbersFromString(report);
        return isReportSafe(translated);
    }

    public static boolean isReportSafeDampened(String report) {
        var translated = StringUtils.extractNumbersFromString(report);

        for (int i = 0; i < translated.size() - 1; i++) {
            if (shouldRemoveIndex(translated, i)) {
                return isSubListSafe(translated, i) || isSubListSafe(translated, i + 1);
            }
        }
        return true;
    }

    private static boolean isSubListSafe(List<Integer> list, int indexToRemove) {
        var subList = new ArrayList<>(list);
        subList.remove(indexToRemove);
        return isReportSafe(subList);
    }

    private static boolean shouldRemoveIndex(List<Integer> list, int i) {
        int current = list.get(i) - list.get(i + 1);
        int previous = (i > 0) ? list.get(i - 1) - list.get(i) : 0;
        return (Math.abs(current) > 3 || current == 0) || (previous != 0 && Math.signum(current) != Math.signum(previous));
    }

    private static boolean isReportSafe(List<Integer> report) {
        int lastDiff = 0;
        for (int i = 0; i < report.size() - 1; i++) {
            int diff = report.get(i) - report.get(i + 1);
            if ((Math.abs(diff) > 3 || diff == 0) || (i > 0 && Math.signum(diff) != Math.signum(lastDiff))) {
                return false;
            }
            lastDiff = diff;
        }
        return true;
    }

    public static long totalSafeReports(List<String> reports) {
        return reports.stream().filter(Day02::isReportSafe).count();
    }

    public static long totalSafeReportsDampened(List<String> reports) {
        return reports.stream().filter(Day02::isReportSafeDampened).count();
    }
}
