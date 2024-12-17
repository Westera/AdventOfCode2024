package solutions.year2024;

import aocUtils.InputUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Day07 {

    private static final Logger logger = Logger.getLogger(Day07.class.getName());

    public static void main(String[] args) {

        try (InputStream inputStream = Day07.class.getClassLoader().getResourceAsStream("2024_Day07.txt")) {
            if (inputStream == null) {
                logger.log(Level.SEVERE, "File not found: 2024_Day04.txt");
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
        logger.log(Level.INFO,"Sum of true equations: {0}", sumTrueEquations(lines, false));
        logger.log(Level.INFO,"Sum of true equations with concat: {0}", sumTrueEquations(lines, true));
    }

    public static long sumTrueEquations(List<String> lines, boolean withConcat) {
        return lines.stream().mapToLong(line -> evaluate(line, withConcat)).sum();
    }

    private static long evaluate(String equation, boolean withConcat) {
        List<Long> parts = Arrays.stream(equation.split(":* ")).mapToLong(Long::parseLong).boxed().toList();
        long answer = parts.getFirst();

        if(withConcat) {
            return evaluateWithConcat(answer, parts.get(1), parts.subList(2, parts.size())) ? answer : 0;
        }

        return evaluate(answer, parts.get(1), parts.subList(2, parts.size())) ? answer : 0;
    }

    private static boolean evaluate(long target, long currentSum, List<Long> parts) {
        if (target == currentSum && parts.isEmpty()) {
            return true;
        }
        if (parts.isEmpty()) {
            return false;
        }
        long next = parts.getFirst();
        return evaluate(target, currentSum + next, parts.subList(1, parts.size())) || evaluate(target, currentSum * next, parts.subList(1, parts.size()));
    }

    private static boolean evaluateWithConcat(long target, long currentSum, List<Long> parts) {
        if (target == currentSum && parts.isEmpty()) {
            return true;
        }
        if (parts.isEmpty()) {
            return false;
        }
        long next = parts.getFirst();
        return evaluateWithConcat(target, currentSum + next, parts.subList(1, parts.size())) || evaluateWithConcat(target, currentSum * next, parts.subList(1, parts.size())) || evaluateWithConcat(target, Long.parseLong(Long.toString(currentSum) + Long.toString(next)), parts.subList(1, parts.size()));
    }
}
