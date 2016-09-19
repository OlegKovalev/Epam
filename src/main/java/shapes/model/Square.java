package shapes.model;

import shapes.Color;

public class Square extends Rectangle {

    private double length;

    public Square(double length) {
        super(length, length);
    }

    public Square(double length, Color color, boolean filled) {
        super(length, length, color, filled);
    }

    @Override
    public String getName() {
        return "Square";
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setWidth(double length) {
        setLength(length);
    }

    @Override
    public String toString() {
        return "Square";
    }

/*
    @Override
	public double getWidth(){
		return
	}*/
}
