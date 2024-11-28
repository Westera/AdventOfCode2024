package solutions.year2015;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.logging.Level;
import java.util.logging.Logger;

import aocUtils.InputUtils;
import aocUtils.StringUtils;

public class Day02 {

    private static final Logger logger = Logger.getLogger(Day02.class.getName());

    public static int calculateTotal(List<String> dimensions, ToIntFunction<String> calculator) {
        return dimensions.stream()
                .mapToInt(calculator)
                .sum();
    }

    private static List<Integer> parseDimensions(String dimension) {
        List<Integer> dims = StringUtils.extractNumbersFromString(dimension);
        if (dims.size() != 3) {
            throw new IllegalArgumentException("Each dimension line must contain exactly 3 numbers.");
        }
        return dims;
    }

    static int calculatePaperForDimensions(String dimension) {
        List<Integer> dims = parseDimensions(dimension);
        int l = dims.get(0), w = dims.get(1), h = dims.get(2);

        int lw = l * w;
        int wh = w * h;
        int hl = h * l;

        int surfaceArea = 2 * lw + 2 * wh + 2 * hl;
        int slack = Math.min(lw, Math.min(wh, hl));

        return surfaceArea + slack;
    }

    static int calculateRibbonForDimensions(String dimension) {
        List<Integer> dims = parseDimensions(dimension);
        int l = dims.get(0), w = dims.get(1), h = dims.get(2);

        // Find the smallest perimeter
        int[] perimeters = { 2 * (l + w), 2 * (w + h), 2 * (h + l) };
        int smallestPerimeter = Math.min(perimeters[0], Math.min(perimeters[1], perimeters[2]));

        // Calculate the volume for the bow
        int volume = l * w * h;

        return smallestPerimeter + volume;
    }

    public static void main(String[] args) {
        try (InputStream inputStream = Day02.class.getClassLoader().getResourceAsStream("2015_Day02.txt")) {
            if (inputStream == null) {
                logger.log(Level.SEVERE, "File not found: 2015_Day02.txt");
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
        List<String> dimensions = InputUtils.readLinesFromInputStream(inputStream);
        int totalWrappingPaper = calculateTotal(dimensions, Day02::calculatePaperForDimensions);
        System.out.printf("Total wrapping paper needed: %d square feet%n", totalWrappingPaper);
        int totalRibbon = calculateTotal(dimensions, Day02::calculateRibbonForDimensions);
        System.out.printf("Total ribbon needed: %d feet%n", totalRibbon);
    }
}
