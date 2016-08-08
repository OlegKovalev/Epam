package se02.task2_4;

import se02.task2_4.goods.*;
import se02.task2_4.properties.PaperSize;
import se02.task2_4.sort.SortedByCost;
import se02.task2_4.sort.SortedByName;

import java.util.Collections;

public class EmployeeTest {

    public static void main(String[] args) {

        Employee employee = new Employee();

        employee.addStationery(new Pen(200, "Bic", Color.GREEN, 2));
        employee.addStationery(new Stapler(700, "Brauberg", Color.GREEN, 1));
        employee.addStationery(new Marker(330, "Erich Krause", Color.GREY, 1));
        employee.addStationery(new Pencil(200, "Brauberg", Color.RED, 3));
        employee.addStationery(new Paper(578, "Erich Krause", Color.WHITE, 2, PaperSize.A4));

        System.out.println("Cost of stationers: " + employee.getCostOfStationers());

        System.out.println("\nWithout sort:");
        employee.printCollection();

        Collections.sort(employee.getStationers(), new SortedByCost());

        System.out.println("\nSort by cost:");
        employee.printCollection();

        Collections.sort(employee.getStationers(), new SortedByName());

        System.out.println("\nSort by name:");
        employee.printCollection();

        Collections.sort(employee.getStationers(), new SortedByCost().thenComparing(new SortedByName()));

        System.out.println("\nSort by cost and name:");
        employee.printCollection();

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
