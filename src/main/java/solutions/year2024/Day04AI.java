package solutions.year2024;

import java.io.IOException;
import java.io.InputStream;

public class Day04AI {

    private static final String TARGET_WORD = "XMAS";

    public static int countOccurrences(char[][] matrix) {

        int wordLength = TARGET_WORD.length();
        int count = 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Check each possible starting point in the matrix
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                count += searchInAllDirections(matrix, r, c, wordLength);
            }
        }

        return count;
    }

    private static int searchInAllDirections(char[][] matrix, int r, int c, int length) {
        int count = 0;
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;

        // Define the direction vectors for 8 possible directions
        int[][] directions = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}, {0, -1}, {-1, 0}, {-1, -1}, {1, -1}};

        for (int[] d : directions) {
            boolean found = true;
            for (int i = 0; i < length; i++) {
                int newRow = r + i * d[0];
                int newCol = c + i * d[1];

                if (newRow < 0 || newRow >= maxRow || newCol < 0 || newCol >= maxCol || matrix[newRow][newCol] != TARGET_WORD.charAt(i)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                count++;
            }
        }

        return count;
    }

    public static int countXMasOccurrences(char[][] matrix) {
        int count = 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Iterate through the matrix leaving a border of 1 (pattern is 3x3)
        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < cols - 1; c++) {
                count += isXMasPattern(matrix, r, c) ? 1 : 0;
            }
        }

        return count;
    }

    private static boolean isXMasPattern(char[][] matrix, int r, int c) {
        // Check for X-MAS pattern considering all "MAS" direction combinations
        return (isMAS(matrix[r - 1][c - 1], matrix[r][c], matrix[r + 1][c + 1]) &&
                isMAS(matrix[r + 1][c - 1], matrix[r][c], matrix[r - 1][c + 1]));
    }

    private static boolean isMAS(char first, char second, char third) {
        // Check both forward and backward directions for "MAS"
        return (first == 'M' && second == 'A' && third == 'S') ||
                (first == 'S' && second == 'A' && third == 'M');
    }

    private static char[][] readInputAsCharMatrix(InputStream inputStream) throws IOException {
        // Using InputUtils from provided code
        return aocUtils.InputUtils.readInputAsCharMatrix(inputStream);
    }

    public static void main(String[] args) throws IOException {
        // Example usage:
        InputStream inputStream = Day04AI.class.getClassLoader().getResourceAsStream("2024_Day04.txt"); // Obtain your InputStream here
        char[][] matrix = readInputAsCharMatrix(inputStream);
        int occurrences = countOccurrences(matrix);
        System.out.println("Total occurrences of XMAS: " + occurrences);
        occurrences = countXMasOccurrences(matrix);
        System.out.println("Total occurrences of X-MAS: " + occurrences);
    }
}