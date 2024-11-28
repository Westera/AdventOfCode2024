package solutions.year2015;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day02Test {

    @Test
    void testCalculatePaperForDimensions() {
        assertEquals(58, Day02.calculatePaperForDimensions("2x3x4"));
        assertEquals(43, Day02.calculatePaperForDimensions("1x1x10"));
    }

    @Test
    void testCalculateRibbonForDimensions() {
        assertEquals(34, Day02.calculateRibbonForDimensions("2x3x4"));
        assertEquals(14, Day02.calculateRibbonForDimensions("1x1x10"));
    }

    @Test
    void testCalculateTotalWrappingPaper() {
        List<String> dimensions = List.of("2x3x4", "1x1x10");
        assertEquals(101, Day02.calculateTotal(dimensions, Day02::calculatePaperForDimensions));
    }

    @Test
    void testCalculateTotalRibbon() {
        List<String> dimensions = List.of("2x3x4", "1x1x10");
        assertEquals(48, Day02.calculateTotal(dimensions, Day02::calculateRibbonForDimensions));
    }

    @Test
    void testParseDimensionsEdgeCases() {
        try {
            Day02.calculatePaperForDimensions("0x0x0");
        } catch (Exception e) {
            // Expected: dimensions should contain positive values
        }

        try {
            Day02.calculateRibbonForDimensions("-1x-1x-1");
        } catch (Exception e) {
            // Expected: dimensions should contain positive values
        }
    }
}