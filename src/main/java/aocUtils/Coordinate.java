package aocUtils;

/**
 * Represents a coordinate with x and y values.
 *
 * @param x the x-coordinate
 * @param y the y-coordinate
 */
public record Coordinate(int x, int y) {

    /**
     * Moves the coordinate by the specified delta values for x and y.
     *
     * @param dx the change in the x-coordinate
     * @param dy the change in the y-coordinate
     * @return a new coordinate with the x and y values increased by the specified delta values
     */
    public Coordinate move(int dx, int dy) {
        return new Coordinate(this.x + dx, this.y + dy);
    }

    /**
     * Returns a string representation of the coordinate in the format (x, y).
     *
     * @return a string representing the coordinate in the format (x, y)
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}