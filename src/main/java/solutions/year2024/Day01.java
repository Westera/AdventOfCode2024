package solutions.year2024;

import aocUtils.InputUtils;
import aocUtils.ListUtils;
import aocUtils.Pair;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class Day01 {

    private static final Logger logger = Logger.getLogger(Day01.class.getName());

    public static void main(String[] args) {
        try (InputStream inputStream = Day01.class.getClassLoader().getResourceAsStream("2024_Day01.txt")) {
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
        Pair<List<Integer>, List<Integer>> listTuple = createLists(rows);

        int totalDiff = calcTotalDiff(listTuple);
        logger.log(Level.INFO,"Total diff is: {0}", totalDiff);

        int similarityScore = calcSimilarityScore(listTuple);
        logger.log(Level.INFO, "Similarity score is: {0}", similarityScore);
    }

    public static int calcTotalDiff(Pair<List<Integer>, List<Integer>> listTuple) {
        List<Integer> sortedLeft = listTuple.key().stream().sorted().toList();
        List<Integer> sortedRight = listTuple.value().stream().sorted().toList();

        return IntStream.range(0, sortedLeft.size())
                .map(i -> Math.abs(sortedLeft.get(i) - sortedRight.get(i)))
                .sum();
    }

    public static int calcSimilarityScore(Pair<List<Integer>, List<Integer>> listTuple) {
        Map<Integer, Long> rightFrequency = ListUtils.getFrequencyMap(listTuple.value());

        return listTuple.key().stream()
                .mapToInt(key -> key * rightFrequency.getOrDefault(key, 0L).intValue())
                .sum();
    }

    public static Pair<List<Integer>, List<Integer>> createLists(List<String> rows) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        rows.forEach(row -> {
            String[] entries = row.split("\\s+");
            left.add(Integer.parseInt(entries[0]));
            right.add(Integer.parseInt(entries[1]));
        });

        return new Pair<>(left, right);
    }
}
