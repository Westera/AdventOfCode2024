package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {

    @Test
    void testPairCreation() {
        Pair<Integer, String> pair = new Pair<>(1, "one");
        assertEquals(1, pair.key());
        assertEquals("one", pair.value());
    }

    @Test
    void testPairEquality() {
        Pair<Integer, String> pair1 = new Pair<>(1, "one");
        Pair<Integer, String> pair2 = new Pair<>(1, "one");
        assertEquals(pair1, pair2);
    }

    @Test
    void testPairHashcode() {
        Pair<Integer, String> pair1 = new Pair<>(1, "one");
        Pair<Integer, String> pair2 = new Pair<>(1, "one");
        assertEquals(pair1.hashCode(), pair2.hashCode());
    }
}