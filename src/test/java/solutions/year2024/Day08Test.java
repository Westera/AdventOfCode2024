package solutions.year2024;

import aocUtils.Coordinate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

class Day08Test {

    @Test
    void testExampleInput() {
        char[][] matrix = {
                "............".toCharArray(),
                "........0...".toCharArray(),
                ".....0......".toCharArray(),
                ".......0....".toCharArray(),
                "....0.......".toCharArray(),
                "......A.....".toCharArray(),
                "............".toCharArray(),
                "............".toCharArray(),
                "........A...".toCharArray(),
                ".........A..".toCharArray(),
                "............".toCharArray(),
                "............".toCharArray()
        };

        Map<Character, List<Coordinate>> antennaLocations = new HashMap<>();
        IntStream.range(0, matrix.length).forEach(i -> {
            IntStream.range(0, matrix[i].length).forEach(j -> {
                if (matrix[i][j] != '.') {
                    antennaLocations.computeIfAbsent(matrix[i][j], k -> new ArrayList<>()).add(new Coordinate(i, j));
                }
            });
        });

        int antiNodes = Day08.findAntinodes(antennaLocations, matrix.length, matrix[0].length);
        Assertions.assertEquals(14, antiNodes);
    }

    @Test
    void testExampleInputContinous() {
        char[][] matrix = {
                "............".toCharArray(),
                "........0...".toCharArray(),
                ".....0......".toCharArray(),
                ".......0....".toCharArray(),
                "....0.......".toCharArray(),
                "......A.....".toCharArray(),
                "............".toCharArray(),
                "............".toCharArray(),
                "........A...".toCharArray(),
                ".........A..".toCharArray(),
                "............".toCharArray(),
                "............".toCharArray()
        };

        Map<Character, List<Coordinate>> antennaLocations = new HashMap<>();
        IntStream.range(0, matrix.length).forEach(i -> {
            IntStream.range(0, matrix[i].length).forEach(j -> {
                if (matrix[i][j] != '.') {
                    antennaLocations.computeIfAbsent(matrix[i][j], k -> new ArrayList<>()).add(new Coordinate(i, j));
                }
            });
        });

        int antiNodes = Day08.findContinousAntinodes(antennaLocations, matrix.length, matrix[0].length);
        Assertions.assertEquals(34, antiNodes);
    }
}
