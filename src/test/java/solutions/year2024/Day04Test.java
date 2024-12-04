package solutions.year2024;

import aocUtils.InputUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Day04Test {

    @Test
    public void testExampleInputNoFaultTolerance() throws IOException {
        long total = Day04.findAllXmas(InputUtils.readInputAsCharMatrix(new ByteArrayInputStream("MMMSXXMASM\nMSAMXMSMSA\nAMXSXMAAMM\nMSAMASMSMX\nXMASAMXAMM\nXXAMMXXAMA\nSMSMSASXSS\nSAXAMASAAA\nMAMMMXMMMM\nMXMXAXMASX".getBytes())));
        Assertions.assertEquals(18, total);
    }

    @Test
    public void testExampleInputOneFaultTolerance() throws IOException {
        long total = Day04.findAllCrossMas(InputUtils.readInputAsCharMatrix(new ByteArrayInputStream("MMMSXXMASM\nMSAMXMSMSA\nAMXSXMAAMM\nMSAMASMSMX\nXMASAMXAMM\nXXAMMXXAMA\nSMSMSASXSS\nSAXAMASAAA\nMAMMMXMMMM\nMXMXAXMASX".getBytes())));
        Assertions.assertEquals(9, total);
    }
}
