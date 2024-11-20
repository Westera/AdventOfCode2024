package utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputUtilsTest {

    @Test
    void testReadLinesFromFile() throws IOException {
        List<String> lines = InputUtils.readLinesFromFile("src/test/resources/testFile.txt");
        assertNotNull(lines);
        assertEquals(3, lines.size());
        assertEquals("line1", lines.get(0));
        assertEquals("line2", lines.get(1));
        assertEquals("line3", lines.get(2));
    }

    @Test
    void testReadFileAsString() throws IOException {
        String content = InputUtils.readFileAsString("src/test/resources/testFile.txt");
        assertNotNull(content);
        assertEquals("line1\nline2\nline3\n", content);
    }
}