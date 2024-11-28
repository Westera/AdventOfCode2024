package aocUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Utility class for converting between different data formats.
 */
public class ConversionUtils {

    /**
     * Converts a list of strings to a list of integers.
     *
     * @param lines the list of strings to be converted
     * @return a list of integers parsed from the given list of strings
     */
    public static List<Integer> stringsToIntegers(List<String> lines) {
        return lines.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
    }

    /**
     * Converts a delimited string of integers into an array of integers.
     *
     * @param input the delimited string containing integers
     * @param delimiter the delimiter that separates the integers in the input string
     * @return an array of integers parsed from the input string
     */
    public static int[] stringToIntArray(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }
}