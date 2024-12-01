package solutions.year2024;

import aocUtils.InputUtils;
import aocUtils.Pair;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Day01 {

    private static final Logger logger = Logger.getLogger(solutions.year2015.Day01.class.getName());

    public static void main(String[] args) {
        try (InputStream inputStream = Day01.class.getClassLoader().getResourceAsStream("2024_Day01.txt")) {
            if (inputStream == null) {
                logger.log(Level.SEVERE, "File not found: 2015_Day01.txt");
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
        Pair<List<Integer>,List<Integer>> sortedListTuple = createSortedLists(rows);
        Pair<List<Integer>,List<Integer>> listTuple = createLists(rows);

        logger.info("Total diff is: " + calcTotalDiff(sortedListTuple));

        logger.info("Similarity score is: " + calcSimilarityScore(listTuple));
    }

    public static int calcTotalDiff(Pair<List<Integer>, List<Integer>> sortedListTuple) {
        int sum = 0;
        List<Integer> left = sortedListTuple.key();
        List<Integer> right = sortedListTuple.value();

        for(int i = 0; i < left.size() ; i++) {
            sum += calcDiff(left.get(i), right.get(i));
        }

        return sum;
    }

    public static int calcSimilarityScore(Pair<List<Integer>, List<Integer>> sortedListTuple) {
        AtomicInteger sum = new AtomicInteger();
        List<Integer> left = sortedListTuple.key();
        List<Integer> right = sortedListTuple.value();

        left.forEach(number -> sum.addAndGet(number * Collections.frequency(right, number)));

        return sum.get();
    }

    public static int calcDiff(int left, int right) {
        return Math.abs(left-right);
    }

    public static Pair<List<Integer>, List<Integer>> createLists(List<String> rows) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        rows.forEach( row -> {
            String[] entries = row.split("\\s+");
            Integer leftEntry = Integer.parseInt(entries[0]);
            Integer rightEntry = Integer.parseInt(entries[1]);
            left.add(leftEntry);
            right.add(rightEntry);
        });

        return new Pair<>(left, right);
    }

    public static Pair<List<Integer>, List<Integer>> createSortedLists(List<String> rows) {
        Pair<List<Integer>, List<Integer>> sortedListTuple = createLists(rows);

        sortedListTuple.key().sort(Integer::compareTo);
        sortedListTuple.value().sort(Integer::compareTo);

        return sortedListTuple;
    }
}
