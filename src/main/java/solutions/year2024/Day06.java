package solutions.year2024;

import aocUtils.Coordinate;
import aocUtils.InputUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class Day06 {

    private static final Logger logger = Logger.getLogger(Day06.class.getName());

    private static final List<Character> directions = List.of('<', '^', '>', 'v');
    private static final List<Coordinate> deltas = List.of(new Coordinate(0, -1), new Coordinate(-1, 0), new Coordinate(0, 1), new Coordinate(1, 0));

    public static void main(String[] args) {

        try (InputStream inputStream = Day06.class.getClassLoader().getResourceAsStream("2024_Day06.txt")) {
            if (inputStream == null) {
                logger.log(Level.SEVERE, "File not found: 2024_Day04.txt");
                return;
            }
            run(inputStream);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "An error occurred while processing the file", e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An unexpected error occurred", e);
        }
    }

    public static void run(InputStream inputStream) throws IOException {
        char[][] matrix = InputUtils.readInputAsCharMatrix(inputStream);
        logger.info("Number of Positions: " + countPositions(matrix));
        logger.info("Number of Loops: " + countLoops(matrix));
    }

    public static int countPositions(char[][] matrix) {
        Set<Coordinate> coordinateSet = new HashSet<>();

        Coordinate start = findStart(matrix);
        coordinateSet.add(start);

        int index = directions.indexOf(matrix[start.x()][start.y()]);

        int x = start.x();
        int y = start.y();

        int newX;
        int newY;

        while ((newX = x + deltas.get(index).x()) >= 0 && newX < matrix.length && (newY = y + deltas.get(index).y()) >= 0 && newY < matrix[0].length) {
            if (matrix[newX][newY] == '#') {
                index = (index + 1) % 4;
            } else {
                x = newX;
                y = newY;
                coordinateSet.add(new Coordinate(x, y));
            }
        }
        return coordinateSet.size();
    }

    private static Coordinate findStart(char[][] matrix) {
        for(int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[i].length ; j++) {
                if(directions.contains(matrix[i][j])) {
                    return new Coordinate(i, j);
                }
            }
        }
        return new Coordinate(-1, -1);
    }

    public static long countLoops(char[][] matrix) {
        return IntStream.range(0, matrix.length).boxed()
                .flatMap(row -> IntStream.range(0, matrix[row].length)
                        .filter(col -> matrix[row][col] == '.').mapToObj(col -> new Coordinate(row, col)))
                .parallel().filter(pos -> isLoopWithReplacement(matrix, pos)).count();
    }

    private static boolean isLoopWithReplacement(char[][] matrix, Coordinate pos) {
        char[][] clonedMatrix = cloneMatrix(matrix);
        clonedMatrix[pos.x()][pos.y()] = '#';
        return isLoop(clonedMatrix);
    }

    private static char[][] cloneMatrix(char[][] matrix) {
        // Clone the matrix to avoid modifying the original reference
        return Arrays.stream(matrix).map(char[]::clone) // Clone each row
                .toArray(char[][]::new);
    }

    public static boolean isLoop (char[][] matrix) {
        Set<List<Coordinate>> coordinateSet = new HashSet<>();
        List<Coordinate> movesBeforeTurn = new ArrayList<>();

        Coordinate start = findStart(matrix);
        movesBeforeTurn.add(start);

        int index = directions.indexOf(matrix[start.x()][start.y()]);

        int x = start.x();
        int y = start.y();

        int newX;
        int newY;

        while ((newX = x + deltas.get(index).x()) >= 0 && newX < matrix.length && (newY = y + deltas.get(index).y()) >= 0 && newY < matrix[0].length) {
            matrix[x][y] = 'X';
            if (matrix[newX][newY] == '#') {
                index = (index + 1) % 4;
                if(!coordinateSet.add(new ArrayList<>(movesBeforeTurn)) && movesBeforeTurn.size() > 1) {
                    return true;
                }
                movesBeforeTurn.clear();
            } else {
                x = newX;
                y = newY;
                movesBeforeTurn.add(new Coordinate(x, y));
            }
        }
        return false;
    }
}
