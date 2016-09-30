package shapes;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import shapes.exception.InvalidValue;
import shapes.model.Circle;
import shapes.model.Point;

import static org.junit.Assert.assertEquals;

public class CircleTest {

    Circle circle;
    Circle circleWithCenter;

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws InvalidValue {
        circle = new Circle(5);
        circleWithCenter = new Circle(5, Color.GREEN, true, 3, 3);
    }

    @Test
    public void testCircle() throws InvalidValue {
        assertEquals("Default color should be black!", Color.BLACK, circle.getColor());
    }

    @Test
    public void testRadius() {
        assertEquals(5, circle.getRadius(), 0.01);
    }

    @Test(expected = InvalidValue.class, timeout = 100)
    public void testInvalidRadius() throws InvalidValue {
        circle.setRadius(-2.0);
    }

    @Test
    public void testInvalidRadius2() throws InvalidValue {
        expectedException.expect(InvalidValue.class);
        expectedException.expectMessage("Radius must be more than 0!");
        circle.setRadius(-3.0);
    }

    @Test
    public void testCenter() throws InvalidValue {
        assertEquals(new Point(3, 3), circleWithCenter.getCenterLocation());
    }

    @Test
    public void testSetCenterLocation() {
        circleWithCenter.setCenterLocation(8, 8);
        assertEquals(new Point(8, 8), circleWithCenter.getCenterLocation());
    }

    @Test
    public void testMoveCenter() {
        circleWithCenter.moveCenter(10, -2, 15);
        assertEquals(new Point(10, -2, 15), circleWithCenter.getCenterLocationVelocity());
    }

}
