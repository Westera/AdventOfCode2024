package utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void testSplitString() {
        String input = "a,b,c";
        List<String> result = StringUtils.splitString(input, ",");
        assertEquals(List.of("a", "b", "c"), result);
    }

    @Test
    void testExtractNumbersFromString() {
        String input = "12abc34def56";
        List<Integer> numbers = StringUtils.extractNumbersFromString(input);
        assertEquals(List.of(12, 34, 56), numbers);
    }
}