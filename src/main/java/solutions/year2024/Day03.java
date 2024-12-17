package solutions.year2024;

import aocUtils.InputUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 {

    private static final Logger logger = Logger.getLogger(Day03.class.getName());

    public static void main(String[] args) {
        try (InputStream inputStream = Day03.class.getClassLoader().getResourceAsStream("2024_Day03.txt")) {
            if (inputStream == null) {
                logger.log(Level.SEVERE, "File not found: 2024_Day03.txt");
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
        String input = InputUtils.readInputStreamAsString(inputStream);

        long sumOfCorrectMulOps = getSumOfCorrectMulOps(input);
        logger.log(Level.INFO,"Sum of correct add operations: {0}", sumOfCorrectMulOps);
        long sumOfCorrectMulOpsWithDoAndDont = getSumOfCorrectMulOpsWithDoAndDont(input);
        logger.log(Level.INFO,"Sum of correct add operations: {0}", sumOfCorrectMulOpsWithDoAndDont);
    }

    public static long getSumOfCorrectMulOps(String input) {
        long sumOfmultiplications = 0;
        final Matcher matcher = Pattern.compile("mul\\((\\d+),(\\d+)\\)").matcher(input);
        while(matcher.find()) {
            sumOfmultiplications += multFromMatch(matcher, 1, 2);
        }
        return sumOfmultiplications;
    }

    public static long getSumOfCorrectMulOpsWithDoAndDont(String input) {
        long sumOfmultiplications = 0;
        final Matcher matcher = Pattern.compile("(mul\\((\\d+),(\\d+)\\))|(do\\(\\))|(don't\\(\\))").matcher(input);
        boolean doFlag = true;
        while(matcher.find()) {
            String operator = matcher.group();
            if(operator.equals("do()")) {
                doFlag = true;
            } else if(operator.equals("don't()")) {
                doFlag = false;
            }else if (doFlag) {
                sumOfmultiplications += multFromMatch(matcher, 2, 3);
            }
        }
        return sumOfmultiplications;
    }

    private static long multFromMatch(Matcher matcher, int groupIndex1, int groupIndex2) {
        long operand1 = Long.parseLong(matcher.group(groupIndex1));
        long operand2 = Long.parseLong(matcher.group(groupIndex2));
        return operand1 * operand2;
    }
}
