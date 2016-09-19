package shapes;

import shapes.exception.InvalidValue;
import shapes.model.Circle;
import shapes.model.Rectangle;
import shapes.model.Shape;

public class Viewer {

	public static void main(String[] args) throws InvalidValue {

		Shape shape = new Circle(3, Color.GREEN, false);

		System.out.println(shape.toString());

		Rectangle rect = new Rectangle(2, 3);
		System.out.println(rect.toString());
		
	}
}
