package solutions.year2024;

import aocUtils.Coordinate;
import aocUtils.InputUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class Day08 {

    private static final Logger logger = Logger.getLogger(Day08.class.getName());

    public static void main(String[] args) {

        try (InputStream inputStream = Day08.class.getClassLoader().getResourceAsStream("2024_Day08.txt")) {
            if (inputStream == null) {
                logger.log(Level.SEVERE, "File not found: 2024_Day08.txt");
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
        char[][] matrix = InputUtils.readInputAsCharMatrix(inputStream);
        Map<Character, List<Coordinate>> antennaLocations = new HashMap<>();
        IntStream.range(0, matrix.length).forEach(i ->
            IntStream.range(0, matrix[i].length).forEach(j -> {
                if (matrix[i][j] != '.') {
                    antennaLocations.computeIfAbsent(matrix[i][j], _ -> new ArrayList<>()).add(new Coordinate(i, j));
                }
            })
        );
        int antiNodes = findAntinodes(antennaLocations, matrix.length, matrix[0].length);
        logger.log(Level.INFO, "Number of antinodes: {0}", antiNodes);
        antiNodes = findContinousAntinodes(antennaLocations, matrix.length, matrix[0].length);
        logger.log(Level.INFO, "Number of antinodes: {0}", antiNodes);
    }

    public static int findAntinodes(Map<Character, List<Coordinate>> antennaLocations, int boundryX, int boundryY) {
        Set<Coordinate> antinodesAdded = new HashSet<>();
        AtomicInteger antinodes = new AtomicInteger();
        antennaLocations.forEach((_, antennas) -> {
            for(int i = 0; i < antennas.size(); i++) {
                for(int j = i + 1; j < antennas.size(); j++) {
                    Coordinate a = antennas.get(i);
                    Coordinate b = antennas.get(j);

                    int x = b.x() - a.x();
                    int y = b.y() - a.y();

                    Coordinate antinode1 = new Coordinate(b.x() + x, b.y() + y);
                    Coordinate antinode2 = new Coordinate(a.x() - x, a.y() - y);
                    if (antinode1.x() >= 0 && antinode1.x() < boundryX && antinode1.y() >= 0 && antinode1.y() < boundryY && antinodesAdded.add(antinode1)) {
                            antinodes.getAndIncrement();
                    }

                    if (antinode2.x() >= 0 && antinode2.x() < boundryX && antinode2.y() >= 0 && antinode2.y() < boundryY && antinodesAdded.add(antinode2)) {
                            antinodes.getAndIncrement();
                    }
                }
            }
        });
        return antinodes.get();
    }

    public static int findContinousAntinodes(Map<Character, List<Coordinate>> antennaLocations, int boundryX, int boundryY) {
        Set<Coordinate> antinodesAdded = new HashSet<>();
        AtomicInteger antinodes = new AtomicInteger();
        antennaLocations.forEach((_, antennas) -> {
            for(int i = 0; i < antennas.size(); i++) {
                Coordinate a = antennas.get(i);
                if(antinodesAdded.add(a)) {
                    antinodes.getAndIncrement();
                }
                for(int j = i + 1; j < antennas.size(); j++) {
                    Coordinate b = antennas.get(j);
                    if(antinodesAdded.add(b)) {
                        antinodes.getAndIncrement();
                    }

                    int x = b.x() - a.x();
                    int y = b.y() - a.y();

                    boolean nextOob = false;
                    boolean prevOob = false;

                    int delta = 1;

                    while(!nextOob || !prevOob) {
                        Coordinate antinodeNext = new Coordinate(b.x() + x * delta, b.y() + y * delta);
                        Coordinate antinodePrev = new Coordinate(a.x() - x * delta, a.y() - y * delta);
                        if (antinodeNext.x() >= 0 && antinodeNext.x() < boundryX && antinodeNext.y() >= 0 && antinodeNext.y() < boundryY) {
                            if(antinodesAdded.add(antinodeNext)) {
                                antinodes.getAndIncrement();
                            }
                        } else {
                            nextOob = true;
                        }

                        if (antinodePrev.x() >= 0 && antinodePrev.x() < boundryX && antinodePrev.y() >= 0 && antinodePrev.y() < boundryY) {
                            if(antinodesAdded.add(antinodePrev)) {
                                antinodes.getAndIncrement();
                            }
                        } else {
                            prevOob = true;
                        }
                        delta++;
                    }
                }
            }
        });
        return antinodes.get();
    }
}
