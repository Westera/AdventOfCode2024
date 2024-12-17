package solutions.year2024;

import aocUtils.InputUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class Day04 {

    private static final Logger logger = Logger.getLogger(Day04.class.getName());
    private static final int CHRISTMAS_WORD_LENGTH = 4;

    public static void main(String[] args) {
        try (InputStream inputStream = Day04.class.getClassLoader().getResourceAsStream("2024_Day04.txt")) {
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
        logger.log(Level.INFO,"Number of Xmas: {0}", findAllXmas(matrix));
        logger.log(Level.INFO,"Number of X-mas: {0}", findAllCrossMas(matrix));
    }

    public static int findAllXmas(char[][] matrix) {
        return IntStream.range(0, matrix.length).parallel()
                .flatMap(i -> IntStream.range(0, matrix[i].length).parallel()
                        .filter(j -> matrix[i][j] == 'X')
                        .map(j -> countXmasFromPosition(matrix, i, j)))
                .sum();
    }

    private static int countXmasFromPosition(char[][] matrix, int i, int j) {
        return (isWordInDirection(matrix, i, j, 0, 1) ? 1 : 0) + // left to right
                (isWordInDirection(matrix, i, j, 0, -1) ? 1 : 0) + // right to left
                (isWordInDirection(matrix, i, j, 1, 0) ? 1 : 0) + // up to down
                (isWordInDirection(matrix, i, j, -1, 0) ? 1 : 0) + // down to up
                (isWordInDirection(matrix, i, j, 1, 1) ? 1 : 0) + // diagonal se
                (isWordInDirection(matrix, i, j, -1, -1) ? 1 : 0) + // diagonal nw
                (isWordInDirection(matrix, i, j, 1, -1) ? 1 : 0) + // diagonal sw
                (isWordInDirection(matrix, i, j, -1, 1) ? 1 : 0); // diagonal ne
    }

    private static boolean isWordInDirection(char[][] matrix, int x, int y, int dx, int dy) {
        String targetWord = "MAS";
        for (int k = 1; k < CHRISTMAS_WORD_LENGTH; k++) {
            int nx = x + k * dx;
            int ny = y + k * dy;
            if (!isInBounds(matrix, nx, ny) || matrix[nx][ny] != targetWord.charAt(k - 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isInBounds(char[][] matrix, int x, int y) {
        return x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length;
    }

    public static int findAllCrossMas(char[][] matrix) {
        return (int) IntStream.range(1, matrix.length - 1).parallel()
                .flatMap(i -> IntStream.range(1, matrix[i].length - 1).parallel()
                        .filter(j -> matrix[i][j] == 'A' && isCrossMas(matrix, i, j)))
                .count();
    }

    private static boolean isCrossMas(char[][] matrix, int i, int j) {
        return (matrix[i - 1][j - 1] == 'M' && matrix[i + 1][j + 1] == 'S' || matrix[i - 1][j - 1] == 'S' && matrix[i + 1][j + 1] == 'M') &&
                (matrix[i + 1][j - 1] == 'M' && matrix[i - 1][j + 1] == 'S' || matrix[i + 1][j - 1] == 'S' && matrix[i - 1][j + 1] == 'M');
    }
}
