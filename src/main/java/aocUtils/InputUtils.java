package aocUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Utility class providing methods for reading input from InputStreams.
 */
public class InputUtils {

    public static List<String> readLinesFromInputStream(InputStream inputStream) throws IOException {
        try(InputStreamReader isr = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr)) {
            return br.lines().toList();
        }
    }

    public static String readInputStreamAsString(InputStream inputStream) throws IOException {
        return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
    }

    public static char[][] readInputAsCharMatrix(InputStream inputStream) throws IOException {
        return readLinesFromInputStream(inputStream).stream()
                                                    .map(String::toCharArray)
                                                    .toArray(char[][]::new);
    }
}