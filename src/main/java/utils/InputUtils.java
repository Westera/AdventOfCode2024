package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class InputUtils {
    public static List<String> readLinesFromFile(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
    
    public static String readFileAsString(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}