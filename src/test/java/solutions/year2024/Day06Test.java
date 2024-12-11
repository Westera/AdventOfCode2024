package solutions.year2024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day06Test {

    @Test
    void testExampleInput() {
        char[][] matrix = {
                "....#.....".toCharArray(),
                ".........#".toCharArray(),
                "..........".toCharArray(),
                "..#.......".toCharArray(),
                ".......#..".toCharArray(),
                "..........".toCharArray(),
                ".#..^.....".toCharArray(),
                "........#.".toCharArray(),
                "#.........".toCharArray(),
                "......#...".toCharArray()
        };

        int positions = Day06.countPositions(matrix);
        Assertions.assertEquals(41, positions);
    }

    @Test
    void testExampleInputIsLoop() {
        char[][] matrix = {
                "....#.....".toCharArray(),
                ".........#".toCharArray(),
                "..........".toCharArray(),
                "..#.......".toCharArray(),
                ".......#..".toCharArray(),
                "..........".toCharArray(),
                ".#.#^.....".toCharArray(),
                "........#.".toCharArray(),
                "#.........".toCharArray(),
                "......#...".toCharArray()
        };

        boolean isLoop = Day06.isLoop(matrix);
        Assertions.assertTrue(isLoop);
    }

    @Test
    void testExampleInputIsNotLoop() {
        char[][] matrix = {
                "....#.....".toCharArray(),
                ".........#".toCharArray(),
                "..........".toCharArray(),
                "..#.......".toCharArray(),
                ".......#..".toCharArray(),
                "..........".toCharArray(),
                ".#..^.....".toCharArray(),
                "........#.".toCharArray(),
                "#.........".toCharArray(),
                "......#...".toCharArray()
        };

        boolean isLoop = Day06.isLoop(matrix);
        Assertions.assertFalse(isLoop);
    }

    @Test
    void testExampleInputCountLoops() {
        char[][] matrix = {
                "....#.....".toCharArray(),
                ".........#".toCharArray(),
                "..........".toCharArray(),
                "..#.......".toCharArray(),
                ".......#..".toCharArray(),
                "..........".toCharArray(),
                ".#..^.....".toCharArray(),
                "........#.".toCharArray(),
                "#.........".toCharArray(),
                "......#...".toCharArray()
        };

        long positions = Day06.countLoops(matrix);
        Assertions.assertEquals(6, positions);
    }

    @Test
    void testExampleInputCountLoopsHard() {
        char[][] matrix = {
                "...........#.....#......".toCharArray(),
                "...................#....".toCharArray(),
                "...#.....##.............".toCharArray(),
                "......................#.".toCharArray(),
                "..................#.....".toCharArray(),
                "..#.....................".toCharArray(),
                "....................#...".toCharArray(),
                "........................".toCharArray(),
                ".#........^.............".toCharArray(),
                "..........#..........#..".toCharArray(),
                "..#.....#..........#....".toCharArray(),
                "........#.....#..#......".toCharArray(),

        };

        long positions = Day06.countLoops(matrix);
        Assertions.assertEquals(19, positions);
    }
}
