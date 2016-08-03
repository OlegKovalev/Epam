package se02;

import se02.good.Pen;
import se02.good.Stapler;

public class EmployeeTest {

	public static void main(String[] args){

		Employee employee = new Employee();

		employee.addStationery(new Pen(200, "Bic", Color.GREEN, 2));
		employee.addStationery(new Stapler(700, "Brauberg", Color.BLUE, 1));

		System.out.println(employee.getCostOfStationers());

		System.out.println("----------------------");

		System.out.println(employee.getStationeries());
	}

/*	public Stationery() {
		this(0, "none", Color.BLACK, 0);
	}

	public Stationery(int cost, String manufacturer, Color color, int count) {
		this.cost = cost;
		this.manufacturer = manufacturer;
		this.color = color;
		this.count = count;
	}*/
}
