package solutions.year2024;

import aocUtils.InputUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Day05 {

    private static final Logger logger = Logger.getLogger(Day05.class.getName());

    public static void main(String[] args) {
        try (InputStream inputStream = Day05.class.getClassLoader().getResourceAsStream("2024_Day05.txt")) {
            if (inputStream == null) {
                logger.log(Level.SEVERE, "File not found: 2024_Day05.txt");
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
        Map<Integer, List<Integer>> rulesAfter = new HashMap<>();
        Map<Integer, List<Integer>> rulesBefore = new HashMap<>();
        String input = InputUtils.readInputStreamAsString(inputStream);
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
        int printUpdateSum = calcPrintUpdateSum(rulesBefore, rulesAfter, seriesPagesToPrint);
        logger.info("Print update sum is: " + printUpdateSum);
        int printCorrectedSum = calcCorrectedSum(rulesBefore, rulesAfter, seriesPagesToPrint);
        logger.info("Print update sum is: " + printCorrectedSum);
    }

    public static int calcPrintUpdateSum(Map<Integer, List<Integer>> rulesBefore, Map<Integer, List<Integer>> rulesAfter, List<List<Integer>> seriesOfPagesToPrint) {

        return seriesOfPagesToPrint.stream().mapToInt(pages -> {
            Deque<Integer> remainingPages = new ArrayDeque<>(pages);
            Set<Integer> printed = new HashSet<>();

            while (!remainingPages.isEmpty()) {
                int toPrint = remainingPages.pollFirst();
                if (rulesAfter.getOrDefault(toPrint, Collections.emptyList()).stream().anyMatch(printed::contains)
                        || rulesBefore.getOrDefault(toPrint, Collections.emptyList()).stream().anyMatch(remainingPages::contains)) {
                    return 0;
                }
                printed.add(toPrint);
            }

            return pages.get((pages.size() - 1) / 2);
        }).sum();
    }

    public static int calcCorrectedSum(Map<Integer, List<Integer>> rulesBefore, Map<Integer, List<Integer>> rulesAfter, List<List<Integer>> seriesOfPagesToPrint) {
        return seriesOfPagesToPrint.stream().mapToInt(pages -> {
            List<Integer> copyPages = new ArrayList<>(pages);
            List<Integer> printed = new ArrayList<>();
            boolean isWrong = false;

            for (int i = 0; i < copyPages.size(); i++) {
                int toPrint = copyPages.get(i);
                List<Integer> rulesBeforePage = rulesBefore.getOrDefault(toPrint, Collections.emptyList());
                List<Integer> rulesAfterPage = rulesAfter.getOrDefault(toPrint, Collections.emptyList());

                int earliestFault = rulesAfterPage.stream().filter(printed::contains).findFirst().orElse(-1);
                if (earliestFault != -1) {
                    isWrong = true;
                    printed.add(printed.indexOf(earliestFault), toPrint);
                }

                int latestFault = rulesBeforePage.stream()
                        .filter(copyPages.subList(i + 1, copyPages.size())::contains)
                        .max(Comparator.comparingInt(copyPages::indexOf))
                        .orElse(Integer.MAX_VALUE);
                if (latestFault != Integer.MAX_VALUE) {
                    isWrong = true;
                    copyPages.add(copyPages.indexOf(latestFault) + 1, toPrint);
                    copyPages.remove(i);
                    i--;
                }

                if (!isWrong) {
                    printed.add(toPrint);
                }
            }

            return isWrong ? copyPages.get((copyPages.size() - 1) / 2) : 0;
        }).sum();
    }
}