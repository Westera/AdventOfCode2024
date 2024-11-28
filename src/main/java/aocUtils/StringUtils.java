package aocUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class providing methods for string manipulation and analysis.
 */
public class StringUtils {

    /**
     * Splits the given input string using the specified delimiter and returns the result as a list of strings.
     *
     * @param input the string to be split
     * @param delimiter the delimiter to use for splitting the string
     * @return a list of strings obtained by splitting the input string around matches of the given delimiter
     */
    public static List<String> splitString(String input, String delimiter) {
        return Arrays.asList(input.split(delimiter));
    }

    /**
     * Extracts all integers from the provided input string and returns them as a list of integers.
     *
     * @param input the input string from which to extract numbers
     * @return a list of integers extracted from the input string
     */
    public static List<Integer> extractNumbersFromString(String input) {
        return Arrays.stream(input.split("\\D+"))
                     .filter(s -> !s.isEmpty())
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }
}