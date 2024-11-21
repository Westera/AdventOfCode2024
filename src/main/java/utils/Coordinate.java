package utils;

public record Coordinate(int x, int y) {

    public Coordinate move(int dx, int dy) {
        return new Coordinate(this.x + dx, this.y + dy);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}