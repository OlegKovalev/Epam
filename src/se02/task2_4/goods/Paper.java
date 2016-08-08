package se02.task2_4.goods;

import se02.task2_4.Color;
import se02.task2_4.Stationery;
import se02.task2_4.properties.PaperSize;

public class Paper extends Stationery {


	private PaperSize size;

	public Paper(int cost, String manufacturer, Color color, int count, PaperSize size) {
		super(cost, manufacturer, color, count);
		this.size = size;
	}

	public PaperSize getSize() {
		return size;
	}

	@Override
	public String getName() {
		return "Paper";
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + "cost: " + getCost() + ", manufacturer: " + getManufacturer() +
				", color: " + getColor() + ", count: " + getCount() + ", format: " + size +" "+ size.getSize() +"\n";
	}
}
