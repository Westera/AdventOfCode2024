package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {
    public static List<String> splitString(String input, String delimiter) {
        return Arrays.asList(input.split(delimiter));
    }

    public static List<Integer> extractNumbersFromString(String input) {
        return Arrays.stream(input.split("\\D+"))
                     .filter(s -> !s.isEmpty())
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }
}