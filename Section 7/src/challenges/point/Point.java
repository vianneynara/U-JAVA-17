package challenges.point;

public class Point {
    private int x, y;

    public Point () {}
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance() {
//        return (Math.sqrt((0 - x) * (0 - x) + (0 - y) * (0 - y)));
        return (Math.sqrt((-x) * (-x) + (-y) * (-y)));
    }

    public double distance(int x, int y) {
        return (Math.sqrt((x - this.x) * (x - this.x) + (y - this.y) * (y - this.y)));
    }

    public double distance(Point anotherPoint) {
        return (Math.sqrt((anotherPoint.x - x) * (anotherPoint.x - x) + (anotherPoint.y - y) * (anotherPoint.y - y)));
    }
}
