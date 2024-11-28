package aocUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputUtilsTest {

    @Test
    void testReadLinesFromFile() throws IOException {
        List<String> lines = InputUtils.readLinesFromInputStream(Files.newInputStream(Path.of("src/test/resources/testFile.txt")));
        assertNotNull(lines);
        assertEquals(3, lines.size());
        assertEquals("line1", lines.get(0));
        assertEquals("line2", lines.get(1));
        assertEquals("line3", lines.get(2));
    }

    @Test
    void testReadFileAsString() throws IOException {
        String content = InputUtils.readInputStreamAsString(Files.newInputStream(Path.of("src/test/resources/testFile.txt")));
        assertNotNull(content);
        assertEquals("line1\nline2\nline3\n", content);
    }
}