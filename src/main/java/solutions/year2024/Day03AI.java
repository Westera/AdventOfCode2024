package solutions.year2024;

import aocUtils.InputUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03AI {

    private static final Pattern MUL_PATTERN = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
    private static final Pattern DO_PATTERN = Pattern.compile("\\bdo\\(\\)");
    private static final Pattern DONT_PATTERN = Pattern.compile("don't\\(\\)");

    public static void main(String[] args) {
        // You would replace System.in with your actual input source
        try (InputStream inputStream = Day03.class.getClassLoader().getResourceAsStream("2024_Day03.txt")) {
            String input = InputUtils.readInputStreamAsString(inputStream);
            int result = calculateSumOfValidMultiplications(input);
            System.out.println("Sum of valid multiplications: " + result);
            result = calculateSumConsideringToggleCommands(input);
            System.out.println("Sum of valid multiplications: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Parses the input to find all valid 'mul(x, y)' instructions and calculates their sum.
     *
     * @param input the corrupted memory input containing instructions
     * @return the sum of the products of all valid 'mul' instructions
     */
    public static int calculateSumOfValidMultiplications(String input) {
        Matcher matcher = MUL_PATTERN.matcher(input);
        int sum = 0;

        while (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            sum += x * y;
        }

        return sum;
    }

    /**
     * Parses the input, considering 'do()' and 'don't()' to enable or disable 'mul' instructions, and calculates
     * the sum of the products of all valid 'mul' instructions when they are enabled.
     *
     * @param input the corrupted memory input containing instructions
     * @return the sum of the products of all valid 'mul' instructions when they are enabled
     */
    public static int calculateSumConsideringToggleCommands(String input) {
        Matcher mulMatcher = MUL_PATTERN.matcher(input);
        Matcher doMatcher = DO_PATTERN.matcher(input);
        Matcher dontMatcher = DONT_PATTERN.matcher(input);

        boolean mulEnabled = true; // mul instructions are enabled by default
        int sum = 0;

        int currentPosition = 0;

        while (currentPosition < input.length()) {
            int nextMulIndex = mulMatcher.find(currentPosition) ? mulMatcher.start() : Integer.MAX_VALUE;
            int nextDoIndex = doMatcher.find(currentPosition) ? doMatcher.start() : Integer.MAX_VALUE;
            int nextDontIndex = dontMatcher.find(currentPosition) ? dontMatcher.start() : Integer.MAX_VALUE;

            if (nextDoIndex < nextMulIndex && nextDoIndex <= nextDontIndex) {
                mulEnabled = true;
                currentPosition = doMatcher.end();
            } else if (nextDontIndex < nextMulIndex) {
                mulEnabled = false;
                currentPosition = dontMatcher.end();
            } else if (nextMulIndex < Integer.MAX_VALUE) {
                if (mulEnabled) {
                    int x = Integer.parseInt(mulMatcher.group(1));
                    int y = Integer.parseInt(mulMatcher.group(2));
                    sum += x * y;
                }
                currentPosition = mulMatcher.end();
            } else {
                break;
            }
        }

        return sum;
    }
}