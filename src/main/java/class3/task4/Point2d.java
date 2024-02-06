package class3.task4;

public class Point2d {
    int x;
    int y;

    public Point2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", x, y);
    }
}
