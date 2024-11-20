package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConversionUtils {
    public static List<Integer> stringsToIntegers(List<String> lines) {
        return lines.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
    }

    public static int[] stringToIntArray(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }
}