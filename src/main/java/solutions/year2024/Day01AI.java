package solutions.year2024;

import aocUtils.InputUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Day01AI {

    private static final Logger logger = Logger.getLogger(Day01AI.class.getName());

    public static void main(String[] args) {
        try (InputStream inputStream = Day01AI.class.getClassLoader().getResourceAsStream("2024_Day01.txt")) {
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
        List<String> lines = InputUtils.readLinesFromInputStream(inputStream);
        logger.info("Total diff is: " + new Day01AI().computeTotalDistance(lines));
        logger.info("Similarity score is: " + new Day01AI().computeSimilarityScore(lines));
    }

    public int computeTotalDistance(List<String> lines) {
        // Parsing the lists from the input
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        for (String line : lines) {
            String[] split = line.trim().split("\\s+");
            if (split.length == 2) {
                leftList.add(Integer.parseInt(split[0]));
                rightList.add(Integer.parseInt(split[1]));
            }
        }

        // Sort both lists
        Collections.sort(leftList);
        Collections.sort(rightList);

        // Calculate total distance
        int totalDistance = 0;
        for (int i = 0; i < leftList.size(); i++) {
            totalDistance += Math.abs(leftList.get(i) - rightList.get(i));
        }

        return totalDistance;
    }

    public int computeSimilarityScore(List<String> lines) {
        // Initialize lists for left and right
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        // Parse the input into left and right lists
        for (String line : lines) {
            String[] split = line.trim().split("\\s+");
            if (split.length == 2) {
                leftList.add(Integer.parseInt(split[0]));
                rightList.add(Integer.parseInt(split[1]));
            }
        }

        // Count the frequency of each number in the right list
        Map<Integer, Integer> rightFrequency = new HashMap<>();
        for (Integer num : rightList) {
            rightFrequency.put(num, rightFrequency.getOrDefault(num, 0) + 1);
        }

        // Calculate the similarity score
        int similarityScore = 0;
        for (Integer num : leftList) {
            int countInRight = rightFrequency.getOrDefault(num, 0);
            similarityScore += num * countInRight;
        }

        return similarityScore;
    }
}
