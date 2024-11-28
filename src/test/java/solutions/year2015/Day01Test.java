package solutions.year2015;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day01Test {

    @Test
    public void testCalculateFloorExamples() {
        assertEquals(0, Day01.calculateFloor("(())"));
        assertEquals(0, Day01.calculateFloor("()()"));
        assertEquals(3, Day01.calculateFloor("((("));
        assertEquals(3, Day01.calculateFloor("(()(()("));
        assertEquals(3, Day01.calculateFloor("))((((("));
        assertEquals(-1, Day01.calculateFloor("())"));
        assertEquals(-1, Day01.calculateFloor("))("));
        assertEquals(-3, Day01.calculateFloor(")))"));
        assertEquals(-3, Day01.calculateFloor(")())())"));
    }

    @Test
    public void testCalculateFloorEdgeCases() {
        assertEquals(0, Day01.calculateFloor(""));
        assertEquals(1, Day01.calculateFloor("("));
        assertEquals(-1, Day01.calculateFloor(")"));
    }

    @Test
    public void testFindFirstBasementPositionExamples() {
        assertEquals(1, Day01.findFirstBasementPosition(")"));
        assertEquals(5, Day01.findFirstBasementPosition("()())"));
    }

    @Test
    public void testFindFirstBasementPositionEdgeCases() {
        assertEquals(-1, Day01.findFirstBasementPosition("("));
        assertEquals(-1, Day01.findFirstBasementPosition("()"));
        assertEquals(-1, Day01.findFirstBasementPosition(""));
    }

    @Test
    public void testFindFirstBasementPositionComplexCases() {
        assertEquals(-1, Day01.findFirstBasementPosition("((("));
        assertEquals(-1, Day01.findFirstBasementPosition("(()(()("));
        assertEquals(1, Day01.findFirstBasementPosition(")))"));
        assertEquals(1, Day01.findFirstBasementPosition(")())())"));
    }
}
