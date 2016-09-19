package shapes.model;


public class Point implements Movable {

    private double x, y, velocity;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(double x, double y, double velocity) {
        this.x = x;
        this.y = y;
        this.velocity = velocity;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point getLocation() {
        return new Point(x, y);
    }

    public Point getLocationVelocity() {
        return new Point(x, y, velocity);
    }

    @Override
    public void move(double x, double y, double velocity) {
        setLocation(x, y);
        this.velocity = velocity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0 &&
                Double.compare(point.velocity, velocity) == 0;
    }

    @Override
    public String toString() {
        return "Point, x = " + x + " y = " + y + " velocity = " + velocity;
    }
}
