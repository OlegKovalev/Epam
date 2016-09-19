package shapes.model;

import shapes.Color;
import shapes.Measurable;

public abstract class Shape implements Measurable {

	private Color color;

	private boolean filled;

	private String name;

	public Shape(Color color, boolean filled){
		this.color = color;
		this.filled = filled;
	}

	public Shape(){
		this.color = Color.BLACK;
		this.filled = false;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Color getColor(){
		return color;
	}

	public void setColor(final Color color){
		this.color=color;
	}

	public Boolean isFilled() {
		return filled;
	}

	public void setFilled(Boolean filled) {
		this.filled = filled;
	}

	@Override
	public String toString(){
		return name +": P = " + getPerimeter() + " ; s = " + getArea() + ", C = " + color +
				", F = " + filled;
	}
}
