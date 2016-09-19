package shapes.model;

import shapes.Color;
import shapes.exception.InvalidValue;

public class Circle extends Shape {

    private final String NAME = "Circle";

    private double radius;

    private Point center;

    public Circle(double radius) throws InvalidValue {
        super(Color.BLACK, false);
        center = new Point();
        setRadius(radius);
    }

    public Circle(double radius, Color color, boolean filled) throws InvalidValue {
        super(color, filled);
        center = new Point();
        setRadius(radius);
    }

    public Circle(double radius, Color color, boolean filled, double x, double y) throws InvalidValue {
        this(radius, color, filled);
        center.setLocation(x, y);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws InvalidValue {
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new InvalidValue("Radius must be more than 0!");
        }
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public Point getCenterLocation() {
        return center.getLocation();
    }

    public Point getCenterLocationVelocity() {
        return center.getLocationVelocity();
    }

    public void setCenterLocation(double x, double y) {
        center.setLocation(x, y);
    }

    public void moveCenter(double x, double y, double velocity) {
        center.move(x, y, velocity);
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getName() {
        return NAME;
    }

}
