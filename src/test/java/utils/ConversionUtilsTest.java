package utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConversionUtilsTest {

    @Test
    void testStringsToIntegers() {
        List<String> strings = Arrays.asList("1", "2", "3", "4");
        List<Integer> integers = ConversionUtils.stringsToIntegers(strings);
        assertIterableEquals(Arrays.asList(1, 2, 3, 4), integers);
    }

    @Test
    void testStringToIntArray() {
        String input = "1,2,3,4";
        int[] integers = ConversionUtils.stringToIntArray(input, ",");
        assertArrayEquals(new int[]{1, 2, 3, 4}, integers);
    }
}