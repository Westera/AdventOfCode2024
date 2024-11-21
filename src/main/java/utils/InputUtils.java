package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Utility class providing methods for reading input from files.
 */
public class InputUtils {
    /**
     * Reads all lines from a file specified by the given file path and returns them as a list of strings.
     *
     * @param filePath the path to the file to be read
     * @return a list of strings, where each string is a line from the file
     * @throws IOException if an I/O error occurs reading from the file or a malformed or unmappable byte sequence is read
     */
    public static List<String> readLinesFromFile(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
    
    /**
     * Reads the contents of a file specified by the given file path and returns it as a single string.
     *
     * @param filePath the path to the file to be read
     * @return the contents of the file as a string
     * @throws IOException if an I/O error occurs reading from the file or a malformed or unmappable byte sequence is read
     */
    public static String readFileAsString(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}