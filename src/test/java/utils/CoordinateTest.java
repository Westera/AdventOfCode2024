package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    @Test
    void testCoordinateMovement() {
        Coordinate start = new Coordinate(0, 0);
        Coordinate moved = start.move(1, 1);
        assertEquals(new Coordinate(1, 1), moved);
    }

    @Test
    void testCoordinateEquality() {
        Coordinate a = new Coordinate(1, 1);
        Coordinate b = new Coordinate(1, 1);
        assertEquals(a, b);
    }

    @Test
    void testCoordinateHashcode() {
        Coordinate a = new Coordinate(1, 1);
        Coordinate b = new Coordinate(1, 1);
        assertEquals(a.hashCode(), b.hashCode());
    }
}