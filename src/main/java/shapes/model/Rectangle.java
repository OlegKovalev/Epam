package shapes.model;

import shapes.Color;

public class Rectangle extends Shape {

    private double width;
    private double length;

    public Rectangle(double width, double length) {
        super(Color.BLACK, false);
    }

    public Rectangle(double width, double length, Color circle, boolean filled) {
        super(circle, filled);
        this.width = width;
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return (width + length) * 2;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String getName() {
        return getClass().getName();
    }
}
