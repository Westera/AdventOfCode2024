package solutions.year2015;

import aocUtils.InputUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Day01 {

    private static final Logger logger = Logger.getLogger(Day01.class.getName());

    public static int calculateFloor(String directions) {
        return directions.chars()
                .map(ch -> ch == '(' ? 1 : ch == ')' ? -1 : 0)
                .sum();
    }

    public static int findFirstBasementPosition(String directions) {
        int floor = 0;
        for (int i = 0; i < directions.length(); i++) {
            char ch = directions.charAt(i);
            if (ch == '(') {
                floor++;
            } else if (ch == ')') {
                floor--;
            }
            if (floor == -1) {
                return i + 1;  // Positions are 1-based
            }
        }
        return -1;  // Return -1 if the basement is never reached
    }

    public static void main(String[] args) {
        try (InputStream inputStream = Day01.class.getClassLoader().getResourceAsStream("2015_Day01.txt")) {
            if (inputStream == null) {
                logger.log(Level.SEVERE, "File not found: 2015_Day01.txt");
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
        String directions = InputUtils.readInputStreamAsString(inputStream);
        int finalFloor = calculateFloor(directions);
        int firstBasementPosition = findFirstBasementPosition(directions);

        System.out.printf("Santa ends up on floor: %d%n", finalFloor);
        if (firstBasementPosition != -1) {
            System.out.printf("The first character that causes Santa to enter the basement is at position: %d%n", firstBasementPosition);
        } else {
            System.out.println("Santa never enters the basement.");
        }
    }
}
